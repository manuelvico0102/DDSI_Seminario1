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
    private Vista vista;
    private InsertarPedido insert;
    
    public Controlador(Vista vista, BaseDatos base, InsertarPedido insert){
        this.base = base;
        this.vista = vista;
        this.insert = insert;
        this.vista.setControlador(this);
        this.vista.setVisible(true);
    }
    
    public void CrearTabla() throws SQLException{
        this.base.crearTabla();
    }
    
    public void Desconectar(){
        this.base.cerrarConexion();
    }
    
    public void Insertar() {
        this.vista.setVisible(false);
        this.insert.setControlador(this);
        this.insert.setVisible(true);
    }
}
