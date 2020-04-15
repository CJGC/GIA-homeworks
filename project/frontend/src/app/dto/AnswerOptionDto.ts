import {OnInit } from '@angular/core';
import { QuestionDto } from './abstractDto/QuestionDto';
import { SelectedResponseDto } from './SelectedResponseDto';
import { OpenQuestionDto } from './OpenQuestionDto';

export class AnswerOptionDto implements OnInit {
    private id : number;
    private index : String;
    private description : String;
    private correctAnswer : Boolean;
    private weight : number;
    private selectedResponses : Array<SelectedResponseDto>;
    private question : QuestionDto;

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
