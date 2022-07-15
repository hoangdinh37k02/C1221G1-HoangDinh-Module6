import { Component, OnInit } from '@angular/core';
import {CustomerService} from "../../service/customer.service";
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {Type} from "../../model/type";
import {ActivatedRoute, ParamMap, Router} from "@angular/router";
import {Customer} from "../../model/customer";
import {ToastrService} from "ngx-toastr";

@Component({
  selector: 'app-customer-edit',
  templateUrl: './customer-edit.component.html',
  styleUrls: ['./customer-edit.component.css']
})
export class CustomerEditComponent implements OnInit {
  editForm: FormGroup;
  customer: Customer;
  id: number;
  types: Type[];
  constructor(private route: Router, private toastr : ToastrService,
              private activatedRoute: ActivatedRoute, private customerService: CustomerService) {
  }

  ngOnInit(): void {
    this.customerService.getAllType().subscribe(types => {
      this.types = types;
      this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
        this.id = parseInt(paramMap.get('id'));
        console.log(this.id);
        this.getCustomer(this.id);
      });
    });
  }

  getCustomer(id: number) {
    return this.customerService.findById(id).subscribe(customer => {
      console.log(customer);
      this.customer = customer;
      this.editForm = new FormGroup({
        customerId: new FormControl(this.customer.customerId),
        customerName: new FormControl(this.customer.customerName, [Validators.required,
          Validators.pattern('^([a-zA-ZxzÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚÝàáâãèéêìíòóôõùúýĂăĐđĨĩŨũƠơƯưẠyỳọầảấờễạằệếộậốứữịỗềểẩớặồợụủỹắẫựỉỏừỷởửỵẳẹẽổẵẻỡ]+)((\\s{1}[a-zA-ZxzÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚÝàáâãèéêìíòóôõùúýĂăĐđĨĩŨũƠơƯưẠyỳọầảấờễạằệếộậốứữịỗềểẩớặồợụủỹắẫựỉỏừỷởửỵẳẹẽổẵẻỡ]+){1,})$')]),
        type: new FormControl(this.customer.type, Validators.required),
        email: new FormControl(this.customer.email, [Validators.required, Validators.email]),
        phone: new FormControl(this.customer.phone, [Validators.required,
          Validators.pattern('^(0?)(3[2-9]|5[6|8|9]|7[0|6-9]|8[0-6|8|9]|9[0-4|6-9])[0-9]{7}$')]),
        dateOfBirth: new FormControl(this.customer.dateOfBirth, [Validators.required])
      })
    })
  }

  update(id: number) {
    if (this.editForm.valid){
      this.customerService.updateCustomer(id, this.editForm.value).subscribe(() => {
        this.toastr.success("Cập nhật Thành Công !", "Thông báo", {
          timeOut:3000,
          progressBar: true
        });
      }, e => {
        console.log(e);
      }, () => {
        this.route.navigate(['list']);
      })
    } else {
      this.toastr.warning("Dữ liệu không hợp lệ !", "Thông báo", {
        timeOut:3000,
        progressBar: true
      });
    }
  }

  equals = (item1, item2) => {
    return item1 && item2 && item1.id === item2.id;
  }
}
