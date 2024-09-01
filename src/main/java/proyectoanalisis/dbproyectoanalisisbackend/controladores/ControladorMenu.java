package proyectoanalisis.dbproyectoanalisisbackend.controladores;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import proyectoanalisis.dbproyectoanalisisbackend.entidades.Menu;
import proyectoanalisis.dbproyectoanalisisbackend.servicios.ServicioMenu;

@CrossOrigin(originPatterns = {"http://localhost:4200"})
@RestController
@RequestMapping("/api/menus") // Definiendo la ruta de primer nivel

public class ControladorMenu {
    
    // Implimentando los metodos del request
    @Autowired
    private ServicioMenu service;

    @GetMapping
    public List<Menu> list() {
        return (List<Menu>) service.findAll();
    }

    @GetMapping("/{IdMenu}")
    public ResponseEntity<?> MenuId(@PathVariable String IdMenu) {
        Optional<Menu> menuOpcional = service.findById(IdMenu);
        if(menuOpcional.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(menuOpcional.orElseThrow());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.singletonMap("error", "No se encontro registro de menu con el Id: " + IdMenu));
    }

    @PostMapping
    public ResponseEntity<Menu> CrearMenu(@RequestBody Menu menu) {
        
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(menu));
    }
    

    @PutMapping("/{IdMenu}")
    public ResponseEntity<Menu> ActualizarMenu(@PathVariable String IdMenu, @RequestBody Menu menu) {
        Optional<Menu> menuOpcional = service.findById(IdMenu);
        if(menuOpcional.isPresent()){
            Menu usrDB = menuOpcional.get();
            usrDB.setIdMenu(menu.getIdMenu()); // No tomar en cuenta para futuras actualizaciones, el ID no debe poder ser actualizado
            usrDB.setIdModulo(menu.getIdModulo());
            usrDB.setNombre(menu.getNombre());
            usrDB.setOrdenMenu(menu.getOrdenMenu());            
            usrDB.setFechaCreacion(LocalDateTime.now());
            usrDB.setUsuarioCreacion(menu.getUsuarioCreacion());
            usrDB.setFechaModificacion(LocalDateTime.now());
            usrDB.setUsuarioModificacion(menu.getUsuarioModificacion());
            
            return ResponseEntity.ok(service.save(usrDB));
        }
        
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    
    @DeleteMapping("/{IdMenu}")
        public ResponseEntity<?> eliminarMenu(@PathVariable String IdMenu){
            Optional<Menu> usuarOptional = service.findById(IdMenu);
            if (usuarOptional.isPresent()) {
                service.deleteById(IdMenu);
                return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    
    

}
