
package DAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.dbo_clasificacion;

public class clasificacionDAO extends Conexion{
    
    public List<dbo_clasificacion> mostrarClasificacion() throws Exception{
        
        List<dbo_clasificacion> lista = new ArrayList<dbo_clasificacion>();
        
        try {
            this.Conectar();
            String query = "select * from dbo_clasificacion";
            PreparedStatement stm = this.getCnx().prepareStatement(query);
            ResultSet rs = stm.executeQuery();
            
            while(rs.next()){
                dbo_clasificacion c = new dbo_clasificacion();
                
                c.setId_clasificacion(rs.getInt("id_clasificacion"));
                c.setClasificacion(rs.getString("clasificacion"));
                
                lista.add(c);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.Desconectar();
        }
        
        return lista;
    }
    
}
