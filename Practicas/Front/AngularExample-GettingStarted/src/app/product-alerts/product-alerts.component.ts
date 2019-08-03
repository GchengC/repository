import { Component, OnInit } from '@angular/core';

/*aqui se importa la funcionalidades del input, el mismo se pudo importar en la linea anterior de la siguietne forma:
      import { Component, OnInit, Input } from '@angular/core';
pero a fines de seguir el tutorial se importa como se haria en cualquier proyecto de primera vez */
import { Input } from '@angular/core';

//ahora con las salidas es lo mismo del comentario anterior ya que pertenece a la misma libreria de @angular/core
import { Output, EventEmitter } from '@angular/core';


@Component({
  selector: 'app-product-alerts',
  templateUrl: './product-alerts.component.html',
  styleUrls: ['./product-alerts.component.css']
})
export class ProductAlertsComponent implements OnInit {

  //Esta etiqueta indica que recibira un parametro de entrada el cual se llamara "product" en este TS
  @Input() product;
  //Esta etiqueta indica que enviara un parametro de salida el cual se llamara "notify" en este TS 
  //el cual sera un nuevo tipo de evento gracias a las funcionalidades de EventEmitter;
  @Output() notify = new EventEmitter();

  constructor() { }

  ngOnInit() {
  }

}
