import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';

import { GatewayTrainingCardModule as FitmicroserviceTrainingCardModule } from './fitmicroservice/training-card/training-card.module';
import { GatewayDietModule as FitmicroserviceDietModule } from './fitmicroservice/diet/diet.module';
import { GatewayBiomedicalDataModule as UsermicroserviceBiomedicalDataModule } from './usermicroservice/biomedical-data/biomedical-data.module';
import { GatewayPerformanceModule as UsermicroservicePerformanceModule } from './usermicroservice/performance/performance.module';
import { GatewayPlayerModule as UsermicroservicePlayerModule } from './usermicroservice/player/player.module';
/* jhipster-needle-add-entity-module-import - JHipster will add entity modules imports here */

@NgModule({
    // prettier-ignore
    imports: [
        FitmicroserviceTrainingCardModule,
        FitmicroserviceDietModule,
        UsermicroserviceBiomedicalDataModule,
        UsermicroservicePerformanceModule,
        UsermicroservicePlayerModule,
        /* jhipster-needle-add-entity-module - JHipster will add entity modules here */
    ],
    declarations: [],
    entryComponents: [],
    providers: [],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class GatewayEntityModule {}
