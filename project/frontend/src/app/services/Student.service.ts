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

  public getStudents() : Observable<Array<StudentDto>> {
    return this.http.get<Array<StudentDto>>(environment.apiURL + 'student');
  }

  public saveStudent(student : StudentDto) : Observable<StudentDto> {
    return this.http.post<StudentDto>(environment.apiURL + 'student', student);
  }

  public updateStudent(student : StudentDto) : Observable<StudentDto> {
    return this.http.put<StudentDto>(environment.apiURL + 'student', student);
  }

  public delStudent(student : StudentDto) : Observable<StudentDto> {
    return this.http.delete<StudentDto>(environment.apiURL + 'student/' + student.id);
  }

}
