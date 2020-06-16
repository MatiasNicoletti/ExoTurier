import { Component, OnInit, ViewChild, ElementRef, AfterViewInit, EventEmitter, Output, Input } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { UtilsServiceService } from 'src/app/utils-service.service';

@Component({
  selector: 'app-login-popup',
  templateUrl: './login-popup.component.html',
  styleUrls: ['../../styles/components/_pop-up.scss']
}) 
export class LoginPopupComponent implements OnInit{
  visible: boolean = false;

  constructor(private service: UtilsServiceService) { }
  
  ngOnInit(): void {
    this.service.buttonClickEventTrack.subscribe(res=>{
      console.log(res);
      this.showPopup();
    });
  }

  public showPopup(){
    this.visible = !this.visible;
  }
}
