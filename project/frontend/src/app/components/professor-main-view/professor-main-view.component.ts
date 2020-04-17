import { Component, OnInit } from '@angular/core';
import { ProfessorDto } from 'src/app/dto/ProfessorDto';
import { Router } from '@angular/router';
import { ExamDto } from 'src/app/dto/ExamDto';
import { MessageService } from 'primeng/api';
import { FormGroup, FormBuilder, FormControl, Validators } from '@angular/forms';
import {SelectItem} from 'primeng/api';

@Component({
  selector: 'hom-professor-main-view',
  templateUrl: './professor-main-view.component.html',
  styleUrls: ['./professor-main-view.component.css'],
  providers: [MessageService]
})
export class ProfessorMainViewComponent implements OnInit {

  public showForm : Boolean;
  public loggedProfessor : ProfessorDto;
  public exams : Array<ExamDto>;
  public form : FormGroup;
  // public questionsTypes : SelectItem[];
  // public questionType : String;
  
  constructor(
    public formBuilder: FormBuilder,
    private messageService : MessageService,
    private router : Router
    ) { 
      this.showForm = false;
    }

  ngOnInit(): void {
    this.form = this.formBuilder.group({
      id : ['', []],
      name : new FormControl('', [Validators.required, Validators.maxLength(100)]),
      maxGrade : new FormControl('', [Validators.required, Validators.maxLength(100)]),
      examtime : new FormControl('', [Validators.required, Validators.maxLength(100)]),
      description : new FormControl('', [Validators.required, Validators.maxLength(100)]),
    });

    this.loggedProfessor = JSON.parse(sessionStorage.professor);
    if (this.loggedProfessor === undefined) {
      let url = "/login";
      this.router.navigate([url]);
    }

    this.exams = this.loggedProfessor.exams;
    // this.questionsTypes = [
    //   {label: 'Multi question', value:'Multi'}, 
    //   {label: 'Unique question', value:'Unique'}, 
    //   {label: 'Open question', value:'Open'}
    // ];
  }

  public name() : any {
    return this.form.get('name');
  }

  public maxGrade() : any {
    return this.form.get('maxGrade');
  }

  public examtime() : any {
    return this.form.get('examtime');
  }

  public descript() : any {
    return this.form.get('description');
  }

  public receiveExam($event) : void {

  }

  public saveExam() : void {

  }

  public antiveForm() : void {
    this.showForm = true;
    // this.messageService.add({
    //   severity : 'success',
    //   summary : 'Exam created',
    //   detail : 'Exam was created sucessfully'
    // });
  }

  public cancel() : void {
    this.showForm = false;
  }

}
