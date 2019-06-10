import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes } from '@angular/router';
import { JhiPaginationUtil, JhiResolvePagingParams } from 'ng-jhipster';
import { UserRouteAccessService } from 'app/core';
import { of } from 'rxjs';
import { map } from 'rxjs/operators';
import { BiomedicalData } from 'app/shared/model/usermicroservice/biomedical-data.model';
import { BiomedicalDataService } from './biomedical-data.service';
import { BiomedicalDataComponent } from './biomedical-data.component';
import { BiomedicalDataDetailComponent } from './biomedical-data-detail.component';
import { BiomedicalDataUpdateComponent } from './biomedical-data-update.component';
import { BiomedicalDataDeletePopupComponent } from './biomedical-data-delete-dialog.component';
import { IBiomedicalData } from 'app/shared/model/usermicroservice/biomedical-data.model';

@Injectable({ providedIn: 'root' })
export class BiomedicalDataResolve implements Resolve<IBiomedicalData> {
    constructor(private service: BiomedicalDataService) {}

    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
        const id = route.params['id'] ? route.params['id'] : null;
        if (id) {
            return this.service.find(id).pipe(map((biomedicalData: HttpResponse<BiomedicalData>) => biomedicalData.body));
        }
        return of(new BiomedicalData());
    }
}

export const biomedicalDataRoute: Routes = [
    {
        path: 'biomedical-data',
        component: BiomedicalDataComponent,
        resolve: {
            pagingParams: JhiResolvePagingParams
        },
        data: {
            authorities: ['ROLE_USER'],
            defaultSort: 'id,asc',
            pageTitle: 'BiomedicalData'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'biomedical-data/:id/view',
        component: BiomedicalDataDetailComponent,
        resolve: {
            biomedicalData: BiomedicalDataResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'BiomedicalData'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'biomedical-data/new',
        component: BiomedicalDataUpdateComponent,
        resolve: {
            biomedicalData: BiomedicalDataResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'BiomedicalData'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'biomedical-data/:id/edit',
        component: BiomedicalDataUpdateComponent,
        resolve: {
            biomedicalData: BiomedicalDataResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'BiomedicalData'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const biomedicalDataPopupRoute: Routes = [
    {
        path: 'biomedical-data/:id/delete',
        component: BiomedicalDataDeletePopupComponent,
        resolve: {
            biomedicalData: BiomedicalDataResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'BiomedicalData'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
