import {EmployeeRoutingModule} from './employee-routing.module';
import {EmployeeListComponent} from './employee-list/employee-list.component';
import {EmployeeCeateComponent} from './employee-ceate/employee-ceate.component';
import {EmployeeEditComponent} from './employee-edit/employee-edit.component';
import {EmployeeModalComponent} from './employee-modal/employee-modal.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {AngularFireModule} from '@angular/fire';
import {environment} from '../../../environments/environment.prod';
import {CommonModule} from "@angular/common";
import {NgModule} from "@angular/core";


@NgModule({
  declarations: [
    EmployeeListComponent,
    EmployeeCeateComponent,
    EmployeeEditComponent,
    EmployeeModalComponent],
  imports: [
    CommonModule,
    EmployeeRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    AngularFireModule.initializeApp(environment.firebaseConfig)
  ]
})
export class EmployeeModule {
}
