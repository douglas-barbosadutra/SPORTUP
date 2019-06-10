import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { GatewaySharedModule } from 'app/shared';
import {
    BiomedicalDataComponent,
    BiomedicalDataDetailComponent,
    BiomedicalDataUpdateComponent,
    BiomedicalDataDeletePopupComponent,
    BiomedicalDataDeleteDialogComponent,
    biomedicalDataRoute,
    biomedicalDataPopupRoute
} from './';

const ENTITY_STATES = [...biomedicalDataRoute, ...biomedicalDataPopupRoute];

@NgModule({
    imports: [GatewaySharedModule, RouterModule.forChild(ENTITY_STATES)],
    declarations: [
        BiomedicalDataComponent,
        BiomedicalDataDetailComponent,
        BiomedicalDataUpdateComponent,
        BiomedicalDataDeleteDialogComponent,
        BiomedicalDataDeletePopupComponent
    ],
    entryComponents: [
        BiomedicalDataComponent,
        BiomedicalDataUpdateComponent,
        BiomedicalDataDeleteDialogComponent,
        BiomedicalDataDeletePopupComponent
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class GatewayBiomedicalDataModule {}
