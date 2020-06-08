import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { OutstandingExcursionComponent } from './outstanding-excursion.component';

describe('OutstandingExcursionComponent', () => {
  let component: OutstandingExcursionComponent;
  let fixture: ComponentFixture<OutstandingExcursionComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ OutstandingExcursionComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OutstandingExcursionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
