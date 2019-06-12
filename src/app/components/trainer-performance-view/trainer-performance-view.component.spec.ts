import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TrainerPerformanceViewComponent } from './trainer-performance-view.component';

describe('TrainerPerformanceViewComponent', () => {
  let component: TrainerPerformanceViewComponent;
  let fixture: ComponentFixture<TrainerPerformanceViewComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TrainerPerformanceViewComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TrainerPerformanceViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
