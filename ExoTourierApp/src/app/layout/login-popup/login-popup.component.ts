import { Component, OnInit, ViewChild, ElementRef, AfterViewInit, EventEmitter, Output, Input } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { UtilsServiceService } from 'src/app/utils-service.service';
import { FormGroup, FormControl, FormArray, Validators, NgForm } from '@angular/forms';
import { UserService } from 'src/app/core/services/user.service';
import { User } from 'src/app/core/models/User';

@Component({
  selector: 'app-login-popup',
  templateUrl: './login-popup.component.html',
  styleUrls: ['../../styles/components/_pop-up.scss']
}) 
export class LoginPopupComponent implements OnInit{
  visible: boolean = true;
  loginForm: FormGroup;

  constructor(private service: UtilsServiceService, private userService: UserService,private route: ActivatedRoute,private router: Router) { }
  
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
    //this.loginForm.controls['email'].valuethis.loginForm.controls['password'].value
    this.userService.login('attila@gmail.com','123456').subscribe(res =>{
     this.service.userLogged.next(res);
     localStorage.setItem('loggedUser',JSON.stringify(res));
    });
    this.showPopup();
    
  }
  onSignIn(){
    this.service.buttonClickEventTrack.next(false);
    this.router.navigate(['signIn']);

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
