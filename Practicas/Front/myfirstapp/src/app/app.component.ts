/**Son nuestros componentes en el HTML, bascimente todas esas secciones de nuestra pagina que podremos
 * llamar independientemente a travez de selector (etiquetas HTML) en nuestra pagina
 * Particularmente este app.component es el principal de nuestra pagina
 * distinte del index.html ya que ese esta fuera del mismo, este vendria siendo la etiqueta que esta
 * dentro de ese body en el index.html
 */

import { Component } from '@angular/core';

import { DataService } from './data.service'
import { Post } from './Post';

@Component({
  selector: 'app-root', //etiqueta que se usara en html para llamar este componente
  templateUrl: './app.component.html',//ruta de html usado como template
  styleUrls: ['./app.component.css']// Ruta de CSS usado como stylo UNICO de este template
})
export class AppComponent {

  title = 'myfirstapp';
  Users = ['Ryan', 'Joe', 'Cameron', 'Jhon', 'Bruce'];
  activated = true;
  name2: string = 'Jhon Carter';
  age2: number = 28;

  posts: Post[];

  //Declarar tipo de variables
  activate: boolean = false;
  name: String = 'Ryan Ray';
  age: number;
  address: {
    street: string;
    city: string;
  };
  hobbies: string[];
  Users2: String[] = ['Ryan', 'Joe', 'Cameron']

  constructor(private dataService: DataService) {
    this.age = 28;
    this.address = {
      street: '221 B Baker Street',
      city: 'London'
    };
    this.hobbies = ['Swim', 'read', 'write'];

    this.dataService.getData().subscribe(data => {  
      console.log(data);
      this.posts = data
    });
  }

  sayHello() {
    alert("Hello!");
  }

  deleteUser(user) {
    for (let i = 0; i < this.Users2.length; i++) {
      if (user == this.Users2[i]) {
        this.Users2.splice(i, 1);
      }
    }
  }

  addUser(newUser) {
    console.log(newUser);
    console.log(newUser.value);
    this.Users2.push(newUser.value);
    newUser.value = '';
    newUser.focus();
    return false;
  }

}
