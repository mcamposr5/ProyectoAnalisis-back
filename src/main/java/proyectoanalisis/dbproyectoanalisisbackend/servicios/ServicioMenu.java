package proyectoanalisis.dbproyectoanalisisbackend.servicios;


import java.util.List;
import java.util.Optional;
import proyectoanalisis.dbproyectoanalisisbackend.entidades.Menu;


public interface ServicioMenu {
    
List<Menu> findAll();

Optional<Menu> findById(String IdMenu);

Menu save(Menu menu);

void deleteById(String IdMenu);
    

}
