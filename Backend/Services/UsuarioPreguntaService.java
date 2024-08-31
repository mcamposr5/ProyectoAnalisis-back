package Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.seguridad.model.UsuarioPregunta;
import com.example.seguridad.repository.UsuarioPreguntaRepository;

import java.util.List;

@Service
public class UsuarioPreguntaService {
    
    @Autowired
    private UsuarioPreguntaRepository usuarioPreguntaRepository;

    public UsuarioPregunta save(UsuarioPregunta usuarioPregunta) {
        return usuarioPreguntaRepository.save(usuarioPregunta);
    }

    public List<UsuarioPregunta> findByUsuarioId(Long usuarioId) {
        return usuarioPreguntaRepository.findByUsuarioId(usuarioId);
    }

    public void deleteById(Long id) {
        usuarioPreguntaRepository.deleteById(id);
    }

    public UsuarioPregunta update(Long id, UsuarioPregunta usuarioPregunta) {
        if (usuarioPreguntaRepository.existsById(id)) {
            usuarioPregunta.setId(id);
            return usuarioPreguntaRepository.save(usuarioPregunta);
        } else {
            throw new RuntimeException("UsuarioPregunta no encontrado");
        }
    }
}
