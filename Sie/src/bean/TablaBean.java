package bean;

import java.util.ArrayList;  
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import dao.BienDao;
import vo.BienVo;

@ManagedBean
@ViewScoped
public class TablaBean {
	private ArrayList<BienVo> listaBien = new ArrayList<>();
	private BienVo miBienVo;
	BienDao miBienDao;

	private String msjBD;

   public TablaBean(){
     miBienVo=new BienVo();
     miBienDao=new BienDao();
     cargarBienes();
   }

   public void cargarBienes(){
	  listaBien.clear();
	  listaBien=miBienDao.obtenerListaBienes();
	   if (listaBien==null) {
	      setMsjBD("No se pudo conectar, verifique que la Base de Datos "
	     + "se encuentre iniciada");
	      }
	 }
   
   public ArrayList<BienVo> getListaBien() {
	 return listaBien;
	 }
	   
   public String agregarBien(){
	 listaBien.add(miBienVo);
	  setMsjBD(miBienDao.agregarBien(miBienVo));
     miBienVo=new BienVo();
	return msjBD; 
     }
	   
   public void eliminarBien(BienVo miBienVo){
     setMsjBD(miBienDao.eliminarBien(miBienVo));
      listaBien.remove(miBienVo);
     }
   
   public String editarBien(BienVo  miBienVo){
	 msjBD="ingresa";
	  miBienVo.setEditar(true);
	   return "index";
	 }
   
   public void guardarBien(BienVo miBienVo){
	 setMsjBD(miBienDao.editarBien(miBienVo));
	  miBienVo.setEditar(false);
    }

   	public String getMsjBD() {
   		return msjBD;
   	}

   	public void setMsjBD(String msjBD) {
   		this.msjBD = msjBD;
   	}

	public BienVo getMiBienVo() {
		return miBienVo;
	}

	public void setMiBienVo(BienVo miBienVo) {
		this.miBienVo = miBienVo;
	}
}