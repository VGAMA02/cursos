import { Component } from '@angular/core'; //importar la accion de crear componentes

//Nombre del componente en el archivo html con el selector
@Component({
    selector: "HolaMundo",
    templateUrl:  './primer.component.html',
    styleUrls: ['./primer.component.css']
})
//se necesita el export
export class HolaMundo{
    titulo = "Bienvenido a angular"; 
}