import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/core/models/User';

@Component({
  selector: 'app-users-dashboard',
  templateUrl: './users-dashboard.component.html',
  styleUrls: ['../../../styles/layout/dashboard/_users.scss'],
})
export class UsersDashboardComponent implements OnInit {
  users: User[];

  ngOnInit(): void {}
}
