import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BuyExcursionComponent } from './buy-excursion.component';

describe('BuyExcursionComponent', () => {
  let component: BuyExcursionComponent;
  let fixture: ComponentFixture<BuyExcursionComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BuyExcursionComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BuyExcursionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
