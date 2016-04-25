package ar.com.cristal.creditos.entity.commons;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Empresa {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) 
	private Long id;
	
	@Column
	private String nombre;

	@Column 
	private String cuil;
	
	@Column
	private String domicilio;
	
	
	@Column
	private boolean cobraCuotaSocial = false;
	
	@Column
	private Double participacionDirecta;
	
	@Column
	private Double participacionIndirecta;
	
	@Column(nullable=true)
	private Boolean permiteRapipago = false;
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCuil() {
		return cuil;
	}

	public void setCuil(String cuil) {
		this.cuil = cuil;
	}


	
	public Empresa(){
		super();
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public boolean getCobraCuotaSocial() {
		return cobraCuotaSocial;
	}

	public void setCobraCuotaSocial(boolean cobraCuotaSocial) {
		this.cobraCuotaSocial = cobraCuotaSocial;
	}

	/***
	 * Venta desde la sucursal
	 * @return
	 */
	public Double getParticipacionDirecta() {
		return participacionDirecta;
	}

	public void setParticipacionDirecta(Double participacionDirecta) {
		this.participacionDirecta = participacionDirecta;
	}

	/***
	 * Venta realizada por un comercializador u otro punto externo a las sucursales
	 * @return
	 */
	public Double getParticipacionIndirecta() {
		return participacionIndirecta;
	}

	public void setParticipacionIndirecta(Double participacionIndirecta) {
		this.participacionIndirecta = participacionIndirecta;
	}
	
	
	public Boolean getPermiteRapipago() {
		if (permiteRapipago == null) permiteRapipago = false;
		return permiteRapipago;
	}

	public void setPermiteRapipago(Boolean permiteRapipago) {
		if (permiteRapipago == null) permiteRapipago = false;
		this.permiteRapipago = permiteRapipago;
	}
}
