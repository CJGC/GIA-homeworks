import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, FormControl, Validators } from '@angular/forms';
import { ProfessorService } from '../../services/Professsor.service';
import { environment } from 'src/environments/environment';
import { ActivatedRoute, Router } from '@angular/router';


@Component({
  selector: 'hom-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  public form: FormGroup;
  public loginfailed: Boolean;

  constructor(
    private professorService : ProfessorService,
    private formBuilder : FormBuilder,
    private router : Router) { 
      
    }

  ngOnInit(): void {
    this.form = this.formBuilder.group({
      username : new FormControl('', [Validators.required, Validators.maxLength(100)]),
      password : new FormControl('', [Validators.required, Validators.minLength(8), Validators.maxLength(16)])
    });
    
    this.loginfailed = false;
  }

  public logIn() : void {
      this.professorService.getByUsername(this.form.value.username).
        subscribe (
          response => {
            console.log(response);
          },
          error => {
            if (error.error === "Professor doesn't exist") {
              this.loginfailed = true;
            }
          }
        );
  }

  public signUp() : void {
    let url = "/create-professor";
    this.router.navigate([url]);
  }
}
