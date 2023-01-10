import { Component, Input, OnInit } from '@angular/core';
import { Photo } from 'src/app/photo';
import { PhotoService } from 'src/app/photo.service';

@Component({
  selector: 'app-card',
  templateUrl: './card.component.html',
  styleUrls: ['./card.component.scss']
})
export class CardComponent implements OnInit {

  @Input() photo:Photo|undefined

  @Input() error = false

  constructor(private ps:PhotoService) { }

  ngOnInit(): void {
  }

  elimina() {
    if(this.photo != undefined) {
      this.ps.delete(this.photo.id)
    } else {
      console.log("else");

    }
  }

}
