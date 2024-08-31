package Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.seguridad.model.EstadoUsuario;
import com.example.seguridad.repository.EstadoUsuarioRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EstadoUsuarioService {
    
    @Autowired
    private EstadoUsuarioRepository estadoUsuarioRepository;

    public EstadoUsuario save(EstadoUsuario estadoUsuario) {
        return estadoUsuarioRepository.save(estadoUsuario);
    }

    public List<EstadoUsuario> findAll() {
        return estadoUsuarioRepository.findAll();
    }

    public Optional<EstadoUsuario> findById(Long id) {
        return estadoUsuarioRepository.findById(id);
    }

    public void deleteById(Long id) {
        estadoUsuarioRepository.deleteById(id);
    }

    public EstadoUsuario update(Long id, EstadoUsuario estadoUsuario) {
        if (estadoUsuarioRepository.existsById(id)) {
            estadoUsuario.setId(id);
            return estadoUsuarioRepository.save(estadoUsuario);
        } else {
            throw new RuntimeException("EstadoUsuario no encontrado");
        }
    }
}
