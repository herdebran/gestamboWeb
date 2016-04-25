package ar.com.cristal.creditos.client.localidad;

import ar.com.cristal.creditos.client.dto.ClienteDTO;
import ar.com.cristal.creditos.client.dto.DTO;
import ar.com.snoop.gwt.commons.client.dto.ListBoxItem;

@SuppressWarnings("serial")
public class LocalidadDTO extends DTO implements ListBoxItem{

	private Long id;
	
	private Integer codigo;
	
	private String nombre;
	
	private ClienteDTO cliente;
	
	private ProvinciaDTO provincia;

	public String getItemText() {
		return nombre;
	}

	public String getItemValue() {
		return id.toString();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ClienteDTO getCliente() {
		return cliente;
	}

	public void setCliente(ClienteDTO cliente) {
		this.cliente = cliente;
	}

	public ProvinciaDTO getProvincia() {
		return provincia;
	}

	public void setProvincia(ProvinciaDTO provincia) {
		this.provincia = provincia;
	}

}
