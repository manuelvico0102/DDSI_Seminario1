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
        
    //String url = "jdbc:oracle:thin:@//oracle0.ugr.es:1521/practbd.oracle0.ugr.es";
    String url = "jdbc:oracle:thin:@oracle0.ugr.es:1521/practbd.oracle0.ugr.es";
    String usuario = "x6520114";
    String password = "x6520114"; 
    Connection conexion = null;
    Statement st;
        
    public BaseDatos (){
        
    }
    
    public void obtenerConexion(){
        try{
            conexion = DriverManager.getConnection(url,usuario,password);
            if(conexion != null){
                System.out.println("Conectado a la base de datos");
                st = conexion.createStatement();
                conexion.setAutoCommit(false);
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos");     
            System.exit(0);
        }
    }
    
    public void crearTabla() throws SQLException{

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
        
        try{
            conexion.commit();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Error al hacer commit");
        }
    }
    
    public void borrarTablas() throws SQLException{
        String bdetallePedido = "DROP TABLE DETALLE_PEDIDO";
        st.execute(bdetallePedido);
        
        String bPedido = "DROP TABLE PEDIDO";
        st.execute(bPedido);
        
        String bStock = "DROP TABLE STOCK";
        st.execute(bStock);
        
        conexion.commit();
    }
    
    public void insertarPedido(javax.swing.JTextField cCliente, javax.swing.JTextField cPedido, javax.swing.JFormattedTextField fechaPedido) throws SQLException{
        String aniadePedido = "INSERT INTO PEDIDO VALUES('"
                                +cPedido.getText()+"', '"
                                +cCliente.getText()+"', '"
                                +fechaPedido.getText()+"')";
        st.executeUpdate(aniadePedido);
        conexion.commit();
    }
    
   
    
    public void cerrarConexion(){
        
        try{
            st.close();
            conexion.close();
            System.out.println("Se ha desconectado correctamente");
            System.exit(0);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al desconectar de la base de datos");     
            System.exit(0);
        }

    }
    
}