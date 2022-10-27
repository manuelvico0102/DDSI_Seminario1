package seminario1;

<<<<<<< HEAD
public class main
{
    
    public static void main(String[ ] arg) {
      BaseDatos base = new BaseDatos();
      System.out.println("Hola Java!!!");
       try{
=======

public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Conectamos
        BaseDatos base = new BaseDatos();
        
        try{
>>>>>>> fd083fe2b8e277413315bc64c8c119b1968ccb63
            base.obtenerConexion();
        }catch(Exception e){
            System.out.println("Error al conectar con la base de datos");
        }
        
        // Preguntamos qué quiere hacer
        Vista vista = new Vista();
        Controlador controlador = new Controlador(vista, base);
    }
    
}

