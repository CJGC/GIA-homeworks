import {OnInit } from '@angular/core';
import { QuestionDto } from './abstractDto/QuestionDto';
import { AnswerOptionDto } from './AnswerOptionDto';

export class MultiQuestionDto extends QuestionDto implements OnInit {
    
    public answerOptions : Array<AnswerOptionDto>;

    ngOnInit() {
        this.answerOptions = new Array<AnswerOptionDto>();
    }

}
