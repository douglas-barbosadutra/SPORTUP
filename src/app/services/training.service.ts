import { Injectable } from '@angular/core';

import { tap, catchError } from 'rxjs/operators';
import { HttpClient } from '@angular/common/http';
import { Training } from '../models/training';
import { BiomedicalData } from '../models/BiomedicalData';
import { Team} from '../models/Team';
import { Observable, of } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TrainingService {

  constructor(private http: HttpClient) { }

  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
        console.error(error);
        console.log('${operation} failed: ${error.message}');
        return of(result as T);
    };
}


  getTrainingList(): Observable <Training[]> {
  const training: Training = JSON.parse(sessionStorage.getItem('training'));
  return this.http.get<any>('http://localhost:8080/Trainer/training')
      .pipe(tap((response) => console.log('Training'), catchError(this.handleError('error', {})))
      );
  }

  updateTraining(id: number,info: String): void{
    const training: Training = JSON.parse(sessionStorage.getItem('training'));
    this.http.get<Training>('http://localhost:8080/Training/update?idTraining='+ id + '&info=' +info).subscribe(() => console.log('Training update'));
      
  } 


  createTraining(info:string): Observable<Training> {
    return this.http.get<Training>('http://localhost:8080/Training/creaTraining?info='+ info)
        .pipe(tap((response) => console.log('Team'), catchError(this.handleError('info error', {})))
        );
  }

  

}




