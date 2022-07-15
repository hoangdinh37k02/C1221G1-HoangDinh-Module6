import {Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import {CustomerService} from "../../service/customer.service";
import {Customer} from "../../model/customer";
import {Type} from "../../model/type";
import {ToastrService} from "ngx-toastr";
import {Router} from "@angular/router";

@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.css']
})
export class CustomerListComponent implements OnInit {
  public customers: Customer [];
  public types: Type [];
  public totalPages: number;
  public currentPage: number;

  isChoosen: boolean;
  choosenIndex: number;
  choosenId: number;
  idDelete: number;
  nameDelete: string;

  @ViewChild('name') name: ElementRef;
  constructor(private customerService: CustomerService, private toastr : ToastrService,
              private router: Router) { }

  ngOnInit(): void {
    this.getAllType();
    this.getAllCustomer();
  }

  getAllType(){
    this.customerService.getAllType().subscribe(types => {
      this.types = types;
      console.log(types);
    })
  }

  getAllCustomer(){
    this.customerService.getAllEmployee({
      page: 0, size: 3
    }).subscribe( customers => {
      this.customers = customers['content'];
      this.currentPage = customers['number']
      this.totalPages = customers['totalPages']
      console.log(customers);
    }, () => {
      this.customers = [];
    })
  };

  previousPage() {
    const request = {};
    if (this.currentPage>0){
      request['page'] = this.currentPage - 1;
      request['size'] = 3;
      request['name'] =this.name.nativeElement.value;
      this.customerService.getAllEmployee(request).subscribe( customers => {
        this.customers = customers['content'];
        this.currentPage = customers['number'];
        this.totalPages = customers['totalPages'];
      }, () => {
      });
    }
  }

  nextPage() {
    const request = {};
    if ((this.currentPage+1)<this.totalPages){
      request['page'] = this.currentPage + 1;
      request['size'] = 3;
      request['name'] =this.name.nativeElement.value;
      this.customerService.getAllEmployee(request).subscribe( customers => {
        this.customers = customers['content'];
        this.currentPage = customers['number'];
        this.totalPages = customers['totalPages'];
      }, () => {
      });
    }
  }

  search() {
    this.customerService.getAllEmployee({
      page: 0, size: 3, name: this.name.nativeElement.value
    }).subscribe( customers => {
        this.customers = customers['content'];
        this.currentPage = customers['number']
        this.totalPages = customers['totalPages']
    }, () => {
      this.customers = [];
    })
  }

  getValueToDelete(i: number, customerId: number, customerName: string) {
    if (this.choosenIndex !== i) {
      this.isChoosen = true;
      this.choosenIndex = i;
      this.choosenId = customerId;
    } else {
      this.isChoosen = !this.choosenId;
      this.choosenIndex = null;
      this.idDelete = null;
    }
    if (this.isChoosen) {
      this.idDelete = customerId;
      this.nameDelete = customerName;
    }
  }

  deleteCustomer(idDelete: number) {
    this.customerService.delete(idDelete).subscribe(() => {
      this.toastr.success("Xóa Thành Công !", "Thông báo", {
        timeOut:3000,
        progressBar: true
      });
      this.ngOnInit();
    });
  }

  confirmSelect() {
    if (!this.isChoosen) {
      this.toastr.warning('Bạn chưa chọn khách hàng', 'Cảnh Báo', {
        timeOut: 1500,
        progressBar: true,
      });
    } else {
      this.router.navigate(['/edit', this.choosenId]);
    }
  }
}
