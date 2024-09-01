package proyectoanalisis.dbproyectoanalisisbackend.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import proyectoanalisis.dbproyectoanalisisbackend.entidades.Sucursal;
import proyectoanalisis.dbproyectoanalisisbackend.repositorios.RepositorioSucursal;

@Service
public class ServicioSucursalImp implements ServicioSucursal {

        private RepositorioSucursal repositorio;
    
    public ServicioSucursalImp(RepositorioSucursal repositorio){
        this.repositorio = repositorio;
    }

    @Override
    @Transactional(readOnly = true)// los metodos son transaccionales por ello se utiliza esta anotacion, se define como tipo readOnly = true ya que es solo para consulta
    public List<Sucursal> findAll() {
        return (List<Sucursal>) this.repositorio.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Sucursal> findByNombre(String Nombre) {
        return this.repositorio.findByNombre(Nombre);
    }

    @Override
    @Transactional
    public Sucursal save(Sucursal sucursal) {
        return this.repositorio.save(sucursal);
    }

    @Override
    @Transactional // En este caso no se define como readOnly ya que si estamos modificando los datos y se define como void ya que no retornamos nada
    public void deleteById(Integer IdSucursal) {
         this.repositorio.deleteById(IdSucursal);
    }
}
