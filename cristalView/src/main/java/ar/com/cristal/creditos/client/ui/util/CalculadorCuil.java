package ar.com.cristal.creditos.client.ui.util;


public class CalculadorCuil {

	/***
	 * dado un dni y un tipo de persona (fisica -hombre o mujer- o jurídica devuele el cuil correspondiente)
	 * @param dni
	 * @param tipoPersona
	 * 
	 * XX-dni-Y
	 * 27 significa que es mujer 
	 * 20 hombre
	 * 23 puede ser ambos (se usa cuando hay otro número igual)
	 * 30 empresas
	 * @return
	 */
	public static String obtenerCuil(String dni, String tipoPersona){
		String result = "";
		String dniCalculable = dni;
		
		while (dniCalculable.length() < 8){
			dniCalculable = "0" + dniCalculable;
		}
		
		
		
		String xx = "";
		
		if (tipoPersona.equalsIgnoreCase(ConstantesView.MASCULINO)){
			xx = "20";
		} else if (tipoPersona.equalsIgnoreCase(ConstantesView.FEMENINO)){
			xx = "27";
		} else if (tipoPersona.equalsIgnoreCase(ConstantesView.AMBOS)){
			xx = "23";
		} if (tipoPersona.equalsIgnoreCase(ConstantesView.EMPRESA)){
			xx = "30";
		}
		
		result = xx + dniCalculable;
		
		String verificador = codigoVerificador(result);
		
		result = xx + "-" + dniCalculable + "-" + verificador;
		
		return result;
	}
	
	/***
	 * Dado el valor correspondiente a persona física o jurídica obtiene el dígito verificador
	 * @param xxDni
	 * 
	 * Multiplica dígito a dígito por 5 4 3 2 7 6 5 4 3 2 
	 * 
	 * 2 0 1 2 3 4 5 6 7 8 
	 * x 
	 * 5 4 3 2 7 6 5 4 3 2 
	 * ———————————————————— 
	 * 10+0+3+4+21+24+25+24+21+16= 148 
	 *
	 *
	 * 148 mod 11 = 5 ( porque 148 mod 11 = 13 * 11 + 5 ). 
	 * 11 - 5 = 6 
	 * 
	 * Si R = 0, entonces Y = 0.
	 * 
	 * Si R = 1, entonces Y = 9.
	 * 
	 *  Sino, Y = 11 – R.
	 * @return
	 */
	private static String codigoVerificador(String xxDni){
		char[] digitos = xxDni.toCharArray();
		int[] multiplicadores = new int[]{5,4,3,2,7,6,5,4,3,2};
		
		int acumulador = 0;
		
		for (int i = 0; i < 10; i++){
			int dig = Integer.parseInt(String.valueOf(digitos[i]));
			acumulador = acumulador + dig * multiplicadores[i];
		}
	
		int resto = acumulador % 11;
		
		String result = "";
		
		if (resto == 0){
			result = "0";
		} else if (resto == 1){
			result = "1";
		} else {
			result = String.valueOf(11 - resto);
		}
		
		
		return result;
	}
}
