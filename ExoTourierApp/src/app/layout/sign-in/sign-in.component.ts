import { Component, OnInit } from '@angular/core';
import { UtilsServiceService } from 'src/app/utils-service.service';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { User } from 'src/app/core/models/User';
import { UserService } from 'src/app/core/services/user.service';

@Component({
  selector: 'app-sign-in',
  templateUrl: './sign-in.component.html',
  styleUrls: ['../../styles/layout/_sign-in.scss']
})
export class SignInComponent implements OnInit {
  signinForm: FormGroup;
  constructor(private service: UtilsServiceService, private userService: UserService) { }

  ngOnInit(): void {
    this.service.buttonClickEventTrack.next(false);
    this.initForm();
  }
  private initForm(){
    let userFirstname = '';
    let userSurname = '';
    let userEmail = '';
    let userPassword = '';
 
    this.signinForm = new FormGroup({
      email: new FormControl(userEmail, Validators.required),
      password: new FormControl(userPassword, Validators.required),
      firstname: new FormControl(userFirstname, Validators.required),
      surname: new FormControl(userSurname, Validators.required)
    });
  }

  onSubmit(){ 
    let user: User = new User();
    user.firstname = this.signinForm.controls['firstname'].value;
    user.surname = this.signinForm.controls['surname'].value;
    user.email = this.signinForm.controls['email'].value;
    user.password = this.signinForm.controls['password'].value;
    user.isActive = true;
    this.userService.signin(user).subscribe(res =>{
      console.log(res); 
    }, error => {
      console.log(error);
    })
  }
}
