/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, fakeAsync, tick } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { Observable, of } from 'rxjs';

import { GatewayTestModule } from '../../../../test.module';
import { BiomedicalDataUpdateComponent } from 'app/entities/usermicroservice/biomedical-data/biomedical-data-update.component';
import { BiomedicalDataService } from 'app/entities/usermicroservice/biomedical-data/biomedical-data.service';
import { BiomedicalData } from 'app/shared/model/usermicroservice/biomedical-data.model';

describe('Component Tests', () => {
    describe('BiomedicalData Management Update Component', () => {
        let comp: BiomedicalDataUpdateComponent;
        let fixture: ComponentFixture<BiomedicalDataUpdateComponent>;
        let service: BiomedicalDataService;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [GatewayTestModule],
                declarations: [BiomedicalDataUpdateComponent]
            })
                .overrideTemplate(BiomedicalDataUpdateComponent, '')
                .compileComponents();

            fixture = TestBed.createComponent(BiomedicalDataUpdateComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(BiomedicalDataService);
        });

        describe('save', () => {
            it(
                'Should call update service on save for existing entity',
                fakeAsync(() => {
                    // GIVEN
                    const entity = new BiomedicalData(123);
                    spyOn(service, 'update').and.returnValue(of(new HttpResponse({ body: entity })));
                    comp.biomedicalData = entity;
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
                    const entity = new BiomedicalData();
                    spyOn(service, 'create').and.returnValue(of(new HttpResponse({ body: entity })));
                    comp.biomedicalData = entity;
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
