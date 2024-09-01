package proyectoanalisis.dbproyectoanalisisbackend.entidades;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "empresa")
public class Empresa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "IdEmpresa")
	private Integer idEmpresa;
	
	@Column(name = "Nombre")
	private String nombre;
	
	@Column(name = "Direccion")
	private String direccion;
	
	@Column(name = "Nit")
	private String nit;

	@Column(name = "PasswordCantidadMayusculas")
	private Integer passwordcantidadmayusuculas;
	
	@Column(name = "PasswordCantidadMinusculas")
	private Integer passwordcantidadminusculas;
	
	@Column(name = "PasswordCantidadCaracteresEspeciales")
	private Integer passwordcantidadcaracteresespeciales;
	
	@Column(name = "PasswordCantidadCaducidadDias")
	private Integer passwordcantidadcaducidaddias;
	
	@Column(name = "PasswordLargo")
	private Integer passwordlargo;
	
	@Column(name = "PasswordIntentosAntesDeBloquear")
	private Integer passwordintentosantesdebloquear;
	
	@Column(name = "PasswordCantidadNumeros")
	private Integer passwordcantidadnumeros;
	
	@Column(name = "PasswordCantidadPreguntasValidar")
	private Integer passwordcantidadpreguntasvalidar;
	
	@Column(name = "FechaCreacion")
	private LocalDateTime fechacreacion;
	
	@Column(name = "UsuarioCreacion")
	private String usuariocreacion;
	
	@Column(name = "FechaModificacion")
	private LocalDateTime fechamodificacion;
	
	@Column(name = "UsuarioModificacion")
	private String usuariomodificacion;
	
	@OneToMany(mappedBy = "idempresa")
	private List<Sucursal> sucursalList;
	
	public Integer getIdempresa() {
		return idEmpresa;
	}

	public void setIdempresa(Integer idempresa) {
		this.idEmpresa = idempresa;
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

	public String getNit() {
		return nit;
	}

	public void setNit(String nit) {
		this.nit = nit;
	}

	public Integer getPasswordcantidadmayusuculas() {
		return passwordcantidadmayusuculas;
	}

	public void setPasswordcantidadmayusuculas(Integer passwordcantidadmayusuculas) {
		this.passwordcantidadmayusuculas = passwordcantidadmayusuculas;
	}

	public Integer getPasswordcantidadminusculas() {
		return passwordcantidadminusculas;
	}

	public void setPasswordcantidadminusculas(Integer passwordcantidadminusculas) {
		this.passwordcantidadminusculas = passwordcantidadminusculas;
	}

	public Integer getPasswordcantidadcaracteresespeciales() {
		return passwordcantidadcaracteresespeciales;
	}

	public void setPasswordcantidadcaracteresespeciales(Integer passwordcantidadcaracteresespeciales) {
		this.passwordcantidadcaracteresespeciales = passwordcantidadcaracteresespeciales;
	}

	public Integer getPasswordcantidadcaducidaddias() {
		return passwordcantidadcaducidaddias;
	}

	public void setPasswordcantidadcaducidaddias(Integer passwordcantidadcaducidaddias) {
		this.passwordcantidadcaducidaddias = passwordcantidadcaducidaddias;
	}

	public Integer getPasswordlargo() {
		return passwordlargo;
	}

	public void setPasswordlargo(Integer passwordlargo) {
		this.passwordlargo = passwordlargo;
	}

	public Integer getPasswordintentosantesdebloquear() {
		return passwordintentosantesdebloquear;
	}

	public void setPasswordintentosantesdebloquear(Integer passwordintentosantesdebloquear) {
		this.passwordintentosantesdebloquear = passwordintentosantesdebloquear;
	}

	public Integer getPasswordcantidadnumeros() {
		return passwordcantidadnumeros;
	}

	public void setPasswordcantidadnumeros(Integer passwordcantidadnumeros) {
		this.passwordcantidadnumeros = passwordcantidadnumeros;
	}

	public Integer getPasswordcantidadpreguntasvalidar() {
		return passwordcantidadpreguntasvalidar;
	}

	public void setPasswordcantidadpreguntasvalidar(Integer passwordcantidadpreguntasvalidar) {
		this.passwordcantidadpreguntasvalidar = passwordcantidadpreguntasvalidar;
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

	public List<Sucursal> getSucursalList() {
		return sucursalList;
	}

	public void setSucursalList(List<Sucursal> sucursalList) {
		this.sucursalList = sucursalList;
	}
    
}
