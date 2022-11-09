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
import javax.swing.table.DefaultTableModel;
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
    String usuario = "x3310000";
    String password = "x3310000";
    Connection conexion = null;
    Statement st;
    Savepoint pedido;
    
    int pedidoActual;

    public BaseDatos() {

    }

    public void obtenerConexion() {
        try {
            conexion = DriverManager.getConnection(url, usuario, password);
            if (conexion != null) {
                System.out.println("Conectado a la base de datos");
                st = conexion.createStatement();
                conexion.setAutoCommit(false);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos");
            System.exit(0);
        }
    }

    public void crearTabla() throws SQLException {

        // Borrar las tablas
        try {
            this.borrarTablas();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Las tablas no existian de antes");
        }

        // Crear la tabla
        String stock = "CREATE TABLE STOCK ("
                + " CPRODUCTO NUMBER(3) PRIMARY KEY,"
                + "CANTIDAD NUMBER(4) CHECK (CANTIDAD >= 0)"
                + ")";
        st.executeUpdate(stock);

        String pedido = "CREATE TABLE PEDIDO ("
                + " CPEDIDO NUMBER(3) PRIMARY KEY,"
                + " CPRODUCTO NUMBER(3),"
                + "FECHA_PEDIDO DATE"
                + ")";
        st.executeUpdate(pedido);

        String detallePedido = "CREATE TABLE DETALLE_PEDIDO ("
                + " CPEDIDO NUMBER(3) REFERENCES STOCK(CPRODUCTO),"
                + " CPRODUCTO NUMBER(3) REFERENCES PEDIDO(CPEDIDO),"
                + "CANTIDAD NUMBER(4) CHECK (CANTIDAD >= 0),"
                + "PRIMARY KEY(CPEDIDO, CPRODUCTO)"
                + ")";
        st.executeUpdate(detallePedido);
        
        // Añadir 10 tuplas
        this.crearDiezTuplas();

        this.commit();
    }

    public void borrarTablas() throws SQLException {
        String bdetallePedido = "DROP TABLE DETALLE_PEDIDO";
        st.execute(bdetallePedido);

        String bPedido = "DROP TABLE PEDIDO";
        st.execute(bPedido);

        String bStock = "DROP TABLE STOCK";
        st.execute(bStock);

        this.commit();
    }
    
    public void crearDiezTuplas() throws SQLException{
        String aniadeStock = "INSERT INTO STOCK VALUES('"
                + "001" + "', '"
                + "44" + "')";
        st.executeUpdate(aniadeStock);
        aniadeStock = "INSERT INTO STOCK VALUES('"
                + "002" + "', '"
                + "45" + "')";
        st.executeUpdate(aniadeStock);
        aniadeStock = "INSERT INTO STOCK VALUES('"
                + "003" + "', '"
                + "34" + "')";
        st.executeUpdate(aniadeStock);
        aniadeStock = "INSERT INTO STOCK VALUES('"
                + "004" + "', '"
                + "37" + "')";
        st.executeUpdate(aniadeStock);
        aniadeStock = "INSERT INTO STOCK VALUES('"
                + "005" + "', '"
                + "1" + "')";
        st.executeUpdate(aniadeStock);
        aniadeStock = "INSERT INTO STOCK VALUES('"
                + "006" + "', '"
                + "4" + "')";
        st.executeUpdate(aniadeStock);
         aniadeStock = "INSERT INTO STOCK VALUES('"
                + "007" + "', '"
                + "3" + "')";
        st.executeUpdate(aniadeStock);
        aniadeStock = "INSERT INTO STOCK VALUES('"
                + "008" + "', '"
                + "13" + "')";
        st.executeUpdate(aniadeStock);
        aniadeStock = "INSERT INTO STOCK VALUES('"
                + "009" + "', '"
                + "412" + "')";
        st.executeUpdate(aniadeStock);
        aniadeStock = "INSERT INTO STOCK VALUES('"
                + "010" + "', '"
                + "73" + "')";
        st.executeUpdate(aniadeStock);
    }

    public void insertarPedido(javax.swing.JTextField cCliente, javax.swing.JTextField cPedido, javax.swing.JFormattedTextField fechaPedido) throws SQLException {
        String aniadePedido = "INSERT INTO PEDIDO VALUES('"
                + cPedido.getText() + "', '"
                + cCliente.getText() + "', '"
                + fechaPedido.getText() + "')";
        st.executeUpdate(aniadePedido);
        
        pedidoActual = Integer.parseInt(cPedido.getText());
        

        pedido = conexion.setSavepoint();
    }

    public void buscarTablaPedido(javax.swing.JTable tablePedido, String tabla) throws SQLException {
        DefaultTableModel modelo = (DefaultTableModel) tablePedido.getModel();

        //Borramos las filas que hayan escritas
        int filas = modelo.getRowCount();
        for (int i = 0; i < filas; i++) {
            modelo.removeRow(0);
        }

        ResultSet rs = st.executeQuery("SELECT * FROM " + tabla);

        if (tabla == "PEDIDO" || tabla == "DETALLE_PEDIDO") {
            while (rs.next()) {
                String[] fila = {rs.getString(1), rs.getString(2), rs.getString(3)};
                modelo.addRow(fila);
            }
        } else if (tabla == "STOCK") {
            while (rs.next()) {
                String[] fila = {rs.getString(1), rs.getString(2)};
                modelo.addRow(fila);
            }
        }
    }

    //Las opciones 1,2,3 y 4 no estan terminadas
    //Opcion 1.

    //Comprueba si hay stock, si hay actualiza stock y devuelve true, en caso contrario false
    public boolean compruebaStock(javax.swing.JTextField Cprod, javax.swing.JTextField cantidad) {
        boolean hayStock = false;
        int cant = Integer.parseInt(cantidad.getText());
        
        String salida = "SELECT * FROM STOCK WHERE CPRODUCTO = " + Cprod.getText();
        try {
            ResultSet res = st.executeQuery(salida);
            res.next();
            
            //int cantida = Integer.parseInt(res.getString(2));

            if (res.getInt(2) >= cant) {
                hayStock = true;
                cant = res.getInt(2) - cant;
            }
            res.close();
        } catch (SQLException ex) {
            Logger.getLogger(BaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (hayStock) {
            String actualiza = "update STOCK set CANTIDAD='" + cant + "' "
                    + "WHERE CPRODUCTO = '" + Cprod.getText() + "'";
            try {
                st.execute(actualiza);
            } catch (SQLException ex) {
                Logger.getLogger(BaseDatos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return hayStock;
    }
    
    
    public void insertarDetalle(javax.swing.JTextField cProducto, javax.swing.JTextField cantidad) throws SQLException {
        String aniadePedido = "INSERT INTO DETALLE_PEDIDO VALUES('"
                + pedidoActual + "', '"
                + cProducto.getText() + "', '"
                + cantidad.getText() + "')";
        st.executeUpdate(aniadePedido);

        pedido = conexion.setSavepoint();
    }


    //Opcion 2 de Dar de alta un nuevo pedido
    public void eliminarDetallesDeUnPedido() {
        String borrarDetalles = "DELETE FROM DETALLE_PEDIDO"
                + " WHERE CPEDIDO = '" + pedidoActual + "'";
        try {
            st.execute(borrarDetalles);
        } catch (SQLException ex) {
            Logger.getLogger(BaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            conexion.rollback(pedido);
        } catch (SQLException ex) {
            Logger.getLogger(BaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //La opcion 3 debe ser un rollback
    public void rollback() {
        try {
            conexion.rollback();
        } catch (SQLException ex) {
            Logger.getLogger(BaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //La opcion 4 debe ser un commit
    public void commit() {
        try {
            conexion.commit();
        } catch (SQLException ex) {
            Logger.getLogger(BaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void cerrarConexion() {

        try {
            st.close();
            conexion.close();
            System.out.println("Se ha desconectado correctamente");
            System.exit(0);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al desconectar de la base de datos");
            System.exit(0);
        }

    }

}
