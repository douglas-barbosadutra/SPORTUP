import { Injectable } from '@angular/core';

import { tap, catchError } from 'rxjs/operators';
import { HttpClient } from '@angular/common/http';
import { Training } from '../models/training';
import { Player } from '../models/player';
import { Observable, of } from 'rxjs';
import { BiomedicalData } from '../models/biomedicalData';
import { Performance } from '../models/performance';

@Injectable({
  providedIn: 'root'
})
export class PlayerService {

  constructor(private http: HttpClient) { }

  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
        console.error(error);
        console.log('${operation} failed: ${error.message}');
        return of(result as T);
    };
  }

  getTraining(idPlayer: number): Observable <Training> {
    //const training: Training = JSON.parse(sessionStorage.getItem('training'));
    return this.http.get<Training>('http://localhost:8080/Player/getTraining?playerId='+idPlayer)
        .pipe(tap((response) => console.log('Training'), catchError(this.handleError('error', {})))
        );
    }

  getInfo(idUser: number): Observable <Player> {
    //const player: Player = JSON.parse(sessionStorage.getItem('player'));
    return this.http.get<Player>('http://localhost:8080/Player/getInfo?playerId='+idUser)
        .pipe(tap((response) => console.log('Player'), catchError(this.handleError('error', {})))
        );
    }

    addInfo(idUser:number,info: string): Observable<Player> {
      return this.http.get<Player>('http://localhost:8080/Player/addInfo?playerId='+ idUser+ ' &info=' + info)
          .pipe(tap((response) => console.log('Player'), catchError(this.handleError('info error', {})))
          );
    }
  
    getBiomedicalData(idUser:number): Observable<BiomedicalData> {
      return this.http.get<BiomedicalData>('http://localhost:8080/BiomedicalData/getBiomedical?playerId='+ idUser)
          .pipe(tap((response) => console.log('Player'), catchError(this.handleError('info error', {})))
          );
    }
    getPerformance(idUser:number): Observable<Performance> {
      return this.http.get<Performance>('http://localhost:8080/Performance/getPerformance?playerId='+ idUser)
          .pipe(tap((response) => console.log('Player'), catchError(this.handleError('info error', {})))
          );
    }
}
