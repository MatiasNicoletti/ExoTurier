import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  users: [] = [];
  constructor() { 
   
  }

  

  public setUsers(users){
    this.users = users;
  }
}
