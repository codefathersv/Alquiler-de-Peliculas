
package DAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.dbo_peliculas;

public class mostrarPelicula extends Conexion{
    
    public List<dbo_peliculas> mostraPelicula() throws Exception{
        
        List<dbo_peliculas> lista = new ArrayList<dbo_peliculas>();
        
        try {
            this.Conectar();
            String query = "select id_pelicula, nombre_pelicula from dbo_peliculas";
            PreparedStatement stm = this.getCnx().prepareStatement(query);
            ResultSet rs = stm.executeQuery();
            
            while(rs.next()){
                
                dbo_peliculas p = new dbo_peliculas();
                
                p.setId_pelicula(rs.getInt("id_pelicula"));
                p.setNombre_pelicula(rs.getString("nombre_pelicula"));
                lista.add(p);
                
            }
        } catch (Exception e) {
            throw e;
        }finally{
            this.Desconectar();
        }
        
        return lista;
    }
    
}
