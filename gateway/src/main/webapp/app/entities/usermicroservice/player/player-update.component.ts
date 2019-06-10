import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { JhiAlertService } from 'ng-jhipster';

import { IPlayer } from 'app/shared/model/usermicroservice/player.model';
import { PlayerService } from './player.service';
import { IBiomedicalData } from 'app/shared/model/usermicroservice/biomedical-data.model';
import { BiomedicalDataService } from 'app/entities/usermicroservice/biomedical-data';
import { IPerformance } from 'app/shared/model/usermicroservice/performance.model';
import { PerformanceService } from 'app/entities/usermicroservice/performance';

@Component({
    selector: 'jhi-player-update',
    templateUrl: './player-update.component.html'
})
export class PlayerUpdateComponent implements OnInit {
    private _player: IPlayer;
    isSaving: boolean;

    biomedicaldata: IBiomedicalData[];

    performances: IPerformance[];

    constructor(
        private jhiAlertService: JhiAlertService,
        private playerService: PlayerService,
        private biomedicalDataService: BiomedicalDataService,
        private performanceService: PerformanceService,
        private activatedRoute: ActivatedRoute
    ) {}

    ngOnInit() {
        this.isSaving = false;
        this.activatedRoute.data.subscribe(({ player }) => {
            this.player = player;
        });
        this.biomedicalDataService.query({ filter: 'id-is-null' }).subscribe(
            (res: HttpResponse<IBiomedicalData[]>) => {
                if (!this.player.biomedicalDataId) {
                    this.biomedicaldata = res.body;
                } else {
                    this.biomedicalDataService.find(this.player.biomedicalDataId).subscribe(
                        (subRes: HttpResponse<IBiomedicalData>) => {
                            this.biomedicaldata = [subRes.body].concat(res.body);
                        },
                        (subRes: HttpErrorResponse) => this.onError(subRes.message)
                    );
                }
            },
            (res: HttpErrorResponse) => this.onError(res.message)
        );
        this.performanceService.query({ filter: 'id-is-null' }).subscribe(
            (res: HttpResponse<IPerformance[]>) => {
                if (!this.player.performanceId) {
                    this.performances = res.body;
                } else {
                    this.performanceService.find(this.player.performanceId).subscribe(
                        (subRes: HttpResponse<IPerformance>) => {
                            this.performances = [subRes.body].concat(res.body);
                        },
                        (subRes: HttpErrorResponse) => this.onError(subRes.message)
                    );
                }
            },
            (res: HttpErrorResponse) => this.onError(res.message)
        );
    }

    previousState() {
        window.history.back();
    }

    save() {
        this.isSaving = true;
        if (this.player.id !== undefined) {
            this.subscribeToSaveResponse(this.playerService.update(this.player));
        } else {
            this.subscribeToSaveResponse(this.playerService.create(this.player));
        }
    }

    private subscribeToSaveResponse(result: Observable<HttpResponse<IPlayer>>) {
        result.subscribe((res: HttpResponse<IPlayer>) => this.onSaveSuccess(), (res: HttpErrorResponse) => this.onSaveError());
    }

    private onSaveSuccess() {
        this.isSaving = false;
        this.previousState();
    }

    private onSaveError() {
        this.isSaving = false;
    }

    private onError(errorMessage: string) {
        this.jhiAlertService.error(errorMessage, null, null);
    }

    trackBiomedicalDataById(index: number, item: IBiomedicalData) {
        return item.id;
    }

    trackPerformanceById(index: number, item: IPerformance) {
        return item.id;
    }
    get player() {
        return this._player;
    }

    set player(player: IPlayer) {
        this._player = player;
    }
}
