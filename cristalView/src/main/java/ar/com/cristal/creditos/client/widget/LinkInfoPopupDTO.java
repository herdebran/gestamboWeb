package ar.com.cristal.creditos.client.widget;

import java.io.Serializable;

/**
 * tiene la info de una linea que representa un link
 * @author Guillermo
 *
 */
public class LinkInfoPopupDTO implements Serializable{
	private String utl="";
	private String textoDelLink="";
	
	
	public String getTextoDelLink() {
		return textoDelLink;
	}
	public void setTextoDelLink(String textoDelLink) {
		this.textoDelLink = textoDelLink;
	}
	public String getUtl() {
		return utl;
	}
	public void setUtl(String utl) {
		this.utl = utl;
	}
	
	
	public Double valor;


	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	

}
