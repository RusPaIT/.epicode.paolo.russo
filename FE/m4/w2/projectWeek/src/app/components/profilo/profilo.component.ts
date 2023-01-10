import { Component, OnInit } from '@angular/core';
import { ProfiloService } from './profilo.service';

@Component({
  selector: 'app-profilo',
  templateUrl: './profilo.component.html',
  styleUrls: ['./profilo.component.scss']
})
export class ProfiloComponent implements OnInit {

  user: any;
  constructor(private profiloSrv: ProfiloService) { }

  ngOnInit(): void {
    this.user = this.profiloSrv.getUser()
    console.log(this.user);
  }

}
