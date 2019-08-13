import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UnitsStagedComponent } from './units-staged.component';

describe('UnitsStagedComponent', () => {
  let component: UnitsStagedComponent;
  let fixture: ComponentFixture<UnitsStagedComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UnitsStagedComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UnitsStagedComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
