import { Component, OnInit } from '@angular/core';
import { EstadoUsuarioService } from './estado-usuario.service';
import { EstadoUsuario } from './estado-usuario.model';

@Component({
  selector: 'app-estado-usuario',
  templateUrl: './estado-usuario.component.html',
})
export class EstadoUsuarioComponent implements OnInit {
  estados: EstadoUsuario[] = [];
  nuevoEstado: EstadoUsuario = { id: 0, estado: '' };

  constructor(private estadoUsuarioService: EstadoUsuarioService) {}

  ngOnInit(): void {
    this.loadEstados();
  }

  loadEstados(): void {
    this.estadoUsuarioService.getEstados().subscribe((data) => {
      this.estados = data;
    });
  }

  createEstado(): void {
    this.estadoUsuarioService.createEstado(this.nuevoEstado).subscribe(() => {
      this.loadEstados();
      this.nuevoEstado = { id: 0, estado: '' };
    });
  }

  updateEstado(estado: EstadoUsuario): void {
    this.estadoUsuarioService.updateEstado(estado.id, estado).subscribe(() => {
      this.loadEstados();
    });
  }

  deleteEstado(id: number): void {
    this.estadoUsuarioService.deleteEstado(id).subscribe(() => {
      this.loadEstados();
    });
  }
}
