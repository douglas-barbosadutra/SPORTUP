/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, inject, fakeAsync, tick } from '@angular/core/testing';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { Observable, of } from 'rxjs';
import { JhiEventManager } from 'ng-jhipster';

import { GatewayTestModule } from '../../../../test.module';
import { TrainingCardDeleteDialogComponent } from 'app/entities/fitmicroservice/training-card/training-card-delete-dialog.component';
import { TrainingCardService } from 'app/entities/fitmicroservice/training-card/training-card.service';

describe('Component Tests', () => {
    describe('TrainingCard Management Delete Component', () => {
        let comp: TrainingCardDeleteDialogComponent;
        let fixture: ComponentFixture<TrainingCardDeleteDialogComponent>;
        let service: TrainingCardService;
        let mockEventManager: any;
        let mockActiveModal: any;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [GatewayTestModule],
                declarations: [TrainingCardDeleteDialogComponent]
            })
                .overrideTemplate(TrainingCardDeleteDialogComponent, '')
                .compileComponents();
            fixture = TestBed.createComponent(TrainingCardDeleteDialogComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(TrainingCardService);
            mockEventManager = fixture.debugElement.injector.get(JhiEventManager);
            mockActiveModal = fixture.debugElement.injector.get(NgbActiveModal);
        });

        describe('confirmDelete', () => {
            it(
                'Should call delete service on confirmDelete',
                inject(
                    [],
                    fakeAsync(() => {
                        // GIVEN
                        spyOn(service, 'delete').and.returnValue(of({}));

                        // WHEN
                        comp.confirmDelete(123);
                        tick();

                        // THEN
                        expect(service.delete).toHaveBeenCalledWith(123);
                        expect(mockActiveModal.dismissSpy).toHaveBeenCalled();
                        expect(mockEventManager.broadcastSpy).toHaveBeenCalled();
                    })
                )
            );
        });
    });
});
