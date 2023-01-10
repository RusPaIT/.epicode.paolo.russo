import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.scss']
})
export class ListComponent implements OnInit {

  lists: any [] = [];

  constructor() { }

  ngOnInit(): void {
    fetch("https://jsonplaceholder.typicode.com/todos").then((response) => {
      return response.json();
    })
    .then((data) => {
      this.lists = [...data];

    })
  }

}
