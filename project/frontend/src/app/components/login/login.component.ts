import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, FormControl, Validators } from '@angular/forms';
import { ProfessorService } from '../../services/Professsor.service';
import { Router } from '@angular/router';

@Component({
  selector: 'hom-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  public form: FormGroup;
  public loginfailed: Boolean;
  public passDoesNotMatch: Boolean;

  constructor(
    private professorService : ProfessorService,
    private formBuilder : FormBuilder,
    private router : Router) { }

  ngOnInit(): void {
    this.form = this.formBuilder.group({
      username : new FormControl('', [Validators.required, Validators.maxLength(100)]),
      password : new FormControl('', [Validators.required, Validators.minLength(8), Validators.maxLength(16)])
    });
    
    this.loginfailed = false;
    this.passDoesNotMatch = false;
  }

  public logIn() : void {
    this.passDoesNotMatch = false;
    this.loginfailed = false;
      this.professorService.getByUsername(this.form.value.username).
        subscribe (
          response => {
            if (response.password !== this.form.value.password) {
              this.passDoesNotMatch = true;
              return;
            }

            sessionStorage.professor = JSON.stringify(response);
            let url = "/professor-main-view";
            this.router.navigate([url]);
          },
          error => {
            if (error.error === "Professor doesn't exist") {
              this.loginfailed = true;
            }
            else {
              console.log(error);
            }
          }
        );
  }

  public signUp() : void {
    let url = "/create-professor";
    this.router.navigate([url]);
  }
}
