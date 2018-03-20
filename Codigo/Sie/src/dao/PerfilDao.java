package dao;

import java.sql.Connection; 
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conexion.Conexion;
import vo.LoginVo;
import vo.PerfilVo;

public class PerfilDao {

public ArrayList<PerfilVo> obtenerListaUsuario(String documento) {
		
		Connection connection = null;
		Conexion miConexion = new Conexion();
		PreparedStatement statement = null;
		ResultSet result = null;
		
		PerfilVo miPerfil = new PerfilVo();
		ArrayList<PerfilVo> listaUsuario = null;
		
		connection = miConexion.getConnection();
		
		try{
		  if(connection !=null){
			  String consul = "SELECT * FROM usuarios where documento = ?";
			  statement = connection.prepareStatement(consul);

				statement.setString(1, documento);
								
				result = statement.executeQuery();
				
			 listaUsuario = new ArrayList<>();
			 
			 result = statement.executeQuery();
			 
			 while(result.next()==true){
			   miPerfil = new PerfilVo();
			   miPerfil.setDocumento(result.getString("documento"));
			   miPerfil.setNombre(result.getString("nombreCompleto"));
			   miPerfil.setTelefono(result.getString("telefono"));
			   miPerfil.setCorreo(result.getString("email"));
			   miPerfil.setPassw(result.getString("passw"));
			   miPerfil.setPassw2(result.getString("passw2"));
			   listaUsuario.add(miPerfil);
			 }
		  }
		}catch(SQLException e){
			System.out.println("Error en la consulta del Usuario " +e.getMessage());
		}finally {
			miConexion.desconectar();
		}
		return listaUsuario;
	}

	public String editarUsuario(LoginVo user) {
		String resultado = "";

		Connection connection = null;
		Conexion miConexion = new Conexion();
		PreparedStatement preStatement = null;

		connection = miConexion.getConnection();

		try {

			String consulta = "UPDATE usuarios SET telefono = ?, email = ?, contrasena = ? WHERE documento = ?";

			preStatement = connection.prepareStatement(consulta);
			preStatement.setString(1, user.getTelefono());
			preStatement.setString(2, user.getCorreo());
			preStatement.setString(3, user.getPassw());
			preStatement.setString(4, user.getDocumento());
			preStatement.executeUpdate();

			resultado = "Se ha Actualizado Correctamente";
			miConexion.desconectar();

		} catch (SQLException e) {
			System.out.println(e);
			resultado = "No se Pudó Actualizar el Usuario";
		}
		return resultado;
	}
}
