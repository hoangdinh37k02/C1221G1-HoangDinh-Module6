import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {TourListComponent} from "./tour-list/tour-list.component";
import {TourCreateComponent} from "./tour-create/tour-create.component";
import {TourStaticComponent} from "./tour-static/tour-static.component";


const routes: Routes = [
  {
    path: '', pathMatch: 'full', redirectTo: 'list'
  },
  {path: 'list', component: TourListComponent},
  {path: 'create', component: TourCreateComponent},
  {path: 'static', component: TourStaticComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
