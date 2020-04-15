import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { SelectedResponseDto } from '../dto/SelectedResponseDto';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class SelectedResponseService {

  constructor(private http : HttpClient) { }

  public getSelectedResponse() : Observable<Array<SelectedResponseDto>> {
    return this.http.get<Array<SelectedResponseDto>>(environment.apiURL + 'selectedResponse');
  }

  public saveSelectedResponse(selectedResponse : SelectedResponseDto) : Observable<SelectedResponseDto> {
    return this.http.post<SelectedResponseDto>(environment.apiURL + 'selectedResponse', selectedResponse);
  }

  public updateSelectedResponse(selectedResponse : SelectedResponseDto) : Observable<SelectedResponseDto> {
    return this.http.put<SelectedResponseDto>(environment.apiURL + 'selectedResponse', selectedResponse);
  }

  public delSelectedResponse(selectedResponse : SelectedResponseDto) : Observable<SelectedResponseDto> {
    return this.http.delete<SelectedResponseDto>(environment.apiURL + 'selectedResponse/' + selectedResponse.id);
  }

}
