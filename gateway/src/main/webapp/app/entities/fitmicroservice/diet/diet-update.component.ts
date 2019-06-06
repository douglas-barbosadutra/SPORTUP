import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { IDiet } from 'app/shared/model/fitmicroservice/diet.model';
import { DietService } from './diet.service';

@Component({
    selector: 'jhi-diet-update',
    templateUrl: './diet-update.component.html'
})
export class DietUpdateComponent implements OnInit {
    private _diet: IDiet;
    isSaving: boolean;

    constructor(private dietService: DietService, private activatedRoute: ActivatedRoute) {}

    ngOnInit() {
        this.isSaving = false;
        this.activatedRoute.data.subscribe(({ diet }) => {
            this.diet = diet;
        });
    }

    previousState() {
        window.history.back();
    }

    save() {
        this.isSaving = true;
        if (this.diet.id !== undefined) {
            this.subscribeToSaveResponse(this.dietService.update(this.diet));
        } else {
            this.subscribeToSaveResponse(this.dietService.create(this.diet));
        }
    }

    private subscribeToSaveResponse(result: Observable<HttpResponse<IDiet>>) {
        result.subscribe((res: HttpResponse<IDiet>) => this.onSaveSuccess(), (res: HttpErrorResponse) => this.onSaveError());
    }

    private onSaveSuccess() {
        this.isSaving = false;
        this.previousState();
    }

    private onSaveError() {
        this.isSaving = false;
    }
    get diet() {
        return this._diet;
    }

    set diet(diet: IDiet) {
        this._diet = diet;
    }
}
