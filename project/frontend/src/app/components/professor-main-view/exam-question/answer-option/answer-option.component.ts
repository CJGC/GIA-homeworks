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
  public anwerOptions : Array<AnswerOptionDto>;

  @Input() public question : QuestionDto;

  constructor(public formBuilder : FormBuilder) { }

  ngOnInit(): void {
    this.form = this.formBuilder.group({
      weight : new FormControl('', [Validators.required, Validators.maxLength(100)]),
      description : new FormControl('', [Validators.required, Validators.maxLength(100)]),
      correctAnswer : new FormControl('', [Validators.required, Validators.maxLength(100)])
    });

    this.anwerOptions = Array<AnswerOptionDto>();
  }

  public weight() : any {
    return this.form.get('weight');
  }

  public descript() : any {
    return this.form.get('description');
  }

  public saveAnswerOption() : void {
    this.anwerOptions.push(<AnswerOptionDto> this.form.value);
  }
}
