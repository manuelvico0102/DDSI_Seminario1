/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package seminario1;

import javax.swing.JOptionPane;
import java.sql.*;
import java.sql.DatabaseMetaData;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Logger;
import java.util.logging.Level;
import oracle.jdbc.OracleConnection;
import oracle.jdbc.OracleResultSet;
import oracle.jdbc.OracleStatement;
import oracle.jdbc.pool.OracleDataSource;

/**
 *
 * @author carlota
 */
public class BaseDatos {
        
    String jdbcUrl = "jdbc:oracle:thin:@//oracle0.ugr.es:1521/practbd.oracle0.ugr.es";
    String usuario = "x6520114";
    String password = "x6520114"; 
    //Connection conexion;
    OracleConnection cn;
        
    public BaseDatos (){
        
    }
    
    public void obtenerConexion(){
        try{
            //Class.forName("oracle.jdbc.OracleDriver"); 
            //conexion = DriverManager.getConnection(jdbcUrl, usuario, password);
            //System.out.println("se ha conectado");
            OracleDataSource ods = new OracleDataSource();
            ods.setURL(jdbcUrl);
            ods.setUser(usuario);
            ods.setPassword(password);
            
            
            cn = (OracleConnection) ods.getConnection();
            //OracleStatement st = (OracleStatement) cn.createStatement();
            //OracleResultSet rs = (OracleResultSet) st.executeQuery("");
            
            
            DatabaseMetaData dm = cn.getMetaData();
            System.out.println("Nombre "+dm.getDriverName());
            System.out.println("Version "+dm.getDriverVersion());
            System.out.println("URL "+dm.getURL());
            System.out.println("Usuario "+dm.getUserName());
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos");     
            System.exit(0);
        }
    }   
    
    public void cerrarConexion(){
        
        try{
            cn.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al desconectar de la base de datos");     
            System.exit(0);
        }

    }
    
}
