import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import * as moment from 'moment';

import { DATE_FORMAT } from 'app/shared/constants/input.constants';
import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared/util/request-util';
import { IKCP } from 'app/shared/model/kcp.model';

type EntityResponseType = HttpResponse<IKCP>;
type EntityArrayResponseType = HttpResponse<IKCP[]>;

@Injectable({ providedIn: 'root' })
export class KCPService {
  public resourceUrl = SERVER_API_URL + 'api/kcps';

  constructor(protected http: HttpClient) {}

  create(kCP: IKCP): Observable<EntityResponseType> {
    const copy = this.convertDateFromClient(kCP);
    return this.http
      .post<IKCP>(this.resourceUrl, copy, { observe: 'response' })
      .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
  }

  update(kCP: IKCP): Observable<EntityResponseType> {
    const copy = this.convertDateFromClient(kCP);
    return this.http
      .put<IKCP>(this.resourceUrl, copy, { observe: 'response' })
      .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
  }

  find(id: number): Observable<EntityResponseType> {
    return this.http
      .get<IKCP>(`${this.resourceUrl}/${id}`, { observe: 'response' })
      .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
  }

  query(req?: any): Observable<EntityArrayResponseType> {
    const options = createRequestOption(req);
    return this.http
      .get<IKCP[]>(this.resourceUrl, { params: options, observe: 'response' })
      .pipe(map((res: EntityArrayResponseType) => this.convertDateArrayFromServer(res)));
  }

  delete(id: number): Observable<HttpResponse<{}>> {
    return this.http.delete(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }

  protected convertDateFromClient(kCP: IKCP): IKCP {
    const copy: IKCP = Object.assign({}, kCP, {
      resetDate: kCP.resetDate && kCP.resetDate.isValid() ? kCP.resetDate.format(DATE_FORMAT) : undefined,
    });
    return copy;
  }

  protected convertDateFromServer(res: EntityResponseType): EntityResponseType {
    if (res.body) {
      res.body.resetDate = res.body.resetDate ? moment(res.body.resetDate) : undefined;
    }
    return res;
  }

  protected convertDateArrayFromServer(res: EntityArrayResponseType): EntityArrayResponseType {
    if (res.body) {
      res.body.forEach((kCP: IKCP) => {
        kCP.resetDate = kCP.resetDate ? moment(kCP.resetDate) : undefined;
      });
    }
    return res;
  }
}
