package Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.seguridad.model.EstadoUsuario;

@Repository
public interface EstadoUsuarioRepository extends JpaRepository<EstadoUsuario, Long> {
}
