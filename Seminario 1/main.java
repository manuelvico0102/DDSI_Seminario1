package Seminario1;


public class main
{
    
    public static void main(String[ ] arg) {
      BaseDatos base = new BaseDatos();
      System.out.println("Hola Java");
       try{
            base.obtenerConexion();
        }catch(Exception e){
            System.out.println("Error al conectar con la base de datos");
        }
      
  
    }
}


