import { Component, OnInit } from '@angular/core';
import { fetchPost } from 'src/app/posts.service';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {
  title = "d3";
  ngOnInit(): void {
    fetchPost()
  }
}


