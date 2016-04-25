package ar.com.cristal.creditos.documentos;

import java.util.Calendar;

import ar.com.cristal.creditos.util.DateUtil;

public class Documento {

	private String dia;
	private String titulo;
	private String tipoDocumento;
	
	public String getTitulo() {
		return titulo;
	}
	public String getClausula() {
		return clausula;
	}
	private String clausula;
	
	
	public Documento(){
		super();
	}
	
	public Documento(String titulo, String clausula) {
		super();
		this.titulo = titulo;
		this.clausula = clausula;
		dia = DateUtil.getString(Calendar.getInstance().getTime());
	}
	
	public String getDia() {
		
		return dia;
	}
	public String getTipoDcocumento() {
		return tipoDocumento;
	}
	public void setTipoDcocumento(String tipoDcocumento) {
		this.tipoDocumento = tipoDcocumento;
	}

	
}
