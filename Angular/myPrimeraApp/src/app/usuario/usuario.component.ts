import { Component, OnInit,Input } from '@angular/core';

@Component({
  selector: 'app-usuario',
  templateUrl: './usuario.component.html',
  styleUrls: ['./usuario.component.css']
})
export class UsuarioComponent implements OnInit {
  @Input() nameUser:any;
  nameUser2:any;
  constructor() { }

  ngOnInit(): void {
  }

}
