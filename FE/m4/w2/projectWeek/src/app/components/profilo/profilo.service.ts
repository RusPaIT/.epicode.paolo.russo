import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ProfiloService {

  user: any;

  constructor() { }

  getUser() {
    let takeUser: any = localStorage.getItem('user');
    return this.user = JSON.parse(takeUser)
  }

}
