import { Component, OnInit, Input, Output, EventEmitter} from '@angular/core';
import { User } from '../dto/user';
import { UserService } from '../services/user.service';


@Component({
  selector: 'hom-user-table',
  templateUrl: './user-table.component.html',
  styleUrls: ['./user-table.component.css'],
  providers: [UserService]
})
export class UserTableComponent implements OnInit {

  @Input() public users : Array<User>;
  @Output() public evenEmitter : EventEmitter<User>;

  constructor(private userService : UserService) { 
    this.evenEmitter = new EventEmitter<User>();
  }

  ngOnInit(): void {
    this.getUsers();
  }

  public getUsers() {
  
    this.userService.getUsers().subscribe( 
      res => {
        if (res != null) {
          console.log(res);
          this.users = res;
        }
      }
    ), error => {
      console.log(error.error.message);
    }
  }

  public editUser(user : User) : void {
    this.evenEmitter.emit(user);
  }

  public delUser(user : User) : void {
    let index = this.users.indexOf(user);
    this.users.splice(index, 1);
  }
}
