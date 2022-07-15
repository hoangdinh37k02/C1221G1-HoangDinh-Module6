import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {Type} from "../../model/type";
import {CustomerService} from "../../service/customer.service";
import {Router} from "@angular/router";
import {ToastrService} from "ngx-toastr";

@Component({
  selector: 'app-customer-create',
  templateUrl: './customer-create.component.html',
  styleUrls: ['./customer-create.component.css']
})
export class CustomerCreateComponent implements OnInit {
  createForm: FormGroup;
  types: Type[];

  constructor(private customerService: CustomerService,
              private router: Router, private toastr : ToastrService) {
    this.createForm = new FormGroup({
      customerName: new FormControl('', [Validators.required,
        Validators.pattern('^([a-zA-ZxzÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚÝàáâãèéêìíòóôõùúýĂăĐđĨĩŨũƠơƯưẠyỳọầảấờễạằệếộậốứữịỗềểẩớặồợụủỹắẫựỉỏừỷởửỵẳẹẽổẵẻỡ]+)((\\s{1}[a-zA-ZxzÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚÝàáâãèéêìíòóôõùúýĂăĐđĨĩŨũƠơƯưẠyỳọầảấờễạằệếộậốứữịỗềểẩớặồợụủỹắẫựỉỏừỷởửỵẳẹẽổẵẻỡ]+){1,})$')]),
      dateOfBirth: new FormControl('', [Validators.required]),
      phone: new FormControl('', [Validators.required,
        Validators.pattern('^(0?)(3[2-9]|5[6|8|9]|7[0|6-9]|8[0-6|8|9]|9[0-4|6-9])[0-9]{7}$')]),
      email: new FormControl('', [Validators.required, Validators.email]),
      type: new FormControl('', Validators.required)
    })
  }

  ngOnInit(): void {
    this.getAllType();
    console.log(this.types);
  }

  getAllType(){
    this.customerService.getAllType().subscribe(types => {
      this.types = types;
    })
  }


  create() {
    console.log(this.createForm.value)
    // console.log(this.createForm.valid)
    if (this.createForm.valid){
      this.customerService.saveEmployee(this.createForm.value).subscribe(() => {
      this.router.navigateByUrl('list');
        this.toastr.success("Thêm Mới Thành Công !", "Thông báo", {
          timeOut:3000,
          progressBar: true
        });
      }, () => {
        alert("fail")
      })
    } else {
      this.toastr.warning("Dữ liệu không hợp lệ !", "Thông báo", {
        timeOut:3000,
        progressBar: true
      });
    }
  }
}
