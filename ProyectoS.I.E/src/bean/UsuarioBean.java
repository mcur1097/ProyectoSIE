package bean;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import dao.UsuarioDao;
import vo.UsuarioVo;

@ManagedBean
public class UsuarioBean {
	
	private ArrayList<UsuarioVo> listaUsuarios=new ArrayList<>();
	private UsuarioVo miUsuarioVo; 
	UsuarioDao miUsuarioDao;
	private String mensaje;
	
	public UsuarioBean(){
		miUsuarioVo=new UsuarioVo();
		miUsuarioDao=new UsuarioDao();
		cargarUsuarios();
	}

	private void cargarUsuarios() {
	listaUsuarios.clear();
	listaUsuarios=miUsuarioDao.obtenerListaUsuarios();
	if (listaUsuarios==null) {
		setMensaje("No se pudo conectar,verifique que la base de datos este conectada");
	    }
	}

	public ArrayList<UsuarioVo> getListaUsuarios(){
		return listaUsuarios;
	} 

	public void agregarUsuario(){ 	
		System.out.println("Ingresa al metodo" + miUsuarioVo.getNombre());
		
		listaUsuarios.add(miUsuarioVo);
		setMensaje(miUsuarioDao.agregarUsuario(miUsuarioVo));
		miUsuarioVo= new UsuarioVo();		
	}  
	
	public void eliminarUsuario(UsuarioVo miUsuarioVo){
		System.out.println(miUsuarioVo);
		setMensaje(miUsuarioDao.eliminarUsuario(miUsuarioVo));
		listaUsuarios.remove(miUsuarioVo);
	}

	public void guardarUsuario(UsuarioVo miUsuarioVo){
		setMensaje(miUsuarioDao.editarUsuario(miUsuarioVo));
		miUsuarioVo.setEditar(false);
	}
	
	public String editarUsuario(UsuarioVo miUsuarioVo){
		mensaje="Ingresa";
		miUsuarioVo.setEditar(true);
		return "usuario";
		}
	
	public UsuarioVo getMiUsuarioVo() {
		return miUsuarioVo;
	}

	public void setMiUsuarioVo(UsuarioVo miUsuarioVo) {
		this.miUsuarioVo = miUsuarioVo;
	}

	public UsuarioDao getMiUsuarioDao() {
		return miUsuarioDao;
	}

	public void setMiUsuarioDao(UsuarioDao miUsuarioDao) {
		this.miUsuarioDao = miUsuarioDao;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
}
