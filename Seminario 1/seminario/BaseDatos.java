package seminario1;

import java.sql.*;
import java.sql.DriverManager;
import javax.swing.JOptionPane;


public class BaseDatos {

    String jdbcUrl = "jdbc:oracle:thin:@//oracle0.ugr.es:1521/practbd.oracle0.ugr.es";
    String usuario = "x6512201";
    String password = "x6512201"; 

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
