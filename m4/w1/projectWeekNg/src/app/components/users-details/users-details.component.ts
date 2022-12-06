import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { User } from 'src/app/models/posts';
import { __importDefault } from 'tslib';

@Component({
  selector: 'app-users-details',
  templateUrl: './users-details.component.html',
  styleUrls: ['./users-details.component.scss']
})
export class UsersDetailsComponent implements OnInit {

 persona: any

  constructor(private route: ActivatedRoute) { }

  ngOnInit(): void {

  }

}
