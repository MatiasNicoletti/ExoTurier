import { Injectable } from '@angular/core';
import { City } from '../models/City';
import { HttpService } from '../http/http.service';

@Injectable({
  providedIn: 'root',
})
export class CityService {
  Cities: City[];

  constructor(private httpService: HttpService) {}

  public findAll() {
    return this.httpService.fetchCities();
  }
}
