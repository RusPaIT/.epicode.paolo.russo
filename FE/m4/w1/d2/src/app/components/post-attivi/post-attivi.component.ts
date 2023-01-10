import { Component, OnInit, } from '@angular/core';
import { Post } from 'src/app/models/posts';
import { getPosts, getPostsFiltered } from 'src/app/posts.service';
@Component({
  selector: 'app-post-attivi',
  templateUrl: './post-attivi.component.html',
  styleUrls: ['./post-attivi.component.scss']
})
export class PostAttiviComponent implements OnInit {

  posts: Post[] = [];


  constructor() { }

  ngOnInit(): void {

    this.posts = []
    let r = getPostsFiltered(true)
    r.then((res) => {
      this.posts = res
    })
  }

}
