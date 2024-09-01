package proyectoanalisis.dbproyectoanalisisbackend.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import proyectoanalisis.dbproyectoanalisisbackend.entidades.Menu;
import proyectoanalisis.dbproyectoanalisisbackend.repositorios.RepositorioMenu;


@Service
public class ServicioMenuImp implements ServicioMenu{

    private RepositorioMenu repositorio;

    public ServicioMenuImp(RepositorioMenu repositorio){
        this.repositorio = repositorio;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Menu> findAll() {
    return (List<Menu>) this.repositorio.findAll();
    }
    @Override
    @Transactional(readOnly = true)
    public Optional<Menu> findById(String IdMenu) {
    return this.repositorio.findById(IdMenu);
    }
    @Override
    @Transactional
    public Menu save(Menu menu) {
    return this.repositorio.save(menu);
    }
    @Override
    @Transactional // En este caso no se define como readOnly ya qu
    public void deleteById(String IdMenu) {
     this.repositorio.deleteById(IdMenu);
    }

}
