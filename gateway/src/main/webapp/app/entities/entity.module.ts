import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';

import { GatewayTrainingCardModule as FitmicroserviceTrainingCardModule } from './fitmicroservice/training-card/training-card.module';
import { GatewayDietModule as FitmicroserviceDietModule } from './fitmicroservice/diet/diet.module';
/* jhipster-needle-add-entity-module-import - JHipster will add entity modules imports here */

@NgModule({
    // prettier-ignore
    imports: [
        FitmicroserviceTrainingCardModule,
        FitmicroserviceDietModule,
        /* jhipster-needle-add-entity-module - JHipster will add entity modules here */
    ],
    declarations: [],
    entryComponents: [],
    providers: [],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class GatewayEntityModule {}
