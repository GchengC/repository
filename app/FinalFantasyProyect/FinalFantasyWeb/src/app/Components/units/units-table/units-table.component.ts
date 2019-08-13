import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { Units } from 'src/app/Models/units';
import { UnitsService } from 'src/app/Services/units.service';

@Component({
  selector: 'app-units-table',
  templateUrl: './units-table.component.html',
  styleUrls: ['./units-table.component.css']
})
export class UnitsTableComponent implements OnInit {

  @Input() unitsList: Units[];
  dataSource: Units[];

  displayedColumns: string[] = ['id', 'name', 'firstClass', 'secondClass', 'thirdClass', 'baseStarts', 'maxStarts']

  constructor() {
  }
  ngOnInit() {
  }
}
