import { Component, OnInit } from '@angular/core';
import { ProfessorDto } from 'src/app/dto/ProfessorDto';
import { Router } from '@angular/router';
import { ExamDto } from 'src/app/dto/ExamDto';
import { MessageService, MenuItem } from 'primeng/api';
import { FormGroup, FormBuilder, FormControl, Validators } from '@angular/forms';

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
  public examSettingItems : MenuItem[];
  public activeIndex : number;
  public exam : ExamDto;
  
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

    this.examSettingItems = [
      {label: 'Exam info'},
      {label: 'Exam questions'}
    ];
    this.activeIndex = 0;
    this.exams = this.loggedProfessor.exams;
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

  public receiveExam($exam) : void {
    this.form.setValue(event);
  }

  public saveExam() : void {

  }

  public antiveForm() : void {
    this.showForm = true;
    this.exam = this.form.value;
    // this.messageService.add({
    //   severity : 'success',
    //   summary : 'Exam created',
    //   detail : 'Exam was created sucessfully'
    // });
  }

  public cancel() : void {
    this.form.reset();
    this.exam = null;
    this.showForm = false;
  }

}
