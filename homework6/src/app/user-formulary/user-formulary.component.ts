import { Component, OnInit } from '@angular/core';
import { User } from '../dto/user';
import {InputTextModule} from 'primeng/inputtext';

@Component({
  selector: 'hom-user-formulary',
  templateUrl: './user-formulary.component.html',
  styleUrls: ['./user-formulary.component.css']
})
export class UserFormularyComponent implements OnInit {

  public userDto : User;
  public users : Array<User>;

  constructor() { }

  ngOnInit(): void {
    this.userDto = new User();
    this.users = new Array<User>();
  }

  ngOnChange() {
    console.log("Changed");
  }

  public saveUser() : void {
    this.users.push(this.userDto);
    this.userDto = new User();
  }
  
}
