import {Component, OnInit} from '@angular/core';
import {ReportService} from "../../../service/report.service";
import {Static} from "../../../model/static";
import {Chart, registerables} from 'chart.js';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import * as $ from "jquery";
import {StaticByMonth} from "../../../model/static-by-month";
import {ToastrService} from "ngx-toastr";

Chart.register(...registerables);

@Component({
  selector: 'app-statistital-chart',
  templateUrl: './statistital-chart.component.html',
  styleUrls: ['./statistital-chart.component.css']
})
export class StatistitalChartComponent implements OnInit {
  statics: Static[] = [];
  staticsByMonth: StaticByMonth[] = [];
  public year = true;
  public month = true;
  canvas: any;
  ctx: any;
  show = false;
  show1 = false;
  showYear: string;
  showMonth: string;
  staticForm: FormGroup;

  constructor(private reportService: ReportService, private toastr: ToastrService) {
  }

  ngOnInit(): void {
    this.staticForm = new FormGroup({
      year: new FormControl('', [Validators.required]),
      month: new FormControl('', [Validators.required]),
    });
  }
  submit() {
    $('#myChart').remove(); // this is my <canvas> element
    $('#containChart').append('<canvas style="width: 100%" id="myChart"><canvas>');
    if ((this.staticForm.value.month != '' && this.staticForm.value.year == '')||
      (this.staticForm.value.month == '' && this.staticForm.value.year == '')) {
      this.show = false;
      this.show1 = false;
    } else if (this.staticForm.value.month != '' && this.staticForm.value.year != '') {
      this.statics = [];
      this.reportService.getStaticByMonth(this.staticForm.value.month, this.staticForm.value.year)
        .subscribe(staticsByMonth => {
          console.log(staticsByMonth);
          this.showMonth = this.staticForm.value.month;
          this.showYear = this.staticForm.value.year;
          this.show = true;
          this.show1 = true;
          this.staticsByMonth = staticsByMonth;
          this.canvas = document.getElementById('myChart');
          this.ctx = this.canvas.getContext('2d');
          const myChart = new Chart(this.ctx, {
            type: 'line',
            data: {
              labels: ['Ng??y 1', 'Ng??y 2', 'Ng??y 3', 'Ng??y 4', 'Ng??y 5', 'Ng??y 6', 'Ng??y 7', 'Ng??y 8', 'Ng??y 9', 'Ng??y 10'
                , 'Ng??y 11', 'Ng??y 12', 'Ng??y 13', 'Ng??y 14', 'Ng??y 15', 'Ng??y 16', 'Ng??y 17', 'Ng??y 18', 'Ng??y 19', 'Ng??y 20'
                , 'Ng??y 21', 'Ng??y 22', 'Ng??y 23', 'Ng??y 24', 'Ng??y 25', 'Ng??y 26', 'Ng??y 27', 'Ng??y 28', 'Ng??y 29', 'Ng??y 30', 'Ng??y 31'],
              datasets: [
                {
                  label: 'Doanh thu',
                  data: [staticsByMonth[0].revenue, staticsByMonth[1].revenue, staticsByMonth[2].revenue,
                    staticsByMonth[3].revenue, staticsByMonth[4].revenue, staticsByMonth[5].revenue,
                    staticsByMonth[6].revenue, staticsByMonth[7].revenue, staticsByMonth[8].revenue,
                    staticsByMonth[9].revenue, staticsByMonth[10].revenue, staticsByMonth[11].revenue,
                    staticsByMonth[12].revenue, staticsByMonth[13].revenue, staticsByMonth[14].revenue,
                    staticsByMonth[15].revenue, staticsByMonth[16].revenue, staticsByMonth[17].revenue,
                    staticsByMonth[18].revenue, staticsByMonth[19].revenue, staticsByMonth[20].revenue,
                    staticsByMonth[21].revenue, staticsByMonth[22].revenue, staticsByMonth[23].revenue,
                    staticsByMonth[24].revenue, staticsByMonth[25].revenue, staticsByMonth[26].revenue,
                    staticsByMonth[27].revenue, staticsByMonth[28].revenue, staticsByMonth[29].revenue,
                    staticsByMonth[30].revenue],
                  borderColor: 'limegreen',
                  backgroundColor: [
                    'limegreen'
                  ],
                  borderWidth: 1
                },
                {
                  label: 'L???i nhu???n',
                  data: [staticsByMonth[0].profit, staticsByMonth[1].profit, staticsByMonth[2].profit,
                    staticsByMonth[3].profit, staticsByMonth[4].profit, staticsByMonth[5].profit,
                    staticsByMonth[6].profit, staticsByMonth[7].profit, staticsByMonth[8].profit,
                    staticsByMonth[9].profit, staticsByMonth[10].profit, staticsByMonth[11].profit,
                    staticsByMonth[12].profit, staticsByMonth[13].profit, staticsByMonth[14].profit,
                    staticsByMonth[15].profit, staticsByMonth[16].profit, staticsByMonth[17].profit,
                    staticsByMonth[18].profit, staticsByMonth[19].profit, staticsByMonth[20].profit,
                    staticsByMonth[21].profit, staticsByMonth[22].profit, staticsByMonth[23].profit,
                    staticsByMonth[24].profit, staticsByMonth[25].profit, staticsByMonth[26].profit,
                    staticsByMonth[27].profit, staticsByMonth[28].profit, staticsByMonth[29].profit,
                    staticsByMonth[30].profit],
                  borderColor: 'violet',
                  backgroundColor: [
                    'violet'
                  ],
                  borderWidth: 2
                },
              ]
            },
            options: {
              responsive: false,
              scales: {
                y: {
                  beginAtZero: true,
                },
              },
            },

          });
        });
    } else {
      this.staticsByMonth = [];
      this.show1 = false;
      this.reportService.getStatic(this.staticForm.value.year).subscribe(statics => {
        this.showYear = this.staticForm.value.year;
        this.show = true;
        console.log(statics);
        this.statics = statics;
        this.canvas = document.getElementById('myChart');
        this.ctx = this.canvas.getContext('2d');
        const myChart = new Chart(this.ctx, {
          type: 'line',
          data: {
            labels: ['Th??ng 1', 'Th??ng 2', 'Th??ng 3', 'Th??ng 4', 'Th??ng 5', 'Th??ng 6', 'Th??ng 7', 'Th??ng 8', 'Th??ng 9', 'Th??ng 10'
              , 'Th??ng 11', 'Th??ng 12'],
            datasets: [
              {
                label: 'Doanh thu',
                data: [statics[0].revenue, statics[1].revenue, statics[2].revenue, statics[3].revenue
                  , statics[4].revenue, statics[5].revenue, statics[6].revenue, statics[7].revenue
                  , statics[8].revenue, statics[9].revenue, statics[10].revenue, statics[11].revenue],
                borderColor: 'limegreen',
                backgroundColor: [
                  'limegreen'
                ],
                borderWidth: 1
              },
              {
                label: 'L???i nhu???n',
                data: [statics[0].profit, statics[1].profit, statics[2].profit, statics[3].profit
                  , statics[4].profit, statics[5].profit, statics[6].profit, statics[7].profit
                  , statics[8].profit, statics[9].profit, statics[10].profit, statics[11].profit],
                borderColor: 'violet',
                backgroundColor: [
                  'violet'
                ],
                borderWidth: 2
              },
            ]
          },
          options: {
            responsive: false,
            scales: {
              y: {
                beginAtZero: true,
              },
            },
          },

        });
      });
    }
  }
}
