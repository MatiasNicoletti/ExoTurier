import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';
import { ExcursionsGridComponent } from 'src/app/layout/excursions-grid/excursions-grid.component';
import { LandingComponent } from 'src/app/layout/landing/landing.component';
import { BuyExcursionComponent } from 'src/app/layout/buy-excursion/buy-excursion.component';
import { HomeDashboardComponent } from 'src/app/layout/dashboard/home-dashboard/home-dashboard.component';
import { NewExcursionDashboardComponent } from 'src/app/layout/dashboard/new-excursion-dashboard/new-excursion-dashboard.component';
import { UsersDashboardComponent } from 'src/app/layout/dashboard/users-dashboard/users-dashboard.component';
import { ReportsDashboardComponent } from 'src/app/layout/dashboard/reports-dashboard/reports-dashboard.component';
import { ExcursionsDashboardComponent } from 'src/app/layout/dashboard/excursions-dashboard/excursions-dashboard.component';

const routes: Routes = [
  { path: '', component: LandingComponent },
  { path: 'home', component: LandingComponent },
  { path: 'excursions', component: ExcursionsGridComponent },
  { path: 'single', component: BuyExcursionComponent },

  { path: 'dashboard', component: HomeDashboardComponent },
  { path: 'dashboard/excursion', component: NewExcursionDashboardComponent },
  { path: 'dashboard/excursions', component: ExcursionsDashboardComponent },
  { path: 'dashboard/user', component: UsersDashboardComponent },
  { path: 'dashboard/reports', component: ReportsDashboardComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
