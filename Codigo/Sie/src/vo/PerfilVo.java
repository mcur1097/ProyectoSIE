package vo;

public class PerfilVo {

	private String documento;
	private String nombre;
	private String correo;
	private String telefono;
	private String passw;
	private String passw2;
	private boolean editar;
	
	public PerfilVo(){ 	}
	
	public PerfilVo(String documento,String nombre, String correo, String telefono, 
			 String passw2, boolean editar, String passw) {
		super();
		this.documento=documento;
		this.nombre = nombre;
		this.correo = correo;
		this.telefono = telefono;
		this.passw = passw;
		this.passw2=passw2;
		this.editar=editar;
	}
	
	public String getDocumento() { return documento; }

	public void setDocumento(String documento) { this.documento = documento; }
	
	public boolean isEditar() { return editar;	}

	public void setEditar(boolean editar) {	this.editar = editar;}
		
	public String getNombre() { return nombre; }

	public void setNombre(String nombre) {	this.nombre = nombre;}

	public String getCorreo() {	return correo;	}

	public void setCorreo(String correo) {	this.correo = correo;	}

	public String getTelefono() {	return telefono; }

	public void setTelefono(String telefono) {	this.telefono = telefono;	}
	
	public String getPassw() { 	return passw;	}

	public void setPassw(String passw) {	this.passw = passw;	}

	public String getPassw2() { 	return passw2;	}

	public void setPassw2(String passw2) {	this.passw2 = passw2;	}

	

}
