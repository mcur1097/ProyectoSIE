package dao;

import java.sql.Connection;     
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conexion.Conexion;
import vo.BienVo;

public class BienDao {

	public String agregarBien(BienVo miBien){
		String resultado="";
		
		Connection connection = null;
		Conexion miConexion = new Conexion();
		PreparedStatement preStatement = null;
		
		connection = miConexion.getConnection();
		
		String consulta = "INSERT INTO bien (placa,serialB,nombreBien,descripcion,modelo,marca,fechaIngreso,valor,areaAm,cedula)"
				+ "VALUES (?,?,?,?,?,?,?,?,?,?)";
		
		try{
		  preStatement = connection.prepareStatement(consulta);
		  preStatement.setString(1, miBien.getPlaca());
		  preStatement.setString(2, miBien.getSerialB());
		  preStatement.setString(3, miBien.getNomBien());
		  preStatement.setString(4, miBien.getDescripcion());
		  preStatement.setString(5, miBien.getModelo());
		  preStatement.setString(6, miBien.getMarca());
		  preStatement.setString(7, miBien.getIngreso());
		  preStatement.setString(8, miBien.getValor());
		  preStatement.setString(9, miBien.getArea());
		  preStatement.setString(10, miBien.getCuentadante());
		  preStatement.execute();
		  
		}catch (SQLException e){
			System.out.println("No se pudo Registrar el Bien: "+e.getMessage());
			resultado="No Registró";
		}finally {
			miConexion.desconectar();
		}
	 return resultado;	
	}
	
	
	public String editarBien(BienVo miBien){
		String resultado="";
		
		Connection connection = null;
		Conexion miConexion = new Conexion();
		PreparedStatement preStatement = null;
		
		connection = miConexion.getConnection();
		
		try{
			
	String consulta = "UPDATE bien SET serialB = ?, nombreBien = ?, descripcion = ?, modelo = ?, marca = ?, "
		+ "fechaIngreso = ?, valor = ? WHERE placa = ?";
	
	
		  preStatement = connection.prepareStatement(consulta);
		  preStatement.setString(1, miBien.getSerialB());
		  preStatement.setString(2, miBien.getNomBien());
		  preStatement.setString(3, miBien.getDescripcion());
		  preStatement.setString(4, miBien.getModelo());
		  preStatement.setString(5, miBien.getMarca());
		  preStatement.setString(6, miBien.getIngreso());
		  preStatement.setString(7, miBien.getValor());
		  preStatement.setString(8, miBien.getPlaca());
		  preStatement.executeUpdate();
		  
		  resultado="Se ha Actualizado Correctamente";
		  miConexion.desconectar();
		  
		}catch (SQLException e){
			System.out.println(e);
			resultado="No se Pudó Actualizar el Bien";
		}
	 return resultado;	
	}
	
	
	public String eliminarBien(BienVo miBien){
		String resp="";
		
		Connection connection = null;
		Conexion miConexion = new Conexion();
		PreparedStatement statement = null;
		
		connection = miConexion.getConnection();
		
		try{
			
		 String sentencia = "DELETE FROM bien where placa = ? ";
		 
		 statement = connection.prepareStatement(sentencia);
		 statement.setString(1, miBien.getPlaca());
		 statement.executeUpdate();
		 
		 resp="Se ha Eliminado el Bien Correctamente";
		 statement.close();
		 miConexion.desconectar();
		 
		}catch(SQLException e){
		  System.out.println(e.getMessage());
		  resp="No se pudó Eliminar el Bien";
		}
		return resp;
	}
	
	public ArrayList<BienVo> obtenerListaBienes() {
		
		Connection connection = null;
		Conexion miConexion = new Conexion();
		PreparedStatement statement = null;
		ResultSet result = null;
		
		BienVo miBien = new BienVo();
		ArrayList<BienVo> listaBienes = null;
		
		connection = miConexion.getConnection();
		
		String consul = "SELECT * FROM bien";
		
		try{
		  if(connection !=null){
			 listaBienes = new ArrayList<>();
			 statement = connection.prepareStatement(consul);
			 
			 result = statement.executeQuery();
			 
			 while(result.next()==true){
			   miBien = new BienVo();
			   miBien.setPlaca(result.getString("placa"));
			   miBien.setSerialB(result.getString("serialb"));
			   miBien.setNomBien(result.getString("nombreBien"));
			   miBien.setDescripcion(result.getString("descripcion"));
			   miBien.setModelo(result.getString("modelo"));
			   miBien.setMarca(result.getString("marca"));
			   miBien.setIngreso(result.getString("fechaIngreso"));
			   miBien.setValor(result.getString("valor"));
			   miBien.setArea(result.getString("areaAm"));
			   miBien.setCuentadante(result.getString("cedula"));
			   listaBienes.add(miBien);
			 }
		  }
		}catch(SQLException e){
			System.out.println("Error en la consulta del Usuario " +e.getMessage());
		}finally {
			miConexion.desconectar();
		}
		return listaBienes;
	}
}
