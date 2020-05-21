import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { UserService } from '../services/user.service';
import { map, tap } from 'rxjs/operators';
import { Observable } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class HttpService {

  constructor(private http: HttpClient, private userService: UserService) { }

  public fetchUsers(){

   let response = this.http.get<Observable<any>>('http://localhost:8080/users/');
  //  console.log(response);
    return response;
  }
}
