package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conexion.Conexion;
import vo.Area;

public class AreaDao {
	
	Area miArea=new Area();
	
	public String agregarArea(Area miArea){
		String resultado="";
		Connection connection=null;
		Conexion conexion=new Conexion();
		PreparedStatement preStatement=null;
		
		connection=conexion.getConnection();
		String consulta="INSERT INTO area(nombreArea, descripcion) VALUES (?,?);";
		
		try{
			preStatement=connection.prepareStatement(consulta);
			preStatement.setString(1, miArea.getNombreArea());
			preStatement.setString(2, miArea.getDescripcion());
			preStatement.execute();
		}catch(SQLException e){
			System.out.println("No se pudo registrar el area "+e.getMessage());
			resultado="No se pudo registrar";
		}finally {
			conexion.desconectar();
		}
		return resultado;
	}
	
	public ArrayList<Area> obtenerListaArea(){
		Connection connection=null;
		Conexion miConexion=new Conexion();
		PreparedStatement statement=null;
		ResultSet result=null;
		
		Area miArea=new Area();
		ArrayList<Area> listaArea=null;
		
		connection=miConexion.getConnection();
		
		String consulta="SELECT * FROM area;";
		
		try{
			if(connection!=null){
				listaArea=new ArrayList<>();
				statement=connection.prepareStatement(consulta);
				result=statement.executeQuery();
				
				while(result.next()==true){
					miArea=new Area();
					miArea.setIdArea(result.getString("idArea"));
					miArea.setNombreArea(result.getString("nombreArea"));
					miArea.setDescripcion(result.getString("descripcion"));
					listaArea.add(miArea);
				}
				
			}
		}catch(SQLException e){
			System.out.println("Error en la consulta del area: "+e.getMessage());
		}finally{
			miConexion.desconectar();
		}
		return listaArea;
	}
	
	public String editarArea(Area miArea){
		
		String resultado="";
		Connection connection=null;
		Conexion miConexion=new Conexion();
		connection=miConexion.getConnection();
		try{
			System.out.println("entr");
			String consulta="UPDATE area SET nombreArea=?, descripcion=? where idArea=?;";
			PreparedStatement preStatement=connection.prepareStatement(consulta);
			preStatement.setString(1, miArea.getNombreArea());
			preStatement.setString(2, miArea.getDescripcion());
			preStatement.setString(3, miArea.getIdArea());
			preStatement.executeUpdate();
			
			resultado="Se ha Actualizado el area satisfactoriamente";
			miConexion.desconectar();
			
		}catch(SQLException e){
			System.out.println(e);
			resultado="No se pudo actualizar el area";
		}
		return resultado;
		}
	
	
	public String eliminarArea(Area miArea){
		Connection connection=null;
		Conexion miConexion=new Conexion();
		connection=miConexion.getConnection();
		
		String resp="";
		try{
			String sentencia="DELETE FROM area WHERE idArea=?";
			
			PreparedStatement statement=connection.prepareStatement(sentencia);
			statement.setString(1, miArea.getIdArea());
			
			statement.executeUpdate();
			
			resp="Se ha eliminado exitosamente";
			statement.close();
			miConexion.desconectar();
					
		}catch (SQLException e) {
			System.out.println(e.getMessage());
			resp="No se puede eliminar";
			// TODO: handle exception
		}
		return resp;
	}
	/*
	public Area consultarAreaIndividual(String nombreArea){
		Connection connection=null;
		Conexion miConexion=new Conexion();
		PreparedStatement statement=null;
		ResultSet result=null;
		
		Area miArea=null;
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!Entro a consultas de area individual!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!111");
		connection=miConexion.getConnection();
		
		String consulta="SELECT * FROM area WHERE nombreArea="+nombreArea;
		
		try{
			if(connection!=null){
				statement=connection.prepareStatement(consulta);
				
				result=statement.executeQuery();
				
				if(result.next()==true){
					miArea=new Area();
					miArea.setCodigoArea(result.getInt("codigoArea"));
					miArea.setNombreArea(result.getString("nombreArea"));
					miArea.setTipoArea(result.getString("tipoArea"));
				}
						
			}
		}catch(SQLException e){
			System.out.println("Error en la consulta del area: "+e.getMessage());
		}finally {
			miConexion.desconectar();
		}
		return miArea;
	}*/

}

