package bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.model.SelectItem;

import dao.AreaDao;
import dao.LecturaDao;
import dao.TomaFisicaDao;
import vo.Area;
import vo.LecturaVo;
import vo.TomaFisicaVo;

@ManagedBean
@SessionScoped
public class TomaFisicaBean {

	private TomaFisicaDao tomaFisicaDao;
	private Area miArea;
	private Integer areaId;

	private String mensajeConfirmacion;
	private ArrayList<TomaFisicaVo> listaBienes=new ArrayList<>();
	private List<SelectItem> itemAreas;
	HashMap<Integer, Area> mapaAreas=new HashMap<>();
	ArrayList<String> listaIdBienes=new ArrayList<>();
	
	public TomaFisicaBean(){
		tomaFisicaDao=new TomaFisicaDao();
		itemAreas=new ArrayList<SelectItem>();
		miArea=new Area();
		cargarAreas();
		
	}
	
	public void sincronizar(){
		System.out.println("INGRESA A SINCRONIZAR");
		
		LecturaVo lecturaVo=new LecturaVo();
		LecturaDao lecturaDao=new LecturaDao();
		TomaFisicaVo nuevoBien=null;
		
		ArrayList<String> placasIguales=new ArrayList<>();
		ArrayList<String> placasNuevas=new ArrayList<>();
		ArrayList<String> placasFaltantes=new ArrayList<>();
		ArrayList<String> listaIdFinal=new ArrayList<>();
		ArrayList<String> listaIdSincronizados=new ArrayList<>();
		
		ArrayList<LecturaVo> listaBienesSincronizados=lecturaDao.obtenerBienesSincronizados(areaId);
		
		for (int i = 0; i < listaBienesSincronizados.size(); i++) {
			System.out.println(listaBienesSincronizados.get(i).getIdArea()+" - "+listaBienesSincronizados.get(i).getIdBien());
			listaIdSincronizados.add(listaBienesSincronizados.get(i).getIdBien());
			if (listaIdBienes.contains(listaBienesSincronizados.get(i).getIdBien())) {
				placasIguales.add(listaBienesSincronizados.get(i).getIdBien());
			}else{
				
				nuevoBien=tomaFisicaDao.obtenerBien(listaBienesSincronizados.get(i).getIdBien());
				if (nuevoBien!=null) {
					placasNuevas.add(listaBienesSincronizados.get(i).getIdBien());
					System.out.println("Nuevo Bien: "+nuevoBien.getPlaca()+" - area "+nuevoBien.getAreaActual());
					nuevoBien.setAreaActual(mapaAreas.get(areaId).getNombreArea());
					nuevoBien.setColor("#FFBF00");
					System.out.println("Nuevo Bien desps: "+nuevoBien.getPlaca()+" - area "+nuevoBien.getAreaActual());
					listaBienes.add(nuevoBien);	
				}				
			}
		}
		System.out.println("**************************************");

		
		
		System.out.println("PLACAS IGUALES");
		for (int i = 0; i < placasIguales.size(); i++) {
			System.out.println(placasIguales.get(i)+" , ");
			listaIdFinal.add(placasIguales.get(i));
		}
		
		System.out.println("PLACAS NUEVAS");
		for (int i = 0; i < placasNuevas.size(); i++) {
			System.out.println(placasNuevas.get(i)+" , ");
			listaIdFinal.add(placasNuevas.get(i));
		}
		
		System.out.println("sincronizados: "+listaIdSincronizados);
		System.out.println("finales: "+listaIdBienes);
		for (int i = 0; i < listaIdBienes.size(); i++) {
			if (!listaIdSincronizados.contains(listaIdBienes.get(i))) {
				placasFaltantes.add(listaIdBienes.get(i));
			}
		}
		
		System.out.println("PLACAS FALTANTES");
		for (int i = 0; i < placasFaltantes.size(); i++) {
			System.out.println(placasFaltantes.get(i)+" , ");
		}
		
		for (int i = 0; i < listaBienes.size(); i++) {
			for (int j = 0; j < placasFaltantes.size(); j++) {
				if (listaBienes.get(i).getPlaca().equals(placasFaltantes.get(j))) {
					listaBienes.get(i).setColor("#DF0101");
					listaBienes.get(i).setAreaActual("No Registra");;
				}
			}
		}
		
	}

	private void cargarAreas() {
		
		AreaDao miAreaDao=new AreaDao();
		ArrayList<Area> listaArea;
		listaArea=miAreaDao.obtenerListaArea();
		
		if (listaArea.size()>0) {
				
			for (int i = 0; i < listaArea.size(); i++) {
				itemAreas.add(new SelectItem(listaArea.get(i).getCodigoArea(),listaArea.get(i).getNombreArea()));
				mapaAreas.put(listaArea.get(i).getCodigoArea(),listaArea.get(i));
				System.out.println(listaArea.get(i).getCodigoArea()+" - "+listaArea.get(i).getNombreArea());
			}
			
		}else{
			listaArea=new ArrayList<>();
			mensajeConfirmacion="Actualmente no existen areas registradas";
		}
	}
	
	
	public void consultarBienesArea(AjaxBehaviorEvent event){
		System.out.println("INGRESA AL METODO DEL CAMBIO");
		System.out.println("CODIGO: "+areaId);
		System.out.println("Mapa Areas: "+mapaAreas);
		
		listaBienes=new ArrayList<>();
		listaIdBienes=new ArrayList<>();
		
		if (mapaAreas!=null) {
			miArea=mapaAreas.get(areaId);
			
			listaBienes=tomaFisicaDao.obtenerListaBienesAsociados(areaId);
			generarListaIdBienes(listaBienes);
			
			System.out.println("Objeto miArea: "+miArea);
			System.out.println("Codigo: "+miArea.getCodigoArea());
			System.out.println("Nombre: "+miArea.getNombreArea());
			System.out.println("Descripcion: "+miArea.getDescripcion());
		}
				
	}
	
	private void generarListaIdBienes(ArrayList<TomaFisicaVo> listaBienes) {
		
		System.out.println("Lista Bienes Actuales");
		for (int i = 0; i < listaBienes.size(); i++) {
			listaIdBienes.add(listaBienes.get(i).getPlaca());
			System.out.println(listaBienes.get(i).getPlaca());
		}
		
	}

	public void asignarBien(TomaFisicaVo bien){
		System.out.println("VA A ASIGNAR BIEN");
		System.out.println("Bien seleccionado: "+bien.getNombre());
	}
	
	public Integer getAreaId() {
		return areaId;
	}



	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}


	public List<SelectItem> getItemAreas() {
		return itemAreas;
	}



	public void setItemAreas(List<SelectItem> itemAreas) {
		this.itemAreas = itemAreas;
	}

	public String getMensajeConfirmacion() {
		return mensajeConfirmacion;
	}
	public void setMensajeConfirmacion(String mensajeConfirmacion) {
		this.mensajeConfirmacion = mensajeConfirmacion;
	}


	public Area getMiArea() {
		return miArea;
	}



	public void setMiArea(Area miArea) {
		this.miArea = miArea;
	}



	public ArrayList<TomaFisicaVo> getListaBienes() {
		return listaBienes;
	}



	public void setListaBienes(ArrayList<TomaFisicaVo> listaBienes) {
		this.listaBienes = listaBienes;
	}
	
}
