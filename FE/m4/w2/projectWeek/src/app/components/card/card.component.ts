import { style } from '@angular/animations';
import { Component, Input, OnInit } from '@angular/core';
import { catchError, reduce } from 'rxjs';
import { favMovie, Movie } from '../movies/movies.interface';
import { MoviesService } from '../movies/movies.service';

@Component({
  selector: 'app-card',
  templateUrl: './card.component.html',
  styleUrls: ['./card.component.scss']
})
export class CardComponent implements OnInit {

  @Input() m!: Movie;
  @Input() i!: number;

  favorites!: any
  fav: boolean = false;
  filter: any

  constructor(private movieSrv: MoviesService) { }

  ngOnInit(): void {
    this.getFavorite()
  }

  getFavorite() {
    this.movieSrv.getFav().subscribe((res) => {
      this.favorites = res
      let x = this.favorites.find((f: any) => f.movieId == this.m.id)
      if (x) {
        this.fav = true
        this.filter = x

      } else {
        this.fav = false
      }
    })
  }




  addFav(idM: number, i: number) {
    this.movieSrv.getFav().subscribe((res) => {
      this.favorites = res
      let x = this.favorites.find((f: any) => f.movieId == this.m.id)
      if (x) {
        this.fav = true
        this.filter = x

      } else {
        this.fav = false
      }

    })
    this.movieSrv.addFavorite(idM).subscribe(res => {
      console.log(res);
      this.fav = true
    })
  }

  removeFav() {
    console.log(this.filter.id);

    this.movieSrv.removeFavorite(this.filter.id).subscribe(res => {
      console.log(res);
    })
    this.fav = false
  }

}
