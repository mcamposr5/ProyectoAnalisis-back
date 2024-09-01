package proyectoanalisis.dbproyectoanalisisbackend.servicios;

import java.util.List;
import java.util.Optional;
import proyectoanalisis.dbproyectoanalisisbackend.entidades.Usuario;

public interface ServicioUsuario{

    // Muestra la lista de todos los usuarios
    List<Usuario> findAll();

    // busca un usuario por medio de su IdUsuario, este dato se envía como parámetro y es del tipo String
    Optional<Usuario> findById(String IdUsuario);

    // Guarda un usuario, únicamente enviamos el usuario como objeto completo
    Usuario save(Usuario usuario);

    // Elimina el usuario, es del tipo void ya que no estoy retornando ningun valor únicamente le envio el IdUsuario como parámetro.
    void deleteById(String IdUsuario);
    
}
