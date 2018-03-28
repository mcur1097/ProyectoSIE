package vo;

public class Area{
	
	private String idArea;
	private String nombreArea;
	private String descripcion;
	private boolean editar;
	
	public Area(){
		
	}
	
	public Area(String idArea, String nombreArea, String descripcion, boolean editar){
		this.idArea=idArea;
		this.nombreArea=nombreArea;
		this.descripcion=descripcion;
		this.editar=editar;
	}
	public String getIdArea() {
		return idArea;
	}

	public void setIdArea(String idArea) {
		this.idArea = idArea;
	}

		public String getNombreArea() {
		return nombreArea;
	}

	public void setNombreArea(String nombreArea) {
		this.nombreArea = nombreArea;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public boolean isEditar() {
		return editar;
	}

	public void setEditar(boolean editar) {
		this.editar = editar;
	}
	
}
