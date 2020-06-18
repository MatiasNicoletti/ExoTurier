import { Component, OnInit, Input, Output, EventEmitter, OnChanges, SimpleChanges } from '@angular/core';
import { HttpService } from 'src/app/core/http/http.service';
import { LoginPopupComponent } from '../login-popup/login-popup.component';
import { UtilsServiceService } from 'src/app/utils-service.service';
import { Subject } from 'rxjs';
import { UserService } from 'src/app/core/services/user.service';
import { User } from 'src/app/core/models/User';


@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['../../styles/layout/_navigation.scss']
})
export class NavComponent implements OnInit{
  @Input() user: User;

  constructor(private httpService: HttpService, private service: UtilsServiceService
    , public userService: UserService)  { }
  
  
  ngOnInit(): void {
    
    /*this.service.userLogged.subscribe(res => {
      this.user = res as User;
    });
    console.log(this.user);*/
    
    this.user = JSON.parse(localStorage.getItem('loggedUser'));
  }
 
  getUsers(){
    this.httpService.fetchExcursions().subscribe(res => {
      console.log(res);
    }, err => {
      console.log('Lista de excursiones vacia');
    });
  }

  showPopUp() {
  
    this.service.buttonClickEventTrack.next(false);
  }


  onClicked(){
    localStorage.removeItem('loggedUser');

  }

  getUser(){
    return this.userService.getLoggedUser();
  }
}
