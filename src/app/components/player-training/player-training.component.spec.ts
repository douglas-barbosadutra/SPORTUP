import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PlayerTrainingComponent } from './player-training.component';

describe('PlayerTrainingComponent', () => {
  let component: PlayerTrainingComponent;
  let fixture: ComponentFixture<PlayerTrainingComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PlayerTrainingComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PlayerTrainingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
