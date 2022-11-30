import { Component, OnInit } from '@angular/core';
import { Post } from 'src/app/models/posts';
import { getPosts, getPostsFiltered, attivaPost } from 'src/app/posts.service';
@Component({
  selector: 'app-post-non-attivi',
  templateUrl: './post-non-attivi.component.html',
  styleUrls: ['./post-non-attivi.component.scss']
})
export class PostNonAttiviComponent implements OnInit {

  posts: Post[] = []

  constructor() { }

  ngOnInit(): void {

    /*  this.posts = []
      let r = getPostsFiltered(false)
      r.then((res) => {
        this.posts = res
      })

  */

    this.posts = getPostsFiltered(false)
  }

  attiva(id: number) {
    attivaPost(id)
    this.posts = this.posts.filter((e) => {
      return !(e.id ==id)
    })
  }
}


