import { Component } from '@angular/core';
import { ProfessorGlobalInstance } from './services/ProfessorGlobalInstance.service';

@Component({
  selector: 'hom-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  providers: [ProfessorGlobalInstance]
})
export class AppComponent {
  title = 'Main';
  constructor() { }

  ngOnInit() { 
  }

}
