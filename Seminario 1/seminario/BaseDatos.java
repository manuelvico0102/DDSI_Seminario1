

import java.sql.*;
import java.sql.DriverManager;

public class BaseDatos {
    String jdbcUrl = "jdbc:oracle:thin:@//oracle0.ugr.es:1521/practbd.oracle0.ugr.es";
    String usuario = "x6520114";
    String password = "x6520114"; 
    Connection conexion;
    public BaseDatos (){

    }
    public void obtenerConexion() throws SQLException{
        try{
            System.out.println("se ha coctado");
            Class.forName("oracle.jdbc.OracleDriver"); 
            System.out.println("se ha conectado");
            conexion = DriverManager.getConnection(jdbcUrl, usuario, password);
          
        }catch(Exception e){
            System.out.println("Error al conectar con la base de datos");
        }
    }   
}

