package ar.com.cristal.creditos.entity.tambo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Categoria {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) 
	private Long id;
	@Column
	private String categoria;
	@Column
	private Boolean eliminado=false;
	@ManyToOne
	private Raza raza;
	@Column
	private Long categoriaSiguienteId;

	public Categoria(){
		super();
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Boolean getEliminado() {
		return eliminado;
	}


	public void setEliminado(Boolean eliminado) {
		this.eliminado = eliminado;
	}


	public String getCategoria() {
		return categoria;
	}


	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}


	public Raza getRaza() {
		return raza;
	}


	public void setRaza(Raza raza) {
		this.raza = raza;
	}


	public Long getCategoriaSiguienteId() {
		return categoriaSiguienteId;
	}


	public void setCategoriaSiguienteId(Long categoriaSiguienteId) {
		this.categoriaSiguienteId = categoriaSiguienteId;
	}


}


