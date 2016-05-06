package ar.com.cristal.creditos.entity.tambo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class ResultadoTacto {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) 
	private Long id;
	@Column (unique=true, nullable=false)
	private String resultado;
	@Column
	private Boolean problema;
	@Column
	private Boolean interrumpePreniez;
	@Column
	private Boolean reiniciaCiclo;
	@Column
	private Boolean analizable;
	

	public ResultadoTacto(){
		super();
	}


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

	

}


