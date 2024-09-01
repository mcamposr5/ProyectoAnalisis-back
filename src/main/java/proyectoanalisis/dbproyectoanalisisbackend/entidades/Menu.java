package proyectoanalisis.dbproyectoanalisisbackend.entidades;


import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity 
@Table(name = "menu") 
public class Menu {

    @Id 
        
    @Column(name = "IdMenu")

    private String IdMenu;

    private String IdModulo;

    private String Nombre;

    private Integer OrdenMenu;

    private LocalDateTime FechaCreacion;

    private String UsuarioCreacion;

    private LocalDateTime FechaModificacion;

    private String UsuarioModificacion;



    public String getIdMenu() {
    return IdMenu;
    }
    public void setIdMenu(String idMenu) {
    IdMenu = idMenu;
    }


    public String getIdModulo() {
        return IdModulo;
    }
        public void setIdModulo(String idModulo) {
        IdModulo = idModulo;
    }


    public String getNombre() {
        return Nombre;
    }
        public void setNombre(String nombre) {
        Nombre = nombre;
    }
    

    public Integer getOrdenMenu() {
        return OrdenMenu;
    }
    public void setOrdenMenu(Integer ordenMenu) {
        OrdenMenu = ordenMenu;
    }


    public LocalDateTime getFechaCreacion() {
        return FechaCreacion;
    }
    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        FechaCreacion = fechaCreacion;
    }
        

    public String getUsuarioCreacion() {
        return UsuarioCreacion;
        }
        public void setUsuarioCreacion(String usuarioCreacion) {
            UsuarioCreacion = usuarioCreacion;

    }


    public LocalDateTime getFechaModificacion() {
        return FechaModificacion;
    }
    public void setFechaModificacion(LocalDateTime fechaModificacion) {
        FechaModificacion = fechaModificacion;
    }

    public String getUsuarioModificacion() {
        return UsuarioModificacion;
        }
        public void setUsuarioModificacion(String usuarioModificacion) {
            UsuarioModificacion = usuarioModificacion;
    }



}