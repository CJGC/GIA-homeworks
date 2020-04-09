import { Component, OnInit } from '@angular/core';
import { User } from '../dto/user';
import { UserService } from '../services/user.service';
import { FormGroup, FormBuilder, FormControl, Validators } from '@angular/forms';

@Component({
  selector: 'hom-user-formulary',
  templateUrl: './user-formulary.component.html',
  styleUrls: ['./user-formulary.component.css'],
  providers: [UserService]
})
export class UserFormularyComponent implements OnInit {

  //Attributes control in my form
  public form: FormGroup;
  public users : Array<User>;
  public showAddBtn : boolean;

  constructor(private userService : UserService,
    private formBuilder : FormBuilder) {
    this.showAddBtn = true;
  }

  ngOnInit(): void {
    this.form = this.formBuilder.group({
      id : ['', []],
      name : new FormControl('', [Validators.required, Validators.maxLength(100)]),
      username : new FormControl('', [Validators.required, Validators.maxLength(50)]),
      email : new FormControl('', [Validators.required, Validators.maxLength(100), Validators.email]),
      password : new FormControl('', [Validators.required, Validators.minLength(8), Validators.maxLength(16)])
    });
    this.showAddBtn = true;
    this.getUsers();
  }

  public getUsers() {
    this.userService.getUsers().subscribe(
      response => {
        this.users = response;
      },
      error => {console.log(error.error);}
    );
  }

  ngOnChange() {
    console.log("Changed");
  }

  public saveUser() : void {    
    this.userService.saveUser(<User> this.form.value).subscribe(
      response => {
        this.users.push(response);
        this.form.reset();
      },
      error => {console.log(error.error.message);}
    );
  }
  
  public receiveUser($user) : void {
    this.form.setValue($user);
    this.showAddBtn = false;
  }

  public updateUser() : void {
    this.userService.updateUser(<User> this.form.value).subscribe(
      response => {
        this.users.splice(this.users.indexOf(this.form.value),1,response);
        this.form.reset();
      },
      error => {console.log(error.error.message);}
    )
    this.showAddBtn = true;
  }

  public cancelUpdate() : void {
    this.form.reset();
    this.showAddBtn = true;
  }
}
