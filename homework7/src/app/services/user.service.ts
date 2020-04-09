import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from '../dto/user';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http : HttpClient) { }


  public getUsers() : Observable<Array<User>> {
    return this.http.get<Array<User>>(environment.apiURL + 'user');
  }

  public saveUser(user : User) : Observable<User> {
    return this.http.post<User>(environment.apiURL + 'user', user);
  }

  public updateUser(user : User) : Observable<User> {
    return this.http.put<User>(environment.apiURL + 'user/' + user.id, user);
  }

  public delUser(user : User) : Observable<User> {
    return this.http.delete<User>(environment.apiURL + 'user/' + user.id);
  }

}
