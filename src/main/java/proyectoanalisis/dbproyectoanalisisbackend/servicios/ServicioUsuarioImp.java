package proyectoanalisis.dbproyectoanalisisbackend.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import proyectoanalisis.dbproyectoanalisisbackend.entidades.Usuario;
import proyectoanalisis.dbproyectoanalisisbackend.repositorios.RepositorioUsuario;

@Service //Esta anotacion la utilizamos para indicar que es una clase service, definimos la lógica de negocio
public class ServicioUsuarioImp implements ServicioUsuario{

    private final RepositorioUsuario repositorio;
    
    public ServicioUsuarioImp(RepositorioUsuario repositorio){
        this.repositorio = repositorio;
    }

    @Override
    @Transactional(readOnly = true)// los metodos son transaccionales por ello se utiliza esta anotacion, se define como tipo readOnly = true ya que es solo para consulta
    public List<Usuario> findAll() {
        return (List<Usuario>) this.repositorio.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Usuario> findById(String IdUsuario) {
        return this.repositorio.findById(IdUsuario);
    }

    @Override
    @Transactional
    public Usuario save(Usuario usuario) {
        return this.repositorio.save(usuario);
    }

    @Override
    @Transactional // En este caso no se define como readOnly ya que si estamos modificando los datos y se define como void ya que no retornamos nada
    public void deleteById(String IdUsuario) {
         this.repositorio.deleteById(IdUsuario);
    }

}
