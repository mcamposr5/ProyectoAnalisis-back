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
import proyectoanalisis.dbproyectoanalisisbackend.entidades.Modulo;
import proyectoanalisis.dbproyectoanalisisbackend.servicios.ServicioMenu;
import proyectoanalisis.dbproyectoanalisisbackend.servicios.ServicioModulo;

@CrossOrigin(originPatterns = {"http://localhost:4200"})
@RestController
@RequestMapping("/api/modulos") 

public class ControladorModulo {

    
    @Autowired
    private ServicioModulo service;
    @GetMapping
    public List<Modulo> list() {
    return (List<Modulo>) service.findAll();
}
    @GetMapping("/{IdModulo}")
    public ResponseEntity<?> ModuloId(@PathVariable String IdModulo) {
    Optional<Modulo> moduloOpcional = service.findById(IdModulo);
    if(moduloOpcional.isPresent()){
        return ResponseEntity.status(HttpStatus.OK).body(moduloOpcional.orElseThrow());
    }
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.singletonMap("error", "No se encontro registro de modulo con el Id: " + IdModulo));
}
    @PostMapping
    public ResponseEntity<Modulo> CrearModulo(@RequestBody Modulo modulo) {
    
    return ResponseEntity.status(HttpStatus.CREATED).body(service.save(modulo));
}
    
    @PutMapping("/{IdModulo}")
    public ResponseEntity<Modulo> ActualizarModulo(@PathVariable String IdModulo, @RequestBody Modulo modulo) {
    Optional<Modulo> moduloOpcional = service.findById(IdModulo);
    if(moduloOpcional.isPresent()){
        Modulo usrDB = moduloOpcional.get();        
        usrDB.setIdModulo(modulo.getIdModulo());
        usrDB.setNombre(modulo.getNombre());
        usrDB.setOrdenMenu(modulo.getOrdenMenu());            
        usrDB.setFechaCreacion(LocalDateTime.now());
        usrDB.setUsuarioCreacion(modulo.getUsuarioCreacion());
        usrDB.setFechaModificacion(LocalDateTime.now());
        usrDB.setUsuarioModificacion(modulo.getUsuarioModificacion());
        
        return ResponseEntity.ok(service.save(usrDB));
    }
    
    return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
}
    
    @DeleteMapping("/{IdModulo}")
    public ResponseEntity<?> eliminarModulo(@PathVariable String IdModulo){
        Optional<Modulo> usuarOptional = service.findById(IdModulo);
        if (usuarOptional.isPresent()) {
            service.deleteById(IdModulo);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    
    

}
