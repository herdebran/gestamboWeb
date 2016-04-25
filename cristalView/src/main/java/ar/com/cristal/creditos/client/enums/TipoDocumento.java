package ar.com.cristal.creditos.client.enums;

public enum TipoDocumento {

	DNI(1),
	LE(2),
	LC(3),
	CI(4),
	Pasaporte(5),
	CUIT(6);
	
	private final Integer value;
	
	TipoDocumento(Integer value){
		this.value = value;
	}
	
	private Integer value(){
		return value;
	}
}