/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package seminario1;

import oracle.jdbc.pool.OracleDataSource;


/**
 *
 * @author carlota
 */
public class main {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        
        // Conectamos
        BaseDatos base = new BaseDatos();
        
        try{
            base.obtenerConexion();
        }catch(Exception e){
            System.out.println("Error al conectar con la base de datos");
        }
        
        // Preguntamos qué quiere hacer
        Vista vista = new Vista();
        Controlador controlador = new Controlador(vista, base);
    }
    
}
