import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { GatewaySharedModule } from 'app/shared';
import {
    PlayerComponent,
    PlayerDetailComponent,
    PlayerUpdateComponent,
    PlayerDeletePopupComponent,
    PlayerDeleteDialogComponent,
    playerRoute,
    playerPopupRoute
} from './';

const ENTITY_STATES = [...playerRoute, ...playerPopupRoute];

@NgModule({
    imports: [GatewaySharedModule, RouterModule.forChild(ENTITY_STATES)],
    declarations: [PlayerComponent, PlayerDetailComponent, PlayerUpdateComponent, PlayerDeleteDialogComponent, PlayerDeletePopupComponent],
    entryComponents: [PlayerComponent, PlayerUpdateComponent, PlayerDeleteDialogComponent, PlayerDeletePopupComponent],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class GatewayPlayerModule {}
