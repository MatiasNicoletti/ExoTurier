import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { UserService } from '../services/user.service';

@Injectable({
  providedIn: 'root'
})
export class HttpService {

  constructor(private http: HttpClient, private userService: UserService) { }

  public fetchUsers(){
    return this.http.get<any[]>('http://localhost:8080/users/');
  }
}
