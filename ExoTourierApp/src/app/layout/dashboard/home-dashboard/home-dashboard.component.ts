import { Component, OnInit } from '@angular/core';
import { ExcursionService } from 'src/app/core/services/excursion.service';
import { UserService } from 'src/app/core/services/user.service';
import { PurchasesService } from 'src/app/core/services/purchases.service';
import { Excursion } from 'src/app/core/models/Excursion';

@Component({
  selector: 'app-home-dashboard',
  templateUrl: './home-dashboard.component.html',
  styleUrls: ['../../../styles/layout/dashboard/_home.scss'],
})
export class HomeDashboardComponent implements OnInit {
    
  countExcursions: Number;
  mostPurchased: Excursion;
  countUsers: Number;      

  constructor(private excursionService: ExcursionService, private userService: UserService, private purchaseService: PurchasesService) {}

  ngOnInit() {
    
    this.userService.findAll().subscribe((data) => {
      this.countUsers = data.length;
    });

    this.excursionService.findAll().subscribe((data) => {
      this.excursions = data;      
      this.countExcursions = this.excursions.length;            
    });

    this.excursionService.mostPurchased().subscribe((data) => {                  
      this.mostPurchased = data.body;
    }); 
  }
    
}
