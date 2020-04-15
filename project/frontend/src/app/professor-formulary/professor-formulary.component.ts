import { Component, OnInit } from '@angular/core';
import { ProfessorDto } from '../dto/ProfessorDto';
import { ProfessorService } from '../services/Professsor.service';
import { FormGroup, FormBuilder, FormControl, Validators } from '@angular/forms';

@Component({
  selector: 'hom-professor-formulary',
  templateUrl: './professor-formulary.component.html',
  styleUrls: ['./professor-formulary.component.css'],
  providers: [ProfessorService]
})
export class ProfessorFormularyComponent implements OnInit {

  //Attributes control in my form
  public form: FormGroup;
  public professors : Array<ProfessorDto>;
  public showAddBtn : boolean;

  constructor(private ProfessorService : ProfessorService,
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
    this.getProfessors();
  }

  public getProfessors() {
    this.ProfessorService.getProfessors().subscribe(
      response => {
        this.professors = response;
      },
      error => {console.log(error.error);}
    );
  }

  ngOnChange() {
    console.log("Changed");
  }

  public saveProfessor() : void {    
    this.ProfessorService.saveProfessor(<ProfessorDto> this.form.value).subscribe(
      response => {
        this.professors.push(response);
        this.form.reset();
      },
      error => {console.log(error.error.message);}
    );
  }
  
  public receiveProfessor($professor) : void {
    this.form.setValue($professor);
    this.showAddBtn = false;
  }

  public updateProfessor() : void {
    this.ProfessorService.updateProfessor(<ProfessorDto> this.form.value).subscribe(
      response => {
        this.professors.splice(this.professors.indexOf(this.form.value),1,response);
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
