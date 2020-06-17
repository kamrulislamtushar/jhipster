import { Moment } from 'moment';

export interface IKCP {
  id?: number;
  login?: string;
  password?: string;
  firstName?: string;
  lastName?: string;
  email?: string;
  activated?: boolean;
  langKey?: string;
  imageUrl?: string;
  activationKey?: string;
  resetKey?: string;
  resetDate?: Moment;
  designation?: string;
  nid?: string;
  company?: string;
}

export class KCP implements IKCP {
  constructor(
    public id?: number,
    public login?: string,
    public password?: string,
    public firstName?: string,
    public lastName?: string,
    public email?: string,
    public activated?: boolean,
    public langKey?: string,
    public imageUrl?: string,
    public activationKey?: string,
    public resetKey?: string,
    public resetDate?: Moment,
    public designation?: string,
    public nid?: string,
    public company?: string
  ) {
    this.activated = this.activated || false;
  }
}
