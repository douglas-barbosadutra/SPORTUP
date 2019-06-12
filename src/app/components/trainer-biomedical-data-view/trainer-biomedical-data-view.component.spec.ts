import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TrainerBiomedicalDataViewComponent } from './trainer-biomedical-data-view.component';

describe('TrainerBiomedicalDataViewComponent', () => {
  let component: TrainerBiomedicalDataViewComponent;
  let fixture: ComponentFixture<TrainerBiomedicalDataViewComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TrainerBiomedicalDataViewComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TrainerBiomedicalDataViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
