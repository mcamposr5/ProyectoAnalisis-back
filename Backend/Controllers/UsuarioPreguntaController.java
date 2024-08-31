package Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.seguridad.model.UsuarioPregunta;
import com.example.seguridad.service.UsuarioPreguntaService;

import java.util.List;

@RestController
@RequestMapping("/api/usuario-pregunta")
public class UsuarioPreguntaController {

    @Autowired
    private UsuarioPreguntaService usuarioPreguntaService;

    @GetMapping("/{usuarioId}")
    public ResponseEntity<List<UsuarioPregunta>> getPreguntasByUsuarioId(@PathVariable Long usuarioId) {
        return ResponseEntity.ok(usuarioPreguntaService.findByUsuarioId(usuarioId));
    }

    @PostMapping
    public ResponseEntity<UsuarioPregunta> createPregunta(@RequestBody UsuarioPregunta usuarioPregunta) {
        return ResponseEntity.ok(usuarioPreguntaService.save(usuarioPregunta));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioPregunta> updatePregunta(@PathVariable Long id, @RequestBody UsuarioPregunta usuarioPregunta) {
        return ResponseEntity.ok(usuarioPreguntaService.update(id, usuarioPregunta));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePregunta(@PathVariable Long id) {
        usuarioPreguntaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
