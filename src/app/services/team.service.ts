import { Injectable } from '@angular/core';

import { tap, catchError } from 'rxjs/operators';
import { HttpClient } from '@angular/common/http';
import { Team } from '../models/team';
import { Observable, of } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class TeamService {

  constructor(private http: HttpClient) { }

  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
        console.error(error);
        console.log('${operation} failed: ${error.message}');
        return of(result as T);
    };
}

getTeamList(): Observable <Team[]> {
  const team: Team = JSON.parse(sessionStorage.getItem('team'));
  return this.http.get<any>('http://localhost:8080/Team/view')
      .pipe(tap((response) => console.log('Team'), catchError(this.handleError('error', {})))
      );
  }

  updateTeam(id: number,info: String): void{
    const team: Team = JSON.parse(sessionStorage.getItem('team'));
    this.http.get<Team>('http://localhost:8080/Team/update?teamId='+ id + '&info=' +info).subscribe(() => console.log('Team update'));
      
  } 

  createTeam(info:string): Observable<Team> {
    return this.http.get<Team>('http://localhost:8080/Team/creaTeam?info='+ info)
        .pipe(tap((response) => console.log('Team'), catchError(this.handleError('info error', {})))
        );
  }


}
