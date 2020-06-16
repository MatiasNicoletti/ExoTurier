import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { HttpService } from 'src/app/core/http/http.service';
import { LoginPopupComponent } from '../login-popup/login-popup.component';
import { UtilsServiceService } from 'src/app/utils-service.service';
import { Subject } from 'rxjs';


@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['../../styles/layout/_navigation.scss']
})
export class NavComponent implements OnInit {


  constructor(private httpService: HttpService, private service: UtilsServiceService)  { }
  
  ngOnInit(): void {
    
  }

  getUsers(){
    this.httpService.fetchExcursions().subscribe(res => {
      console.log(res);
    }, err => {
      console.log('Lista de excursiones vacia');
    });
  }

  changeColors() {
    this.service.buttonClickEventTrack.next(false);
  }
}
