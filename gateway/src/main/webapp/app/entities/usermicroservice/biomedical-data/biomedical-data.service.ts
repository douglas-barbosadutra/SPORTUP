import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared';
import { IBiomedicalData } from 'app/shared/model/usermicroservice/biomedical-data.model';

type EntityResponseType = HttpResponse<IBiomedicalData>;
type EntityArrayResponseType = HttpResponse<IBiomedicalData[]>;

@Injectable({ providedIn: 'root' })
export class BiomedicalDataService {
    private resourceUrl = SERVER_API_URL + 'usermicroservice/api/biomedical-data';

    constructor(private http: HttpClient) {}

    create(biomedicalData: IBiomedicalData): Observable<EntityResponseType> {
        return this.http.post<IBiomedicalData>(this.resourceUrl, biomedicalData, { observe: 'response' });
    }

    update(biomedicalData: IBiomedicalData): Observable<EntityResponseType> {
        return this.http.put<IBiomedicalData>(this.resourceUrl, biomedicalData, { observe: 'response' });
    }

    find(id: number): Observable<EntityResponseType> {
        return this.http.get<IBiomedicalData>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }

    query(req?: any): Observable<EntityArrayResponseType> {
        const options = createRequestOption(req);
        return this.http.get<IBiomedicalData[]>(this.resourceUrl, { params: options, observe: 'response' });
    }

    delete(id: number): Observable<HttpResponse<any>> {
        return this.http.delete<any>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }
}
