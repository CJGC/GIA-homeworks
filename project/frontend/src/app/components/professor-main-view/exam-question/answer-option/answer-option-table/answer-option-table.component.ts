import { Component, OnInit, Output, Input, EventEmitter } from '@angular/core';
import { AnswerOptionDto } from 'src/app/dto/AnswerOptionDto';

@Component({
  selector: 'hom-answer-option-table',
  templateUrl: './answer-option-table.component.html',
  styleUrls: ['./answer-option-table.component.css']
})
export class AnswerOptionTableComponent implements OnInit {

  @Input() public answerOptions : Array<AnswerOptionDto>;
  @Output() public evenEmitter : EventEmitter<Object>;

  constructor() { this.evenEmitter = new EventEmitter<AnswerOptionDto>();}

  ngOnInit(): void {
  }

  public editAnsOpt(ansOpt : AnswerOptionDto) : void {
    let request = {requestType : 'edit', answerDto : ansOpt};
    this.evenEmitter.emit(request);
  }

  public delAnsOpt(ansOpt : AnswerOptionDto) : void {
    let request = {requestType : 'del', answerDto : ansOpt};
    this.evenEmitter.emit(request);
  }
}
