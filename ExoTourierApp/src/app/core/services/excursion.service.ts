import { Injectable } from '@angular/core';
import { Excursion } from '../models/Excursion';
import { Observable } from 'rxjs';
import { HttpService } from '../http/http.service';

@Injectable({
  providedIn: 'root',
})
export class ExcursionService {
  excursions: [] = [];
  excursionsUrl: string;

  constructor(private httpService: HttpService) {}

  public setExcursions(excursions) {
    this.excursions = excursions;
  }

  public findAll() {
    return this.httpService.fetchExcursions();
  }

  public create(excursion: Excursion) {
    return this.httpService.saveExcursion(excursion);
  }
}
