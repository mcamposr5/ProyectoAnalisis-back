package proyectoanalisis.dbproyectoanalisisbackend.controladores;

import org.springframework.web.bind.annotation.RestController;

import proyectoanalisis.dbproyectoanalisisbackend.entidades.Usuario;
import proyectoanalisis.dbproyectoanalisisbackend.servicios.ServicioUsuario;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;



/*El controlador es el encargado de atender los request o peticiones del usuario
se comunica con la base de datos
*/
@RestController
@RequestMapping("/api/usuarios") // Definiendo la ruta de primer nivel
public class ControladorUsuario {

    // Implimentando los metodos del request
    @Autowired
    private ServicioUsuario service;

    @GetMapping
    public List<Usuario> list() {
        return (List<Usuario>) service.findAll();
    }

    @GetMapping("/{IdUsuario}")
    public ResponseEntity<?> UsuarioId(@PathVariable String IdUsuario) {
        Optional<Usuario> usuarioOpcional = service.findById(IdUsuario);
        if(usuarioOpcional.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(usuarioOpcional.orElseThrow());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.singletonMap("error", "No se encontro registro de usuario con el Id: " + IdUsuario));
    }

    @PostMapping
    public ResponseEntity<Usuario> CrearUsuario(@RequestBody Usuario usuario) {
        
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(usuario));
    }
    

    @PutMapping("/{IdUsuario}")
    public ResponseEntity<Usuario> ActualizarUsuario(@PathVariable String IdUsuario, @RequestBody Usuario usuario) {
        Optional<Usuario> usuarioOpcional = service.findById(IdUsuario);
        if(usuarioOpcional.isPresent()){
            // Definiendo únicamente los campos que requiero poder modificar del usuario
            Usuario usrDB = usuarioOpcional.get();
            //usrDB.setIdUsuario(usuario.getIdUsuario()); // No tomar en cuenta para futuras actualizaciones, el ID no debe poder ser actualizado
            usrDB.setNombre(usuario.getNombre());
            usrDB.setApellido(usuario.getApellido());
            usrDB.setCorreoElectronico(usuario.getCorreoElectronico());
            usrDB.setFechaNacimiento(usuario.getFechaNacimiento());
            usrDB.setPassword(usuario.getPassword());
            usrDB.setIdGenero(usuario.getIdGenero());
            usrDB.setFotografia(usuario.getFotografia());
            return ResponseEntity.ok(service.save(usrDB));
        }
        
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    
    @DeleteMapping("/{IdUsuario}")
        public ResponseEntity<?> eliminarUsuario(@PathVariable String IdUsuario){
            Optional<Usuario> usuarOptional = service.findById(IdUsuario);
            if (usuarOptional.isPresent()) {
                service.deleteById(IdUsuario);
                return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    
    

}
