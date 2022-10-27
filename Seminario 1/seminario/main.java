package seminario1;


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

