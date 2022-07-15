import { Injectable } from '@angular/core';
import {environment} from "../../environments/environment";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Customer} from "../model/customer";
import {Type} from "../model/type";
const API_URL = `${environment.apiUrl}`;
@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  constructor(private http: HttpClient) { }

  public getAllEmployee(request): Observable<Customer[]> {
    const params = request;
    return this.http.get<Customer[]>(API_URL + `/customer`, {params});
  }

  public getAllType(): Observable<Type[]> {
    return this.http.get<Type[]>(API_URL + `/customer/type`);
  }

  findById(customerId: number): Observable<Customer | any> {
    return this.http.get(`${API_URL}/customer/${customerId}`);
  }

  delete(customerId: number) {
    return this.http.delete<Customer>(`${API_URL}/customer/delete/${customerId}`);
  }

  saveEmployee(customer): Observable<Customer> {
    return this.http.post<Customer>(`${API_URL}/customer/create`, customer);
  }

  updateCustomer(id: number, customer: Customer): Observable<Customer> {
    return this.http.patch<Customer>(`${API_URL}/customer/${id}`, customer);
  }
}
