import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Excursion } from 'src/app/core/models/Excursion';
import { ExcursionService } from 'src/app/core/services/excursion.service';
import { CityService } from 'src/app/core/services/city.service';
import { City } from 'src/app/core/models/City';

@Component({
  selector: 'app-new-excursion-dashboard',
  templateUrl: './new-excursion-dashboard.component.html',
  styleUrls: ['../../../styles/layout/dashboard/_new-excursions.scss'],
})
export class NewExcursionDashboardComponent {
  excursion: Excursion;
  cities: City[];

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private excursionService: ExcursionService,
    private cityService: CityService
  ) {
    this.excursion = new Excursion();
  }

  ngOnInit() {
    this.cityService.findAll().subscribe((data) => {
      this.cities = data;
    });
    console.log(this.cities);
  }

  onSubmit() {
    console.log('entrando');
    this.excursionService
      .create(this.excursion)
      .subscribe((result) => this.gotoExcursionList());
  }

  gotoExcursionList() {
    this.router.navigate(['/dashboard/excursions']);
  }
}
