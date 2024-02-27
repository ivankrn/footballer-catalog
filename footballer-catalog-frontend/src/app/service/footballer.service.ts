import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Footballer } from '../model/footballer.model';

@Injectable({
  providedIn: 'root'
})
export class FootballerService {

  private apiUrl: string = "http://localhost:8080/api/footballers"

  constructor(private httpClient: HttpClient) { }

  public findById(id: number): Observable<Footballer> {
    return this.httpClient.get<Footballer>(this.apiUrl + "/" + id);
  }

  public findAll(): Observable<Footballer[]> {
    return this.httpClient.get<Footballer[]>(this.apiUrl);
  }

  public create(footballer: Footballer) {
    return this.httpClient.post<Footballer>(this.apiUrl, footballer);
  }

  public update(id: number, footballer: Footballer) {
    return this.httpClient.put<Footballer>(this.apiUrl + "/" + id, footballer);
  }

  public delete(id: number) {
    return this.httpClient.delete(this.apiUrl + " / " + id);
  }
  
}
