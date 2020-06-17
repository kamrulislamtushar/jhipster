import { Component } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { IKCP } from 'app/shared/model/kcp.model';
import { KCPService } from './kcp.service';

@Component({
  templateUrl: './kcp-delete-dialog.component.html',
})
export class KCPDeleteDialogComponent {
  kCP?: IKCP;

  constructor(protected kCPService: KCPService, public activeModal: NgbActiveModal, protected eventManager: JhiEventManager) {}

  cancel(): void {
    this.activeModal.dismiss();
  }

  confirmDelete(id: number): void {
    this.kCPService.delete(id).subscribe(() => {
      this.eventManager.broadcast('kCPListModification');
      this.activeModal.close();
    });
  }
}
