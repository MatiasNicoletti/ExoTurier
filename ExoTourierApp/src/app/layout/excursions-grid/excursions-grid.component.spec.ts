import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ExcursionsGridComponent } from './excursions-grid.component';

describe('ExcursionsGridComponent', () => {
  let component: ExcursionsGridComponent;
  let fixture: ComponentFixture<ExcursionsGridComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ExcursionsGridComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ExcursionsGridComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
