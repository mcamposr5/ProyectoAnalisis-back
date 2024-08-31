package Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.seguridad.model.UsuarioPregunta;

import java.util.List;

@Repository
public interface UsuarioPreguntaRepository extends JpaRepository<UsuarioPregunta, Long> {
    List<UsuarioPregunta> findByUsuarioId(Long usuarioId);
}
