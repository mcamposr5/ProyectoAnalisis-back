package proyectoanalisis.dbproyectoanalisisbackend.servicios;

import java.util.List;
import java.util.Optional;

import proyectoanalisis.dbproyectoanalisisbackend.entidades.Sucursal;

public interface ServicioSucursal {
            // Muestra la lista de todas las Empresas
            List<Sucursal> findAll();

            // busca un usuario por medio de su IdUsuario, este dato se envía como parámetro y es del tipo String
            Optional<Sucursal> findByNombre(String Nombre);
        
            // Guarda un usuario, únicamente enviamos el usuario como objeto completo
            Sucursal save(Sucursal sucursal);
        
            // Elimina el usuario, es del tipo void ya que no estoy retornando ningun valor únicamente le envio el IdUsuario como parámetro.
            void deleteById(Integer IdSucursal);
}


