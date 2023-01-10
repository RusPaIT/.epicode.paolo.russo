import { Component, OnInit, } from '@angular/core';
import { Post } from 'src/app/models/posts';
import { getPosts, fetchPost, getPostsFiltered, disattivaPost, eliminaPost, dettaglio } from 'src/app/posts.service';

@Component({
  selector: 'app-post-attivi',
  templateUrl: './post-attivi.component.html',
  styleUrls: ['./post-attivi.component.scss']
})
export class PostAttiviComponent implements OnInit {

  posts: Post[] = [];


  constructor() { }

  ngOnInit(): void {

    this.posts = getPostsFiltered(true);

  }

  disattiva(id: number) {
    disattivaPost(id)
    this.posts = this.posts.filter((e) => {
      return !(e.id ==id)
    })
  }

  elimina(id: number) {
    eliminaPost(id)
    this.posts = this.posts.filter((e) => {
      return !(e.id ==id)
    })
  }

}
