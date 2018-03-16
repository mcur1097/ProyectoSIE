package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.faces.bean.SessionScoped;

import conexion.Conexion;
import vo.Area;
@SessionScoped
public class AreaDao {
	
	Area miArea=new Area();
	
	public String agregarArea(Area miArea){
		String resultado="";
		Connection connection=null;
		Conexion conexion=new Conexion();
		PreparedStatement preStatement=null;
		
		connection=conexion.getConnection();
		String consulta="INSERT INTO area(nombreArea,tipoArea) VALUES (?,?);";
		
		try{
			preStatement=connection.prepareStatement(consulta);
			preStatement.setString(1, miArea.getNombreArea());
			preStatement.setString(2, miArea.getTipoArea());
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
					miArea.setCodigoArea(result.getInt("codigoArea"));
					miArea.setNombreArea(result.getString("nombreArea"));
					miArea.setTipoArea(result.getString("tipoArea"));
					listaArea.add(miArea);
				}
				
				/*for (int i = 0; i < listaArea.size(); i++) {
					System.out.println("Codigo: "+listaArea.get(i).getCodigoArea());
					System.out.println("Nombre: "+listaArea.get(i).getNombreArea());
					System.out.println("Tipo: "+listaArea.get(i).getTipoArea());
				}*/
				
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
		System.out.println("eeeeeeeeeeees");
		connection=miConexion.getConnection();
		try{
			System.out.println("entr");
			String consulta="UPDATE area SET nombreArea=?, tipoArea=? where codigoArea=?;";
			PreparedStatement preStatement=connection.prepareStatement(consulta);
			preStatement.setString(1, miArea.getNombreArea());
			preStatement.setString(2, miArea.getTipoArea());
			preStatement.setInt(3, miArea.getCodigoArea());
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
			String sentencia="DELETE FROM area WHERE codigoArea=?";
			
			PreparedStatement statement=connection.prepareStatement(sentencia);
			statement.setInt(1, miArea.getCodigoArea());
			
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
	
	public Area consultarAreaIndividual(String nombreArea){
		Connection connection=null;
		Conexion miConexion=new Conexion();
		PreparedStatement statement=null;
		ResultSet result=null;
		
		Area miArea=null;
		
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
	}

}

