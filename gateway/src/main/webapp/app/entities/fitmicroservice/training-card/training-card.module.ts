import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { GatewaySharedModule } from 'app/shared';
import {
    TrainingCardComponent,
    TrainingCardDetailComponent,
    TrainingCardUpdateComponent,
    TrainingCardDeletePopupComponent,
    TrainingCardDeleteDialogComponent,
    trainingCardRoute,
    trainingCardPopupRoute
} from './';

const ENTITY_STATES = [...trainingCardRoute, ...trainingCardPopupRoute];

@NgModule({
    imports: [GatewaySharedModule, RouterModule.forChild(ENTITY_STATES)],
    declarations: [
        TrainingCardComponent,
        TrainingCardDetailComponent,
        TrainingCardUpdateComponent,
        TrainingCardDeleteDialogComponent,
        TrainingCardDeletePopupComponent
    ],
    entryComponents: [
        TrainingCardComponent,
        TrainingCardUpdateComponent,
        TrainingCardDeleteDialogComponent,
        TrainingCardDeletePopupComponent
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class GatewayTrainingCardModule {}
