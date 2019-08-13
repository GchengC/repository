import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UnitsNavComponent } from './units-nav.component';

describe('UnitsNavComponent', () => {
  let component: UnitsNavComponent;
  let fixture: ComponentFixture<UnitsNavComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UnitsNavComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UnitsNavComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
