import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { ProfessorDto } from '../../dto/ProfessorDto';
import { ProfessorService } from '../../services/Professsor.service';
import { FormGroup, FormBuilder, FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'hom-professor-formulary',
  templateUrl: './professor-formulary.component.html',
  styleUrls: ['./professor-formulary.component.css'],
  providers: [ProfessorService]
})
export class ProfessorFormularyComponent implements OnInit {

  public form: FormGroup;
  public signUpFailed : boolean;

  constructor(private ProfessorService : ProfessorService,
    private formBuilder : FormBuilder,
    private router : Router
    ) {  }

  ngOnInit(): void {
    this.form = this.formBuilder.group({
      id : ['', []],
      identificationCard : new FormControl('', [Validators.pattern("[0-9]+"), Validators.maxLength(15)]),
      name : new FormControl('', [Validators.required, Validators.maxLength(100)]),
      lastname : new FormControl('', [Validators.required, Validators.maxLength(100)]),
      email : new FormControl('', [Validators.required, Validators.maxLength(100), Validators.email]),
      username : new FormControl('', [Validators.required, Validators.maxLength(100)]),
      password : new FormControl('', [Validators.required, Validators.minLength(8), Validators.maxLength(16)]),
      exams : ['', []]
    });

    this.signUpFailed = false;
  }

  public saveProfessor() : void {    
    this.ProfessorService.saveProfessor(<ProfessorDto> this.form.value).subscribe(
      response => {
        this.form.reset();
        let url = "/login"
        this.router.navigate([url]);
      },
      error => {
        console.log(error);
        this.signUpFailed = true;
      }
    );
  }

  public cancel() : void {
    this.form.reset();
    let url = "/login";
    this.router.navigate([url]);
  }
}
