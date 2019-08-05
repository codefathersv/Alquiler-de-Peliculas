
package DAO;

public class test_cnx {
    public static void main(String[] args) {
        Conexion c = new Conexion();
        try{
            c.Conectar();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
