/* tslint:disable max-line-length */
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';

import { GatewayTestModule } from '../../../../test.module';
import { BiomedicalDataDetailComponent } from 'app/entities/usermicroservice/biomedical-data/biomedical-data-detail.component';
import { BiomedicalData } from 'app/shared/model/usermicroservice/biomedical-data.model';

describe('Component Tests', () => {
    describe('BiomedicalData Management Detail Component', () => {
        let comp: BiomedicalDataDetailComponent;
        let fixture: ComponentFixture<BiomedicalDataDetailComponent>;
        const route = ({ data: of({ biomedicalData: new BiomedicalData(123) }) } as any) as ActivatedRoute;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [GatewayTestModule],
                declarations: [BiomedicalDataDetailComponent],
                providers: [{ provide: ActivatedRoute, useValue: route }]
            })
                .overrideTemplate(BiomedicalDataDetailComponent, '')
                .compileComponents();
            fixture = TestBed.createComponent(BiomedicalDataDetailComponent);
            comp = fixture.componentInstance;
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
                // GIVEN

                // WHEN
                comp.ngOnInit();

                // THEN
                expect(comp.biomedicalData).toEqual(jasmine.objectContaining({ id: 123 }));
            });
        });
    });
});
