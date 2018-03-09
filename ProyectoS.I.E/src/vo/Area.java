package vo;

public class Area{
	
	private int codigoArea;
	private String nombreArea;
	private String tipoArea;
	private boolean editar;

	public Area(){

	}

	public Area(int codigoArea, String nombreArea, String tipoArea, boolean editar){
	super();
	this.codigoArea=codigoArea;
	this.nombreArea=nombreArea;
	this.tipoArea=tipoArea;
	this.editar=editar;
	}


	public boolean isEditar(){
		return editar;
	}
	
	public void setEditar(boolean editar){
		this.editar=editar;
	}
	
	public String getNombreArea(){
		return nombreArea;
	}
	
	public void setNombreArea(String nombreArea){
		this.nombreArea=nombreArea;
	}

	public Integer getCodigoArea(){
	return codigoArea;
	}

	public void setCodigoArea(Integer codigoArea){
	this.codigoArea=codigoArea;
	}

	public String getTipoArea(){
	    return tipoArea;
	} 


	public void setTipoArea(String tipoArea){
	    this.tipoArea=tipoArea;
	}
}