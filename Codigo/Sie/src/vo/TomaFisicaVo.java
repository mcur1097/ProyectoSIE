package vo;

public class TomaFisicaVo {
	
    private String placa;
    private String serialB;
    private String nombre;
    private String modelo;
    private String marca;
    private String valor;
    private String descripcion;
    private String fechaIngreso;
    private String tipo;
    private String idArea;
    private String areaAsignada;
    private String areaActual;
    private String documentoUser;
    private String cuentadante;
    private String color;
       
    
	public TomaFisicaVo(String placa, String serialB, String nombre, String modelo, String marca, String valor,
			String descripcion, String fechaIngreso, String tipo, String idArea, String documentoUser,
			String cuentadante) {
		super();
		this.placa = placa;
		this.serialB = serialB;
		this.nombre = nombre;
		this.modelo = modelo;
		this.marca = marca;
		this.valor = valor;
		this.descripcion = descripcion;
		this.fechaIngreso = fechaIngreso;
		this.tipo = tipo;
		this.idArea = idArea;
		this.documentoUser = documentoUser;
		this.cuentadante = cuentadante;
	}
	
	public TomaFisicaVo(){
		
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
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
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
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getFechaIngreso() {
		return fechaIngreso;
	}
	public void setFechaIngreso(String fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getIdArea() {
		return idArea;
	}
	public void setIdArea(String idArea) {
		this.idArea = idArea;
	}
	public String getDocumentoUser() {
		return documentoUser;
	}
	public void setDocumentoUser(String documentoUser) {
		this.documentoUser = documentoUser;
	}
	public String getCuentadante() {
		return cuentadante;
	}
	public void setCuentadante(String cuentadante) {
		this.cuentadante = cuentadante;
	}

	public String getAreaAsignada() {
		return areaAsignada;
	}

	public void setAreaAsignada(String areaAsignada) {
		this.areaAsignada = areaAsignada;
	}

	public String getAreaActual() {
		return areaActual;
	}

	public void setAreaActual(String areaActual) {
		this.areaActual = areaActual;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

}
