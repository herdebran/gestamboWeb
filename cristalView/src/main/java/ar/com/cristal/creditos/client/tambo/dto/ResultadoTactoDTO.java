package ar.com.cristal.creditos.client.tambo.dto;

import ar.com.cristal.creditos.client.dto.DTO;
import ar.com.snoop.gwt.commons.client.dto.ListBoxItem;


@SuppressWarnings("serial")
public class ResultadoTactoDTO  extends DTO implements ListBoxItem{
	private Long id;
	private String resultado;
	private Boolean problema;
	private Boolean interrumpePreniez;
	private Boolean reiniciaCiclo;
	private Boolean analizable;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
	public String getResultado() {
		return resultado;
	}
	public void setResultado(String resultado) {
		this.resultado = resultado;
	}
	public Boolean getProblema() {
		return problema;
	}
	public void setProblema(Boolean problema) {
		this.problema = problema;
	}
	public Boolean getInterrumpePreniez() {
		return interrumpePreniez;
	}
	public void setInterrumpePreniez(Boolean interrumpePreniez) {
		this.interrumpePreniez = interrumpePreniez;
	}
	public Boolean getReiniciaCiclo() {
		return reiniciaCiclo;
	}
	public void setReiniciaCiclo(Boolean reiniciaCiclo) {
		this.reiniciaCiclo = reiniciaCiclo;
	}
	public Boolean getAnalizable() {
		return analizable;
	}
	public void setAnalizable(Boolean analizable) {
		this.analizable = analizable;
	}
	@Override
	public String getItemText() {
		return this.resultado;
	}
	@Override
	public String getItemValue() {
		return this.id.toString();
	}
	
	

}
