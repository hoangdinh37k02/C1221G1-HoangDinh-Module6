import { Component, OnInit } from '@angular/core';
import {LoaiTour} from "../model/loai-tour";
import {PhamVi} from "../model/pham-vi";
import {TourService} from "../service/tour.service";
import {ToastrService} from "ngx-toastr";
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {Router} from "@angular/router";

@Component({
  selector: 'app-tour-create',
  templateUrl: './tour-create.component.html',
  styleUrls: ['./tour-create.component.css']
})
export class TourCreateComponent implements OnInit {
  loaiTour: LoaiTour[] = [];
  phamVi: PhamVi[] = [];
  createForm: FormGroup;
  constructor(private tourService: TourService, private toastr : ToastrService, private route: Router) {
    this.createForm = new FormGroup({
      tenTour: new FormControl('', Validators.required),
      diaDiem: new FormControl('', Validators.required),
      ngayKhoiHanh: new FormControl('', Validators.required),
      ngayVe: new FormControl('', Validators.required),
      ngayKTDK: new FormControl('', Validators.required),
      soNguoiToiDa: new FormControl('',[Validators.required, Validators.maxLength(50)]),
      lichTrinh: new FormControl(''),
      yeuCauDT: new FormControl(''),
      chiPhi: new FormControl(''),
      loaiTour: new FormControl('', Validators.required),
      phamVi: new FormControl('', Validators.required),
    })
  }

  ngOnInit(): void {
    this.getLoaiTour();
    this.getPhamVi();
  }

  getLoaiTour(){
    this.tourService.getLoaiTour().subscribe(loaiTour => {
      this.loaiTour = loaiTour;
    })
  }

  getPhamVi(){
    this.tourService.getPhamVi().subscribe(phamVi => {
      this.phamVi = phamVi;
    })
  }

  create() {
    if (this.createForm.valid) {
      console.log(this.createForm.value)
      this.tourService.save(this.createForm.value).subscribe(() => {
        this.toastr.success("Thêm Mới Thành Công !", "Thông báo", {
          timeOut:3000,
          progressBar: true

        });
        this.route.navigate(['/list']);
      }, () => {
      })
    } else {
      this.toastr.warning("Dữ liệu không hợp lệ !", "Thông báo", {
        timeOut:3000,
        progressBar: true

      });
    }
  }
}
