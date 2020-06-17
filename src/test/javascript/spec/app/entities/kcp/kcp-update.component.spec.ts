import { ComponentFixture, TestBed, fakeAsync, tick } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { FormBuilder } from '@angular/forms';
import { of } from 'rxjs';

import { JhipsterPracticeTestModule } from '../../../test.module';
import { KCPUpdateComponent } from 'app/entities/kcp/kcp-update.component';
import { KCPService } from 'app/entities/kcp/kcp.service';
import { KCP } from 'app/shared/model/kcp.model';

describe('Component Tests', () => {
  describe('KCP Management Update Component', () => {
    let comp: KCPUpdateComponent;
    let fixture: ComponentFixture<KCPUpdateComponent>;
    let service: KCPService;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [JhipsterPracticeTestModule],
        declarations: [KCPUpdateComponent],
        providers: [FormBuilder],
      })
        .overrideTemplate(KCPUpdateComponent, '')
        .compileComponents();

      fixture = TestBed.createComponent(KCPUpdateComponent);
      comp = fixture.componentInstance;
      service = fixture.debugElement.injector.get(KCPService);
    });

    describe('save', () => {
      it('Should call update service on save for existing entity', fakeAsync(() => {
        // GIVEN
        const entity = new KCP(123);
        spyOn(service, 'update').and.returnValue(of(new HttpResponse({ body: entity })));
        comp.updateForm(entity);
        // WHEN
        comp.save();
        tick(); // simulate async

        // THEN
        expect(service.update).toHaveBeenCalledWith(entity);
        expect(comp.isSaving).toEqual(false);
      }));

      it('Should call create service on save for new entity', fakeAsync(() => {
        // GIVEN
        const entity = new KCP();
        spyOn(service, 'create').and.returnValue(of(new HttpResponse({ body: entity })));
        comp.updateForm(entity);
        // WHEN
        comp.save();
        tick(); // simulate async

        // THEN
        expect(service.create).toHaveBeenCalledWith(entity);
        expect(comp.isSaving).toEqual(false);
      }));
    });
  });
});
