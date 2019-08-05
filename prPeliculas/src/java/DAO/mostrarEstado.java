
package DAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.dbo_estado;

public class mostrarEstado extends Conexion{
    
    public List<dbo_estado> mostrarEstado() throws Exception{
        
        List<dbo_estado> lista = new ArrayList<dbo_estado>();
        
        try {
            this.Conectar();
            String query = "select * from dbo_estado";
            PreparedStatement stm = this.getCnx().prepareStatement(query);
            ResultSet rs = stm.executeQuery();
            
            while(rs.next()){
                
                dbo_estado e = new dbo_estado();
                
                e.setId_estado(rs.getInt("id_estado"));
                e.setEstado(rs.getString("estado"));
                lista.add(e);
                
            }
        } catch (Exception e) {
            throw e;
        }finally{
            this.Desconectar();
        }
        
        return lista;
    }
    
}
