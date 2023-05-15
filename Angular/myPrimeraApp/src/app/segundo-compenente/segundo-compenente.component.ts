import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-segundo-compenente',
  templateUrl: './segundo-compenente.component.html',
  styleUrls: ['./segundo-compenente.component.css']
})
export class SegundoCompenenteComponent implements OnInit {

  titulo = "Aqui deberian ir algunos datos HD";
  activado = true;
  users = ['ryan', 'juan', 'joe'];
  constructor() { }

  ngOnInit(): void {
  }

}
