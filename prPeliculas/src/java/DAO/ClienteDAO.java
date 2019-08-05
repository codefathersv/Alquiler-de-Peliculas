
package DAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.dbo_clientes;

public class ClienteDAO extends Conexion{
    
    public List<dbo_clientes> mostrarClientes() throws Exception{
        
        List<dbo_clientes> lista = new ArrayList<dbo_clientes>();
        
        try{
            this.Conectar();
            String consultaS = "select * from dbo_clientes";
            PreparedStatement stm = this.getCnx().prepareStatement(consultaS);
            ResultSet rs = stm.executeQuery();
            
            while(rs.next()){
                dbo_clientes c = new dbo_clientes();
                c.setId_cliente(rs.getInt("id_cliente"));
                c.setNombre_cliente(rs.getString("nombre_cliente"));
                c.setApellido_cliente(rs.getString("apellido_cliente"));
                c.setDireccion(rs.getString("direccion"));
                c.setCorreo(rs.getString("correo"));
                c.setNum_celular(rs.getString("num_celular"));
                lista.add(c);
            }
        }catch(Exception ex){
            throw ex;
        }finally{
            this.Desconectar();
        }
        
        return lista;
    }
    
    public void agregarCliente(dbo_clientes c) throws Exception{
        
        try{
            this.Conectar();
            String consultaI = "insert into dbo_clientes(nombre_cliente,apellido_cliente,direccion,correo,num_celular) values (?,?,?,?,?)";
            PreparedStatement stm = this.getCnx().prepareStatement(consultaI);
            stm.setString(1, c.getNombre_cliente());
            stm.setString(2, c.getApellido_cliente());
            stm.setString(3, c.getDireccion());
            stm.setString(4, c.getCorreo());
            stm.setString(5, c.getNum_celular());
            stm.executeUpdate();
        }catch(Exception ex){
            throw ex;
        }finally{
            this.Desconectar();
        }
        
    }
    
    public void eliminarCliente(int id) throws Exception{
        
        try{
            this.Conectar();
            String consultaD = "delete from dbo_clientes where id_cliente = ?";
            PreparedStatement stm = this.getCnx().prepareStatement(consultaD);
            stm.setInt(1, id);
            stm.executeUpdate();
        }catch(Exception ex){
            throw ex;
        }finally{
            this.Desconectar();
        }
        
    }
    
    public dbo_clientes filaCliente(int id) throws Exception{
        
        dbo_clientes c = new dbo_clientes();
        
        try {
            this.Conectar();
            String query = "select * from dbo_clientes where id_cliente = ?;";
            PreparedStatement stm = this.getCnx().prepareStatement(query);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            
            while(rs.next()){
                c.setId_cliente(rs.getInt("id_cliente"));
                c.setNombre_cliente(rs.getString("nombre_cliente"));
                c.setApellido_cliente(rs.getString("apellido_cliente"));
                c.setDireccion(rs.getString("direccion"));
                c.setCorreo(rs.getString("correo"));
                c.setNum_celular(rs.getString("num_celular"));
            }
        } catch (Exception ex) {
            throw ex;
        }finally{
            this.Desconectar();
        }
        return c;
    }
    
    public void actualizarCliente(dbo_clientes c) throws Exception{
        
        try {
            this.Conectar();
            String queryupd = "update dbo_clientes set nombre_cliente =? , apellido_cliente =? , direccion =? , correo =? , num_celular =? where id_cliente = ?;";
            PreparedStatement stm = this.getCnx().prepareStatement(queryupd);
            
            stm.setString(1, c.getNombre_cliente());
            stm.setString(2, c.getApellido_cliente());
            stm.setString(3, c.getDireccion());
            stm.setString(4, c.getCorreo());
            stm.setString(5, c.getNum_celular());
            stm.setInt(6, c.getId_cliente());
            stm.executeUpdate();
            
        } catch (Exception ex) {
            throw ex;
        } finally{
            this.Desconectar();
        }
    }

    
}
