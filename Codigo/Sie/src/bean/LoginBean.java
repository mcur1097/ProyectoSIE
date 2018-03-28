package bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import vo.LoginVo;
import dao.LoginDao;

@ManagedBean
@SessionScoped
public class LoginBean {

    private LoginVo miLoginVo;
	private String mensaje;
	LoginDao miLoginDao;
	private String resp="";
	private String respnom="";
	private String nombreusu="";
	FacesContext context = FacesContext.getCurrentInstance();
	HttpSession session = (HttpSession)context.getExternalContext().getSession(true);
	
	public LoginBean(){
		miLoginVo =new LoginVo();
		miLoginDao =new LoginDao(); 
	}
	public void usuario(String nombreusu){
		
	setRespnom(miLoginDao.nombredeusuario(nombreusu));	
	}
	
	public String validarUsuario () {

		LoginVo persona=miLoginDao.consultarUsuarioLogin(miLoginVo.getDocumento(), miLoginVo.getPassw());
		session.setAttribute("user", persona);
		if (persona!=null) {
			
			resp="inicio.jsf";
			mensaje="";
			nombreusu=persona.getNombre();
			usuario(nombreusu);
			
		}else{
			resp="";
			mensaje="El usuario no es Valido, Verifique nuevamente...";
		}
		return resp;
	}

	public String pagina(){
		String inicio="";
		
		if(miLoginDao.isDtos()==true){
			inicio="inicio";
			
		}else{
			inicio="login";
		}
		return inicio;
	}
	
	public LoginVo getMiLoginVo() {
		return miLoginVo;
	}

	public void setMiLoginVo(LoginVo miLoginVo) {
		this.miLoginVo = miLoginVo;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getResp() {
		return resp;
	}

	public void setResp(String resp) {
		this.resp = resp;
	}
	public String getRespnom() {
		return respnom;
	}
	public void setRespnom(String respnom) {
		this.respnom = respnom;
	}
	public String getNombreusu() {
		return nombreusu;
	}
	public void setNombreusu(String nombreusu) {
		this.nombreusu = nombreusu;
	}
}
