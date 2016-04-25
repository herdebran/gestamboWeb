package ar.com.cristal.creditos.common;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;


@Service(value="prepagoProperties")
public class CristalProperties {


	private static String token;
	private Logger log = Logger.getLogger(CristalProperties.class);	
	private Map<String,Object> properties = new HashMap<String, Object>();
	
	
	
	/** Instancia */
	private static CristalProperties instance = new CristalProperties();

    /** Propiedades */
    private Properties props;
	
    /**
     * @return Retorna la instancia.
     */
    public static CristalProperties getInstance() {
        return instance;
    }

    /**
     * Constructor.
     * 
     */
    public CristalProperties() {
        this.props = new Properties();

        try {
        	InputStream is = this.getClass().getClassLoader().getResourceAsStream("ar/com/cristal/creditos/cristal.properties");
        	
            props.load(is);
            token = props.getProperty("token");
            log.debug("token" + token);
            
        } catch (Exception e) {
        	log.error(e,e);
        	throw new RuntimeException("Error loading cristal.properties file",e);
        }
    }
    
    
    public String getValue(String key) throws Exception{
        if (props == null) {
            throw new RuntimeException("Error loading cristal.properties file");
        }
        
        String prop = "";
        if (!properties.containsKey(key)){
        	log.debug("Se consulta al archivo .properties para obtener valor para clave: " + key);
        	prop = this.props.getProperty(key); 
	        if (prop == null) {
	            throw new Exception("Propiedad no encontrada");
	        }
	        properties.put(key, prop);
        } else 
        	prop = properties.get(key).toString();
       
        
        return prop;
    }
    


}
