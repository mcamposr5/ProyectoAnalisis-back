package proyectoanalisis.dbproyectoanalisisbackend.entidades;

import java.time.LocalDateTime;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "sucursal")
public class Sucursal {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "IdSucursal")
	private Integer idsucursal;
	
	@Column(name = "Nombre")
	private String nombre;
	
	@Column(name = "Direccion")
	private String direccion;
	
	@Column(name = "IdEmpresa")
	private Integer idempresa;
	
	@Column(name = "FechaCreacion")
	private LocalDateTime fechacreacion;
	
	@Column(name = "UsuarioCreacion")
	private String usuariocreacion;
	
	@Column(name = "FechaModificacion")
	private LocalDateTime fechamodificacion;
	
	@Column(name = "UsuarioModificacion")
	private String usuariomodificacion;
	
	public Integer getIdsucursal() {
		return idsucursal;
	}

	public void setIdsucursal(Integer idsucursal) {
		this.idsucursal = idsucursal;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Integer getIdempresa() {
		return idempresa;
	}

	public void setIdempresa(Integer idempresa) {
		this.idempresa = idempresa;
	}

	public LocalDateTime getFechacreacion() {
		return fechacreacion;
	}

	public void setFechacreacion(LocalDateTime fechacreacion) {
		this.fechacreacion = fechacreacion;
	}

	public String getUsuariocreacion() {
		return usuariocreacion;
	}

	public void setUsuariocreacion(String usuariocreacion) {
		this.usuariocreacion = usuariocreacion;
	}

	public LocalDateTime getFechamodificacion() {
		return fechamodificacion;
	}

	public void setFechamodificacion(LocalDateTime fechamodificacion) {
		this.fechamodificacion = fechamodificacion;
	}

	public String getUsuariomodificacion() {
		return usuariomodificacion;
	}

	public void setUsuariomodificacion(String usuariomodificacion) {
		this.usuariomodificacion = usuariomodificacion;
	}
}
