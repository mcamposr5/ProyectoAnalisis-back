package proyectoanalisis.dbproyectoanalisisbackend.repositorios;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import proyectoanalisis.dbproyectoanalisisbackend.entidades.Empresa;

/*Utilizando la libreria CrudRepository le indicamos a la interfaz
 * repositorioUsuario que tendrá la capacidad de crear un CRUD de un tipo especifico 
 * en este caso de tipo Usuario
*/
public interface RepositorioEmpresa extends CrudRepository<Empresa, Integer>{

        // Método personalizado para buscar una empresa por nombre
        Optional<Empresa> findByNombre(String nombre);
    
}