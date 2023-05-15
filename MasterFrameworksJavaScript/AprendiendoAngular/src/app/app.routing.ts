//todo este archivo sirve para poder hacer rutas dinamicas
//por ejemplo en una barra de menu.

//importar los modulos del router de angular
import { ModuleWithProviders } from "@angular/core";
import { Routes, RouterModule } from "@angular/router";

//importar componentes a los cuales les quiero hacer una pagina exclusiva
import { HomeComponent } from './components/home/home.component';
import { BlogComponent } from "./components/blog/blog.component";
import { FormularioComponent } from "./components/formulario/formulario.component";
import { PeliculasComponent } from "./Components/peliculas/peliculas.component";
import { PaginaComponent } from "./components/pagina/pagina.component";
import { ErrorComponent } from './Components/error/error.component';
import { Route } from "@angular/compiler/src/core";
import { Component } from '@angular/core';
import { ArticleDetailsComponent } from './Components/article-details/article-details.component';
import { SearchComponent } from './Components/search/search.component';
import { ArticleCreateComponent } from './Components/article-create/article-create.component';
import { ArticleEditComponent } from './Components/article-edit/article-edit.component';



//Array de rutas
//Configuracion de todas las rutas que se van a crear
const appRouters: Routes = [
    {path: '', component: HomeComponent},
    {path: 'home', component: HomeComponent},
    {path: 'blog', component: BlogComponent},
    {path: 'blog/articulo/:id', component: ArticleDetailsComponent},
    {path: 'blog/editar/:id', component: ArticleEditComponent},
    {path: 'blog/crear', component: ArticleCreateComponent},
    {path: 'buscar/:search', component: SearchComponent},
    {path: 'formulario', component: FormularioComponent},
    {path: 'peliculas', component: PeliculasComponent},
    {path: 'pagina-de-pruebas', component: PaginaComponent},
    {path: 'pagina-de-pruebas/:nombre/:apellidos', component: PaginaComponent},
    {path: '**', component: ErrorComponent}
];

// Exportar el modulo de rutas, es necesario colocar esto justo así:
export const appRoutingProviders: any[] = [];
export const routing: ModuleWithProviders<any> = RouterModule.forRoot(appRouters);
