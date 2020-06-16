import { Injectable } from '@angular/core';
import { HttpService } from '../http/http.service';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  users: [] = [];
  constructor(private httpService: HttpService) { 
   
  }

  

  public setUsers(users){
    this.users = users;
  }

  public login(email:string, password:string){
   
      return this.httpService.login(email, password).subscribe(res =>{
        console.log(res);
      });
  }
}
