import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CustomerListComponent } from './customer/customer-list/customer-list.component';
import {HttpClientModule} from "@angular/common/http";
import { CustomerCreateComponent } from './customer/customer-create/customer-create.component';
import {ReactiveFormsModule} from "@angular/forms";
import { CustomerEditComponent } from './customer/customer-edit/customer-edit.component';
import {ToastrModule} from "ngx-toastr";
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';

@NgModule({
  declarations: [
    AppComponent,
    CustomerListComponent,
    CustomerCreateComponent,
    CustomerEditComponent,
    HeaderComponent,
    FooterComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
    ToastrModule.forRoot({
      positionClass :'toast-top-right'})
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
