import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { ITrainingCard } from 'app/shared/model/fitmicroservice/training-card.model';

@Component({
    selector: 'jhi-training-card-detail',
    templateUrl: './training-card-detail.component.html'
})
export class TrainingCardDetailComponent implements OnInit {
    trainingCard: ITrainingCard;

    constructor(private activatedRoute: ActivatedRoute) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ trainingCard }) => {
            this.trainingCard = trainingCard;
        });
    }

    previousState() {
        window.history.back();
    }
}
