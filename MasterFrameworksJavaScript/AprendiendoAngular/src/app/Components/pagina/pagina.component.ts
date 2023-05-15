import { Route } from '@angular/compiler/src/core';
import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute, Params } from '@angular/router';
@Component({
  selector: 'app-pagina',
  templateUrl: './pagina.component.html',
  styleUrls: ['./pagina.component.css']
})
export class PaginaComponent implements OnInit {
  //pasamos las funciones necesarias al constructor para pasar parametros
  public nombre: string;
  public apellidos: string;
  constructor( private _route: ActivatedRoute, private _router: Router) {
    this.nombre = "";
    this.apellidos = "";
   }

  ngOnInit(): void {
    //metodo observable
    this._route.params.subscribe((params: Params) => {
      console.log(params);
      this.nombre = params.nombre;
      this.apellidos = params.apellidos;
    });
  }

  //metodo para redireccionar
  redireccion(){
    this._router.navigate(['/pagina-de-pruebas', 'Brandon','Gama']);
  }

}
