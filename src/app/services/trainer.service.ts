import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { tap, catchError } from 'rxjs/operators';
import { HttpClient } from '@angular/common/http';
import { BiomedicalData } from '../models/BiomedicalData';
import { Team} from '../models/Team';
import { Training} from '../models/Training';

import { Performance } from '../models/Performance';

@Injectable({
  providedIn: 'root'
})
export class TrainerService {
  constructor(private http: HttpClient) { }
  
  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
        console.error(error);
        console.log('${operation} failed: ${error.message}');
        return of(result as T);
    };
  }

  getBiomedicalData(id:number): Observable<BiomedicalData> {
    return this.http.get<BiomedicalData>('http://localhost:8080/Trainer/biomedicalData?idPlayer='+ id)
        .pipe(tap((response) => console.log('Trainer'), catchError(this.handleError('info error', {})))
        );
  }


  getPerformance(id:number): Observable<Performance> {
    return this.http.get<Performance>('http://localhost:8080/Trainer/performance?idPlayer='+ id)
        .pipe(tap((response) => console.log('Trainer'), catchError(this.handleError('info error', {})))
        );
  }

 
  


}
