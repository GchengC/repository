import { Component, OnInit, Input } from '@angular/core'; //se agrega el componente Input para habilitar entradas de variables

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {
  @Input() nameUser; //se declara varialbe de parametro de entrada recibido

  constructor() { }

  ngOnInit() {
  }

}
