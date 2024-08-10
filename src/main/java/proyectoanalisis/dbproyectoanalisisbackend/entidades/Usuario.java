package proyectoanalisis.dbproyectoanalisisbackend.entidades;

import java.time.LocalDate;
import java.time.LocalDateTime;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.persistence.*;

@Entity // definimos la clase del tipo entidad
@Table(name = "usuario") // definimos la clase como el tipo tabla enlazado a la tabla usuario
public class Usuario {

    @Id // Definimos el IdUsuario como un identificador único
    //@GeneratedValue(strategy = GenerationType.IDENTITY) // Definimos el ID como una estrategia autoincremental, no aplica ya que por el lado de la base de datos este campo esta como varchar
    private String idUsuario;

    private String nombre;

    private String apellido;

    private LocalDate fechaNacimiento; // Para DATE

    private Long idStatusUsuario;

    private String password;

    private Long idGenero;

    private LocalDateTime ultimaFechaIngreso; // Para DATETIME

    private Long intentosDeAcceso;

    private String sesionActual;

    private LocalDateTime ultimaFechaCambioPassword; // Para DATETIME

    private String correoElectronico;

    private Long requiereCambiarPassword;

    @Lob // Indica que el tipo de dato a utilizar es muy grande
    @Column(name = "fotografia", columnDefinition = "MEDIUMBLOB")    //Especifica que a nivel de la base de datos la columna fotografia es del tipo Medium
    private byte[] fotografia;

    private Long telefonoMovil;

    private Long idSucursal;

    private LocalDateTime fechaCreacion; // Para DATETIME

    private String usuarioCreacion;

    private LocalDateTime fechaModificacion; // Para DATETIME

    private String usuarioModificacion;

    // Getters y setters
    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Long getIdStatusUsuario() {
        return idStatusUsuario;
    }

    public void setIdStatusUsuario(Long idStatusUsuario) {
        this.idStatusUsuario = idStatusUsuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getIdGenero() {
        return idGenero;
    }

    public void setIdGenero(Long idGenero) {
        this.idGenero = idGenero;
    }

    public LocalDateTime getUltimaFechaIngreso() {
        return ultimaFechaIngreso;
    }

    public void setUltimaFechaIngreso(LocalDateTime ultimaFechaIngreso) {
        this.ultimaFechaIngreso = ultimaFechaIngreso;
    }

    public Long getIntentosDeAcceso() {
        return intentosDeAcceso;
    }

    public void setIntentosDeAcceso(Long intentosDeAcceso) {
        this.intentosDeAcceso = intentosDeAcceso;
    }

    public String getSesionActual() {
        return sesionActual;
    }

    public void setSesionActual(String sesionActual) {
        this.sesionActual = sesionActual;
    }

    public LocalDateTime getUltimaFechaCambioPassword() {
        return ultimaFechaCambioPassword;
    }

    public void setUltimaFechaCambioPassword(LocalDateTime ultimaFechaCambioPassword) {
        this.ultimaFechaCambioPassword = ultimaFechaCambioPassword;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public Long getRequiereCambiarPassword() {
        return requiereCambiarPassword;
    }

    public void setRequiereCambiarPassword(Long requiereCambiarPassword) {
        this.requiereCambiarPassword = requiereCambiarPassword;
    }

    public byte[] getFotografia() {
        return fotografia;
    }

    public void setFotografia(byte[] fotografia) {
        this.fotografia = fotografia;
    }

    public Long getTelefonoMovil() {
        return telefonoMovil;
    }

    public void setTelefonoMovil(Long telefonoMovil) {
        this.telefonoMovil = telefonoMovil;
    }

    public Long getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(Long idSucursal) {
        this.idSucursal = idSucursal;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getUsuarioCreacion() {
        return usuarioCreacion;
    }

    public void setUsuarioCreacion(String usuarioCreacion) {
        this.usuarioCreacion = usuarioCreacion;
    }

    public LocalDateTime getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(LocalDateTime fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public String getUsuarioModificacion() {
        return usuarioModificacion;
    }

    public void setUsuarioModificacion(String usuarioModificacion) {
        this.usuarioModificacion = usuarioModificacion;
    }
}