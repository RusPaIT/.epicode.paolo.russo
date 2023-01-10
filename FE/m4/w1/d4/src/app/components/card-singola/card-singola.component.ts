import { Component, OnInit, Input } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Post } from 'src/app/models/posts';
@Component({
  selector: 'app-card-singola',
  templateUrl: './card-singola.component.html',
  styleUrls: ['./card-singola.component.scss']
})
export class CardSingolaComponent implements OnInit {
  @Input() p!: Post
  constructor( private route:  ActivatedRoute ) { }

  ngOnInit(): void {
  }

}
