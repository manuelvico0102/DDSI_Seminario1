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
    private Opciones opciones;
    private Consultas consulta;
    private Opcion1 opcion1;
    
    public Controlador(Vista vista, BaseDatos base, InsertarPedido insert, Opciones opcion, Consultas consulta, Opcion1 opcion1){
        this.base = base;
        this.vista = vista;
        this.insert = insert;
        this.opciones = opcion;
        this.consulta = consulta;
        this.opcion1 = opcion1;
        this.vista.setControlador(this);
        this.vista.setVisible(true);
    }
    
    public void CrearTabla() throws SQLException{
        this.base.crearTabla();
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
        this.opciones.setVisible(false);
        this.opciones.setControlador(this);
        this.opciones.setVisible(true);
    }
    
    public void mostrarTablas(){
        this.vista.setVisible(false);
        this.consulta.setVisible(true);
        this.consulta.setControlador(this);
    }
    
    public void volverMenu(){
        this.vista.setVisible(true);
        this.consulta.setVisible(false);
        this.opciones.setVisible(false);
    }
    
    public boolean comprobarStock(javax.swing.JTextField cProducto, javax.swing.JTextField cantidad){
        return this.base.compruebaStock(cProducto, cantidad);
    }
    
    public void insertarDetalle(javax.swing.JTextField cProducto, javax.swing.JTextField cantidad) throws SQLException{
        this.base.insertarDetalle(cProducto, cantidad);
    }
    
    public void opcion1(){
        this.opciones.setVisible(false);
        this.opcion1.setControlador(this);
        this.opcion1.setVisible(true);
    }
    
    public void eliminarDetalles(){
        this.base.eliminarDetallesDeUnPedido();
    }
    
    public void cancelarPedido(){
        this.base.rollback();
    }
    
    public void finalizarPedido(){
        this.base.commit();
    }
}
