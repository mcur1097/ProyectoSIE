package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conexion.Conexion;
import vo.TomaFisicaVo;

public class TomaFisicaDao {

	public ArrayList<TomaFisicaVo> obtenerListaBienesAsociados(Integer areaId) {
		Connection connection = null;
		Conexion miConexion = new Conexion();
		PreparedStatement statement = null;
		ResultSet result = null;

		TomaFisicaVo misBienes = new TomaFisicaVo();
		ArrayList<TomaFisicaVo> listaBienes = null;

		connection = miConexion.getConnection();
		
		String consulta = "SELECT b.placa,b.serialB,b.nombre,b.modelo,b.marca,b.valor,b.descripcion,"
				+ "b.fechaIngreso,b.tipo,b.idArea,a.nombreArea,b.documento_User,"
				+ " u.nombreCompleto AS cuentadante FROM bien b,usuarios u, area a "
				+ "WHERE b.idArea="+areaId+""
				+ " AND b.documento_User=u.documento AND b.idArea=a.idArea";
		
		System.out.println("***************************************");
		System.out.println(consulta);
		try {
			if (connection != null) {
				listaBienes = new ArrayList<>();
				statement = connection.prepareStatement(consulta);

				result = statement.executeQuery();

				while (result.next() == true) {
					misBienes = new TomaFisicaVo();
					misBienes.setPlaca(result.getString("placa"));
					misBienes.setSerialB(result.getString("serialB"));
					misBienes.setNombre(result.getString("nombre"));
					misBienes.setModelo(result.getString("modelo"));
					misBienes.setMarca(result.getString("marca"));
					misBienes.setValor(result.getString("valor"));
					misBienes.setDescripcion(result.getString("descripcion"));
					misBienes.setFechaIngreso(result.getString("fechaIngreso"));
					misBienes.setTipo(result.getString("tipo"));
					misBienes.setIdArea(result.getString("idArea"));
					misBienes.setAreaAsignada(result.getString("nombreArea"));
					misBienes.setAreaActual(result.getString("nombreArea"));
					misBienes.setDocumentoUser(result.getString("documento_user"));
					misBienes.setCuentadante(result.getString("cuentadante"));
					misBienes.setColor("000000");
					
					listaBienes.add(misBienes);
				}
				
			}
		} catch (SQLException e) {
			System.out.println("Error en la consulta de los bienes: " + e.getMessage());
		} finally {
			miConexion.desconectar();
		}
		return listaBienes;
	}

	public TomaFisicaVo obtenerBien(String idBien) {
		Connection connection = null;
		Conexion miConexion = new Conexion();
		PreparedStatement statement = null;
		ResultSet result = null;

		TomaFisicaVo miBien = null;

		connection = miConexion.getConnection();
		
		String consulta = "SELECT b.placa,b.serialB,b.nombre,b.modelo,b.marca,b.valor,b.descripcion,b.fechaIngreso,b.tipo,b.idArea,"
				+ "a.nombreArea,b.documento_User, u.nombreCompleto AS cuentadante"
				+ " FROM bien b,usuarios u, AREA a "
				+ "WHERE  b.placa="+idBien+" AND b.documento_User=u.documento AND b.idArea=a.idArea";
		
		System.out.println("***************************************");
		System.out.println(consulta);
		try {
			if (connection != null) {
				statement = connection.prepareStatement(consulta);

				result = statement.executeQuery();

				if (result.next() == true) {
					miBien = new TomaFisicaVo();
					miBien.setPlaca(result.getString("placa"));
					miBien.setSerialB(result.getString("serialB"));
					miBien.setNombre(result.getString("nombre"));
					miBien.setModelo(result.getString("modelo"));
					miBien.setMarca(result.getString("marca"));
					miBien.setValor(result.getString("valor"));
					miBien.setDescripcion(result.getString("descripcion"));
					miBien.setFechaIngreso(result.getString("fechaIngreso"));
					miBien.setTipo(result.getString("tipo"));
					miBien.setIdArea(result.getString("idArea"));
					miBien.setAreaAsignada(result.getString("nombreArea"));
					miBien.setAreaActual(result.getString("nombreArea"));
					miBien.setDocumentoUser(result.getString("documento_user"));
					miBien.setCuentadante(result.getString("cuentadante"));
					
				}
				
			}
		} catch (SQLException e) {
			System.out.println("Error en la consulta del bien: " + e.getMessage());
		} finally {
			miConexion.desconectar();
		}
		return miBien;
	}

}
