import { Injectable } from "@angular/core"; //evitar usar new en algunas de claraciones
import { Pelicula } from "../models/pelicula";

//definir servicio
@Injectable()
export class PeliculaService{
    public peliculas!: Pelicula[];

    constructor(){
        this.peliculas = [
            new Pelicula("Cholo's Ranfla",2017,'https://http2.mlstatic.com/D_NQ_NP_920315-MLM25209814928_122016-O.jpg '),
            new Pelicula("Spiderman 9", 2020,'https://i.pinimg.com/474x/c8/99/39/c899398288dbcdcc50f80164401d7fae.jpg' ),
            //tambien se pueden definir objectos json literales pero tienen que tener las mismas propiedades:
            {year: 2015, title: "Las puercas del nilo", image: 'https://egiptoexclusivo.com/wp-content/uploads/2020/12/el-rio-nilo-en-egipto.jpg'},
            {year: 2014, title: "La doña", image: 'https://static.13.cl/7/sites/default/files/styles/manualcrop_890x500/public/programas/articulos/field-imagen/senora_nota_0.jpg?itok=khuLmzWp'}
        ]
    }
    holaMundo(){ //metodo del servicio
        return 'hola mundo desde un servicio de angular !!!';
    }
    getPeliculas(){
        return this.peliculas;
    }
}