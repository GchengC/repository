import { Component, OnInit, ViewChild } from '@angular/core';
import { UnitsTableComponent } from './units-table/units-table.component'

import { UnitsService } from '../../Services/units.service'

import { Units } from '../../Models/units';




@Component({
  selector: 'app-units',
  templateUrl: './units.component.html',
  styleUrls: ['./units.component.css'],
  providers: [UnitsService]
})
export class UnitsComponent implements OnInit {

  @ViewChild('unitsTable', { static: false }) utable: UnitsTableComponent;


  unitsStaged: Units[];
  unitSelect: boolean = false;
  unit: Units;


  constructor(private unitsService: UnitsService) {
  }

  ngOnInit() {
    this.getUnits();
  }


  resetForm() {
    //this.unit = new Units;
    this.unitSelect = false;
  }

  addUnit() {
    //this.unitsStaged.push(this.unit);
    this.postUnits(this.unit);
  }

  editUnit(unitSelect: Units) {
    this.unit = unitSelect;
    this.unitSelect = true;
  }

  postUnits(unit: Units) {
    console.log(unit.id);
    this.unitsService.postUnits(unit).subscribe(res => {
      console.log("Guardado");
      this.resetForm();
      this.getUnits();
    });
  }

  getUnits() {
    this.unitsService.getUnits()
      .subscribe(res => {
        this.utable.dataSource = res as Units[];
        console.log(res);
      }, error => {
        console.log(error);
      });

  }

  putUnits() {
    this.unitsService.putUnits(this.unit)
      .subscribe(res => { console.log("Unidad Modificada con Exito") })
  }


  deleteUnit(id: number) {
    if (confirm("Estas Seguro que quiere eliminar la Unidad?")) {
      this.unitsService.deleteUnits(id).subscribe(res => {
        console.log(res);
        this.getUnits();
      });
    }
  }
}
