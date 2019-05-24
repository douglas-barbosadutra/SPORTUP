import { Injectable } from '@angular/core';
import { tap, catchError } from 'rxjs/operators';
import { HttpClient } from '@angular/common/http';
import { TrainingCard } from '../models/trainingCard';
import { Observable, of } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TrainingCardService {

  constructor(private http: HttpClient) { }

  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
        console.error(error);
        console.log('${operation} failed: ${error.message}');
        return of(result as T);
    };
}

  getTrainingCard(idTraining: number): Observable<TrainingCard[]>{
    const trainingCard: TrainingCard = JSON.parse(sessionStorage.getItem('trainingCard'));
    return this.http.get<any>('http://localhost:8080/TrainingCard/view?trainingId='+idTraining)
      .pipe(tap((response) => console.log('TrainingCard'), catchError(this.handleError('error', {})))
      );
  }

}
