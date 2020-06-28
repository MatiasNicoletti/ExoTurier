import { Injectable } from '@angular/core';
import { HttpService } from '../http/http.service';
import { Purchase } from '../models/Purchase';

@Injectable({
  providedIn: 'root'
})
export class PurchasesService {
  
  purchases: Purchase[];

  constructor(private httpService: HttpService) { }

  public findAll() {
    return this.httpService.fetchPurchases();
  }

}
