package ar.com.cristal.creditos.entity.login;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import ar.com.cristal.creditos.entity.tambo.Vaca;

@Entity
@Table
public class Establecimiento {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) 
	private Long id;
	
	public String getCuidad() {
		return cuidad;
	}

	public void setCuidad(String cuidad) {
		this.cuidad = cuidad;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	@Column
	private String nombre;

	@Column 
	private String cuil;
	
	@Column
	private String domicilio;
	
	@Column
	private String cuidad;
	
	@Column
	private String provincia;
	
	@ManyToOne(optional=false)
	@JoinColumn	
	private Usuario usuario;
	
	@OneToMany(mappedBy="establecimiento")
	@JoinColumn(name="establecimiento_id")
	private List<Vaca> vacas;


	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCuil() {
		return cuil;
	}

	public void setCuil(String cuil) {
		this.cuil = cuil;
	}


	
	public Establecimiento(){
		super();
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public List<Vaca> getVacas() {
		return vacas;
	}

	public void setVacas(List<Vaca> vacas) {
		this.vacas = vacas;
	}
	
	

}
