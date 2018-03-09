package vo;

public class LoginVo {

	private String documento;
	private String nombre;
	private String Apellido;
	private int edad;
	private String passw;
	private String sexo;
	private boolean editar;
	
	public LoginVo(){ 	}
	
	public LoginVo(String documento,String nombre, String apellido, int edad, 
			 String sexo, boolean editar, String passw) {
		super();
		this.documento=documento;
		this.nombre = nombre;
		this.Apellido = apellido;
		this.edad = edad;
		this.passw = passw;
		this.sexo=sexo;
		this.editar=editar;
	}
	
	public String getDocumento() { return documento; }

	public void setDocumento(String documento) { this.documento = documento; }
	
	public boolean isEditar() { return editar;	}

	public void setEditar(boolean editar) {	this.editar = editar;}
		
	public String getNombre() { return nombre; }

	public void setNombre(String nombre) {	this.nombre = nombre;}

	public String getApellido() {	return Apellido;	}

	public void setApellido(String apellido) {	this.Apellido = apellido;	}

	public int getEdad() {	return edad; }

	public void setEdad(int edad) {	this.edad = edad;	}
	
	public String getPassw() { 	return passw;	}

	public void setPassw(String passw) {	this.passw = passw;	}

	public String getSexo() { 	return sexo;	}

	public void setSexo(String sexo) {	this.sexo = sexo;	}

	
}
