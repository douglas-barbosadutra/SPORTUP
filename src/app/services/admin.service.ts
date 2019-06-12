import { Injectable } from '@angular/core';

import { tap, catchError } from 'rxjs/operators';
import { HttpClient } from '@angular/common/http';
import { User } from '../models/User';
import { Observable, of } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class AdminService {
  constructor(private http: HttpClient) { }
  
  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
        console.error(error);
        console.log('${operation} failed: ${error.message}');
        return of(result as T);
    };
  }


  assignType(userId: number, type: string): Observable<User> {
    return this.http.get<User>('http://localhost:8080/User/assignType?userId=' + userId + '&type=' + type)
        .pipe(tap((response) => console.log('User'), catchError(this.handleError('assignType error', {})))
        );
  }

  delete(userId: number): Observable<User> {
    return this.http.get<User>('http://localhost:8080/User/delete?userId=' + userId)
        .pipe(tap((response) => console.log('User'), catchError(this.handleError('delete error', {})))
        );
  }


  getUsersList(): Observable<User[]> {
    return this.http.get<Array<User>>('http://localhost:8080/User/userManagement?=')
        .pipe(tap((response) => console.log('User'), catchError(this.handleError('view error', {})))
        );
  }


}
