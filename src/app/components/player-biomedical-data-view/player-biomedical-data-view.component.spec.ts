import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PlayerBiomedicalDataViewComponent } from './player-biomedical-data-view.component';

describe('PlayerBiomedicalDataViewComponent', () => {
  let component: PlayerBiomedicalDataViewComponent;
  let fixture: ComponentFixture<PlayerBiomedicalDataViewComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PlayerBiomedicalDataViewComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PlayerBiomedicalDataViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
