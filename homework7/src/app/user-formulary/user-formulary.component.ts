import { Component, OnInit } from '@angular/core';
import { User } from '../dto/user';
import { UserTableService } from '../user-table/user-table.service';
import { FormGroup, FormBuilder, FormControl, Validators } from '@angular/forms';

@Component({
  selector: 'hom-user-formulary',
  templateUrl: './user-formulary.component.html',
  styleUrls: ['./user-formulary.component.css'],
  providers: [UserTableService]
})
export class UserFormularyComponent implements OnInit {

  //Attributes control in my form
  public form: FormGroup;


  public userDto : User;
  public userDtoCopy : User;
  public users : Array<User>;
  public showAddBtn : boolean;

  constructor(private tableService : UserTableService,
    private formBuilder : FormBuilder) {
    this.showAddBtn = true;
  }

  ngOnInit(): void {
    this.form = this.formBuilder.group({
      id : ['', []],
      name : new FormControl('', [Validators.required, Validators.maxLength(100)]),
      username : new FormControl('', [Validators.required, Validators.maxLength(50)]),
      email : new FormControl('', [Validators.required, Validators.maxLength(100)]),
      password : new FormControl('', [Validators.required, Validators.minLength(8), Validators.maxLength(16)])
    });

    this.userDto = new User();
    this.users = new Array<User>();
  }

  ngOnChange() {
    console.log("Changed");
  }

  public saveUser() : void {    
    this.tableService.saveUser(<User> this.form.value);
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
