package ar.com.cristal.creditos.entity.commons;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class  Tablas {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) 
	private Long id;
	
	/***
	 * Información que puede mostrarse en un combo o label
	 * Para MOROSO_2 podría decir Moroso 2
	 */
	@Column
	private String nombre;

	@Column
	private String descripcion;
	
	
	/*
	 * MOROSO_2, PREJUDICIAL, ETC
	 */
	@Column
	private String codigo;
	
	@Column
	private String aux1;
	
	/*
	 * este campo identifica el dominio de valores 
	 * xej: tipo_documento, empresa o tipo_morosos
	 */
	@Column
	private String tipo;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getAux1() {
		return aux1;
	}

	public void setAux1(String aux1) {
		this.aux1 = aux1;
	}

}
