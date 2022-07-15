import {Component, OnInit} from '@angular/core';
import {Invoice} from "../../../model/invoice";
import {InvoiceService} from "../../../service/invoice.service";
import {FormControl, FormGroup} from "@angular/forms";
import {ToastrService} from "ngx-toastr";

@Component({
  selector: 'app-invoice-list',
  templateUrl: './invoice-list.component.html',
  styleUrls: ['./invoice-list.component.css']
})
export class InvoiceListComponent implements OnInit {
  invoiceList: Invoice[] = [];
  totalPages: number;
  currentPage: number;
  idDel: string;
  startDate: string = "";
  endDate: string = new Date().toLocaleDateString('ez-ZA');
  startTime: string = "";
  endTime: string = "23:59";
  typeOfInvoiceId: string = '1';
  fieldSort: string = 'invoiceId';
  searchForm: FormGroup;
  isChosen: boolean;
  chosenIndex: number;
  chosenId: string;

  constructor(private invoiceService: InvoiceService, private toastr : ToastrService) {
    this.searchForm = new FormGroup({
      startDate: new FormControl(''),
      // startDate: new FormControl('', [this.checkStartDate]),
      endDate: new FormControl(),
      startTime: new FormControl(),
      endTime: new FormControl(),
      typeOfInvoiceId: new FormControl("1"),
      fieldSort: new FormControl("invoiceId")
    })
  }

  ngOnInit(): void {
    this.getAllInvoice({page: 0, size: 5});
  }

  getAllInvoice(request) {
    this.invoiceService.getAll(request).subscribe(invoices => {
      if (invoices != null) {
        this.invoiceList = invoices['content'];
        this.currentPage = invoices['number'];
        this.totalPages = invoices['totalPages'];
      } else {
        this.invoiceList = [];
        // this.currentPage = -1;
        // this.totalPages = 0;
      }
    }, () => {
      alert('Không tìm thấy dữ liệu');
    })
  }

  previousPage() {
    const request = {};
    if ((this.currentPage) > 0) {
      request['page'] = this.currentPage - 1;
      request['size'] = 5;
      request['startDate'] = this.startDate;
      request['endDate'] = this.endDate;
      request['startDate'] = this.startDate;
      request['startTime'] = this.startTime;
      request['endTime'] = this.endTime;
      request['typeOfInvoiceId'] = this.typeOfInvoiceId;
      request['fieldSort'] = this.fieldSort;
      this.getAllInvoice(request);
    }
  }

  nextPage() {
    const request = {};
    if ((this.currentPage + 1) < this.totalPages) {
      request['page'] = this.currentPage + 1;
      request['size'] = 5;
      request['startDate'] = this.startDate;
      request['endDate'] = this.endDate;
      request['startDate'] = this.startDate;
      request['startTime'] = this.startTime;
      request['endTime'] = this.endTime;
      request['typeOfInvoiceId'] = this.typeOfInvoiceId;
      request['fieldSort'] = this.fieldSort;
      this.getAllInvoice(request);

    }
  }

  deleteInvoice(idDel: string) {
    if (idDel == null) {
      alert("Chưa chọn hóa đơn")
    } else {
      this.invoiceService.deleteInvoiceById(idDel).subscribe(() => {
        this.ngOnInit();
        this.toastr.success("Xóa hóa đơn thành công !", "", {
          timeOut: 3000,
          progressBar: true
        })
      }, e => console.log(e));
    }
  }

  search() {
    console.log(this.startTime);
    console.log(this.endTime);
    console.log(this.startDate);
    console.log(this.endDate);
    console.log(this.fieldSort);
    console.log(this.typeOfInvoiceId);
    if (this.searchForm.value.startDate == null) {
      this.searchForm.value.startDate = this.startDate
    }
    if (this.searchForm.value.endDate == null) {
      this.searchForm.value.endDate = this.endDate
    }
    if (this.searchForm.value.startTime == null) {
      this.searchForm.value.startTime = this.startTime
    }
    if (this.searchForm.value.endTime == null) {
      this.searchForm.value.endTime = this.endTime
    }
    this.fieldSort = this.searchForm.value.fieldSort
    this.typeOfInvoiceId = this.searchForm.value.typeOfInvoiceId
    this.invoiceService.getAll({
      page: 0, size: 5, startDate: this.searchForm.value.startDate, endDate: this.searchForm.value.endDate,
      startTime: this.searchForm.value.startTime, endTime: this.searchForm.value.endTime,
      typeOfInvoiceId: this.typeOfInvoiceId, fieldSort: this.fieldSort
    }).subscribe(invoices => {
      if (invoices != null) {
        this.invoiceList = invoices['content'];
        this.currentPage = invoices['number'];
        this.totalPages = invoices['totalPages'];
      } else {
        this.invoiceList = [];
        this.currentPage = -1;
        this.totalPages = 0;
      }
    }
    // , () => {
    //   alert('Không tìm thấy dữ liệu');
    // }
    )
  }

  chooseInvoice(index: number, invoiceId: string): void {
    if (this.chosenIndex !== index) {
      this.isChosen = true;
      this.chosenIndex = index;
      this.chosenId = invoiceId;
    } else {
      this.isChosen = !this.isChosen;
      this.chosenIndex = null;
      this.idDel = null;
    }
    if (this.isChosen) {
      this.idDel = invoiceId;
    }
  }

  // checkStartDate(date: FormGroup) {
  //   const start = date.get('startDate').value;
  //   const today = new Date().toLocaleDateString('ez-ZA');
  //   if(start > today) {
  //     return {isAfter: true}
  //   } else {
  //     return null;
  //   }
  // }
  reset() {
    this.ngOnInit();
  }
}
