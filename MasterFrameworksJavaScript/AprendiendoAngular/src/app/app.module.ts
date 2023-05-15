import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {routing, appRoutingProviders} from './app.routing';
import { FormsModule } from '@angular/forms';
//import { MomentModule } from 'ngx-moment';
import { MomentModule } from 'angular2-moment';
import { AngularFileUploaderModule } from "angular-file-uploader";


import { AppComponent } from './app.component'; //importar componentes
import { MiComponente } from './Components/mi_componente/mi_componente.component';
import { PeliculasComponent } from './Components/peliculas/peliculas.component';
import { HeaderComponent } from './components/header/header.component';
import { SliderComponent } from './components/slider/slider.component';
import { SidebarComponent } from './components/sidebar/sidebar.component';
import { FooterComponent } from './components/footer/footer.component';
import { HomeComponent } from './components/home/home.component';
import { BlogComponent } from './components/blog/blog.component';
import { FormularioComponent } from './components/formulario/formulario.component';
import { PaginaComponent } from './components/pagina/pagina.component';
//import { PeliculaComponent } from './components/pelicula/pelicula.component';
import { PeliculaPiezaComponent } from './Components/pelicula-pieza/pelicula-pieza.component';
import { esParPipe } from './pipes/espar.pipe';
import { HttpClientModule } from '@angular/common/http';
import { ArticlesComponent } from './components/articles/articles.component';
import { ArticleDetailsComponent } from './Components/article-details/article-details.component';
import { SearchComponent } from './Components/search/search.component';
import { ArticleCreateComponent } from './Components/article-create/article-create.component';
import { ArticleEditComponent } from './Components/article-edit/article-edit.component';

//en esta parte se cargan todos los componentes y servicios el providers es importante para hacer el cambio de rutas
@NgModule({
  declarations: [
    AppComponent, //aqui llamamos a todos los componentes para llamarlos en cualquier lado
    MiComponente, PeliculasComponent, HeaderComponent,
    SliderComponent, SidebarComponent, FooterComponent,
    HomeComponent, BlogComponent, FormularioComponent,
    PaginaComponent, PeliculaPiezaComponent,esParPipe, ArticlesComponent,
    ArticleDetailsComponent, SearchComponent, ArticleCreateComponent,ArticleEditComponent  ],
  imports: [
  BrowserModule,
  routing,
  FormsModule,
  HttpClientModule,
  MomentModule,
  AngularFileUploaderModule
  ],
  providers: [appRoutingProviders], //aqui cargamos servicios
  bootstrap: [AppComponent] //componente inicial, con que inicia la app exactamente.
})
export class AppModule { }
