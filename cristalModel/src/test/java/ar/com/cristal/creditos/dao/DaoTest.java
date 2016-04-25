package ar.com.cristal.creditos.dao;

import java.util.List;

import junit.framework.Assert;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import ar.com.cristal.creditos.entity.creditos.Cliente;
@ContextConfiguration(locations={"/ar/com/cristal/creditos/cristalModel-application-context-test.xml"})
public class DaoTest extends AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
	GenericDao genericDao;
	
	
	@Test
	@Rollback(true)
	public void test() {
		
		Cliente c  = new Cliente("Johnny", "App");
		
		
		try {
			genericDao.save(c);
			
			List<Cliente> ls = genericDao.getAll(Cliente.class);
			

			Assert.assertTrue("Clientes ", !ls.isEmpty());
						
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		assert(true);
		
	}

}
