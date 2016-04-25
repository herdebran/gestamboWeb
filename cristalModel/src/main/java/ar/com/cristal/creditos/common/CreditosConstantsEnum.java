/**
 * 
 */
package ar.com.cristal.creditos.common;

/**
 * @author daniel.madera
 *
 */
public enum CreditosConstantsEnum {
	INDICE_CUOTA(1.5), UMBRAL_CUOTA(325), UMBRAL_LEY(5);
	
	
	double valor;
	
	
	public double getValor() {
		return valor;
	}


	CreditosConstantsEnum(double value){
		valor = value;
	}
	
	
	
}