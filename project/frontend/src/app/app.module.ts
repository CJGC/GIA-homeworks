import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { TableModule } from 'primeng/table';
import { InputTextModule } from 'primeng/inputtext';
import { ButtonModule } from 'primeng/button';
import { HttpClientModule } from '@angular/common/http';
import { ProfessorFormularyComponent } from './components/professor-formulary/professor-formulary.component';
import { AppComponent } from './app.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { ExamTableComponent } from './components/exams-table/exam-table.component';
import { LoginComponent } from './components/login/login.component';
import { AppRoutingModule } from '../app-routing.module';
import { ProfessorMainViewComponent } from './components/professor-main-view/professor-main-view.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MessagesModule } from 'primeng/messages';
import { EditorModule } from 'primeng/editor';
import { SpinnerModule } from 'primeng/spinner';
import { ListboxModule } from 'primeng/listbox';

@NgModule({
  declarations: [
    AppComponent,
    ProfessorFormularyComponent,
    ExamTableComponent,
    LoginComponent,
    ProfessorMainViewComponent
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
    ListboxModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
