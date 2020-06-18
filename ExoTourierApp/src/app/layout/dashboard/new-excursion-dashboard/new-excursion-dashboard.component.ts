import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Excursion } from 'src/app/core/models/Excursion';
import { ExcursionService } from 'src/app/core/services/excursion.service';

@Component({
  selector: 'app-new-excursion-dashboard',
  templateUrl: './new-excursion-dashboard.component.html',
  styleUrls: ['../../../styles/layout/dashboard/_new-excursions.scss'],
})
export class NewExcursionDashboardComponent {
  excursion: Excursion;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private excursionService: ExcursionService
  ) {
    this.excursion = new Excursion();
  }

  onSubmit() {
    this.excursionService
      .create(this.excursion)
      .subscribe((result) => this.gotoExcursionList());
  }

  gotoExcursionList() {
    this.router.navigate(['/dashboard/excursions']);
  }
}
