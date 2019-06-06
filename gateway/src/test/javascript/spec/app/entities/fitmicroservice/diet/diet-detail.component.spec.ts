/* tslint:disable max-line-length */
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';

import { GatewayTestModule } from '../../../../test.module';
import { DietDetailComponent } from 'app/entities/fitmicroservice/diet/diet-detail.component';
import { Diet } from 'app/shared/model/fitmicroservice/diet.model';

describe('Component Tests', () => {
    describe('Diet Management Detail Component', () => {
        let comp: DietDetailComponent;
        let fixture: ComponentFixture<DietDetailComponent>;
        const route = ({ data: of({ diet: new Diet(123) }) } as any) as ActivatedRoute;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [GatewayTestModule],
                declarations: [DietDetailComponent],
                providers: [{ provide: ActivatedRoute, useValue: route }]
            })
                .overrideTemplate(DietDetailComponent, '')
                .compileComponents();
            fixture = TestBed.createComponent(DietDetailComponent);
            comp = fixture.componentInstance;
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
                // GIVEN

                // WHEN
                comp.ngOnInit();

                // THEN
                expect(comp.diet).toEqual(jasmine.objectContaining({ id: 123 }));
            });
        });
    });
});
