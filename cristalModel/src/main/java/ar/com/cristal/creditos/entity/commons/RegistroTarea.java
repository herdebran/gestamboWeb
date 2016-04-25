package ar.com.cristal.creditos.entity.commons;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/***
 * Mantiene registro de las tareas (jobs) ejecutados. De esta forma se podrá determinar si una tarea <br/>
 * se ejecutó en forma completa o incluso si intentó ejecutarse.
 * 
 * Por ejemplo para el caso de la creación de las cuotas sociales, que en caso de caer el día 21 domingo, o <br/>
 * en caso de que se encuentre el servidor apagado no se crearán dichas cuotas.
 * 
 * @author daniel.madera
 *
 */
@Entity
@Table
public class RegistroTarea {

	///Acciones necesarias: Crear Cuota Social, Marcar Morosidad Cliente, Actualizar Cuotas Vencidas
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) 
	private Long id;
	
	@Column
	private String accion;
	
	@Column
	private Date fechaInicio;
	
	@Column
	private Date fechaFin;
	
	@Column
	private Boolean procesado;
	
	@Column(length=300)
	private String observacion;
		
	@Column
	private Long usuarioId;
	
	


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}

	public String getAccion() {
		return accion;
	}


	public void setAccion(String accion) {
		this.accion = accion;
	}


	public Date getFechaInicio() {
		return fechaInicio;
	}


	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}


	public Date getFechaFin() {
		return fechaFin;
	}


	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}


	public Boolean getProcesado() {
		return procesado;
	}


	public void setProcesado(Boolean procesado) {
		this.procesado = procesado;
	}


	public String getObservacion() {
		return observacion;
	}


	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}


	public Long getUsuarioId() {
		return usuarioId;
	}


	public void setUsuarioId(Long usuarioId) {
		this.usuarioId = usuarioId;
	}
	
	
 }

