import { Component, OnInit } from '@angular/core';
import { Excursion } from 'src/app/core/models/Excursion';
import { ActivatedRoute, Router } from '@angular/router';
import { HttpService } from 'src/app/core/http/http.service';

@Component({
  selector: 'app-buy-excursion',
  templateUrl: './buy-excursion.component.html',
  styleUrls: ['../../styles/layout/_buy-excursion.scss']
})
export class BuyExcursionComponent implements OnInit {
  excursion: Excursion;
  constructor(private route: ActivatedRoute,
    private router: Router, private httpService: HttpService) { }

  ngOnInit(): void {
    this.route.queryParams.subscribe(params =>{
    this.httpService.getExcursionById(params['id']).subscribe(res=>{
       this.excursion = res as Excursion;
       
      });
    });
    
  }
  
}
