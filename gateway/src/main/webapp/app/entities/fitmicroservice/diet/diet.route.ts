import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes } from '@angular/router';
import { JhiPaginationUtil, JhiResolvePagingParams } from 'ng-jhipster';
import { UserRouteAccessService } from 'app/core';
import { of } from 'rxjs';
import { map } from 'rxjs/operators';
import { Diet } from 'app/shared/model/fitmicroservice/diet.model';
import { DietService } from './diet.service';
import { DietComponent } from './diet.component';
import { DietDetailComponent } from './diet-detail.component';
import { DietUpdateComponent } from './diet-update.component';
import { DietDeletePopupComponent } from './diet-delete-dialog.component';
import { IDiet } from 'app/shared/model/fitmicroservice/diet.model';

@Injectable({ providedIn: 'root' })
export class DietResolve implements Resolve<IDiet> {
    constructor(private service: DietService) {}

    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
        const id = route.params['id'] ? route.params['id'] : null;
        if (id) {
            return this.service.find(id).pipe(map((diet: HttpResponse<Diet>) => diet.body));
        }
        return of(new Diet());
    }
}

export const dietRoute: Routes = [
    {
        path: 'diet',
        component: DietComponent,
        resolve: {
            pagingParams: JhiResolvePagingParams
        },
        data: {
            authorities: ['ROLE_USER'],
            defaultSort: 'id,asc',
            pageTitle: 'Diets'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'diet/:id/view',
        component: DietDetailComponent,
        resolve: {
            diet: DietResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'Diets'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'diet/new',
        component: DietUpdateComponent,
        resolve: {
            diet: DietResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'Diets'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'diet/:id/edit',
        component: DietUpdateComponent,
        resolve: {
            diet: DietResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'Diets'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const dietPopupRoute: Routes = [
    {
        path: 'diet/:id/delete',
        component: DietDeletePopupComponent,
        resolve: {
            diet: DietResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'Diets'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
