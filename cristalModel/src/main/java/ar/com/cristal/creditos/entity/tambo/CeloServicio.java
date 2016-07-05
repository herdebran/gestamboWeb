package ar.com.cristal.creditos.entity.tambo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import ar.com.cristal.creditos.common.TipoCeloServicioEnum;
import ar.com.cristal.creditos.common.ToroProbadoAventuraEnum;
import ar.com.cristal.creditos.entity.login.Establecimiento;

@Entity
@Table
public class CeloServicio {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) 
	private Long id;
	@Column
	private Date fecha;
	@Enumerated(EnumType.STRING)
	private TipoCeloServicioEnum tipo;
	@Column
	private int nroCeloServicio;
	@Column
	private int lactancia;
	@ManyToOne
	private Vaca vaca;	
	@ManyToOne
	private Toro toro;	
	@ManyToOne
	private TipoServicio tipoServicio;	
	@ManyToOne
	private Inseminador inseminador;	
	@Column(length=50)
	private String observaciones;
	@Column
	private Boolean eliminado=false;
	@Column
	private Date fechaAlta;
	@Column
	private Long usuarioAlta;
	

	public CeloServicio(){
		super();
	}




	
	
}


