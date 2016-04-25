package ar.com.cristal;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;

import ar.com.cristal.creditos.common.CristalProperties;

@ContextConfiguration(locations={"/ar/com/cristal/creditos/cristalModel-application-context-test.xml"})
public class PropertiesTest {
	
	
	CristalProperties cristalProperties;
	

	@Test
	public void testProperties(){
		
		
		 try {
			 cristalProperties = CristalProperties.getInstance();
			 
			System.out.println(cristalProperties.getValue("TIPO_EMPLEO").toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		 
		 
		 Assert.assertTrue(true);

	}
	
}
