import { Component, OnInit } from '@angular/core';
import { ProfessorDto } from 'src/app/dto/ProfessorDto';
import { ProfessorGlobalInstance } from 'src/app/services/ProfessorGlobalInstance.service';

@Component({
  selector: 'hom-professor-main-view',
  templateUrl: './professor-main-view.component.html',
  styleUrls: ['./professor-main-view.component.css']
})
export class ProfessorMainViewComponent implements OnInit {

  public loggedProfessor : ProfessorDto; 
  constructor(public professorGlobalInstance : ProfessorGlobalInstance ) { }

  ngOnInit(): void {
    this.loggedProfessor = this.professorGlobalInstance.getProfessorInstance();
    console.log(this.loggedProfessor);
  }

}
