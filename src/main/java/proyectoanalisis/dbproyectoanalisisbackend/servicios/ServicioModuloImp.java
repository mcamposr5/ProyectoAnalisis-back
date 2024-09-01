package proyectoanalisis.dbproyectoanalisisbackend.servicios;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import proyectoanalisis.dbproyectoanalisisbackend.entidades.Modulo;
import proyectoanalisis.dbproyectoanalisisbackend.repositorios.RepositorioModulo;


@Service
public class ServicioModuloImp implements ServicioModulo{

    private RepositorioModulo repositorio;

    public ServicioModuloImp(RepositorioModulo repositorio){
        this.repositorio = repositorio;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Modulo> findAll() {
    return (List<Modulo>) this.repositorio.findAll();
    }
    @Override
    @Transactional(readOnly = true)
    public Optional<Modulo> findById(String IdModulo) {
    return this.repositorio.findById(IdModulo);
    }
    @Override
    @Transactional
    public Modulo save(Modulo modulo) {
    return this.repositorio.save(modulo);
    }
    @Override
    @Transactional 
    public void deleteById(String IdModulo) {
     this.repositorio.deleteById(IdModulo);
    }

}















