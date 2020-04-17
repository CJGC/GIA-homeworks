import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { TableModule } from 'primeng/table';
import { InputTextModule } from 'primeng/inputtext';
import { ButtonModule } from 'primeng/button';
import { HttpClientModule } from '@angular/common/http';
import { ProfessorFormularyComponent } from './components/professor-formulary/professor-formulary.component';
import { AppComponent } from './app.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { LoginComponent } from './components/login/login.component';
import { AppRoutingModule } from '../app-routing.module';
import { ProfessorMainViewComponent } from './components/professor-main-view/professor-main-view.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MessagesModule } from 'primeng/messages';
import { EditorModule } from 'primeng/editor';
import { SpinnerModule } from 'primeng/spinner';
import { ListboxModule } from 'primeng/listbox';
import { StepsModule } from 'primeng/steps';
import { FieldsetModule } from 'primeng/fieldset'
import { ToggleButtonModule } from 'primeng/togglebutton';
import { ExamTableComponent } from './components/professor-main-view/exams-table/exam-table.component';
import { ExamQuestionComponent } from './components/professor-main-view/exam-question/exam-question.component';
import { AnswerOptionComponent } from './components/professor-main-view/exam-question/answer-option/answer-option.component';

@NgModule({
  declarations: [
    AppComponent,
    ProfessorFormularyComponent,
    ExamTableComponent,
    LoginComponent,
    ProfessorMainViewComponent,
    ExamQuestionComponent,
    AnswerOptionComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    InputTextModule,
    ButtonModule,
    TableModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule,
    MessagesModule,
    AppRoutingModule,
    EditorModule,
    SpinnerModule,
    ListboxModule,
    StepsModule,
    FieldsetModule,
    ToggleButtonModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
