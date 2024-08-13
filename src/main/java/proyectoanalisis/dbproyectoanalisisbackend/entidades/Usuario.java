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
        @Column(name = "IdUsuario")
        private String IdUsuario;
        
        private String Nombre;

        private String Apellido;

        private LocalDate FechaNacimiento; // Para DATE

        private Integer IdStatusUsuario;

        private String Password;

        private Integer IdGenero;

        private LocalDateTime UltimaFechaIngreso; // Para DATETIME

        private Integer IntentosDeAcceso;

        private String SesionActual;

        private LocalDateTime UltimaFechaCambioPassword; // Para DATETIME

        private String CorreoElectronico;

        private Integer RequiereCambiarPassword;

        @Lob // Indica que el tipo de dato a utilizar es muy grande
        @Column(name = "Fotografia", columnDefinition = "MEDIUMBLOB")    //Especifica que a nivel de la base de datos la columna fotografia es del tipo Medium
        private byte[] Fotografia;

        private String TelefonoMovil;

        private Integer IdSucursal;

        private LocalDateTime FechaCreacion; // Para DATETIME

        private String UsuarioCreacion;

        private LocalDateTime FechaModificacion; // Para DATETIME

        private String UsuarioModificacion;

        // Getters y setters
        public String getIdUsuario() {
            return IdUsuario;
        }

        public void setIdUsuario(String idUsuario) {
            IdUsuario = idUsuario;
        }

        public String getNombre() {
            return Nombre;
        }

        public void setNombre(String nombre) {
            Nombre = nombre;
        }

        public String getApellido() {
            return Apellido;
        }

        public void setApellido(String apellido) {
            Apellido = apellido;
        }

        public LocalDate getFechaNacimiento() {
            return FechaNacimiento;
        }

        public void setFechaNacimiento(LocalDate fechaNacimiento) {
            FechaNacimiento = fechaNacimiento;
        }

        public Integer getIdStatusUsuario() {
            return IdStatusUsuario;
        }

        public void setIdStatusUsuario(Integer idStatusUsuario) {
            IdStatusUsuario = idStatusUsuario;
        }

        public String getPassword() {
            return Password;
        }

        public void setPassword(String password) {
            Password = password;
        }

        public Integer getIdGenero() {
            return IdGenero;
        }

        public void setIdGenero(Integer idGenero) {
            IdGenero = idGenero;
        }

        public LocalDateTime getUltimaFechaIngreso() {
            return UltimaFechaIngreso;
        }

        public void setUltimaFechaIngreso(LocalDateTime ultimaFechaIngreso) {
            UltimaFechaIngreso = ultimaFechaIngreso;
        }

        public Integer getIntentosDeAcceso() {
            return IntentosDeAcceso;
        }

        public void setIntentosDeAcceso(Integer intentosDeAcceso) {
            IntentosDeAcceso = intentosDeAcceso;
        }

        public String getSesionActual() {
            return SesionActual;
        }

        public void setSesionActual(String sesionActual) {
            SesionActual = sesionActual;
        }

        public LocalDateTime getUltimaFechaCambioPassword() {
            return UltimaFechaCambioPassword;
        }

        public void setUltimaFechaCambioPassword(LocalDateTime ultimaFechaCambioPassword) {
            UltimaFechaCambioPassword = ultimaFechaCambioPassword;
        }

        public String getCorreoElectronico() {
            return CorreoElectronico;
        }

        public void setCorreoElectronico(String correoElectronico) {
            CorreoElectronico = correoElectronico;
        }

        public Integer getRequiereCambiarPassword() {
            return RequiereCambiarPassword;
        }

        public void setRequiereCambiarPassword(Integer requiereCambiarPassword) {
            RequiereCambiarPassword = requiereCambiarPassword;
        }

        public byte[] getFotografia() {
            return Fotografia;
        }

        public void setFotografia(byte[] fotografia) {
            Fotografia = fotografia;
        }

        public String getTelefonoMovil() {
            return TelefonoMovil;
        }

        public void setTelefonoMovil(String telefonoMovil) {
            TelefonoMovil = telefonoMovil;
        }

        public Integer getIdSucursal() {
            return IdSucursal;
        }

        public void setIdSucursal(Integer idSucursal) {
            IdSucursal = idSucursal;
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