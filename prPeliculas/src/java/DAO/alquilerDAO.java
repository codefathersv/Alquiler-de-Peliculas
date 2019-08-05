
package DAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.*;

public class alquilerDAO extends Conexion{
    
    public List<dbo_alquiler> mostrarHistorial() throws Exception{
        
        List<dbo_alquiler> lista = new ArrayList<dbo_alquiler>();
        
        try {
            this.Conectar();
            String queryS = "select a.id_alquiler, p.nombre_pelicula, c.nombre_cliente, c.apellido_cliente, a.descripcion, a.fecha_alquiler, a.fecha_entrega, a.costo, e.estado from dbo_alquiler a inner join dbo_peliculas p on p.id_pelicula = a.id_pelicula inner join dbo_clientes c on c.id_cliente = a.id_cliente inner join dbo_estado e on e.id_estado = a.id_estado order by id_alquiler;";
            PreparedStatement stm = this.getCnx().prepareStatement(queryS);
            ResultSet rs = stm.executeQuery();
            
            while(rs.next()){
                
                dbo_alquiler a = new dbo_alquiler();
                dbo_peliculas p = new dbo_peliculas();
                dbo_clientes c = new dbo_clientes();
                dbo_estado e = new dbo_estado();
                
                a.setId_alquiler(rs.getInt("id_alquiler"));
                p.setNombre_pelicula(rs.getString("nombre_pelicula"));
                a.setPelicula(p);
                c.setNombre_cliente(rs.getString("nombre_cliente"));
                c.setApellido_cliente(rs.getString("apellido_cliente"));
                a.setCliente(c);
                a.setDescripcion(rs.getString("descripcion"));
                a.setFecha_alquiler(rs.getString("fecha_alquiler"));
                a.setFecha_entrega(rs.getString("fecha_entrega"));
                a.setCosto(rs.getDouble("costo"));
                e.setEstado(rs.getString("estado"));
                a.setEstado(e);
                lista.add(a);
                
            }
        } catch (Exception e) {
            throw e;
        }finally{
            this.Desconectar();
        }
        
        return lista;
    }
    
    public void agregarAlquiler(dbo_alquiler a) throws Exception{
        
        dbo_peliculas p = a.getPelicula();
        dbo_clientes c = a.getCliente();
        dbo_estado es = a.getEstado();
        
        try {
            this.Conectar();
            String query = "insert into dbo_alquiler(id_pelicula,id_cliente,descripcion,fecha_alquiler,fecha_entrega,costo,id_estado) values(?,?,?,?,?,?,?)";
            PreparedStatement stm = this.getCnx().prepareStatement(query);
            
            stm.setInt(1, p.getId_pelicula());
            stm.setInt(2, c.getId_cliente());
            stm.setString(3, a.getDescripcion());
            stm.setString(4, a.getFecha_alquiler());
            stm.setString(5, a.getFecha_entrega());
            stm.setDouble(6, a.getCosto());
            stm.setInt(7, es.getId_estado());
            stm.executeUpdate();
            
        } catch (Exception e) {
            throw e;
        }finally{
            this.Desconectar();
        }
        
    }
    
    public void eliminarHistorial(int id) throws Exception{
        
        try{
            this.Conectar();
            String queryD = "delete from dbo_alquiler where id_alquiler = ?";
            PreparedStatement stm = this.getCnx().prepareStatement(queryD);
            stm.setInt(1, id);
            stm.executeUpdate();
        }catch(Exception e){
            throw e;
        }finally{
            this.Desconectar();
        }
        
    }
    
    public dbo_alquiler selectFila(int id) throws Exception{
        
        dbo_alquiler a = new dbo_alquiler();
        dbo_peliculas p = new dbo_peliculas();
        dbo_clientes c = new dbo_clientes();
        dbo_estado es = new dbo_estado();
        
        try {
            this.Conectar();
            String query = "select * from dbo_alquiler where id_alquiler = ?;";
            PreparedStatement stm = this.getCnx().prepareStatement(query);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            
            while(rs.next()){
                a.setId_alquiler(rs.getInt("id_alquiler"));
                p.setId_pelicula(rs.getInt("id_pelicula"));
                a.setPelicula(p);
                c.setId_cliente(rs.getInt("id_cliente"));
                a.setCliente(c);
                a.setDescripcion(rs.getString("descripcion"));
                a.setFecha_alquiler(rs.getString("fecha_alquiler"));
                a.setFecha_entrega(rs.getString("fecha_entrega"));
                a.setCosto(rs.getDouble("costo"));
                es.setId_estado(rs.getInt("id_estado"));
                a.setEstado(es);
            }
        } catch (Exception e) {
            throw e;
        }finally{
            this.Desconectar();
        }
        
        return a;
    }
    
    public void actualizarEstado(dbo_alquiler a) throws Exception{
        
        dbo_peliculas p = a.getPelicula();
        dbo_clientes c = a.getCliente();
        dbo_estado es = a.getEstado();
        
        try {
            this.Conectar();
            String updquery = "update dbo_alquiler set id_pelicula = ?, id_cliente = ?, descripcion =?, fecha_alquiler = ?, fecha_entrega =?, costo=?, id_estado = ? where id_alquiler = ?;";
            PreparedStatement stm = this.getCnx().prepareStatement(updquery);
            stm.setInt(1, p.getId_pelicula());
            stm.setInt(2, c.getId_cliente());
            stm.setString(3, a.getDescripcion());
            stm.setString(4, a.getFecha_alquiler());
            stm.setString(5, a.getFecha_entrega());
            stm.setDouble(6, a.getCosto());
            stm.setInt(7, es.getId_estado());
            stm.setInt(8, a.getId_alquiler());
            stm.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally{
            this.Desconectar();
        }

    }
    
}
