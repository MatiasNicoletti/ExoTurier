import { Component, OnInit } from '@angular/core';
import { Excursion } from 'src/app/core/models/Excursion';
import { ExcursionService } from 'src/app/core/services/excursion.service';
import { UserService } from 'src/app/core/services/user.service';
import { PurchasesService } from 'src/app/core/services/purchases.service';
import { Purchase } from 'src/app/core/models/Purchase';

@Component({
  selector: 'app-reports-dashboard',
  templateUrl: './reports-dashboard.component.html',
  styleUrls: ['../../../styles/layout/dashboard/_reports.scss'],
})
export class ReportsDashboardComponent implements OnInit {
  excursions: Excursion[];
  countExcursions: Number;
  mostPurchased: Excursion;
  countUsers: Number;
  purchases: Purchase[];
  countPurchases: Number;
  totalAmount: Number;

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

    this.purchaseService.findAll().subscribe((data) => {                        
      this.purchases = data;
      this.countPurchases = data.length;      

      for(let i = 0; i < this.purchases.length; i++) {
        this.totalAmount += this.purchases[i].totalPrice;
      }
    });

  }
}
