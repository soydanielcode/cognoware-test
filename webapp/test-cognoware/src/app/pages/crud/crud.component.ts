import { Component } from '@angular/core';

@Component({
  selector: 'app-crud',
  standalone: true,
  imports: [],
  templateUrl: './crud.component.html',
  styleUrl: './crud.component.scss'
})
export class CrudComponent {

  datos = [
    { id: 1, nombre: 'Ejemplo 1', descripcion: 'Descripción 1' },
    { id: 2, nombre: 'Ejemplo 2', descripcion: 'Descripción 2' },
    { id: 2, nombre: 'Ejemplo 2', descripcion: 'Descripción 2' },
    { id: 2, nombre: 'Ejemplo 2', descripcion: 'Descripción 2' },
    { id: 2, nombre: 'Ejemplo 2', descripcion: 'Descripción 2' }
  ];
}
