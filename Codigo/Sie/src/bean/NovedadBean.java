package bean;

import java.util.ArrayList; 

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import vo.NovedadVo;
import dao.NovedadDao;
import mail.EmailSenderServices;

@ManagedBean
@SessionScoped
public class NovedadBean {
	private ArrayList<NovedadVo> listaNov = new ArrayList<>();
	private NovedadVo miNovVo;
	private NovedadVo miNovedadVo;
	private NovedadVo miNovedadVo2;
	private NovedadVo miNovedadVo3;
	private NovedadVo miNovedadVo4;
	NovedadDao miNovDao;
    private String mensaje="";
    private String msjBD;    

    public void recibirInstancia(NovedadVo miNov){
    this.miNovedadVo2=miNov;
    EmailSenderServices email=new EmailSenderServices();
    email.recibirInstancia(miNovedadVo);
    }

    public void recibirNombre(NovedadVo miNovNom){
    this.miNovedadVo3=miNovNom;
    EmailSenderServices email=new EmailSenderServices();
    email.recibirInstancia(miNovedadVo);
    }

    public void recibirDocumento(NovedadVo miNovDoc){
    this.miNovedadVo4=miNovDoc;
    EmailSenderServices email=new EmailSenderServices();
    email.recibirInstancia(miNovedadVo);
    }
    
	public NovedadBean(){
		miNovedadVo=new NovedadVo(); 
		miNovDao=new NovedadDao();
	}

	public String envioNovedad() {
		String resp="";

		NovedadVo miNovVo=miNovDao.consultarPlaca(miNovedadVo.getPlaca());

		if(miNovVo==null){			
			mensaje="La Placa no existe en los registros";
		}else{

			miNovedadVo2=miNovDao.consultarCorreo(miNovedadVo.getPlaca());
			miNovedadVo3=miNovDao.consultarNombre(miNovedadVo.getPlaca());
			miNovedadVo4=miNovDao.consultarDocumento(miNovedadVo.getPlaca());
			
			String remitente="proyectoformativosiesena@gmail.com";
	    	String receptor=miNovedadVo2.getCorreo();
	    	String receptor2= "leidycaranton2000@gmail.com";
	    	String pass="proyectoSie";
	    	String asunto="Reporte de Novedades S.I.E"; 
		
	    	String msj="Placa: "+ miNovedadVo.getPlaca() +"\n"
	    			+ "Nombre Bien: "+ miNovedadVo3.getNombreBien() +"\n"
	    			+ "Ambiente: "+ miNovedadVo.getArea() +"\n"
	    			+ "Descripción: "+ miNovedadVo.getDescripcion() +"\n"
	    			+ "Fecha: "+ miNovedadVo.getFecha() +"\n"
	    			+ "Hora: "+ miNovedadVo.getHora() +"\n";

	    	EmailSenderServices email=new EmailSenderServices();
	    	email.enviarCorreo(remitente,receptor,pass,asunto,msj);
	    	email.enviarCorreo(remitente,receptor2,pass,asunto,msj);
	    	
			mensaje="Novedad Realizada";
			
			agregarNovedad(miNovedadVo4.getDocumento());
		  }
		
		return resp;
	}
	
  public String agregarNovedad(String documento){
	listaNov.add(miNovedadVo);
	 setMsjBD(miNovDao.agregarNovedad(miNovedadVo,documento));
	  miNovedadVo=new NovedadVo();
	    return msjBD; 
	}
	  
	public NovedadVo getMiNovedadVo() {
		return miNovedadVo;
	}

	public void setMiNovedadVo(NovedadVo miNovedadVo) {
		this.miNovedadVo = miNovedadVo;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public NovedadVo getMiNovedadVo2() {
		return miNovedadVo2;
	}

	public void setMiNovedadVo2(NovedadVo miNovedadVo2) {
		this.miNovedadVo2 = miNovedadVo2;
	}

	public NovedadVo getMiNovedadVo3() {
		return miNovedadVo3;
	}

	public void setMiNovedadVo3(NovedadVo miNovedadVo3) {
		this.miNovedadVo3 = miNovedadVo3;
	}

	public NovedadVo getMiNovedadVo4() {
		return miNovedadVo4;
	}

	public void setMiNovedadVo4(NovedadVo miNovedadVo4) {
		this.miNovedadVo4 = miNovedadVo4;
	}

	public NovedadVo getMiNovVo() {
		return miNovVo;
	}

	public void setMiNovVo(NovedadVo miNovVo) {
		this.miNovVo = miNovVo;
	}

	public String getMsjBD() {
		return msjBD;
	}

	public void setMsjBD(String msjBD) {
		this.msjBD = msjBD;
	}
}
