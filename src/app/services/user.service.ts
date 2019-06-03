import { Injectable } from '@angular/core';

import { tap, catchError } from 'rxjs/operators';
import { HttpClient } from '@angular/common/http';
import { User } from '../models/user';
import { Observable, of } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) { }

  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
        console.error(error);
        console.log('${operation} failed: ${error.message}');
        return of(result as T);
    };
}


  getUserList(): Observable <User[]> {
  const user: User = JSON.parse(sessionStorage.getItem('user'));
  return this.http.get<any>('http://localhost:8080/User/userManagement')
      .pipe(tap((response) => console.log('User'), catchError(this.handleError('error', {})))
      );
  }

  getUsername(idUser: number): Observable <User>{
    return this.http.get<User>('http://localhost:8080/User/getUser?idUser='+idUser)
      .pipe(tap((response) => console.log('User'), catchError(this.handleError('error', {})))
      );
  }

  assignType(userId: number, type: string): Observable<User> {
    console.log("cariati");
    return this.http.get<User>('http://localhost:8080/User/assignType?userId=' + userId+ '&type=' + type)
        .pipe(tap((response) => console.log('User'), catchError(this.handleError('assignType error', {})))
        );
  }

  delete(userId: number): Observable<User> {
    return this.http.get<User>('http://localhost:8080/User/delete?idUser=' + userId)
        .pipe(tap((response) => console.log('User'), catchError(this.handleError('delete error', {})))
        );
  }
}

