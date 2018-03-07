package conexion;

import java.sql.*;

public class Conexion {
 private String nombreBd="Novedades";
 private String usuario="root";
 private String password="";
 private String url="jdbc:mysql://localhost:3306/"+nombreBd;
 
 Connection conn=null;
 
 public Conexion() {
   
	 try{
	   
	  Class.forName("com.mysql.jdbc.Driver");
	  
	  conn=DriverManager.getConnection(url,usuario,password);
	  
	  if(conn!=null){
		  System.out.println();
	  }else{
		  System.out.println("Error, No se pudo conectar a la BD: "+nombreBd);
	  }
   }
    catch (ClassNotFoundException e){
    	System.out.println("Ocurre una ClassNotFoundException: "+e.getMessage());
    	
  }catch (SQLException e){
	  System.out.println("Ocurre una SQLException: "+nombreBd);
	  System.out.println("Verifique que MySql este encendido");
  }
 }

 public Connection getConnection(){
	 return conn;
 }
 public void desconectar(){
	 conn=null;
 }
 
}
