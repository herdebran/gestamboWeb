package ar.com.cristal.creditos.entity.creditos;

/**
 * representa una consulta de línea de crédito lanzada por un usuario en la
 * pantalla de calculo y emisión de créditos.
 * 
 * @author lucas.napoli
 * 
 */

public class ConsultaLineaCredito {

	private int id;
	private int edad;
	private float extracción; 			//monto líquido disponible del cliente por mes
	private int score;					//score o puntaje Veraz
	private int bcra; 					// 1: situación bcra mala		2: situación bcra regular		3: situación bcra buena
	private float sueldo;
	private int antiguedadLaboral;
	private double cbu;
	private byte dni;
	private String cuil;
	private String nombre;
	private String apellido;
	private int tipoEmpleo; 			// 1: empleado público 2: empleado sector privado
	private int cantCreditos; 			// antigüedad en la cooperativa ó cuantos creditos ha sacado el cliente
	private int empresa;				//id de empresa
	private int comercializador;		//id del comercializador del crédito

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public float getExtracción() {
		return extracción;
	}

	public void setExtracción(float extracción) {
		this.extracción = extracción;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getEmpresa() {
		return empresa;
	}

	public void setEmpresa(int empresa) {
		this.empresa = empresa;
	}

	public int getComercializador() {
		return comercializador;
	}

	public void setComercializador(int comercializador) {
		this.comercializador = comercializador;
	}

	public void setBcra(int bcra) {
		this.bcra = bcra;
	}
	
	public int getBcra(){
		return bcra;
	}

	public int getCantCreditos() {
		return cantCreditos;
	}

	public void setCantCreditos(int cantCreditos) {
		this.cantCreditos = cantCreditos;
	}

	public int getTipoEmpleo() {
		return tipoEmpleo;
	}

	public void setTipoEmpleo(int tipoEmpleo) {
		this.tipoEmpleo = tipoEmpleo;
	}

	public float getSueldo() {
		return sueldo;
	}

	public void setSueldo(float sueldo) {
		this.sueldo = sueldo;
	}

	public int getAntiguedadLaboral() {
		return antiguedadLaboral;
	}

	public void setAntiguedadLaboral(int antiguedadLaboral) {
		this.antiguedadLaboral = antiguedadLaboral;
	}

	public double getCbu() {
		return cbu;
	}

	public void setCbu(double cbu) {
		this.cbu = cbu;
	}

	public byte getDni() {
		return dni;
	}

	public void setDni(byte dni) {
		this.dni = dni;
	}

	public String getCuil() {
		return cuil;
	}

	public void setCuil(String cuil) {
		this.cuil = cuil;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

}
