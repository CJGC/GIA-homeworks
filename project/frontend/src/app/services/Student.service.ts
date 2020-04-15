import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { StudentDto } from '../dto/StudentDto';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class StudentService {

  constructor(private http : HttpClient) { }

  public getProfessors() : Observable<Array<StudentDto>> {
    return this.http.get<Array<StudentDto>>(environment.apiURL + 'student');
  }

  public saveProfessor(student : StudentDto) : Observable<StudentDto> {
    return this.http.post<StudentDto>(environment.apiURL + 'student', student);
  }

  public updateProfessor(student : StudentDto) : Observable<StudentDto> {
    return this.http.put<StudentDto>(environment.apiURL + 'student/', student);
  }

  public delProfessor(student : StudentDto) : Observable<StudentDto> {
    return this.http.delete<StudentDto>(environment.apiURL + 'student/' + student.id);
  }

}
