import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { UsuarioPregunta } from './usuario-pregunta.model';

@Injectable({
  providedIn: 'root',
})
export class UsuarioPreguntaService {
  private apiUrl = 'http://localhost:8080/api/usuario-pregunta';

  constructor(private http: HttpClient) {}

  getPreguntasByUsuarioId(usuarioId: number): Observable<UsuarioPregunta[]> {
    return this.http.get<UsuarioPregunta[]>(`${this.apiUrl}/${usuarioId}`);
  }

  createPregunta(pregunta: UsuarioPregunta): Observable<UsuarioPregunta> {
    return this.http.post<UsuarioPregunta>(this.apiUrl, pregunta);
  }

  updatePregunta(id: number, pregunta: UsuarioPregunta): Observable<UsuarioPregunta> {
    return this.http.put<UsuarioPregunta>(`${this.apiUrl}/${id}`, pregunta);
  }

  deletePregunta(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}
