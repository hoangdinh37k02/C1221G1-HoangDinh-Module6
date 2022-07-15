import { Component, OnInit } from '@angular/core';
import {Tour} from "../model/tour";
import {TourService} from "../service/tour.service";
import {ToastrService} from "ngx-toastr";

@Component({
  selector: 'app-tour-list',
  templateUrl: './tour-list.component.html',
  styleUrls: ['./tour-list.component.css']
})
export class TourListComponent implements OnInit {
  tours: Tour [] = [];
  idToDelete: number;
  nameTour: string;
  p: number;
  constructor(private tourService: TourService, private toastr : ToastrService
              ) { }

  ngOnInit(): void {
    this.tourService.getTour().subscribe(tours => {
      this.tours = tours;
      console.log(tours);
    })
  }

  sendId(maTour: number, nameTour: string) {
    this.idToDelete = maTour;
    console.log(this.idToDelete)
    this.nameTour = nameTour;
  }

  delete(idToDelete: number) {
    this.tourService.delete(idToDelete).subscribe(() => {
      this.toastr.success("Xóa Thành Công !", "Thông báo", {
        timeOut:3000,
        progressBar: true
      });
      this.ngOnInit();
    }, e => {
      console.log(e)
    })
  }
}
