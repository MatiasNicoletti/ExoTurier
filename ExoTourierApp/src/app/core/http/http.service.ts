import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { UserService } from '../services/user.service';
import { map, tap, catchError } from 'rxjs/operators';
import { Observable } from 'rxjs';
import { User } from '../models/User';
import { strict } from 'assert';
@Injectable({
  providedIn: 'root'
})
export class HttpService {

  constructor(private http: HttpClient, private userService: UserService) { }

  public fetchUsers(): Observable<User[]>{

    return this.http.get<User[]>('http://localhost:8080/users/').pipe(
      map((users: User[]) => {
        const change: User[] = users;
        change.map((u: User) => {
            u.name = u.name.toUpperCase();
            return u;
        })
        return users;
      })/*, catchError(e => console.log(e))*/
    );
  }
   
}
