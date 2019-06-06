import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { NgbActiveModal, NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { ITrainingCard } from 'app/shared/model/fitmicroservice/training-card.model';
import { TrainingCardService } from './training-card.service';

@Component({
    selector: 'jhi-training-card-delete-dialog',
    templateUrl: './training-card-delete-dialog.component.html'
})
export class TrainingCardDeleteDialogComponent {
    trainingCard: ITrainingCard;

    constructor(
        private trainingCardService: TrainingCardService,
        public activeModal: NgbActiveModal,
        private eventManager: JhiEventManager
    ) {}

    clear() {
        this.activeModal.dismiss('cancel');
    }

    confirmDelete(id: number) {
        this.trainingCardService.delete(id).subscribe(response => {
            this.eventManager.broadcast({
                name: 'trainingCardListModification',
                content: 'Deleted an trainingCard'
            });
            this.activeModal.dismiss(true);
        });
    }
}

@Component({
    selector: 'jhi-training-card-delete-popup',
    template: ''
})
export class TrainingCardDeletePopupComponent implements OnInit, OnDestroy {
    private ngbModalRef: NgbModalRef;

    constructor(private activatedRoute: ActivatedRoute, private router: Router, private modalService: NgbModal) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ trainingCard }) => {
            setTimeout(() => {
                this.ngbModalRef = this.modalService.open(TrainingCardDeleteDialogComponent as Component, {
                    size: 'lg',
                    backdrop: 'static'
                });
                this.ngbModalRef.componentInstance.trainingCard = trainingCard;
                this.ngbModalRef.result.then(
                    result => {
                        this.router.navigate([{ outlets: { popup: null } }], { replaceUrl: true, queryParamsHandling: 'merge' });
                        this.ngbModalRef = null;
                    },
                    reason => {
                        this.router.navigate([{ outlets: { popup: null } }], { replaceUrl: true, queryParamsHandling: 'merge' });
                        this.ngbModalRef = null;
                    }
                );
            }, 0);
        });
    }

    ngOnDestroy() {
        this.ngbModalRef = null;
    }
}
