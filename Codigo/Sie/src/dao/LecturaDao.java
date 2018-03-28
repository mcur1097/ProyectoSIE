package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conexion.Conexion;
import vo.LecturaVo;

public class LecturaDao {

	public ArrayList<LecturaVo> obtenerBienesSincronizados(Integer areaId) {
		Connection connection = null;
		Conexion miConexion = new Conexion();
		PreparedStatement statement = null;
		ResultSet result = null;

		LecturaVo bienesSincronizados = new LecturaVo();
		ArrayList<LecturaVo> listaBienes = null;

		connection = miConexion.getConnection();
		
		String consulta = "SELECT * FROM lectura WHERE idArea = "+areaId;
		
		System.out.println("***************************************");
		System.out.println(consulta);
		try {
			if (connection != null) {
				listaBienes = new ArrayList<>();
				statement = connection.prepareStatement(consulta);

				result = statement.executeQuery();

				while (result.next() == true) {
					bienesSincronizados = new LecturaVo();
					bienesSincronizados.setIdArea(result.getString("idArea"));
					bienesSincronizados.setIdBien(result.getString("idBien"));					
					listaBienes.add(bienesSincronizados);
				}
				
			}
		} catch (SQLException e) {
			System.out.println("Error en la consulta de los bienes sincronizados: " + e.getMessage());
		} finally {
			miConexion.desconectar();
		}
		return listaBienes;
	}
	

}
