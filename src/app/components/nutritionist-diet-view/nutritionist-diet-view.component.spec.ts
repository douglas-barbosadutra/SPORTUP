import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NutritionistDietViewComponent } from './nutritionist-diet-view.component';

describe('NutritionistDietViewComponent', () => {
  let component: NutritionistDietViewComponent;
  let fixture: ComponentFixture<NutritionistDietViewComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NutritionistDietViewComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NutritionistDietViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
