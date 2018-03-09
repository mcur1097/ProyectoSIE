package bean;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import vo.Area;
import dao.AreaDao;
import vo.BienVo;
import vo.UsuarioVo;
import dao.BienDao;
import dao.UsuarioDao;
@ManagedBean
public class TablaConsulta {
	
	private ArrayList<Area> listaArea=new ArrayList<>();
	private ArrayList<UsuarioVo> listaUsuario=new ArrayList<>();
	private ArrayList<BienVo> listaBien=new ArrayList<>();
	private Area miArea;
	AreaDao miAreaDao;
	private UsuarioVo miUsuario;
	UsuarioDao miUsuarioDao;
	private BienVo miBien;
	BienDao miBienDao;
	private boolean muestraInfo;
	private String msjDB;
	
	public TablaConsulta(){
		miArea=new Area();
		miAreaDao=new AreaDao();
		miUsuario= new UsuarioVo();
		miUsuarioDao=new UsuarioDao();
		miBien=new BienVo();
		miBienDao=new BienDao();
		cargarArea();
	}
	
	public void cargarArea(){
		listaArea.clear();
		listaArea=miAreaDao.obtenerListaArea();
		if(listaArea==null){
			setMsjDB("No se pudo conectar, verifique que la base de datos se encuentre iniciada");
		}
	}
	
	public void consultarArea(){
		System.out.println("***************************Entro a consultas de area***************************************************************************");

		miArea=miAreaDao.consultarAreaIndividual(miArea.getNombreArea());
		if(miArea!=null){
			setMuestraInfo(true);
			setMsjDB("");
		}else{
			setMuestraInfo(false);
			setMsjDB("No se encuentra registrado el area");
			miArea=new Area();
		}
	}
	
	public void consultarBien(){
		System.out.println("***************************Entro a consultas de bien ***************************************************************************");

		miBien=miBienDao.consultarBienIndividual(miBien.getPlaca());
		if(miBien!=null){
			setMuestraInfo(true);
			setMsjDB("");
		}else{
			setMuestraInfo(false);
			setMsjDB("No se encuentra registrada el bien");
			miBien=new BienVo();
		}
	}
	
	public void consultarUsuario(){
		System.out.println("***************************Entro a consultas ***************************************************************************");
		miUsuario=miUsuarioDao.consultarUsuarioIndividual(miUsuario.getDocumento());
		if(miUsuario!=null){
			setMuestraInfo(true);
			setMsjDB("");
		}else{
			setMuestraInfo(false);
			setMsjDB("No se encuentra registrada la persona");
			miUsuario=new UsuarioVo();
		}
	}
		
		
	public ArrayList<Area> getListaArea(){
		return listaArea;
	}
	
	public ArrayList<UsuarioVo> getListaUsuario(){
		return listaUsuario;
	}
	
	public ArrayList<BienVo> getListaBien(){
		return listaBien;
	}
	
	public Area getMiArea(){
		return miArea;
	}
	
	public void setMiArea(Area miArea){
		this.miArea=miArea;
	}
	
	public UsuarioVo getMiUsuario() {
		return miUsuario;
	}

	public void setMiUsuario(UsuarioVo miUsuario) {
		this.miUsuario = miUsuario;
	}

	public BienVo getMiBien() {
		return miBien;
	}

	public void setMiBien(BienVo miBien) {
		this.miBien = miBien;
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
