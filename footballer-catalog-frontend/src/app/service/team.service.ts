import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Team } from '../model/team.model';

@Injectable({
  providedIn: 'root'
})
export class TeamService {

  private apiUrl: string = "http://localhost:8080/api/teams"

  constructor(private httpClient: HttpClient) { }

  public findById(id: number): Observable<Team> {
    return this.httpClient.get<Team>(this.apiUrl + "/" + id);
  }

  public findAll(): Observable<Team[]> {
    return this.httpClient.get<Team[]>(this.apiUrl);
  }

  public create(team: Team) {
    return this.httpClient.post<Team>(this.apiUrl, team);
  }

  public update(id: number, team: Team) {
    return this.httpClient.put<Team>(this.apiUrl + "/" + id, team);
  }

  public delete(id: number) {
    return this.httpClient.delete(this.apiUrl + " / " + id);
  }
  
}
