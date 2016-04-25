package ar.com.cristal.creditos.util;


import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

	
	
	
	
	public class MathUtil {
		
		
		
	    //~ Static fields/initializers =============================================
		private static RoundingMode ROUNDING_MODE = RoundingMode.HALF_UP; 
		
	    private static Log log = LogFactory.getLog(MathUtil.class);
	    
	    //~ Methods ================================================================

	    /***
	     * Redondea a la cantidad de decimales dados
	     * @param valor
	     * @param decimales
	     * @return
	     */
	    public static Double redondear(Double valor, int decimales){
	    	BigDecimal value = new BigDecimal(valor);
	    	value = value.setScale(decimales, ROUNDING_MODE);
	    	return value.doubleValue();
	    }
	    
	    
	    public static Double redondearADosDecimales(Double valor){
	    	BigDecimal value = new BigDecimal(valor);
	    	value = value.setScale(2, ROUNDING_MODE);
	    	return value.doubleValue();
	    }
	    
	    
	    public static String doubleToString2Decimales(double d){
	    	DecimalFormat df = new DecimalFormat("##.00");
	    	return df.format(d);
	    }


		
	    
	    
	}
	
	

