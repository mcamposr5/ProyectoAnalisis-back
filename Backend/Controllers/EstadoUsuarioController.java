package Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.seguridad.model.EstadoUsuario;
import com.example.seguridad.service.EstadoUsuarioService;

import java.util.List;

@RestController
@RequestMapping("/api/estado-usuario")
public class EstadoUsuarioController {
    
    @Autowired
    private EstadoUsuarioService estadoUsuarioService;

    @GetMapping
    public ResponseEntity<List<EstadoUsuario>> getAllEstados() {
        return ResponseEntity.ok(estadoUsuarioService.findAll());
    }

    @PostMapping
    public ResponseEntity<EstadoUsuario> createEstado(@RequestBody EstadoUsuario estadoUsuario) {
        return ResponseEntity.ok(estadoUsuarioService.save(estadoUsuario));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstadoUsuario> getEstadoById(@PathVariable Long id) {
        return estadoUsuarioService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<EstadoUsuario> updateEstado(@PathVariable Long id, @RequestBody EstadoUsuario estadoUsuario) {
        return ResponseEntity.ok(estadoUsuarioService.update(id, estadoUsuario));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEstado(@PathVariable Long id) {
        estadoUsuarioService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
