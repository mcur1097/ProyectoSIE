package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conexion.Conexion;
import vo.UsuarioVo;

 
public class UsuarioDao {
	
	public String agregarUsuario(UsuarioVo miUsuario) {
		String resultado = "";
		Connection connection = null;
		Conexion conexion = new Conexion();
		PreparedStatement preStatement = null;

		connection = conexion.getConnection();
		System.out.println(1);
		
		System.out.println("Nombre=" + miUsuario.getNombre() + "\n" +
		                   "Apellidos=" + miUsuario.getApellidos() + "\n" +
				           "Documento=" + miUsuario.getDocumento() + "\n" +
				           "Telefono="+ miUsuario.getTelefono() + "\n" +
				           "Email=" + miUsuario.getEmail());
				       
		
				        
		String consulta = "INSERT INTO usuarios (nombre,apellidos,documento,telefono,email)"
				+ "  VALUES (?,?,?,?,?)";

		try {
			preStatement = connection.prepareStatement(consulta);
			preStatement.setString(1, miUsuario.getNombre());
			preStatement.setString(2, miUsuario.getApellidos());
			preStatement.setString(3, miUsuario.getDocumento());
			preStatement.setString(4, miUsuario.getTelefono());
			preStatement.setString(5, miUsuario.getEmail());

			preStatement.execute();

			resultado = "Registro Exitoso";

		} catch (SQLException e) {
			System.out.println("No se pudo registrar el usuario: " + e.getMessage());
			e.printStackTrace();
			resultado = "No se pudo registrar";
		} finally {
			conexion.desconectar();
		}

		return resultado;
	}

	public ArrayList<UsuarioVo> obtenerListaUsuarios() {
		Connection connection = null;
		Conexion miConexion = new Conexion();
		PreparedStatement statement = null;
		ResultSet result = null;

		UsuarioVo miUsuarioVo = new UsuarioVo();
		ArrayList<UsuarioVo> listaUsuarios = null;

		connection = miConexion.getConnection();

		String consulta = "SELECT * FROM usuarios ";

		try {
			if (connection != null) {
				listaUsuarios = new ArrayList<>();
				statement = connection.prepareStatement(consulta);

				result = statement.executeQuery();

				while (result.next() == true) {
					miUsuarioVo = new UsuarioVo();
					miUsuarioVo.setNombre(result.getString("nombre"));
					miUsuarioVo.setApellidos(result.getString("apellidos"));
					miUsuarioVo.setDocumento(result.getString("documento"));
					miUsuarioVo.setTelefono(result.getString("telefono"));
					miUsuarioVo.setEmail(result.getString("email"));
					listaUsuarios.add(miUsuarioVo);
				}

			}
		} catch (SQLException e) {
			System.out.println("Error en la consulta del usuario: " + e.getMessage());
		} finally {
			miConexion.desconectar();
		}
		return listaUsuarios;
	}

	public String editarUsuario(UsuarioVo miUsuarioVo) {
		String resultado = "";
		Connection connection = null;
		Conexion miConexion = new Conexion();
		connection = miConexion.getConnection();
		try {
			String consulta = "UPDATE usuarios "
					+ " SET nombre = ? , apellidos=? , documento=? , telefono=? , email= ? "
					+ " WHERE documento= ? ";
			
			PreparedStatement preStatement = connection.prepareStatement(consulta);

			preStatement.setString(1, miUsuarioVo.getNombre());
			preStatement.setString(2, miUsuarioVo.getApellidos());
			preStatement.setString(3, miUsuarioVo.getDocumento());
			preStatement.setString(4, miUsuarioVo.getTelefono());
			preStatement.setString(5, miUsuarioVo.getEmail());
			preStatement.setString(6, miUsuarioVo.getDocumento());
			preStatement.executeUpdate();

			resultado = "Se ha Actualizado el usuario satisfactoriamente";

			miConexion.desconectar();

		} catch (SQLException e) {
			System.out.println(e);
			resultado = "No se pudo actualizar el usuario";
		}
		return resultado;
	}

	public String eliminarUsuario(UsuarioVo usuario) {
		Connection connection = null;
		Conexion miConexion = new Conexion();
		connection = miConexion.getConnection();
		String resp = "";
		try {
			String sentencia = "DELETE FROM usuarios WHERE documento = ? ";
			PreparedStatement statement = connection.prepareStatement(sentencia);
			statement.setString(1, usuario.getDocumento());
			statement.executeUpdate();

			resp = "Se ha eliminado exitosamente";
			statement.close();
			miConexion.desconectar();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			resp = "No se pudo eliminar";
		}
		return resp;
	}
	
	public UsuarioVo consultarUsuarioIndividual(String documento){
		
		System.out.println("****************Entro a consulta individual**********************");
		Connection connection=null;
		Conexion miConexion=new Conexion();
		PreparedStatement statement=null;
		ResultSet result=null;
		
		UsuarioVo miUsuario=null;
		
		connection=miConexion.getConnection();
		
		String consulta="SELECT * FROM usuarios WHERE documento="+documento;
		System.out.println("******************* Entro a al select****************");
		try{
			if(connection!=null){
				statement=connection.prepareStatement(consulta);
				System.out.println("**************** La conexion es difente a null*********************");
				result=statement.executeQuery();
				
				if(result.next()==true){
					miUsuario=new UsuarioVo();
					miUsuario.setDocumento(result.getString("documento"));
					miUsuario.setNombre(result.getString("nombre"));
					miUsuario.setApellidos(result.getString("apellidos"));
					miUsuario.setTelefono(result.getString("telefono"));
					miUsuario.setEmail(result.getString("email"));
				}else{
					
				}
				System.out.println("documento"+miUsuario.getDocumento());
				System.out.println("nombre"+miUsuario.getNombre());
				System.out.println("apellidos"+miUsuario.getApellidos());
				System.out.println("telefono"+miUsuario.getTelefono());
						
			}
		}catch(SQLException e){
			System.out.println("Error en la consulta del usuario: "+e.getMessage());
		}finally {
			miConexion.desconectar();
		}
		return miUsuario;
	}
	
}

