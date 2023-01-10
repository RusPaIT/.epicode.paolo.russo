import { Component, OnInit } from '@angular/core';
import { AuthService } from 'src/app/auth/auth.service';
import { ProfiloService } from '../profilo/profilo.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss']
})
export class DashboardComponent implements OnInit {

  user: any
  name: string = ''
  constructor(private authSrv: AuthService, private profiloSrv: ProfiloService) { }

  ngOnInit(): void {
    this.user = this.profiloSrv.getUser()
    var maiusc = this.user.user.name.charAt(0).toUpperCase() + this.user.user.name.slice(1);
    this.name = maiusc

  }


  logout() {
    this.authSrv.logout()
  }
}
