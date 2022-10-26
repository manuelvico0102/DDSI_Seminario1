
import java.sql.*;
import java.sql.DriverManager;


public class BaseDatos {
    public BaseDatos (){
a
    }
    String jdbcUrl = "jdbc:oracle:thin:@//oracle0.ugr.es:1521/practbd.oracle0.ugr.es";
    String usuario = "x6512201";
    String password = "x6512201"; 
    Connection conexion;
    
    public void obtenerConexion() throws SQLException{
        try{
            Class.forName("oracle.jdbc.OracleDriver"); 
            conexion = DriverManager.getConnection(jdbcUrl, usuario, password);
            System.out.println("se ha conectado");
        }catch(Exception e){
            System.out.println("Error al conectar con la base de datos");
        }
    }   
}
