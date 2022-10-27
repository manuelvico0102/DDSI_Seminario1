package seminario1;

import java.sql.*;
import java.sql.DriverManager;
import javax.swing.JOptionPane;


public class BaseDatos {

    String jdbcUrl = "jdbc:oracle:thin:@//oracle0.ugr.es:1521/practbd.oracle0.ugr.es";
<<<<<<< HEAD
    String usuario = "x6520114";
    String password = "x6520114"; 
=======
    String usuario = "x77203307";
    String password = "x77203307"; 
>>>>>>> fd083fe2b8e277413315bc64c8c119b1968ccb63
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
