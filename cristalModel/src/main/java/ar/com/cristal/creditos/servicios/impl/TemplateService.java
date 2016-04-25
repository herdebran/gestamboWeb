package ar.com.cristal.creditos.servicios.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import ar.com.cristal.creditos.documentos.util.Template;

@Service("templateService")
public class TemplateService {

	private Logger log = Logger.getLogger(TemplateService.class);	
	
	public List<Template> obtenerTemplates(){
		
		log.debug("Generando templates de ejemplo");
		List<Template> templates = new ArrayList<Template>();
		
		Template tempCristal;
		Template tempLaLuisina;
		
		tempCristal = new Template(null, "ReciboCristal.odt","ReciboSalidaCristal", "Recibo Cristal");
		tempCristal.setId(1L);
		templates.add(tempCristal);
		
		tempLaLuisina = new Template(null, "ReciboLaLuisina.odt","ReciboSalidaLaLuisina", "Recibo La Lucila");
		tempLaLuisina.setId(2L);
		templates.add(tempLaLuisina);
		return templates;
		
	}
	
	
	
	
}
