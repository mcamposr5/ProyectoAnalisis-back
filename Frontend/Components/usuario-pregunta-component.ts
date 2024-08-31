import { Component, OnInit } from '@angular/core';
import { UsuarioPreguntaService } from './usuario-pregunta.service';
import { UsuarioPregunta } from './usuario-pregunta.model';

@Component({
  selector: 'app-usuario-pregunta',
  templateUrl: './usuario-pregunta.component.html',
})
export class UsuarioPreguntaComponent implements OnInit {
  preguntas: UsuarioPregunta[] = [];
  nuevaPregunta: UsuarioPregunta = { id: 0, usuarioId: 1, pregunta: '', respuesta: '' }; // Cambiar usuarioId por el ID real

  constructor(private usuarioPreguntaService: UsuarioPreguntaService) {}

  ngOnInit(): void {
    this.loadPreguntas();
  }

  loadPreguntas(): void {
    this.usuarioPreguntaService.getPreguntasByUsuarioId(this.nuevaPregunta.usuarioId).subscribe((data) => {
      this.preguntas = data;
    });
  }

  createPregunta(): void {
    this.usuarioPreguntaService.createPregunta(this.nuevaPregunta).subscribe(() => {
      this.loadPreguntas();
      this.nuevaPregunta = { id: 0, usuarioId: 1, pregunta: '', respuesta: '' }; // Resetear después de guardar
    });
  }

  updatePregunta(pregunta: UsuarioPregunta): void {
    this.usuarioPreguntaService.updatePregunta(pregunta.id, pregunta).subscribe(() => {
      this.loadPreguntas();
    });
  }

  deletePregunta(id: number): void {
    this.usuarioPreguntaService.deletePregunta(id).subscribe(() => {
      this.loadPreguntas();
    });
  }
}
