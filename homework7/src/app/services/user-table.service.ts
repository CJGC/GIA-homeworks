import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from '../dto/user';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class UserTableService {

  constructor(private http : HttpClient) { }


  public getUsers() : Observable<Array<User>> {
    return this.http.get<Array<User>>(environment.apiURL + 'user');
  }

  public saveUser(user : User) : void {
    this.http.post<User>(environment.apiURL + 'user', user).subscribe(
      res => {
        console.log(res);
      }
      , error => {
        console.error(error.error.message);
      }
    );
  }
}
