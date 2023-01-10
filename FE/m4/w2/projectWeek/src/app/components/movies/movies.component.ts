import { Component, OnInit } from '@angular/core';
import { DashMovie, favMovie, Movie } from './movies.interface';
import { MoviesService } from './movies.service';

@Component({
  selector: 'app-movies',
  templateUrl: './movies.component.html',
  styleUrls: ['./movies.component.scss']
})
export class MoviesComponent implements OnInit {


  prova: DashMovie = {
    data: [],
    fav: []
  }
  constructor(private movieSrv: MoviesService) { }

  ngOnInit(): void {
    this.movieSrv.getMovies().subscribe((res) => {
      this.prova.data = res
    })
    this.movieSrv.getFav().subscribe((res) => {
      let x = this.prova.fav.push(res)
    })

  }
}
