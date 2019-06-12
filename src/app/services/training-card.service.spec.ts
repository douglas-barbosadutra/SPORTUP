import { TestBed } from '@angular/core/testing';

import { TrainingCardService } from './training-card.service';

describe('TrainingCardService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: TrainingCardService = TestBed.get(TrainingCardService);
    expect(service).toBeTruthy();
  });
});
