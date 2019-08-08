import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http'
import { FormsModule} from '@angular/forms';

import { AppComponent } from './app.component';
import { UnitsComponent } from './Components/units/units.component';

import { UnitsService } from './Services/units.service';

@NgModule({
  declarations: [
    AppComponent,
    UnitsComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [UnitsService],
  bootstrap: [AppComponent]
})
export class AppModule { }
