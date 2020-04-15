import {OnInit } from '@angular/core';
import { ExamStudentDto } from './ExamStudentDto';
import { AnswerOptionDto } from './AnswerOptionDto';

export class SelectedResponseDto implements OnInit {
    
    public id : number;
    public valoration : number;
    public examStudent : ExamStudentDto;
    public answerOption : AnswerOptionDto;

    ngOnInit() {
        this.id = 0;
        this.valoration = 0.0;
        this.examStudent = new ExamStudentDto;
        this.answerOption = new AnswerOptionDto;
    }

}
