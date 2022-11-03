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
import seminario1.InsertarPedido;
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
            OracleDataSource ods = new OracleDataSource();
            ods.setURL(jdbcUrl);
            ods.setUser(usuario);
            ods.setPassword(password);
            
            cn = (OracleConnection) ods.getConnection();
         
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
    
    public void crearTabla() throws SQLException{
        //b
        OracleStatement st = (OracleStatement) cn.createStatement();

        // Crear la tabla
        String stock = "CREATE TABLE STOCK ("
                + " CPRODUCTO CHAR(3) PRIMARY KEY,"
                +  "CANTIDAD NUMBER(4) CHECK (CANTIDAD >= 0)"
                + ")";
        st.executeUpdate(stock);
        
        String pedido = "CREATE TABLE PEDIDO ("
                + " CPEDIDO CHAR(3) PRIMARY KEY,"
                + " CPRODUCTO CHAR(3),"
                +  "FECHA_PEDIDO DATE"
                + ")";
        st.executeUpdate(pedido);
        
        String detallePedido = "CREATE TABLE DETALLE_PEDIDO ("
                + " CPEDIDO CHAR(3) REFERENCES STOCK(CPRODUCTO),"
                + " CPRODUCTO CHAR(3) REFERENCES PEDIDO(CPEDIDO),"
                + "CANTIDAD NUMBER(4) CHECK (CANTIDAD >= 0),"
                + "PRIMARY KEY(CPEDIDO, CPRODUCTO)"
                + ")";
        st.executeUpdate(detallePedido);
        // Añadir 10 tuplas
    
    }
    
    public void insertarPedido(javax.swing.JTextField cCliente, javax.swing.JTextField cPedido, javax.swing.JFormattedTextField fechaPedido) throws SQLException{
        //Si las tablas ya estan creadas por algun motivo no ejecuta
        //En cambio si creas las tablas y luego añades funciona
        try {
            OracleStatement st = (OracleStatement) cn.createStatement();
            String aniadePedido = "INSERT INTO PEDIDO VALUES('"+cPedido.getText()+"', '"+cCliente.getText()+"', '"+fechaPedido.getText()+"')";
            st.executeUpdate(aniadePedido);
            JOptionPane.showMessageDialog(null, "Pedio añadido");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al añadir el pedido");     
        }
    }
    
    public void cerrarConexion(){
        
        try{
            cn.close();
            System.out.println("Se ha desconectado correctamente");
            System.exit(0);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al desconectar de la base de datos");     
            System.exit(0);
        }

    }
    
}