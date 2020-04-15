import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { OpenResponseDto } from '../dto/OpenResponseDto';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class OpenResponseService {

  constructor(private http : HttpClient) { }

  public getProfessors() : Observable<Array<OpenResponseDto>> {
    return this.http.get<Array<OpenResponseDto>>(environment.apiURL + 'openResponse');
  }

  public saveProfessor(openResponse : OpenResponseDto) : Observable<OpenResponseDto> {
    return this.http.post<OpenResponseDto>(environment.apiURL + 'openResponse', openResponse);
  }

  public updateProfessor(openResponse : OpenResponseDto) : Observable<OpenResponseDto> {
    return this.http.put<OpenResponseDto>(environment.apiURL + 'openResponse', openResponse);
  }

  public delProfessor(openResponse : OpenResponseDto) : Observable<OpenResponseDto> {
    return this.http.delete<OpenResponseDto>(environment.apiURL + 'openResponse/' + openResponse.id);
  }

}
