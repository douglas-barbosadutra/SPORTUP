import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared';
import { ITrainingCard } from 'app/shared/model/fitmicroservice/training-card.model';

type EntityResponseType = HttpResponse<ITrainingCard>;
type EntityArrayResponseType = HttpResponse<ITrainingCard[]>;

@Injectable({ providedIn: 'root' })
export class TrainingCardService {
    private resourceUrl = SERVER_API_URL + 'fitmicroservice/api/training-cards';

    constructor(private http: HttpClient) {}

    create(trainingCard: ITrainingCard): Observable<EntityResponseType> {
        return this.http.post<ITrainingCard>(this.resourceUrl, trainingCard, { observe: 'response' });
    }

    update(trainingCard: ITrainingCard): Observable<EntityResponseType> {
        return this.http.put<ITrainingCard>(this.resourceUrl, trainingCard, { observe: 'response' });
    }

    find(id: number): Observable<EntityResponseType> {
        return this.http.get<ITrainingCard>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }

    query(req?: any): Observable<EntityArrayResponseType> {
        const options = createRequestOption(req);
        return this.http.get<ITrainingCard[]>(this.resourceUrl, { params: options, observe: 'response' });
    }

    delete(id: number): Observable<HttpResponse<any>> {
        return this.http.delete<any>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }
}
