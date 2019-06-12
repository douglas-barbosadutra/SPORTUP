import { Injectable } from '@angular/core';

import { tap, catchError } from 'rxjs/operators';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { User } from '../models/User';
import { Observable, of } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RegisterService {
  
  
  constructor(private http: HttpClient) {}

  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
        console.error(error);
        console.log('${operation} failed: ${error.message}');
        return of(result as T);
    };
  }

  register(username: string, password: string): void {
    console.log("service " + username + password);
    this.http.get<User>('http://localhost:8080/User/creaUser?username='+username+'&password='+password)
        .subscribe(() => console.log('User'), catchError(this.handleError('login error', {})))
    ;
    console.log("service dopo " + username + password);
  }
}
