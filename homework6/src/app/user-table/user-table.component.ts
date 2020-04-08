import { Component, OnInit, Input } from '@angular/core';
import { User } from '../dto/user';

@Component({
  selector: 'hom-user-table',
  templateUrl: './user-table.component.html',
  styleUrls: ['./user-table.component.css']
})
export class UserTableComponent implements OnInit {

  constructor() { }
  @Input() public users : Array<User>;

  ngOnInit(): void {
  }

}
