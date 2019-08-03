import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { products } from '../products'

@Component({
  selector: 'app-product-details',
  templateUrl: './product-details.component.html',
  styleUrls: ['./product-details.component.css']
})
export class ProductDetailsComponent implements OnInit {
  product;

  constructor(private route: ActivatedRoute, ) { }

  ngOnInit() {
    //Se puede obtener informacion de lo manejado en la interfaz y por medio de enrutamiento se puede obtener dica informacion
    //Se importa las funcionalidades de ActivatedRoute para y por medio de este se accede a paramMap el cual mapea la informacion
    //trasmitida en cada ruta generada
    this.route.paramMap.subscribe(params => {
      this.product = products[+params.get('productId')];
      console.log(this.product);
    });
  }

}
