import { Component, OnInit } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
// eslint-disable-next-line @typescript-eslint/no-unused-vars
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';

import { IKCP, KCP } from 'app/shared/model/kcp.model';
import { KCPService } from './kcp.service';

@Component({
  selector: 'jhi-kcp-update',
  templateUrl: './kcp-update.component.html',
})
export class KCPUpdateComponent implements OnInit {
  isSaving = false;
  resetDateDp: any;

  editForm = this.fb.group({
    id: [],
    login: [],
    password: [],
    firstName: [],
    lastName: [],
    email: [],
    activated: [],
    langKey: [],
    imageUrl: [],
    activationKey: [],
    resetKey: [],
    resetDate: [],
    designation: [],
    nid: [],
    company: [],
  });

  constructor(protected kCPService: KCPService, protected activatedRoute: ActivatedRoute, private fb: FormBuilder) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ kCP }) => {
      this.updateForm(kCP);
    });
  }

  updateForm(kCP: IKCP): void {
    this.editForm.patchValue({
      id: kCP.id,
      login: kCP.login,
      password: kCP.password,
      firstName: kCP.firstName,
      lastName: kCP.lastName,
      email: kCP.email,
      activated: kCP.activated,
      langKey: kCP.langKey,
      imageUrl: kCP.imageUrl,
      activationKey: kCP.activationKey,
      resetKey: kCP.resetKey,
      resetDate: kCP.resetDate,
      designation: kCP.designation,
      nid: kCP.nid,
      company: kCP.company,
    });
  }

  previousState(): void {
    window.history.back();
  }

  save(): void {
    this.isSaving = true;
    const kCP = this.createFromForm();
    if (kCP.id !== undefined) {
      this.subscribeToSaveResponse(this.kCPService.update(kCP));
    } else {
      this.subscribeToSaveResponse(this.kCPService.create(kCP));
    }
  }

  private createFromForm(): IKCP {
    return {
      ...new KCP(),
      id: this.editForm.get(['id'])!.value,
      login: this.editForm.get(['login'])!.value,
      password: this.editForm.get(['password'])!.value,
      firstName: this.editForm.get(['firstName'])!.value,
      lastName: this.editForm.get(['lastName'])!.value,
      email: this.editForm.get(['email'])!.value,
      activated: this.editForm.get(['activated'])!.value,
      langKey: this.editForm.get(['langKey'])!.value,
      imageUrl: this.editForm.get(['imageUrl'])!.value,
      activationKey: this.editForm.get(['activationKey'])!.value,
      resetKey: this.editForm.get(['resetKey'])!.value,
      resetDate: this.editForm.get(['resetDate'])!.value,
      designation: this.editForm.get(['designation'])!.value,
      nid: this.editForm.get(['nid'])!.value,
      company: this.editForm.get(['company'])!.value,
    };
  }

  protected subscribeToSaveResponse(result: Observable<HttpResponse<IKCP>>): void {
    result.subscribe(
      () => this.onSaveSuccess(),
      () => this.onSaveError()
    );
  }

  protected onSaveSuccess(): void {
    this.isSaving = false;
    this.previousState();
  }

  protected onSaveError(): void {
    this.isSaving = false;
  }
}
