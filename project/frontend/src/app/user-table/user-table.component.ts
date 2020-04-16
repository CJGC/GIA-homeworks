import { Component, OnInit, Input, Output, EventEmitter} from '@angular/core';
import { ProfessorDto } from '../dto/ProfessorDto';
import { ProfessorService } from '../services/Professsor.service';


@Component({
  selector: 'hom-user-table',
  templateUrl: './user-table.component.html',
  styleUrls: ['./user-table.component.css'],
  providers: [ProfessorService]
})
export class UserTableComponent implements OnInit {

  @Input() public professors : Array<ProfessorDto>;
  @Output() public evenEmitter : EventEmitter<ProfessorDto>;

  constructor(private professorService : ProfessorService) { 
    this.evenEmitter = new EventEmitter<ProfessorDto>();
  }

  ngOnInit(): void {
  }

  public editProfessor(professsor : ProfessorDto) : void {
    this.evenEmitter.emit(professsor);
  }

  public delProfessor(professsor : ProfessorDto) : void {
    this.professorService.delProfessor(professsor).subscribe(
      () => {
        this.professors.splice(this.professors.indexOf(professsor),1);
      },
      error => {console.log(error.error.message);}
    );
  }
}
