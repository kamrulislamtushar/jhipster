import { TestBed, getTestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import * as moment from 'moment';
import { DATE_FORMAT } from 'app/shared/constants/input.constants';
import { KCPService } from 'app/entities/kcp/kcp.service';
import { IKCP, KCP } from 'app/shared/model/kcp.model';

describe('Service Tests', () => {
  describe('KCP Service', () => {
    let injector: TestBed;
    let service: KCPService;
    let httpMock: HttpTestingController;
    let elemDefault: IKCP;
    let expectedResult: IKCP | IKCP[] | boolean | null;
    let currentDate: moment.Moment;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [HttpClientTestingModule],
      });
      expectedResult = null;
      injector = getTestBed();
      service = injector.get(KCPService);
      httpMock = injector.get(HttpTestingController);
      currentDate = moment();

      elemDefault = new KCP(
        0,
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        false,
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        currentDate,
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA'
      );
    });

    describe('Service methods', () => {
      it('should find an element', () => {
        const returnedFromService = Object.assign(
          {
            resetDate: currentDate.format(DATE_FORMAT),
          },
          elemDefault
        );

        service.find(123).subscribe(resp => (expectedResult = resp.body));

        const req = httpMock.expectOne({ method: 'GET' });
        req.flush(returnedFromService);
        expect(expectedResult).toMatchObject(elemDefault);
      });

      it('should create a KCP', () => {
        const returnedFromService = Object.assign(
          {
            id: 0,
            resetDate: currentDate.format(DATE_FORMAT),
          },
          elemDefault
        );

        const expected = Object.assign(
          {
            resetDate: currentDate,
          },
          returnedFromService
        );

        service.create(new KCP()).subscribe(resp => (expectedResult = resp.body));

        const req = httpMock.expectOne({ method: 'POST' });
        req.flush(returnedFromService);
        expect(expectedResult).toMatchObject(expected);
      });

      it('should update a KCP', () => {
        const returnedFromService = Object.assign(
          {
            login: 'BBBBBB',
            password: 'BBBBBB',
            firstName: 'BBBBBB',
            lastName: 'BBBBBB',
            email: 'BBBBBB',
            activated: true,
            langKey: 'BBBBBB',
            imageUrl: 'BBBBBB',
            activationKey: 'BBBBBB',
            resetKey: 'BBBBBB',
            resetDate: currentDate.format(DATE_FORMAT),
            designation: 'BBBBBB',
            nid: 'BBBBBB',
            company: 'BBBBBB',
          },
          elemDefault
        );

        const expected = Object.assign(
          {
            resetDate: currentDate,
          },
          returnedFromService
        );

        service.update(expected).subscribe(resp => (expectedResult = resp.body));

        const req = httpMock.expectOne({ method: 'PUT' });
        req.flush(returnedFromService);
        expect(expectedResult).toMatchObject(expected);
      });

      it('should return a list of KCP', () => {
        const returnedFromService = Object.assign(
          {
            login: 'BBBBBB',
            password: 'BBBBBB',
            firstName: 'BBBBBB',
            lastName: 'BBBBBB',
            email: 'BBBBBB',
            activated: true,
            langKey: 'BBBBBB',
            imageUrl: 'BBBBBB',
            activationKey: 'BBBBBB',
            resetKey: 'BBBBBB',
            resetDate: currentDate.format(DATE_FORMAT),
            designation: 'BBBBBB',
            nid: 'BBBBBB',
            company: 'BBBBBB',
          },
          elemDefault
        );

        const expected = Object.assign(
          {
            resetDate: currentDate,
          },
          returnedFromService
        );

        service.query().subscribe(resp => (expectedResult = resp.body));

        const req = httpMock.expectOne({ method: 'GET' });
        req.flush([returnedFromService]);
        httpMock.verify();
        expect(expectedResult).toContainEqual(expected);
      });

      it('should delete a KCP', () => {
        service.delete(123).subscribe(resp => (expectedResult = resp.ok));

        const req = httpMock.expectOne({ method: 'DELETE' });
        req.flush({ status: 200 });
        expect(expectedResult);
      });
    });

    afterEach(() => {
      httpMock.verify();
    });
  });
});
