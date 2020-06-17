import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';

import { JhipsterPracticeTestModule } from '../../../test.module';
import { KCPDetailComponent } from 'app/entities/kcp/kcp-detail.component';
import { KCP } from 'app/shared/model/kcp.model';

describe('Component Tests', () => {
  describe('KCP Management Detail Component', () => {
    let comp: KCPDetailComponent;
    let fixture: ComponentFixture<KCPDetailComponent>;
    const route = ({ data: of({ kCP: new KCP(123) }) } as any) as ActivatedRoute;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [JhipsterPracticeTestModule],
        declarations: [KCPDetailComponent],
        providers: [{ provide: ActivatedRoute, useValue: route }],
      })
        .overrideTemplate(KCPDetailComponent, '')
        .compileComponents();
      fixture = TestBed.createComponent(KCPDetailComponent);
      comp = fixture.componentInstance;
    });

    describe('OnInit', () => {
      it('Should load kCP on init', () => {
        // WHEN
        comp.ngOnInit();

        // THEN
        expect(comp.kCP).toEqual(jasmine.objectContaining({ id: 123 }));
      });
    });
  });
});
