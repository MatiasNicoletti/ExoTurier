import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { FooterComponent } from './layout/footer/footer.component';
import { NavComponent } from './layout/nav/nav.component';
import { AppRoutingModule } from './core/routing/routing.module';
import { HttpService } from './core/http/http.service';
import { UserService } from './core/services/user.service';
import { HttpClientModule } from '@angular/common/http';
import { HeaderComponent } from './layout/header/header.component';
import { ExcursionsGridComponent } from './layout/excursions-grid/excursions-grid.component';
import { LandingComponent } from './layout/landing/landing.component';
import { RouterModule } from '@angular/router';
import { OutstandingExcursionComponent } from './layout/outstanding-excursion/outstanding-excursion.component';
import { FilterComponent } from './layout/filter/filter.component';
import { GridComponent } from './layout/grid/grid.component';
import { BuyExcursionComponent } from './layout/buy-excursion/buy-excursion.component';
import { HomeDashboardComponent } from './layout/dashboard/home-dashboard/home-dashboard.component';
import { HeaderDashboardComponent } from './layout/dashboard/header-dashboard/header-dashboard.component';
import { FooterDashboardComponent } from './layout/dashboard/footer-dashboard/footer-dashboard.component';
import { NewExcursionDashboardComponent } from './layout/dashboard/new-excursion-dashboard/new-excursion-dashboard.component';
import { ExcursionsDashboardComponent } from './layout/dashboard/excursions-dashboard/excursions-dashboard.component';
import { UsersDashboardComponent } from './layout/dashboard/users-dashboard/users-dashboard.component';
import { ReportsDashboardComponent } from './layout/dashboard/reports-dashboard/reports-dashboard.component';
import { SidebarDashboardComponent } from './layout/dashboard/sidebar-dashboard/sidebar-dashboard.component';
import { NavDashboardComponent } from './layout/dashboard/nav-dashboard/nav-dashboard.component';
import { LoginPopupComponent } from './layout/login-popup/login-popup.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { SecondLandingComponent } from './layout/second-landing/second-landing.component';
import { SignInComponent } from './layout/sign-in/sign-in.component';
@NgModule({
  declarations: [
    AppComponent,
    FooterComponent,
    NavComponent,
    HeaderComponent,
    ExcursionsGridComponent,
    LandingComponent,
    OutstandingExcursionComponent,
    FilterComponent,
    GridComponent,
    BuyExcursionComponent,
    HomeDashboardComponent,
    HeaderDashboardComponent,
    FooterDashboardComponent,
    NewExcursionDashboardComponent,
    ExcursionsDashboardComponent,
    UsersDashboardComponent,
    ReportsDashboardComponent,
    SidebarDashboardComponent,
    NavDashboardComponent,
    LoginPopupComponent,
    SecondLandingComponent,
    SignInComponent,
  ],
  imports: [BrowserModule, AppRoutingModule, HttpClientModule,FormsModule, ReactiveFormsModule], 
  providers: [UserService, HttpService],
  bootstrap: [AppComponent],
}) 
export class AppModule {}
