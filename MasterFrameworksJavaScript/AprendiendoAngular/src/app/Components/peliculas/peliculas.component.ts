import { THIS_EXPR } from '@angular/compiler/src/output/output_ast';
import { Component, OnInit, DoCheck, OnDestroy } from '@angular/core';
import { Pelicula } from 'src/app/models/pelicula';
import { PeliculaService } from 'src/app/services/pelicula.service';
@Component({
  selector: 'peliculas',
  templateUrl: './peliculas.component.html',
  styleUrls: ['./peliculas.component.css'],
  providers:[PeliculaService]
})
//OnInit es un hook que se lanza cuando inicia el componente, no es lo mismo que el contrusctor esto va despues.
export class PeliculasComponent implements OnInit,DoCheck, OnDestroy {

  public titulo: string;
  public peliculas: Array<Pelicula>
  public favorita: Pelicula | undefined;
  public fecha: any;
  //En un constructor no es recomendable meter logica mas alla de inicializcion de variables
  constructor(
    private _peliculaService: PeliculaService
    ) { 
    this.titulo = "Componente peliculas";
    this.peliculas = this._peliculaService.getPeliculas();
    this.fecha = new Date(2020,8,12);
  }
  //Aqui va logica necesaria para el momento de iniciar el componente
  ngOnInit(): void {
    console.log(this.peliculas);
    console.log("Componente iniciado");
    console.log(this._peliculaService.holaMundo());
  }
  //hook que verifica si algo ha cambiado.
  ngDoCheck(){
    console.log("DoCheck lanzado");
  }
  //esto es una funcion definida para usarse en un evento (como el evento click en un boton, mira el html de peliculas para que entiendas)
  cambiarTitulo(){
    this.titulo = "El titulo ha sido cambiado";
  }

  ngOnDestroy(){
    console.log("El componente se va a destruir");
  }

  mostrarFavortia(event: { pelicula: Pelicula}){
    this.favorita = event.pelicula; 
  }

}
