
package DAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.dbo_clientes;

public class mostrarCliente extends Conexion{
    
    public List<dbo_clientes> mostrarCliente() throws Exception{
        
        List<dbo_clientes> lista = new ArrayList<dbo_clientes>();
        
        try {
            this.Conectar();
            String query = "select id_cliente, nombre_cliente, apellido_cliente from dbo_clientes";
            PreparedStatement stm = this.getCnx().prepareStatement(query);
            ResultSet rs = stm.executeQuery();
            
            while(rs.next()){
                
                dbo_clientes c = new dbo_clientes();
                
                c.setId_cliente(rs.getInt("id_cliente"));
                c.setNombre_cliente(rs.getString("nombre_cliente"));
                c.setApellido_cliente(rs.getString("apellido_cliente"));
                lista.add(c);
            }
        } catch (Exception e) {
            throw e;
        }finally{
            this.Desconectar();
        }
        
        return lista;
        
    }
    
}
