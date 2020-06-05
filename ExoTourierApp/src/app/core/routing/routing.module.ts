import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { ExcursionsGridComponent } from 'src/app/layout/excursions-grid/excursions-grid.component';
import { LandingComponent } from 'src/app/layout/landing/landing.component';


const routes: Routes = [
  { path: '', component: LandingComponent},
  { path: 'home', component: LandingComponent},
  { path: 'excursions', component: ExcursionsGridComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }