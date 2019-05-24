import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BiomedicalGraphComponent } from './biomedical-graph.component';

describe('BiomedicalGraphComponent', () => {
  let component: BiomedicalGraphComponent;
  let fixture: ComponentFixture<BiomedicalGraphComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BiomedicalGraphComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BiomedicalGraphComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
