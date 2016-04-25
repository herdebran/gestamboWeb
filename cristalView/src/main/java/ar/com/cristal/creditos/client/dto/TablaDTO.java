package ar.com.cristal.creditos.client.dto;

import java.io.Serializable;

import ar.com.snoop.gwt.commons.client.dto.ListBoxItem;


public class TablaDTO implements Serializable, ListBoxItem{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String nombre;
	private String descripcion;
	/*
	 * en este campo va la info que se necesita extra a los 3 anteriores
	 * por ejemplo para una empresa el cuil
	 */
	private String aux_1;
	
	/*
	 * este campo identifica el dominio de valores 
	 * xej: tipo_documento, empresa o tipo_morosos
	 */
	private String tipo;
	private String codigo="";
	
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

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

	public String getAux_1() {
		return aux_1;
	}

	public void setAux_1(String aux_1) {
		this.aux_1 = aux_1;
	}

	public String getItemText() {
		
		return nombre;
	}

	public String getItemValue() {
		return id.toString();
	}



}
