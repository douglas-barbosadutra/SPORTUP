import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { IBiomedicalData } from 'app/shared/model/usermicroservice/biomedical-data.model';
import { BiomedicalDataService } from './biomedical-data.service';

@Component({
    selector: 'jhi-biomedical-data-update',
    templateUrl: './biomedical-data-update.component.html'
})
export class BiomedicalDataUpdateComponent implements OnInit {
    private _biomedicalData: IBiomedicalData;
    isSaving: boolean;

    constructor(private biomedicalDataService: BiomedicalDataService, private activatedRoute: ActivatedRoute) {}

    ngOnInit() {
        this.isSaving = false;
        this.activatedRoute.data.subscribe(({ biomedicalData }) => {
            this.biomedicalData = biomedicalData;
        });
    }

    previousState() {
        window.history.back();
    }

    save() {
        this.isSaving = true;
        if (this.biomedicalData.id !== undefined) {
            this.subscribeToSaveResponse(this.biomedicalDataService.update(this.biomedicalData));
        } else {
            this.subscribeToSaveResponse(this.biomedicalDataService.create(this.biomedicalData));
        }
    }

    private subscribeToSaveResponse(result: Observable<HttpResponse<IBiomedicalData>>) {
        result.subscribe((res: HttpResponse<IBiomedicalData>) => this.onSaveSuccess(), (res: HttpErrorResponse) => this.onSaveError());
    }

    private onSaveSuccess() {
        this.isSaving = false;
        this.previousState();
    }

    private onSaveError() {
        this.isSaving = false;
    }
    get biomedicalData() {
        return this._biomedicalData;
    }

    set biomedicalData(biomedicalData: IBiomedicalData) {
        this._biomedicalData = biomedicalData;
    }
}
