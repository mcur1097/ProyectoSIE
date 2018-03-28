package vo;

public class NovedadVo {

	private String placa;
	private String descripcion;
	private String hora;
	private String fecha;
	private String area;
	private String correo;
	private String nombreBien;
	private String documento;
	
	public NovedadVo(){
	}
	
	public NovedadVo(String placa, String descripcion, String hora, String fecha, String correo, String nombreBien){
		super();
	  this.placa=placa;
	  this.descripcion=descripcion;
	  this.fecha=fecha;
	  this.hora=hora;
	}
	
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getNombreBien() {
		return nombreBien;
	}
	public void setNombreBien(String nombreBien) {
		this.nombreBien = nombreBien;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}	
}
