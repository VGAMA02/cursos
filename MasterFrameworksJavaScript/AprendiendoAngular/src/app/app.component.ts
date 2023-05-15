import { Component } from '@angular/core';

@Component({
  selector: 'app-root', //etiqueta que se usa en el index
  templateUrl: './app.component.html',  //cargar la vista html asociada al componente
  styleUrls: ['./app.component.css']    //Los estilos que tendra la vista.
})
export class AppComponent {
  ///propiedades de la clase
  title = 'AprendiendoAngular';

}
