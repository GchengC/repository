/**las .spec.ts, son archivos de test de angular, aqui se puede realizar pruebas unitarias
 * por ahora al momento de escribir esto no tengo claro como pero me pondre en ello :)
 */

import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HolaMundoComponent } from './hola-mundo.component';

describe('HolaMundoComponent', () => {
  let component: HolaMundoComponent;
  let fixture: ComponentFixture<HolaMundoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HolaMundoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HolaMundoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
