import {BrowserModule, Title} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {HttpClientModule} from '@angular/common/http';
import {AngularFireStorageModule} from '@angular/fire/storage';
import {AngularFireModule} from '@angular/fire';
import {environment} from '../environments/environment';
import {ToastrModule} from 'ngx-toastr';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {NotFoundComponent} from './component/not-found/not-found.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {HomePageComponent} from './component/templates/home-page/home-page.component';
import {TemplatesModule} from './component/templates/templates.module';
import 'firebase/database';
import {NgxSpinnerModule} from "ngx-spinner";
import {ReportModule} from './component/reports/report.module';

@NgModule({
  declarations: [
    AppComponent,
    NotFoundComponent,
    HomePageComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    AngularFireStorageModule,
    AngularFireModule.initializeApp(environment.firebaseConfig),
    ToastrModule.forRoot({
      positionClass: 'toast-top-right'
    }),
    BrowserAnimationsModule,
    ReportModule,
    FormsModule,
    ReactiveFormsModule,
    BrowserAnimationsModule,
    TemplatesModule,
    ToastrModule.forRoot({
      positionClass: 'toast-top-right'
    }),
    NgxSpinnerModule,

  ],
  providers: [Title],
  bootstrap: [AppComponent]
})
export class AppModule {
}
