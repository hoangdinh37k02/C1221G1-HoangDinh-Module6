import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {environment} from "../../environments/environment";
import {Observable} from "rxjs";
import {Tour} from "../model/tour";
import {LoaiTour} from "../model/loai-tour";
import {PhamVi} from "../model/pham-vi";
import {ThongKe} from "../model/thong-ke";
const API_URL = `${environment.apiUrl}`;
@Injectable({
  providedIn: 'root'
})
export class TourService {

  constructor(private http: HttpClient) { }

  public getTour(): Observable<Tour[]> {
    return this.http.get<Tour[]>(API_URL + `/tour/tour`);
  }

  public getLoaiTour(): Observable<LoaiTour[]> {
    return this.http.get<LoaiTour[]>(API_URL + `/tour/loaiTour`);
  }

  public getPhamVi(): Observable<PhamVi[]> {
    return this.http.get<PhamVi[]>(API_URL + `/tour/phamVi`);
  }

  public delete(id: number) {
    return this.http.delete<Tour>(`${API_URL}/tour/delete/${id}`);
  }

  save(tour): Observable<Tour> {
    return this.http.post<Tour>(`${API_URL}/tour/create`, tour);
  }

  public getThongKe(): Observable<ThongKe[]> {
    return this.http.get<ThongKe[]>(API_URL + `/tour/thongKe`);
  }
}
