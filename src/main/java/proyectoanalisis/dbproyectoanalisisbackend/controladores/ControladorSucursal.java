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


import proyectoanalisis.dbproyectoanalisisbackend.entidades.Sucursal;
import proyectoanalisis.dbproyectoanalisisbackend.repositorios.RepositorioSucursal;
import proyectoanalisis.dbproyectoanalisisbackend.servicios.ServicioSucursal;

@RestController
@RequestMapping("/api/sucursales") // Ruta de primer nivel
@CrossOrigin(originPatterns = {"http://localhost:4200"})
public class ControladorSucursal {

        // Implimentando los metodos del request
    @Autowired
    private ServicioSucursal service;

    @Autowired
    private RepositorioSucursal sucursalRepository;

    @GetMapping
    public List<Sucursal> list() {
          return (List<Sucursal>) service.findAll();
    }

    @GetMapping("/{nombre}")
    public ResponseEntity<?> obtenerSucursalPorNombre(@PathVariable String nombre) {
        Optional<Sucursal> sucursalOpcional = sucursalRepository.findByNombre(nombre);
        if(sucursalOpcional.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(sucursalOpcional.orElseThrow());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                             .body(Collections.singletonMap("error", "No se encontró una sucursal con el nombre: " + nombre));
    }

    @PostMapping
    public ResponseEntity<Sucursal> crearSucursal(@RequestBody Sucursal sucursal) {
                // Asignar la fecha de creación antes de guardar la empresa
        sucursal.setFechacreacion(LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.CREATED).body(sucursalRepository.save(sucursal));
    }

    @PutMapping("/{idSucursal}")
    public ResponseEntity<Sucursal> actualizarSucursal(@PathVariable Integer idSucursal, @RequestBody Sucursal sucursal) {
        Optional<Sucursal> sucursalOpcional = sucursalRepository.findById(idSucursal);
        if(sucursalOpcional.isPresent()){
            Sucursal sucursalDB = sucursalOpcional.get();
            sucursalDB.setDireccion(sucursal.getDireccion());
            sucursalDB.setFechacreacion(sucursal.getFechacreacion());
            sucursalDB.setFechamodificacion(sucursal.getFechamodificacion());
            sucursalDB.setNombre(sucursal.getNombre());
            sucursalDB.setUsuariocreacion(sucursal.getUsuariocreacion());
            sucursalDB.setUsuariomodificacion(sucursal.getUsuariomodificacion());
            return ResponseEntity.ok(sucursalRepository.save(sucursalDB));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping("/{idSucursal}")
    public ResponseEntity<?> eliminarSucursal(@PathVariable Integer idSucursal) {
        Optional<Sucursal> sucursalOpcional = sucursalRepository.findById(idSucursal);
        if (sucursalOpcional.isPresent()) {
            sucursalRepository.deleteById(idSucursal);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
