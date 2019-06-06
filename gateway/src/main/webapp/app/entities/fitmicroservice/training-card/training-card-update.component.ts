import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { ITrainingCard } from 'app/shared/model/fitmicroservice/training-card.model';
import { TrainingCardService } from './training-card.service';

@Component({
    selector: 'jhi-training-card-update',
    templateUrl: './training-card-update.component.html'
})
export class TrainingCardUpdateComponent implements OnInit {
    private _trainingCard: ITrainingCard;
    isSaving: boolean;

    constructor(private trainingCardService: TrainingCardService, private activatedRoute: ActivatedRoute) {}

    ngOnInit() {
        this.isSaving = false;
        this.activatedRoute.data.subscribe(({ trainingCard }) => {
            this.trainingCard = trainingCard;
        });
    }

    previousState() {
        window.history.back();
    }

    save() {
        this.isSaving = true;
        if (this.trainingCard.id !== undefined) {
            this.subscribeToSaveResponse(this.trainingCardService.update(this.trainingCard));
        } else {
            this.subscribeToSaveResponse(this.trainingCardService.create(this.trainingCard));
        }
    }

    private subscribeToSaveResponse(result: Observable<HttpResponse<ITrainingCard>>) {
        result.subscribe((res: HttpResponse<ITrainingCard>) => this.onSaveSuccess(), (res: HttpErrorResponse) => this.onSaveError());
    }

    private onSaveSuccess() {
        this.isSaving = false;
        this.previousState();
    }

    private onSaveError() {
        this.isSaving = false;
    }
    get trainingCard() {
        return this._trainingCard;
    }

    set trainingCard(trainingCard: ITrainingCard) {
        this._trainingCard = trainingCard;
    }
}
