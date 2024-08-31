import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { EstadoUsuario } from './estado-usuario.model';

@Injectable({
  providedIn: 'root',
})
export class EstadoUsuarioService {
  private apiUrl = 'http://localhost:8080/api/estado-usuario';

  constructor(private http: HttpClient) {}

  getEstados(): Observable<EstadoUsuario[]> {
    return this.http.get<EstadoUsuario[]>(this.apiUrl);
  }

  createEstado(estado: EstadoUsuario): Observable<EstadoUsuario> {
    return this.http.post<EstadoUsuario>(this.apiUrl, estado);
  }

  updateEstado(id: number, estado: EstadoUsuario): Observable<EstadoUsuario> {
    return this.http.put<EstadoUsuario>(`${this.apiUrl}/${id}`, estado);
  }

  deleteEstado(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}
