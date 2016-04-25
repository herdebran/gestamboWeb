package ar.com.cristal.creditos.entity.cliente;

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

import ar.com.cristal.creditos.common.TipoDocAnexoEnum;
import ar.com.cristal.creditos.entity.creditos.Cliente;

@Entity
@Table
public class DatoAnexo {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) 
	private Long id;
	
	@Column
	private Long idCliente;
	
	@Column
	private String rotulo;
	
	@Column 
	private String descripcion;
	
	@Column 
	private String filename;
	
	@Column String mimeType;
	
	@Enumerated(EnumType.STRING)
	private TipoDocAnexoEnum tipoDocumento;
	
	@Column
	private Long usuarioId;
	
	@Column
	private Date fechaAltaModificacion;

	
	@Column
	private Long solicitudCreditoId;
	
	
	@ManyToOne
	private Cliente cliente;
	
	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(length=10000000*10*10)
	private byte[] fileContent;

	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	public byte[] getFileContent() {
		return fileContent;
	}

	public void setFileContent(byte[] fileContent) {
		this.fileContent = fileContent;
	}

	public String getRotulo() {
		return rotulo;
	}

	public void setRotulo(String rotulo) {
		this.rotulo = rotulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public TipoDocAnexoEnum getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(TipoDocAnexoEnum tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getMimeType() {
		return mimeType;
	}

	public void setMimeType(String mimeType) {
		this.mimeType = mimeType;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
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

	public Long getSolicitudCreditoId() {
		return solicitudCreditoId;
	}

	public void setSolicitudCreditoId(Long solicitudCreditoId) {
		this.solicitudCreditoId = solicitudCreditoId;
	}
	
	
}
