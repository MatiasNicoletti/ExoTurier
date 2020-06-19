import { Injectable } from '@angular/core';
import { HttpService } from '../http/http.service';
import { HttpErrorResponse } from '@angular/common/http';
import { User } from '../models/User';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root',
})
export class UserService {
  users: [] = [];
  userLogged: User;
  constructor(private httpService: HttpService) {}

  public setUsers(users) {
    this.users = users;
  }

  public login(email: string, password: string) {
    /*this.httpService.login(email, password).subscribe((res:User) =>{
      this.userLogged = res;
    }, (error: HttpErrorResponse) => {
      console.log(error.error);
    });
    return this.userLogged;*/

    return this.httpService.login(email, password);
  }
  public signin(user:User){
    
    return this.httpService.signin(user);
  }
  public getLoggedUser() {
    return this.userLogged;
  }
  public setLoggedUser(user: User) {
    this.userLogged = user;
  }
  public findAll() {
    return this.httpService.fetchUsers();
  }
}
