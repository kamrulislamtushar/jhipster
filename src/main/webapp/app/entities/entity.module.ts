import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

@NgModule({
  imports: [
    RouterModule.forChild([
      {
        path: 'kcp',
        loadChildren: () => import('./kcp/kcp.module').then(m => m.JhipsterPracticeKCPModule),
      },
      /* jhipster-needle-add-entity-route - JHipster will add entity modules routes here */
    ]),
  ],
})
export class JhipsterPracticeEntityModule {}
