import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import {SelectItem} from 'primeng/api';
import { ExamDto } from 'src/app/dto/ExamDto';
import { QuestionDto } from 'src/app/dto/abstractDto/QuestionDto';
import { FormGroup, FormBuilder, FormControl, Validators } from '@angular/forms';

@Component({
  selector: 'hom-exam-question',
  templateUrl: './exam-question.component.html',
  styleUrls: ['./exam-question.component.css']
})
export class ExamQuestionComponent implements OnInit {

  @Input() public exam : ExamDto;
  @Output() public emitter : EventEmitter<ExamDto>;
  public questions : Array<QuestionDto>;
  public question : QuestionDto;
  public questionsTypes : SelectItem[];
  public questionType : String;
  public form : FormGroup;

  constructor(
    public formBuilder: FormBuilder
  ) { }

  ngOnInit(): void {
    this.form = this.formBuilder.group({
      weight : new FormControl('', [Validators.required, Validators.maxLength(100)]),
      description : new FormControl('', [Validators.required, Validators.maxLength(100)])
    });

    this.questionsTypes = [
      {label: 'Multi question', value:'Multi'}, 
      {label: 'Unique question', value:'Unique'}, 
      {label: 'Open question', value:'Open'}
    ];

    this.questions = new Array<QuestionDto>();
    this.questionType = "";
  }

  public clear(event : Event): void {
    this.form.reset();
  }

  public activeIndexChange() : void {
    console.log("Evento");
    this.emitter.emit(this.exam);
  }

  public saveQuestion() : void {

  }

  public sendQuestion($event) : void  {
    this.question = <QuestionDto> this.form.value
  }

  public weight() : any {
    return this.form.get('weight');
  }

  public descript() : any {
    return this.form.get('description');
  }
}
