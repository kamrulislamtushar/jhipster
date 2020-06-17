import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { JhipsterPracticeSharedModule } from 'app/shared/shared.module';
import { KCPComponent } from './kcp.component';
import { KCPDetailComponent } from './kcp-detail.component';
import { KCPUpdateComponent } from './kcp-update.component';
import { KCPDeleteDialogComponent } from './kcp-delete-dialog.component';
import { kCPRoute } from './kcp.route';

@NgModule({
  imports: [JhipsterPracticeSharedModule, RouterModule.forChild(kCPRoute)],
  declarations: [KCPComponent, KCPDetailComponent, KCPUpdateComponent, KCPDeleteDialogComponent],
  entryComponents: [KCPDeleteDialogComponent],
})
export class JhipsterPracticeKCPModule {}
