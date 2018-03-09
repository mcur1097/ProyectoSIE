package dao;

import java.sql.Connection;       
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.NovedadBean;
import conexion.Conexion;
import vo.NovedadVo;

public class NovedadDao {
	
	NovedadBean mino;
	NovedadBean miDoc;
	
	
	public NovedadVo consultarPlaca(String placa) {
		Connection connection = null;
		Conexion miConexion = new Conexion();
		PreparedStatement statement = null;
		ResultSet result = null;

		NovedadVo miNov = null;
        
		connection = miConexion.getConnection();
		
		try {
			if (connection != null) {
				
				String consulta = "SELECT * FROM bien where placa = ?";

				statement = connection.prepareStatement(consulta);

				statement.setString(1, placa);
	
				result = statement.executeQuery();
				
				if (result.next() == true) {
					miNov = new NovedadVo();
				}

			}
		} catch (SQLException e) {
			System.out.println("Error en la consulta del bien: " + e.getMessage());
		} finally {
			miConexion.desconectar();
		}
		return miNov;
	}
	
	public NovedadVo consultarCorreo(String placa) {
		Connection connection = null;
		Conexion miConexion = new Conexion();
		PreparedStatement statement = null;
		ResultSet result = null;

		NovedadVo miNov = new NovedadVo();

		connection = miConexion.getConnection();
		
		try {
			if (connection != null) {
				
				String consulta = "SELECT correo FROM perfilusuario,bien where placa= ? "
						+ "and bien.cedula=perfilusuario.documento";

				statement = connection.prepareStatement(consulta);

				statement.setString(1, placa);
	
				result = statement.executeQuery();
				
				if (result.next() == true) {			       
					miNov = new NovedadVo();
					miNov.setCorreo(result.getString("correo"));
					mino = new NovedadBean();
					mino.recibirInstancia(miNov);
				}

			}
		} catch (SQLException e) {
			System.out.println("Error en la consulta del CORREO: " + e.getMessage());
		} finally {
			miConexion.desconectar();
		}
		return miNov;
	}
	
	public NovedadVo consultarNombre(String placa) {
		Connection connection = null;
		Conexion miConexion = new Conexion();
		PreparedStatement statement = null;
		ResultSet result = null;

		NovedadVo miNovNom = new NovedadVo();

		connection = miConexion.getConnection();
		
		try {
			if (connection != null) {
				
				String consulta = "SELECT nombreBien FROM bien where placa = ?";

				statement = connection.prepareStatement(consulta);

				statement.setString(1, placa);
	
				result = statement.executeQuery();
				
				if (result.next() == true) {			       
					miNovNom = new NovedadVo();
					miNovNom.setNombreBien(result.getString("nombreBien"));
					mino = new NovedadBean();
					mino.recibirNombre(miNovNom);
				}

			}
		} catch (SQLException e) {
			System.out.println("Error en la consulta del Nombre del Bien: " + e.getMessage());
		} finally {
			miConexion.desconectar();
		}
		return miNovNom;
	}
	
	public NovedadVo consultarDocumento(String placa) {
		Connection connection = null;
		Conexion miConexion = new Conexion();
		PreparedStatement statement = null;
		ResultSet result = null;

		NovedadVo miNovDoc = new NovedadVo();

		connection = miConexion.getConnection();
		
		try {
			if (connection != null) {
				
				String consulta = "SELECT documento FROM perfilusuario, bien where placa = ? and perfilusuario.documento"
						+ "=bien.cedula";

				statement = connection.prepareStatement(consulta);

				statement.setString(1, placa);
	
				result = statement.executeQuery();
				
				if (result.next() == true) {			       
					miNovDoc = new NovedadVo();
					miNovDoc.setDocumento(result.getString("Documento"));
					miDoc = new NovedadBean();
					miDoc.recibirDocumento(miNovDoc);
				}
			}
		} catch (SQLException e) {
			System.out.println("Error en la consulta del documento: " + e.getMessage());
		} finally {
			miConexion.desconectar();
		}
		return miNovDoc;
	}		
	
	public String agregarNovedad(NovedadVo miNovedadVo, String documento){
		String resultado="";
		
		Connection connection = null;
		Conexion miConexion = new Conexion();
		PreparedStatement preStatement = null;
		
		connection = miConexion.getConnection();
		
		String consulta = "INSERT INTO novedadusuarios (placa,area,descripcion,fecha,hora,cedula)"
				+ "VALUES (?,?,?,?,?,?)";
		
		try{
		  preStatement = connection.prepareStatement(consulta);
		  preStatement.setString(1, miNovedadVo.getPlaca());
		  preStatement.setString(2, miNovedadVo.getArea());
		  preStatement.setString(3, miNovedadVo.getDescripcion());
		  preStatement.setString(4, miNovedadVo.getFecha());
		  preStatement.setString(5, miNovedadVo.getHora());
		  preStatement.setString(6, documento);
		  preStatement.execute();
		  
		}catch (SQLException e){
			System.out.println("No se pudo Registrar la Novedad: "+e.getMessage());
			resultado="No Registró";
		}finally {
			miConexion.desconectar();
		}
	 return resultado;	
	} 
		
}
