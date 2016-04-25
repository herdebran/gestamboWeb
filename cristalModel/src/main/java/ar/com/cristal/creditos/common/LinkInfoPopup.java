package ar.com.cristal.creditos.common;

/**
 * tiene la info de una linea que representa un link
 * @author Guillermo
 *
 */

public class LinkInfoPopup {

		private String utl="";
		private String textoDelLink="";
		private String urlPathSinNombreArchivo;
		
		/**
		 * El path de la url sin incluir el nombre del archivo
		 * @return
		 */
		public String getUrlPathSinNombreArchivo() {
			return urlPathSinNombreArchivo;
		}
		public void setUrlPathSinNombreArchivo(String urlPathSinNombreArchivo) {
			this.urlPathSinNombreArchivo = urlPathSinNombreArchivo;
		}
		public String getTextoDelLink() {
			return textoDelLink;
		}
		public void setTextoDelLink(String textoDelLink) {
			this.textoDelLink = textoDelLink;
		}
		/**
		 * Utl = Url donde se abre el archivo.
		 * @return
		 */
		public String getUtl() {
			return utl;
		}
		public void setUtl(String utl) {
			this.utl = utl;
		}
	}

