import { Component, OnInit } from '@angular/core';
import { Excursion } from 'src/app/core/models/Excursion';
import { ExcursionService } from 'src/app/core/services/excursion.service';

@Component({
  selector: 'app-excursions-dashboard',
  templateUrl: './excursions-dashboard.component.html',
  styleUrls: ['../../../styles/layout/dashboard/_excursions.scss'],
})
export class ExcursionsDashboardComponent implements OnInit {
  excursions: Excursion[];

  constructor(private excursionService: ExcursionService) {}

  ngOnInit() {
    this.excursionService.findAll().subscribe((data) => {
      this.excursions = data;
    });
  }
}
