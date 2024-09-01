package proyectoanalisis.dbproyectoanalisisbackend.servicios;

import java.util.List;
import java.util.Optional;
import proyectoanalisis.dbproyectoanalisisbackend.entidades.Modulo;


public interface ServicioModulo {  

List<Modulo> findAll();

Optional<Modulo> findById(String IdModulo);

Modulo save(Modulo modulo);

void deleteById(String IdModulo);

}
