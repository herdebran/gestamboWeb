package ar.com.cristal.creditos.client.enums;

public enum EstadoTransaccion {

	Pendiente_de_Carga(1),
	Pendiente_de_Aprobacion(2),
	Pendiente_de_Ejecucion(3),
	Pendiente_de_Cancelacion(4),
	Ejecucion_Confirmada(5),
	Error_de_Ejecucion(6),
	Terminada(7),
	Rechazada(8),
	Cancelada(9);
	
	private final Integer value;
	
	EstadoTransaccion(Integer value){
		this.value = value;
	}
	
	public Integer value(){
		return value;
	}
}