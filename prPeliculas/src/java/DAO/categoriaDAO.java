
package DAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.dbo_categoria;

public class categoriaDAO extends Conexion{
    
    public List<dbo_categoria> mostrarCategoria() throws Exception{
        
        List<dbo_categoria> lista = new ArrayList<dbo_categoria>();
        
        try {
            this.Conectar();
            String query = "select * from dbo_categoria";
            PreparedStatement stm = this.getCnx().prepareStatement(query);
            ResultSet rs = stm.executeQuery();
            
            while(rs.next()){
                
                dbo_categoria c = new dbo_categoria();
                
                c.setId_categoria(rs.getInt("id_categoria"));
                c.setCategoria(rs.getString("categoria"));
                
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
