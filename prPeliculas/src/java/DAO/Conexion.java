
package DAO;
import java.sql.DriverManager;
import java.sql.Connection;

public class Conexion {
    
    private static String bd = "bd_peliculas";
    private static String user = "root";
    private static String pass = "admin";
    private static String ruta = "jdbc:mysql://localhost/"+bd;
    
    Connection cnx;

    public Connection getCnx() {
        return cnx;
    }

    public void setCnx(Connection cnx) {
        this.cnx = cnx;
    }
    
    public void Conectar() throws Exception{
        
        try{
            
            Class.forName("com.mysql.jdbc.Driver");
            this.cnx = DriverManager.getConnection(ruta, user, pass);
            
            if (this.cnx != null) {
                System.out.println("Conexion Exitosa");
            } else {
                System.out.println("Error al conectarse");
            }
            
        }catch(Exception ex){
            throw ex;
        }
        
    }
    
    public void Desconectar() throws Exception{
        
        try{
            
            if (this.cnx != null) {
                if (this.cnx.isClosed() != true) {
                    this.cnx.close();
                }
            }
            
        }catch(Exception ex){
            throw ex;
        }
        
    }
    
}
