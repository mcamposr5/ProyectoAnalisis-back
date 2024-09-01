package proyectoanalisis.dbproyectoanalisisbackend.repositorios;

import org.springframework.data.repository.CrudRepository;

import proyectoanalisis.dbproyectoanalisisbackend.entidades.Menu;


/*Utilizando la libreria CrudRepository le indicamos a la interfaz
 * repositorioUsuario que tendrá la capacidad de crear un CRUD de un tipo especifico 
 * en este caso de tipo Usuario
*/
public interface RepositorioMenu extends CrudRepository<Menu, String>{

    
}