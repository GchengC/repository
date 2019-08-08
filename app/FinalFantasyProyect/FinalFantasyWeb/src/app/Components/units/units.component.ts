import { Component, OnInit } from '@angular/core';
import { Form } from '@angular/forms';

import { UnitsService } from '../../Services/units.service'

import { Units } from '../../Models/units';


@Component({
  selector: 'app-units',
  templateUrl: './units.component.html',
  styleUrls: ['./units.component.css'],
  providers: [UnitsService]
})
export class UnitsComponent implements OnInit {
  unitsStaged: Units[];
  unit: Units;


  constructor(private unitsService: UnitsService) {
    this.unit = new Units;
  }

  ngOnInit() {
    this.getUnits();
  }

  getUnits() {
    this.unitsService.getUnits()
      .subscribe(res => {
        this.unitsService.units = res as Units[];
        console.log(res);
      });

  }

  resetForm() {
    this.unit = new Units;
  }

  addUnit() {
    //this.unitsStaged.push(this.unit);
    this.postUnits(this.unit);
  }

  postUnits(unit: Units) {
    console.log(unit.id);
    this.unitsService.postUnits(unit).subscribe(res =>{
      console.log("Guardado");
      this.resetForm();
      this.getUnits();
    });
  }

  editUnit(unitSelect: Units) {
    this.unit = unitSelect;
  }

  deleteUnit(id: number) {
    this.unitsService.deleteUnits(id).subscribe(res => {
      if (confirm("Estas Seguro que quiere eliminar la Unidad?")) {
        console.log(res);
        this.getUnits();
      }
    });
  }
}
