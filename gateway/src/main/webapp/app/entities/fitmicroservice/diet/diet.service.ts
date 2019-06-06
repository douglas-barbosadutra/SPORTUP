import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared';
import { IDiet } from 'app/shared/model/fitmicroservice/diet.model';

type EntityResponseType = HttpResponse<IDiet>;
type EntityArrayResponseType = HttpResponse<IDiet[]>;

@Injectable({ providedIn: 'root' })
export class DietService {
    private resourceUrl = SERVER_API_URL + 'fitmicroservice/api/diets';

    constructor(private http: HttpClient) {}

    create(diet: IDiet): Observable<EntityResponseType> {
        return this.http.post<IDiet>(this.resourceUrl, diet, { observe: 'response' });
    }

    update(diet: IDiet): Observable<EntityResponseType> {
        return this.http.put<IDiet>(this.resourceUrl, diet, { observe: 'response' });
    }

    find(id: number): Observable<EntityResponseType> {
        return this.http.get<IDiet>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }

    query(req?: any): Observable<EntityArrayResponseType> {
        const options = createRequestOption(req);
        return this.http.get<IDiet[]>(this.resourceUrl, { params: options, observe: 'response' });
    }

    delete(id: number): Observable<HttpResponse<any>> {
        return this.http.delete<any>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }
}
