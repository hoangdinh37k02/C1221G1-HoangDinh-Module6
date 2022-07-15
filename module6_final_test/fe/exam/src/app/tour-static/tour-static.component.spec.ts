import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TourStaticComponent } from './tour-static.component';

describe('TourStaticComponent', () => {
  let component: TourStaticComponent;
  let fixture: ComponentFixture<TourStaticComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TourStaticComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TourStaticComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
