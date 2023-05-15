import { Component, Input, Output, OnInit,EventEmitter } from '@angular/core';

import { Pelicula } from '../../models/pelicula';
@Component({
  selector: 'app-pelicula-pieza',
  templateUrl: './pelicula-pieza.component.html',
  styleUrls: ['./pelicula-pieza.component.css']
})
export class PeliculaPiezaComponent implements OnInit {
  @Input()
  pelicula!: Pelicula;

  @Input()
  i!: number;

  @Output() MarcarFavorita = new EventEmitter();
  constructor() {
    

  }
  ngOnInit(): void {
  }

  seleccionar(event:any,Objpelicula:any)
  {
    this.MarcarFavorita.emit({
      pelicula: Objpelicula
    });
  }

}
