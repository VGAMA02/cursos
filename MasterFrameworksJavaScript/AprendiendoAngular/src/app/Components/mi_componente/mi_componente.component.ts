import { Component } from "@angular/core";
//crear el componente
@Component({
    //tiene que llevar dos propiedades obligatoriamente, selector y template
    selector: 'mi_componente',
    //las dobles llaves llaman a una propiedad mediante "binding por interpolacion", trayendo el valor de dicha propiedad.
    /*template: `
        <h1>{{titulo}}</h1>  
        <h2>{{year}}</h2> 
        <p>{{comentario}}</p>
    `*/     
    templateUrl: './mi_componente.component.html' //el ./ indica directorio actual
}) //no poner ;

export class MiComponente{
    //aqui se pueden definir propiedades, esto tal cual es la definicion de una clase
    public titulo: string | undefined; //se puede poner undefined si no se define en el constructor
    public comentario: string;
    public year: number;
    public mostrarPeliculas: boolean;
    constructor(){
        //se deben respetar los tipos de datos, la aplicacion puede seguir por errores de tipado pero puede dar muchos fallos.
        this.titulo = "hola mundo soy mi_componente !!!";
        this.comentario = "este es mi primer componente";
        this.year = 2021;
        this.mostrarPeliculas = true;
        console.log(this.titulo,"  ",this.comentario,"  ",this.year)
    }

    ocultarPeliculas(){
        this.mostrarPeliculas = false;
    }

}


