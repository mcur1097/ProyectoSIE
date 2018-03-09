package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import conexion.Conexion;
import vo.BienVo;

public class BienDao {
	
	public BienVo consultarBienIndividual(String busqueda){
		Connection connection=null;
		Conexion miConexion=new Conexion();
		PreparedStatement statement=null;
		ResultSet result=null;
		
		BienVo miBien=null;
		
		connection=miConexion.getConnection();
		
		String consulta="SELECT * FROM bien WHERE placa="+busqueda;
		
		try{
			if(connection!=null){
				statement=connection.prepareStatement(consulta);
				
				result=statement.executeQuery();
				
				if(result.next()==true){
					miBien=new BienVo();
					miBien.setPlaca(result.getString("placa"));
					miBien.setSerialb(result.getString("serialb"));
					miBien.setNombreBien(result.getString("nombreBien"));
					miBien.setDescripcion(result.getString("descripcion"));
					miBien.setModelo(result.getString("modelo"));
					miBien.setMarca(result.getString("marca"));
					miBien.setFechaIngreso(result.getString("fechaIngreso"));
					miBien.setValor(result.getFloat("valor"));
					miBien.setAreaAm(result.getInt("areaAm"));
					miBien.setCedula(result.getInt("cedula"));
				}
				
			}
		}catch(SQLException e){
			System.out.println("Error en la consulta del area: "+e.getMessage());
		}finally {
			miConexion.desconectar();
		}
		return miBien;
	}

}
