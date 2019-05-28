import { Injectable } from '@angular/core';

import { tap, catchError } from 'rxjs/operators';
import { HttpClient } from '@angular/common/http';
import { User } from '../models/User';
import { Observable, of } from 'rxjs';
import { Daily } from '../models/Daily';

@Injectable({
  providedIn: 'root'
})
export class NutritionistService {

  constructor(private http: HttpClient) { }

  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
        console.error(error);
        console.log('${operation} failed: ${error.message}');
        return of(result as T);
    };
  }

  getUsersList(): Observable<User[]> {
    return this.http.get<Array<User>>('http://localhost:8080/User/userManagement?=')
        .pipe(tap((response) => console.log('User'), catchError(this.handleError('view error', {})))
        );
  }

  viewDiet(idPlayer: number): Observable<Daily[]>{
    console.log("c'è nessuno?");
    return this.http.get<Daily[]>('http://localhost:8080/Diet/view?playerId='+ idPlayer)
        .pipe(tap((response) => console.log('Fetching daily diet'), catchError(this.handleError('daily diet', {})))
        );
  }

  updateDay(daily: Daily): void{
    console.log("service nutri " + daily.breakfast);
    this.http.get<boolean>('http://localhost:8080/Diet/update?idDay='+ daily.idDay + 
    '&breakfast=' + daily.breakfast + '&snack=' + daily.snack + '&lunch=' + daily.lunch + 
    '&snackAfternoon=' + daily.snackAfternoon + '&dinner=' + daily.dinner).subscribe(() => console.log('Daily diet updated'));
  }
 
}
