import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { IKCP } from 'app/shared/model/kcp.model';

@Component({
  selector: 'jhi-kcp-detail',
  templateUrl: './kcp-detail.component.html',
})
export class KCPDetailComponent implements OnInit {
  kCP: IKCP | null = null;

  constructor(protected activatedRoute: ActivatedRoute) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ kCP }) => (this.kCP = kCP));
  }

  previousState(): void {
    window.history.back();
  }
}
