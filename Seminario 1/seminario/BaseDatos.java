package seminario1;

import java.sql.*;
import java.sql.DriverManager;
import javax.swing.JOptionPane;


public class BaseDatos {

    String jdbcUrl = "jdbc:oracle:thin:@//oracle0.ugr.es:1521/practbd.oracle0.ugr.es";
    String usuario = "x77203307";
    String password = "x77203307"; 
    Connection conexion;
    
    public BaseDatos (){

    }
    
    public void obtenerConexion() throws SQLException{
        try{
            Class.forName("oracle.jdbc.OracleDriver"); 
            conexion = DriverManager.getConnection(jdbcUrl, usuario, password);
            //System.out.println("se ha conectado");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos");     
            //System.exit(0);
        }
    }   
    
    public void cerrarConexion(){
        
        try{
            conexion.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al desconectar de la base de datos");     
            System.exit(0);
        }

    }
    
}
