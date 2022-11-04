/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package seminario1;

import java.sql.SQLException;

/**
 *
 * @author carlota
 */
public class Controlador {
    private BaseDatos base;
    public Vista vista;
    private InsertarPedido insert;
    private Opciones opcion;
    private Consultas consulta;
    
    public Controlador(Vista vista, BaseDatos base, InsertarPedido insert, Opciones opcion, Consultas consulta){
        this.base = base;
        this.vista = vista;
        this.insert = insert;
        this.opcion = opcion;
        this.consulta = consulta;
        this.vista.setControlador(this);
        this.vista.setVisible(true);
    }
    
    public void CrearTabla() throws SQLException{
        this.base.crearTabla();
    }
    
    public void borrarTablas() throws SQLException{
        this.base.borrarTablas();
    }
    
    public void insertadPedido(javax.swing.JTextField cCliente, javax.swing.JTextField cPedido, javax.swing.JFormattedTextField fechaPedido) throws SQLException{
        this.base.insertarPedido(cCliente, cPedido, fechaPedido);
    }
    
    public void buscarTablaPedido(javax.swing.JTable tablePedido, String tabla) throws SQLException{
        this.base.buscarTablaPedido(tablePedido, tabla);
    }
    
    public void Desconectar(){
        this.base.cerrarConexion();
    }
    
    public void Insertar() {
        this.vista.setVisible(false);
        this.insert.setControlador(this);
        this.insert.setVisible(true);
    }
    
    public void elegirOpcion(){
        this.opcion.setVisible(false);
        this.insert.setControlador(this);
        this.opcion.setVisible(true);
    }
    
    public void mostrarTablas(){
        this.vista.setVisible(false);
        this.consulta.setVisible(true);
        this.consulta.setControlador(this);
    }
    
    public void volverMenu(){
        this.vista.setVisible(true);
        this.consulta.setVisible(false);
    }
}
