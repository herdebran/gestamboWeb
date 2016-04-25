package ar.com.cristal.creditos.client.widget;

import ar.com.cristal.creditos.client.dto.DTO;

import com.google.gwt.user.client.ui.RadioButton;

public class RadioButtonId  extends RadioButton{
	private DTO dto = null;

	public RadioButtonId(String name) {
		super(name);		
	}

	private long id;
	
	private int nroFila;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public DTO getDto() {
		return dto;
	}

	public void setDto(DTO dto) {
		this.dto = dto;
	}

	public int getNroFila() {
		return nroFila;
	}

	public void setNroFila(int nroFila) {
		this.nroFila = nroFila;
	}
	
	
	
	
}
