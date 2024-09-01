package proyectoanalisis.dbproyectoanalisisbackend.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import proyectoanalisis.dbproyectoanalisisbackend.entidades.Empresa;
import proyectoanalisis.dbproyectoanalisisbackend.repositorios.RepositorioEmpresa;

@Service
public class ServicioEmpresaImp implements ServicioEmpresa {
    
    private RepositorioEmpresa repositorio;
    
    public ServicioEmpresaImp(RepositorioEmpresa repositorio){
        this.repositorio = repositorio;
    }

    @Override
    @Transactional(readOnly = true)// los metodos son transaccionales por ello se utiliza esta anotacion, se define como tipo readOnly = true ya que es solo para consulta
    public List<Empresa> findAll() {
        return (List<Empresa>) this.repositorio.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Empresa> findByNombre(String Nombre) {
        return this.repositorio.findByNombre(Nombre);
    }

    @Override
    @Transactional
    public Empresa save(Empresa empresa) {
        return this.repositorio.save(empresa);
    }

    @Override
    @Transactional // En este caso no se define como readOnly ya que si estamos modificando los datos y se define como void ya que no retornamos nada
    public void deleteById(Integer IdEmpresa) {
         this.repositorio.deleteById(IdEmpresa);
    }
}
