import { Component, OnInit } from '@angular/core';
import { HttpService } from 'src/app/core/http/http.service';
import { Excursion } from 'src/app/core/models/Excursion';

@Component({
  selector: 'app-grid',
  templateUrl: './grid.component.html',
  styleUrls: ['../../styles/layout/_grid.scss']
})
export class GridComponent implements OnInit {
  excursions: Excursion[];
  constructor(private httpService: HttpService) { }

  ngOnInit(): void {
    this.fetchExcursions();
   // 
  }

  fetchExcursions(){
    this.httpService.fetchExcursions().subscribe(excursionsResponse => {
      this.excursions = excursionsResponse as Excursion[];
      //console.log(this.excursions);
    });
  }


}
