import { Component } from '@angular/core';
import { PhotoService } from './photo.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'd1';

  constructor(private ps:PhotoService) {}

  ngOnInit() {
    this.ps.fetchData()
  }
}
