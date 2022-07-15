import { Component, OnInit } from '@angular/core';
import {TourService} from "../service/tour.service";
import {ToastrService} from "ngx-toastr";
import {Router} from "@angular/router";
import {ThongKe} from "../model/thong-ke";

@Component({
  selector: 'app-tour-static',
  templateUrl: './tour-static.component.html',
  styleUrls: ['./tour-static.component.css']
})
export class TourStaticComponent implements OnInit {
  thongKe: ThongKe[] = [];
  p: number;
  constructor(private tourService: TourService, private toastr : ToastrService, private route: Router) { }

  ngOnInit(): void {
    this.tourService.getThongKe().subscribe(statics => {
      this.thongKe = statics;
      console.log(statics);
    })
  }

}
