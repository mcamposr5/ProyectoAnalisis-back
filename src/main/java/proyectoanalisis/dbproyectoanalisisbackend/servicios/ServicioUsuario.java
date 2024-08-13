package proyectoanalisis.dbproyectoanalisisbackend.servicios;

import java.util.List;
import java.util.Optional;
import proyectoanalisis.dbproyectoanalisisbackend.entidades.Usuario;

public interface ServicioUsuario{

    List<Usuario> findAll();

    Optional<Usuario> findById(String IdUsuario);

    Usuario save(Usuario usuario);

    void deleteById(String IdUsuario);
    
}
