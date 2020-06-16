import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UtilsServiceService {
  public buttonClickEventTrack = new Subject();
  constructor() { }
}
