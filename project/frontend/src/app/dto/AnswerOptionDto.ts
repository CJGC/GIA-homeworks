import {OnInit } from '@angular/core';
import { QuestionDto } from './abstractDto/QuestionDto';
import { SelectedResponseDto } from './SelectedResponseDto';
import { OpenQuestionDto } from './OpenQuestionDto';

export class AnswerOptionDto implements OnInit {
    public id : number;
    public index : String;
    public description : String;
    public correctAnswer : Boolean;
    public weight : number;
    public selectedResponses : Array<SelectedResponseDto>;
    public question : QuestionDto;

    ngOnInit() {
        this.id = 0;
        this.index = new String;
        this.description = new String;
        this.correctAnswer = new Boolean;
        this.weight = 0.0;
        this.selectedResponses = new Array<SelectedResponseDto>();
        this.question = null;
    }

}
