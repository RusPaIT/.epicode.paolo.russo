import { Component, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { Photo } from 'src/app/photo';
import { PhotoService } from 'src/app/photo.service';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.scss']
})
export class ListComponent implements OnInit {

  photos:Photo[] = []

  photoSub!:Subscription

  error = false

  constructor(private ps:PhotoService) { }

  ngOnInit(): void {
    this.photoSub = this.getPhotos()
  }

  getPhotos() {
    // this.ps.getData().subscribe(res=>{
    //   this.photos = res
    // })
    // this.photos = this.ps.getPhotos()

    return this.ps.getDataObs().subscribe((res)=>{
      if(res) this.photos = this.ps.getPhotos()
      else this.error = true
    })


  }

  ngOnDestroy() {
    this.photoSub.unsubscribe()
  }



}
