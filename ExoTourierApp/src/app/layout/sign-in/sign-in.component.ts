import { Component, OnInit } from '@angular/core';
import { UtilsServiceService } from 'src/app/utils-service.service';

@Component({
  selector: 'app-sign-in',
  templateUrl: './sign-in.component.html',
  styleUrls: ['../../styles/layout/_sign-in.scss']
})
export class SignInComponent implements OnInit {

  constructor(private service: UtilsServiceService) { }

  ngOnInit(): void {
    this.service.buttonClickEventTrack.next(false);
  }

}
