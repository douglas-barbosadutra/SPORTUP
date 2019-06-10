import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { NgbActiveModal, NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { IBiomedicalData } from 'app/shared/model/usermicroservice/biomedical-data.model';
import { BiomedicalDataService } from './biomedical-data.service';

@Component({
    selector: 'jhi-biomedical-data-delete-dialog',
    templateUrl: './biomedical-data-delete-dialog.component.html'
})
export class BiomedicalDataDeleteDialogComponent {
    biomedicalData: IBiomedicalData;

    constructor(
        private biomedicalDataService: BiomedicalDataService,
        public activeModal: NgbActiveModal,
        private eventManager: JhiEventManager
    ) {}

    clear() {
        this.activeModal.dismiss('cancel');
    }

    confirmDelete(id: number) {
        this.biomedicalDataService.delete(id).subscribe(response => {
            this.eventManager.broadcast({
                name: 'biomedicalDataListModification',
                content: 'Deleted an biomedicalData'
            });
            this.activeModal.dismiss(true);
        });
    }
}

@Component({
    selector: 'jhi-biomedical-data-delete-popup',
    template: ''
})
export class BiomedicalDataDeletePopupComponent implements OnInit, OnDestroy {
    private ngbModalRef: NgbModalRef;

    constructor(private activatedRoute: ActivatedRoute, private router: Router, private modalService: NgbModal) {}

    ngOnInit() {
        this.activatedRoute.data.subscribe(({ biomedicalData }) => {
            setTimeout(() => {
                this.ngbModalRef = this.modalService.open(BiomedicalDataDeleteDialogComponent as Component, {
                    size: 'lg',
                    backdrop: 'static'
                });
                this.ngbModalRef.componentInstance.biomedicalData = biomedicalData;
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
