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
				
				String consulta = "SELECT email FROM usuarios,bien where placa= ? "
						+ "and bien.documento_User=usuarios.documento";

				statement = connection.prepareStatement(consulta);

				statement.setString(1, placa);
	
				result = statement.executeQuery();
				
				if (result.next() == true) {			       
					miNov = new NovedadVo();
					miNov.setCorreo(result.getString("email"));
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
				
				String consulta = "SELECT nombre FROM bien where placa = ?";

				statement = connection.prepareStatement(consulta);

				statement.setString(1, placa);
	
				result = statement.executeQuery();
				
				if (result.next() == true) {			       
					miNovNom = new NovedadVo();
					miNovNom.setNombreBien(result.getString("nombre"));
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
				
				String consulta = "SELECT documento FROM usuarios, bien where placa = ? and usuarios.documento"
						+ "=bien.documento_User";

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
		
		String consulta = "INSERT INTO novedades (placa_Bien,descripcion,fecha,hora,documento_User,area)"
				+ "VALUES (?,?,?,?,?,?)";
		
		try{
		  preStatement = connection.prepareStatement(consulta);
		  preStatement.setString(1, miNovedadVo.getPlaca());
		  preStatement.setString(2, miNovedadVo.getDescripcion());
		  preStatement.setString(3, miNovedadVo.getFecha());
		  preStatement.setString(4, miNovedadVo.getHora());
		  preStatement.setString(5, documento);
		  preStatement.setString(6, miNovedadVo.getArea());
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
