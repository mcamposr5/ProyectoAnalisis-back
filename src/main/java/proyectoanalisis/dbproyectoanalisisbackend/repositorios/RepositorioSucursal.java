package proyectoanalisis.dbproyectoanalisisbackend.repositorios;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import proyectoanalisis.dbproyectoanalisisbackend.entidades.Sucursal;

/*Utilizando la libreria CrudRepository le indicamos a la interfaz
 * repositorioUsuario que tendrá la capacidad de crear un CRUD de un tipo especifico 
 * en este caso de tipo Usuario
*/
public interface RepositorioSucursal extends CrudRepository<Sucursal, Integer>{

            // Método personalizado para buscar una empresa por nombre
        Optional<Sucursal> findByNombre(String nombre);
}