import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TrainerTrainingComponent } from './trainer-training.component';

describe('TrainerTrainingComponent', () => {
  let component: TrainerTrainingComponent;
  let fixture: ComponentFixture<TrainerTrainingComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TrainerTrainingComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TrainerTrainingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
