import { Component, OnInit, ViewChild, ElementRef, AfterViewInit, EventEmitter, Output, Input } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { UtilsServiceService } from 'src/app/utils-service.service';
import { FormGroup, FormControl, FormArray, Validators } from '@angular/forms';
import { UserService } from 'src/app/core/services/user.service';

@Component({
  selector: 'app-login-popup',
  templateUrl: './login-popup.component.html',
  styleUrls: ['../../styles/components/_pop-up.scss']
}) 
export class LoginPopupComponent implements OnInit{
  visible: boolean = false;
  loginForm: FormGroup;

  constructor(private service: UtilsServiceService, private userService: UserService) { }
  
  ngOnInit(): void {
    this.service.buttonClickEventTrack.subscribe(res=>{
      console.log(res);
      this.showPopup();
    });
    this.initForm();
  }

  public showPopup(){
    this.visible = !this.visible;
  }

  onSubmit(){
    console.log(this.userService.login(this.loginForm.controls['email'].value,this.loginForm.controls['password'].value)); 
    
  }

  private initForm(){
    let userEmail = '';
    let userPassword = '';

    this.loginForm = new FormGroup({
      email: new FormControl(userEmail, Validators.required),
      password: new FormControl(userPassword, Validators.required)
    });
  }
}
