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
  public userDtoCopy : User;
  public users : Array<User>;
  public showAddBtn : boolean;

  constructor() {
    this.showAddBtn = true;
  }

  ngOnInit(): void {
    this.userDto = new User();
    this.users = new Array<User>();
  }

  ngOnChange() {
    console.log("Changed");
  }

  public saveUser() : void {
    if(this.users.indexOf(this.userDto) != -1) 
      return;
    this.users.push(this.userDto);
    this.resetUser();
  }
  
  public resetUser() : void {
    this.userDto = new User();
    this.showAddBtn = true;
  }

  private makeCopy() : void {
    this.userDtoCopy = new User();
    this.userDtoCopy.setId(this.userDto.getId());
    this.userDtoCopy.setUsername(this.userDto.getUsername());
    this.userDtoCopy.setName(this.userDto.getName());
    this.userDtoCopy.setEmail(this.userDto.getEmail());
    this.userDtoCopy.setPassword(this.userDto.getPassword());
  }

  public receiveEvent($event) : void {
    this.showAddBtn = false;
    this.userDto = $event;
    this.makeCopy();
  }

  public cancelUpdate() : void {
    this.userDto.setId(this.userDtoCopy.getId());
    this.userDto.setUsername(this.userDtoCopy.getUsername());
    this.userDto.setName(this.userDtoCopy.getName());
    this.userDto.setEmail(this.userDtoCopy.getEmail());
    this.userDto.setPassword(this.userDtoCopy.getPassword());
    this.resetUser();
  }
}
