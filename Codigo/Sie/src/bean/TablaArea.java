package bean;
import java.util.ArrayList;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import vo.Area;
import dao.AreaDao;
@ManagedBean
@SessionScoped
public class TablaArea {
	
	private ArrayList<Area> listaArea=new ArrayList<>();
	private Area miArea;
	AreaDao miAreaDao;
	private boolean muestraInfo;
	private String msjDB;
	
	public TablaArea(){
		miArea=new Area();
		miAreaDao=new AreaDao();

		cargarArea();
	}
	
	public void cargarArea(){
		listaArea.clear();
		listaArea=miAreaDao.obtenerListaArea();
		if(listaArea==null){
			setMsjDB("No se pudo conectar, verifique que la base de datos se encuentre iniciada");
		}
	}
		
	public ArrayList<Area> getListaArea(){
		return listaArea;
	}

	//Aqui se cambió el tipo de metodo para que retornara la navegacion a la misma pagina
	public String agregarArea(){
		setMsjDB(miAreaDao.agregarArea(miArea));
		miArea=new Area();
		cargarArea();
		
		//return "area";
		  return "area?faces-redirect=true";//Esto hace que se haga una redireccion a la misma pagina para que no realice la ultima acción del boton
		  //en el boton se cambia el actionListener por un action 
		}
	
	public void eliminarArea(Area miArea){
		setMsjDB(miAreaDao.eliminarArea(miArea));
		listaArea.remove(miArea);
	}
	
	public String editarArea(Area miArea){
		System.out.println("entro a editar area-------------------------------------------------");
		msjDB="ingresa";
		miArea.setEditar(true);
		return "areas";
	}
	
	public void guardarArea(Area miArea){
		System.out.println("Entro a guardar area --------------------------------------------------");
		setMsjDB(miAreaDao.editarArea(miArea));
		miArea.setEditar(false);
		}
	
	public Area getMiArea(){
		return miArea;
	}
	
	public void setMiArea(Area miArea){
		this.miArea=miArea;
	}
	
	public String getMsjDB(){
		return msjDB;
	}
	
	public void setMsjDB(String msjDB){
		this.msjDB=msjDB;
	}
	
	public boolean getMuestraInfo(){
		return muestraInfo;
	}
	
	public void setMuestraInfo(boolean muestraInfo){
		this.muestraInfo=muestraInfo;
	}
	
}
