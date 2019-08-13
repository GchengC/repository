/******MODULE******/
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http'
import { FormsModule} from '@angular/forms';

//Materials
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {MatButtonModule, MatCheckboxModule, MatMenuModule, MatIconModule, MatToolbarModule, MatTableModule} from '@angular/material';
/****************************************************************************************************/
/******COMPONENT******/
import { AppComponent } from './app.component';
//Units
import { UnitsComponent } from './Components/units/units.component';
import { UnitsNavComponent } from './Components/units/units-nav/units-nav.component';
import { UnitsTableComponent } from './Components/units/units-table/units-table.component';
import { UnitsStagedComponent } from './Components/units/units-staged/units-staged.component';
import { UnitsFormComponent } from './Components/units/units-form/units-form.component';
import { UnitsDetailComponent } from './Components/units/units-detail/units-detail.component';
//---------------------------------------------------------------------------------------------
//Objects

//---------------------------------------------------------------------------------------------
/****************************************************************************************************/
/******SERVICE******/
import { UnitsService } from './Services/units.service';
/****************************************************************************************************/

@NgModule({
  declarations: [
    AppComponent,
    UnitsComponent,
    UnitsNavComponent,
    UnitsTableComponent,
    UnitsStagedComponent,
    UnitsFormComponent,
    UnitsDetailComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    BrowserAnimationsModule,
    MatButtonModule, 
    MatMenuModule,
    MatToolbarModule,
    MatIconModule,
    MatCheckboxModule,
    MatTableModule
  ],
  providers: [UnitsService],
  bootstrap: [AppComponent]
})
export class AppModule { }
