import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ExcursionsGridComponent } from './layout/excursions-grid/excursions-grid.component';


const routes: Routes = [
  { path: '', redirectTo: '/home', pathMatch: 'full' },
  { path: 'excursions', component: ExcursionsGridComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
