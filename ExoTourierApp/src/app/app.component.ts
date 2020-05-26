import { Component } from '@angular/core';
import { HttpService } from './core/http/http.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'ExoTourierApp';

  constructor(private httpService: HttpService){}


  getUsers(){
  this.httpService.fetchUsers().subscribe(res => {
    console.log(res);
  }, err => {
    console.log('Lista de usuarios vacia');
  });
  
  }
}
