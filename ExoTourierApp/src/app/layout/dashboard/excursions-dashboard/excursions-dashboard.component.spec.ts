import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ExcursionsDashboardComponent } from './excursions-dashboard.component';

describe('ExcursionsDashboardComponent', () => {
  let component: ExcursionsDashboardComponent;
  let fixture: ComponentFixture<ExcursionsDashboardComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ExcursionsDashboardComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ExcursionsDashboardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
