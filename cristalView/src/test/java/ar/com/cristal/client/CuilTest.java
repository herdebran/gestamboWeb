package ar.com.cristal.client;

import junit.framework.TestCase;
import ar.com.cristal.creditos.client.ui.util.CalculadorCuil;



public class CuilTest extends TestCase {
	
	public void testObtenerCuil(){
		String cuil = "20-28068478-4";
		String cuilCalculado = CalculadorCuil.obtenerCuil("28068478", "M");
		assertEquals(cuil, cuilCalculado);
		System.out.println(cuilCalculado);
		
		
		cuil = "20-32393412-7";
		cuilCalculado = CalculadorCuil.obtenerCuil("32393412", "M");
		assertEquals(cuil, cuilCalculado);
		System.out.println(cuilCalculado);
		
		
	}
}
