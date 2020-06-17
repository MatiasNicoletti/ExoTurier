import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Excursion } from '../models/Excursion';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class ExcursionService {
  excursions: [] = [];
  excursionsUrl: string;

  constructor(private http: HttpClient) {
    this.excursionsUrl = 'http://localhost:8080/api/excursions';
  }

  public setExcursions(excursions) {
    this.excursions = excursions;
  }

  public findAll(): Observable<Excursion[]> {
    return this.http.get<Excursion[]>(this.excursionsUrl);
  }

  public save(user: Excursion) {
    return this.http.post<Excursion>(this.excursionsUrl, user);
  }
}
