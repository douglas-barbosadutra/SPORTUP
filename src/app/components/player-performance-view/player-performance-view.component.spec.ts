import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PlayerPerformanceViewComponent } from './player-performance-view.component';

describe('PlayerPerformanceViewComponent', () => {
  let component: PlayerPerformanceViewComponent;
  let fixture: ComponentFixture<PlayerPerformanceViewComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PlayerPerformanceViewComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PlayerPerformanceViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
