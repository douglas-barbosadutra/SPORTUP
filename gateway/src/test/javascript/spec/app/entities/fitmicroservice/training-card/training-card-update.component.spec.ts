/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, fakeAsync, tick } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { Observable, of } from 'rxjs';

import { GatewayTestModule } from '../../../../test.module';
import { TrainingCardUpdateComponent } from 'app/entities/fitmicroservice/training-card/training-card-update.component';
import { TrainingCardService } from 'app/entities/fitmicroservice/training-card/training-card.service';
import { TrainingCard } from 'app/shared/model/fitmicroservice/training-card.model';

describe('Component Tests', () => {
    describe('TrainingCard Management Update Component', () => {
        let comp: TrainingCardUpdateComponent;
        let fixture: ComponentFixture<TrainingCardUpdateComponent>;
        let service: TrainingCardService;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [GatewayTestModule],
                declarations: [TrainingCardUpdateComponent]
            })
                .overrideTemplate(TrainingCardUpdateComponent, '')
                .compileComponents();

            fixture = TestBed.createComponent(TrainingCardUpdateComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(TrainingCardService);
        });

        describe('save', () => {
            it(
                'Should call update service on save for existing entity',
                fakeAsync(() => {
                    // GIVEN
                    const entity = new TrainingCard(123);
                    spyOn(service, 'update').and.returnValue(of(new HttpResponse({ body: entity })));
                    comp.trainingCard = entity;
                    // WHEN
                    comp.save();
                    tick(); // simulate async

                    // THEN
                    expect(service.update).toHaveBeenCalledWith(entity);
                    expect(comp.isSaving).toEqual(false);
                })
            );

            it(
                'Should call create service on save for new entity',
                fakeAsync(() => {
                    // GIVEN
                    const entity = new TrainingCard();
                    spyOn(service, 'create').and.returnValue(of(new HttpResponse({ body: entity })));
                    comp.trainingCard = entity;
                    // WHEN
                    comp.save();
                    tick(); // simulate async

                    // THEN
                    expect(service.create).toHaveBeenCalledWith(entity);
                    expect(comp.isSaving).toEqual(false);
                })
            );
        });
    });
});
