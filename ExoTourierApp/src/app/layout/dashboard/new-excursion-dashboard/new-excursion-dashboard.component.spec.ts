import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NewExcursionDashboardComponent } from './new-excursion-dashboard.component';

describe('NewExcursionDashboardComponent', () => {
  let component: NewExcursionDashboardComponent;
  let fixture: ComponentFixture<NewExcursionDashboardComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NewExcursionDashboardComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NewExcursionDashboardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
