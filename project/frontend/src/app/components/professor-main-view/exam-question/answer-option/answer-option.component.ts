import { Component, OnInit, Input } from '@angular/core';
import { QuestionDto } from 'src/app/dto/abstractDto/QuestionDto';
import { FormGroup, FormBuilder, FormControl, Validators } from '@angular/forms';
import { AnswerOptionDto } from 'src/app/dto/AnswerOptionDto';

@Component({
  selector: 'hom-answer-option',
  templateUrl: './answer-option.component.html',
  styleUrls: ['./answer-option.component.css']
})
export class AnswerOptionComponent implements OnInit {

  public form : FormGroup;
  public answerOptions : Array<AnswerOptionDto>;
  private ansOpt : AnswerOptionDto;

  @Input() public question : QuestionDto;

  constructor(public formBuilder : FormBuilder) { }

  ngOnInit(): void {
    this.form = this.formBuilder.group({
      weight : new FormControl('', [Validators.required, Validators.maxLength(100)]),
      description : new FormControl('', [Validators.required, Validators.maxLength(100)]),
      correctAnswer : new FormControl('', [Validators.required, Validators.maxLength(100)])
    });

    this.answerOptions = Array<AnswerOptionDto>();
  }

  public weight() : any {
    return this.form.get('weight');
  }

  public descript() : any {
    return this.form.get('description');
  }

  public receiveAnsOptRequest($event) : void {
    let requestType = $event.requestType;
    this.ansOpt = <AnswerOptionDto> $event.answerDto;

    if (requestType === "edit") {
      this.form.setValue(this.ansOpt);
    }

    if (requestType === "del") {
      this.answerOptions.splice(this.answerOptions.indexOf(this.ansOpt), 1);
    }
  }

  public saveAnswerOption() : void {
    let ansOpt = <AnswerOptionDto> this.form.value;
    let index = this.answerOptions.indexOf(this.ansOpt);

    if (index === -1) {
      this.answerOptions.push(ansOpt);
    }
    else {
      this.answerOptions.splice(index, 1, ansOpt);
    }

    this.form.reset();
  }
}
