import { Injectable } from '@angular/core';

import { HttpClient } from '@angular/common/http'; //V.0.3.0 - Se agrega funcionalidades de cliente http angular

@Injectable({
  providedIn: 'root'
})
export class CartService {
  items = [];

  constructor(private http: HttpClient) { }

  addToCart(product) {
    this.items.push(product);
  }

  getItems() {
    return this.items;
  }

  clearCart() {
    this.items = [];
    return this.items;
  }

  getShippingPrices() {
    return this.http.get('/assets/shipping.json');
  }
}
