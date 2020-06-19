import { Component, OnInit } from '@angular/core';
import { HttpService } from 'src/app/core/http/http.service';
import { Excursion } from 'src/app/core/models/Excursion';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-grid',
  templateUrl: './grid.component.html',
  styleUrls: ['../../styles/layout/_grid.scss']
})
export class GridComponent implements OnInit {
  excursions: Excursion[];
  excursion: Excursion;
  constructor(private httpService: HttpService,private route: ActivatedRoute,private router: Router) { }

  ngOnInit(): void {
    this.fetchExcursions();
   // 
  }

  fetchExcursions(){
    this.httpService.fetchExcursions().subscribe(excursionsResponse => {
      this.excursions = excursionsResponse as Excursion[];
     console.log(this.excursions);
    });
  }

  onSelectedExcursion(id:number){

    let exc: Excursion;
    this.httpService.getExcursionById(id).subscribe(res => {
      this.router.navigate(['excursions/buy'], { queryParams: { id: id }});
    })
    
  }

}
