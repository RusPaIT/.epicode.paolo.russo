import { Component, OnInit, Input } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Post } from 'src/app/models/posts';
import { fetchPost, dettaglio, getDettaglio } from 'src/app/posts.service';

@Component({
  selector: 'app-card-singola',
  templateUrl: './card-singola.component.html',
  styleUrls: ['./card-singola.component.scss']
})
export class CardSingolaComponent implements OnInit {

  det: Post [] = [];
  id: number = 0;

  constructor( private route:  ActivatedRoute ) { }

  ngOnInit(): void {
    this.route.paramMap.subscribe (params => {
      let idString = params.get("id");
      this.id = parseFloat(idString!);

      fetchPost();

      dettaglio(this.id);

      let get = getDettaglio();
      this.det = get;
    })
  }

}
