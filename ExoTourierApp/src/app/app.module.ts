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


@NgModule({
  declarations: [
    AppComponent,
    FooterComponent,
    NavComponent,
    HeaderComponent,
    ExcursionsGridComponent,
    LandingComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [UserService ,HttpService],
  bootstrap: [AppComponent]
})
export class AppModule { }
