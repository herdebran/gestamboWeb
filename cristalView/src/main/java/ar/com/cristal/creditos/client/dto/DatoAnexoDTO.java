package ar.com.cristal.creditos.client.dto;

import java.util.Date;

public class DatoAnexoDTO extends DTO {


	private static final long serialVersionUID = 1L;
	private Long id;
	private Long idCliente;
	private String tipoDoc;
	private String descripcion;
	private String rotulo;
	private String mimeType;
	private String filename;
	private Long usuarioId;
	private String nombreUsuario;
	private Date fechaAltaModificacion;
	private Long solicitudCreditoId;

	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getMimeType() {
		return mimeType;
	}
	public void setMimeType(String mimeType) {
		this.mimeType = mimeType;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}
	public String getTipoDoc() {
		return tipoDoc;
	}
	public void setTipoDoc(String tipoDoc) {
		this.tipoDoc = tipoDoc;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getRotulo() {
		return rotulo;
	}
	public void setRotulo(String rotulo) {
		this.rotulo = rotulo;
	}
	public Long getUsuarioId() {
		return usuarioId;
	}
	public void setUsuarioId(Long usuarioId) {
		this.usuarioId = usuarioId;
	}
	public Date getFechaAltaModificacion() {
		return fechaAltaModificacion;
	}
	public void setFechaAltaModificacion(Date fechaAltaModificacion) {
		this.fechaAltaModificacion = fechaAltaModificacion;
	}
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public Long getSolicitudCreditoId() {
		return solicitudCreditoId;
	}
	public void setSolicitudCreditoId(Long solicitudCreditoId) {
		this.solicitudCreditoId = solicitudCreditoId;
	}
	
	

}
