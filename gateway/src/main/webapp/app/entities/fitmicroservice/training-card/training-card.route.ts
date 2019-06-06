import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes } from '@angular/router';
import { JhiPaginationUtil, JhiResolvePagingParams } from 'ng-jhipster';
import { UserRouteAccessService } from 'app/core';
import { of } from 'rxjs';
import { map } from 'rxjs/operators';
import { TrainingCard } from 'app/shared/model/fitmicroservice/training-card.model';
import { TrainingCardService } from './training-card.service';
import { TrainingCardComponent } from './training-card.component';
import { TrainingCardDetailComponent } from './training-card-detail.component';
import { TrainingCardUpdateComponent } from './training-card-update.component';
import { TrainingCardDeletePopupComponent } from './training-card-delete-dialog.component';
import { ITrainingCard } from 'app/shared/model/fitmicroservice/training-card.model';

@Injectable({ providedIn: 'root' })
export class TrainingCardResolve implements Resolve<ITrainingCard> {
    constructor(private service: TrainingCardService) {}

    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
        const id = route.params['id'] ? route.params['id'] : null;
        if (id) {
            return this.service.find(id).pipe(map((trainingCard: HttpResponse<TrainingCard>) => trainingCard.body));
        }
        return of(new TrainingCard());
    }
}

export const trainingCardRoute: Routes = [
    {
        path: 'training-card',
        component: TrainingCardComponent,
        resolve: {
            pagingParams: JhiResolvePagingParams
        },
        data: {
            authorities: ['ROLE_USER'],
            defaultSort: 'id,asc',
            pageTitle: 'TrainingCards'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'training-card/:id/view',
        component: TrainingCardDetailComponent,
        resolve: {
            trainingCard: TrainingCardResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'TrainingCards'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'training-card/new',
        component: TrainingCardUpdateComponent,
        resolve: {
            trainingCard: TrainingCardResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'TrainingCards'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'training-card/:id/edit',
        component: TrainingCardUpdateComponent,
        resolve: {
            trainingCard: TrainingCardResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'TrainingCards'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const trainingCardPopupRoute: Routes = [
    {
        path: 'training-card/:id/delete',
        component: TrainingCardDeletePopupComponent,
        resolve: {
            trainingCard: TrainingCardResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'TrainingCards'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
