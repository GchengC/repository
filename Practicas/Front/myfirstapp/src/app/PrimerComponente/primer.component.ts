import { Component } from '@angular/core';

@Component({
    selector:'hola-mundo',
    templateUrl: './primer.component.html',
    styleUrls: ['./primer.component.css']
})  
export class HelloWorld{
    title = 'Bienvenido a Angular';
}