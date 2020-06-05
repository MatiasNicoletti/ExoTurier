import { Component, OnInit } from '@angular/core';
import { HttpService } from 'src/app/core/http/http.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['../../styles/layout/_header.scss']
})
export class HeaderComponent implements OnInit {

  constructor(private http: HttpService) { }

  ngOnInit(): void {
  }

}
