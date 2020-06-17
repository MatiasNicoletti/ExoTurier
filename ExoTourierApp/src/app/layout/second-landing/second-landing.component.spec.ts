import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SecondLandingComponent } from './second-landing.component';

describe('SecondLandingComponent', () => {
  let component: SecondLandingComponent;
  let fixture: ComponentFixture<SecondLandingComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SecondLandingComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SecondLandingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
