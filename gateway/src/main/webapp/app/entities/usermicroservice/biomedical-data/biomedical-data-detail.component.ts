import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { IBiomedicalData } from 'app/shared/model/usermicroservice/biomedical-data.model';

@Component({
    selector: 'jhi-biomedical-data-detail',
    templateUrl: './biomedical-data-detail.component.html'
})
export class BiomedicalDataDetailComponent implements OnInit {
    biomedicalData: IBiomedicalData;

    constructor(private activatedRoute: ActivatedRoute) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ biomedicalData }) => {
            this.biomedicalData = biomedicalData;
        });
    }

    previousState() {
        window.history.back();
    }
}
