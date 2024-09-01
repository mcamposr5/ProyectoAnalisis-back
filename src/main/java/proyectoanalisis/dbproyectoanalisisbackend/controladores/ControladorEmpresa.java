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

import proyectoanalisis.dbproyectoanalisisbackend.entidades.Empresa;
import proyectoanalisis.dbproyectoanalisisbackend.repositorios.RepositorioEmpresa;
import proyectoanalisis.dbproyectoanalisisbackend.servicios.ServicioEmpresa;

/*El controlador es el encargado de atender los request o peticiones del usuario
se comunica con la base de datos
*/
@CrossOrigin(originPatterns = {"http://localhost:4200"})
@RestController
@RequestMapping("/api/empresas") // Definiendo la ruta de primer nivel
public class ControladorEmpresa {
    // Implimentando los metodos del request
    @Autowired
    private ServicioEmpresa service;

     @Autowired
    private RepositorioEmpresa empresaRepository;

    @GetMapping
    public List<Empresa> list() {
          return (List<Empresa>) service.findAll();
    }

    @GetMapping("/{nombre}")
    public ResponseEntity<?> EmpresaNombre(@PathVariable String nombre) {
        Optional<Empresa> empresaOpcional = empresaRepository.findByNombre(nombre);
        if (empresaOpcional.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(empresaOpcional.orElseThrow());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.singletonMap("error", "No se encontró registro de empresa con el Nombre: " + nombre));
    }

    @PostMapping
    public ResponseEntity<Empresa> CrearEmpresa(@RequestBody Empresa empresa) {
        // Asignar la fecha de creación antes de guardar la empresa
        empresa.setFechacreacion(LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.CREATED).body(empresaRepository.save(empresa));
    }

    @PutMapping("/{idempresa}")
    public ResponseEntity<Empresa> ActualizarEmpresa(@PathVariable Integer idempresa, @RequestBody Empresa empresa) {
        Optional<Empresa> empresaOpcional = empresaRepository.findById(idempresa);
        if (empresaOpcional.isPresent()) {
            Empresa empresaDB = empresaOpcional.get();
            empresaDB.setNombre(empresa.getNombre());
            empresaDB.setDireccion(empresa.getDireccion());
            empresaDB.setNit(empresa.getNit());
            empresaDB.setUsuariocreacion(empresa.getUsuariocreacion());
            empresaDB.setFechacreacion(empresa.getFechacreacion()); // Actualizar la fecha de creación (puede ser cambiado según necesidad)
            return ResponseEntity.ok(empresaRepository.save(empresaDB));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping("/{idempresa}")
    public ResponseEntity<?> eliminarEmpresa(@PathVariable Integer idempresa) {
        Optional<Empresa> empresaOpcional = empresaRepository.findById(idempresa);
        if (empresaOpcional.isPresent()) {
            empresaRepository.deleteById(idempresa);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
