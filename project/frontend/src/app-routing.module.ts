import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CommonModule } from '@angular/common';
import { LoginComponent } from './app/components/login/login.component';
import { ProfessorFormularyComponent } from './app/components/professor-formulary/professor-formulary.component';
import { ProfessorMainViewComponent } from './app/components/professor-main-view/professor-main-view.component';



const routes: Routes = [
  { path: '', redirectTo: 'login', pathMatch: 'full' },
  { path: 'login', component : LoginComponent },
  { path: 'create-professor', component: ProfessorFormularyComponent },
  { path: 'professor-main-view', component: ProfessorMainViewComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
