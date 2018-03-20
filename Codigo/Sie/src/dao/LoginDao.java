package dao;

import java.sql.Connection;       
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import conexion.Conexion;
import vo.LoginVo;

public class LoginDao {

	boolean dtos = false;
	
	public boolean isDtos() {
		return dtos;
	}

	public void setDtos(boolean dtos) {
		this.dtos = dtos;
	}
	
	public String nombredeusuario(String nombreusu){
		String nom="";
		nom=nombreusu;
		return nom;
	}

	public LoginVo consultarUsuarioLogin(String documento, String passw) {
		Connection connection = null;
		Conexion miConexion = new Conexion();
		PreparedStatement statement = null;
		ResultSet result = null;

		LoginVo miPersona=null;

		connection = miConexion.getConnection();
		
		try {
			if (connection != null) {
				
				String consulta = "SELECT * FROM perfilusuario where documento = ? and contraseña = ? ";

				statement = connection.prepareStatement(consulta);

				statement.setString(1, documento);
				statement.setString(2, passw);
								
				result = statement.executeQuery();
				if (result.next() == true) {
					dtos=true;
					miPersona = new LoginVo();
					miPersona.setNombre(result.getString("nombre"));
					
					nombredeusuario(result.getString("nombre"));
					
				}else{
					dtos=false;
				}
			}
		} catch (SQLException e) {
			System.out.println("Error en la consulta del usuario: " + e.getMessage());
		} finally {
			miConexion.desconectar();
		}
		return miPersona;
	}
}
