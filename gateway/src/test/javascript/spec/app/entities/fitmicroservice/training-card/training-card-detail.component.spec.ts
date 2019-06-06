/* tslint:disable max-line-length */
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';

import { GatewayTestModule } from '../../../../test.module';
import { TrainingCardDetailComponent } from 'app/entities/fitmicroservice/training-card/training-card-detail.component';
import { TrainingCard } from 'app/shared/model/fitmicroservice/training-card.model';

describe('Component Tests', () => {
    describe('TrainingCard Management Detail Component', () => {
        let comp: TrainingCardDetailComponent;
        let fixture: ComponentFixture<TrainingCardDetailComponent>;
        const route = ({ data: of({ trainingCard: new TrainingCard(123) }) } as any) as ActivatedRoute;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [GatewayTestModule],
                declarations: [TrainingCardDetailComponent],
                providers: [{ provide: ActivatedRoute, useValue: route }]
            })
                .overrideTemplate(TrainingCardDetailComponent, '')
                .compileComponents();
            fixture = TestBed.createComponent(TrainingCardDetailComponent);
            comp = fixture.componentInstance;
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
                // GIVEN

                // WHEN
                comp.ngOnInit();

                // THEN
                expect(comp.trainingCard).toEqual(jasmine.objectContaining({ id: 123 }));
            });
        });
    });
});
