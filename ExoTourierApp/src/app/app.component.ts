import { Component, AfterViewInit, ElementRef } from '@angular/core';
import { HttpService } from './core/http/http.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements AfterViewInit{
  title = 'ExoTourierApp';

  constructor(private httpService: HttpService, private elementRef: ElementRef){}
  ngAfterViewInit(): void {
    this.elementRef.nativeElement.ownerDocument.body.style.backgroundColor = '#EFEFEF';
  }


  getUsers(){
  this.httpService.fetchUsers().subscribe(res => {
    console.log(res);
  }, err => {
    console.log('Lista de usuarios vacia');
  });
  
  }

  addUser(){
    this.httpService.addUser().subscribe(res => {
      console.log(res);
    });
  }
}
