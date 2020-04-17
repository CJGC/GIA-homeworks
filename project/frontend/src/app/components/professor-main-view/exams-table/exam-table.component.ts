import { Component, OnInit, Input, Output, EventEmitter} from '@angular/core';
import { ExamDto } from 'src/app/dto/ExamDto';
import { ProfessorService } from 'src/app/services/Professsor.service';


@Component({
  selector: 'hom-exam-table',
  templateUrl: './exam-table.component.html',
  styleUrls: ['./exam-table.component.css'],
  providers: [ProfessorService]
})
export class ExamTableComponent implements OnInit {

  @Input() public exams : Array<ExamDto>;
  @Output() public evenEmitter : EventEmitter<ExamDto>;

  constructor(private professorService : ProfessorService) { 
    this.evenEmitter = new EventEmitter<ExamDto>();
  }

  ngOnInit(): void {
  }

    public editExam(exam : ExamDto) : void {
      this.evenEmitter.emit(exam);
    }

    public delExam(exam : ExamDto) : void {
      
    }
  // public editProfessor(professsor : ExamDto) : void {
  //   this.evenEmitter.emit(professsor);
  // }

  // public delProfessor(professsor : ExamDto) : void {
  //   this.professorService.delProfessor(professsor).subscribe(
  //     () => {
  //       this.exams.splice(this.exams.indexOf(professsor),1);
  //     },
  //     error => {console.log(error.error.message);}
  //   );
  // }
}
