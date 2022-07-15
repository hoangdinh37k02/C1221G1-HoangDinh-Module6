import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';

import {EmployeeRoutingModule} from './employee-routing.module';
import {EmployeeListComponent} from "./employee-list/employee-list.component";
import {EmployeeCeateComponent} from "./employee-ceate/employee-ceate.component";
import {EmployeeEditComponent} from "./employee-edit/employee-edit.component";
import {EmployeeModalComponent} from "./employee-modal/employee-modal.component";


@NgModule({
  declarations: [
    EmployeeListComponent,
    EmployeeCeateComponent,
    EmployeeEditComponent,
    EmployeeModalComponent],
  imports: [
    CommonModule,
    EmployeeRoutingModule
  ]
})
export class EmployeeModule {
}
