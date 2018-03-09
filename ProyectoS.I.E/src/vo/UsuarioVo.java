package vo;

public class UsuarioVo {

	private String nombre;
	private String Apellidos;
	private String documento;
	private String telefono;
	private String email;
	private boolean editar;

	public UsuarioVo() {
	}

	public UsuarioVo(String nombre, String apellidos, String documento, String telefono, String email, boolean editar) {
		super();
		this.nombre = nombre;
		Apellidos = apellidos;
		this.documento = documento;
		this.telefono = telefono;
		this.email = email;
		this.editar = editar;
	}

	public boolean isEditar() {
		return editar;
	}

	public void setEditar(boolean editar) {
		this.editar = editar;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return Apellidos;
	}

	public void setApellidos(String apellidos) {
		Apellidos = apellidos;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
