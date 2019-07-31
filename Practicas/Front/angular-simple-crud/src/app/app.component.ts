import { Component } from '@angular/core';

import { Employer } from './models/employer';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  employerArray: Employer[] = [
    { id: 1, name: "Ryan", country: "USA" },
    { id: 2, name: "Angelica", country: "USA" },
    { id: 3, name: "Joe", country: "USA" }
  ];

  selectedEmployer: Employer = new Employer();

  addOrEdit() {
    if (this.selectedEmployer.id === 0) {
      this.selectedEmployer.id = this.employerArray.length + 1;
      this.employerArray.push(this.selectedEmployer);
    }

    this.selectedEmployer = new Employer();
  };

  openEdit(employer: Employer) {
    this.selectedEmployer = employer;
  };

  delete() {
    if (confirm('Are you sure you want to delete ir?')) {
      this.employerArray = this.employerArray.filter(x => x != this.selectedEmployer);
      this.selectedEmployer = new Employer();
    } 
  };

}
