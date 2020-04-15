import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { ExamStudentDto } from '../dto/ExamStudentDto';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ExamStudentService {

  constructor(private http : HttpClient) { }

  public getProfessors() : Observable<Array<ExamStudentDto>> {
    return this.http.get<Array<ExamStudentDto>>(environment.apiURL + 'examStudent');
  }

  public saveProfessor(examStudent : ExamStudentDto) : Observable<ExamStudentDto> {
    return this.http.post<ExamStudentDto>(environment.apiURL + 'examStudent', examStudent);
  }

  public updateProfessor(examStudent : ExamStudentDto) : Observable<ExamStudentDto> {
    return this.http.put<ExamStudentDto>(environment.apiURL + 'examStudent', examStudent);
  }

  public delProfessor(examStudent : ExamStudentDto) : Observable<ExamStudentDto> {
    return this.http.delete<ExamStudentDto>(environment.apiURL + 'examStudent/' + examStudent.id);
  }

}
