import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { UserService } from '../services/user.service';
import { map, tap, catchError } from 'rxjs/operators';
import { Observable } from 'rxjs';
import { User } from '../models/User';
import { strict } from 'assert';
@Injectable({
  providedIn: 'root'
})
export class HttpService {
  private httpHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });
  constructor(private http: HttpClient, private userService: UserService) { }

  public fetchUsers(): Observable<User[]>{

    return this.http.get<User[]>('http://localhost:8080/users/').pipe(
      map((users: User[]) => {
        const change: User[] = users;
        change.map((u: User) => {
            u.firstname = u.firstname.toUpperCase();
            return u;
        });
        return users;
      })/*, catchError(e => console.log(e))*/
    );
  }

  public addUser(){
    const user: User = {
       id: 0,
       email: "tutanka@gmail.com",
       isActive: true,
       firstname: "Tutanka",
       surname: "Amon", 
       password: "123456",
       purchases: []
    }
    return this.http.post('http://localhost:8080/users/', user, { headers: this.httpHeaders });
  }
   
}
