import { Injectable } from '@angular/core';

import { tap, catchError } from 'rxjs/operators';
import { HttpClient } from '@angular/common/http';
import { User } from '../models/User';
import { Observable, of } from 'rxjs';

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
}
