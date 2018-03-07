package vo;

public class BienVo {

	private String placa;
	private String serialB;
	private String nomBien;
	private String descripcion;
	private String modelo;
	private String marca;
	private String ingreso;
	private String valor;
	private String area;
	private String cuentadante;
	private boolean editar;
	
	public BienVo(){
	}
	
	public BienVo(String placa, String serialB, String nomBien, String descripcion, String modelo, String marca,
			String ingreso, String valor, String area, String cuentadante){
		super();
		this.placa=placa;
		this.serialB=serialB;
		this.nomBien=nomBien;
		this.descripcion=descripcion;
		this.modelo=modelo;
		this.marca=marca;
		this.ingreso=ingreso;
		this.valor=valor;
		this.area=area;
		this.cuentadante=cuentadante;
	}
	
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getSerialB() {
		return serialB;
	}
	public void setSerialB(String serialB) {
		this.serialB = serialB;
	}
	public String getNomBien() {
		return nomBien;
	}
	public void setNomBien(String nomBien) {
		this.nomBien = nomBien;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getIngreso() {
		return ingreso;
	}
	public void setIngreso(String ingreso) {
		this.ingreso = ingreso;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getCuentadante() {
		return cuentadante;
	}
	public void setCuentadante(String cuentadante) {
		this.cuentadante = cuentadante;
	}

	public boolean getEditar() {
		return editar;
	}

	public void setEditar(boolean editar) {
		this.editar = editar;
	}
}
