import { Component, OnInit, Input, Output, EventEmitter} from '@angular/core';
import { User } from '../dto/user';

@Component({
  selector: 'hom-user-table',
  templateUrl: './user-table.component.html',
  styleUrls: ['./user-table.component.css']
})
export class UserTableComponent implements OnInit {

  @Input() public users : Array<User>;
  @Output() public evenEmitter : EventEmitter<User>;

  constructor() { 
    this.evenEmitter = new EventEmitter<User>();
  }

  ngOnInit(): void {
  }

  public editUser(user : User) : void {
    this.evenEmitter.emit(user);
  }

  public delUser(user : User) : void {
    let index = this.users.indexOf(user);
    this.users.splice(index, 1);
  }
}
