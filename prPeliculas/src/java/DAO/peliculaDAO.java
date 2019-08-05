
package DAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.dbo_categoria;
import model.dbo_clasificacion;
import model.dbo_clientes;
import model.dbo_peliculas;

public class peliculaDAO extends Conexion{
    
    public List<dbo_peliculas> mostrarPeliculas() throws Exception{
        
        List<dbo_peliculas> lista = new ArrayList<dbo_peliculas>();
        
        try {
            this.Conectar();
            String queryM = "select p.id_pelicula, p.nombre_pelicula, p.sinopsis, c.clasificacion, ca.categoria, p.age_estreno from dbo_peliculas p inner join dbo_clasificacion c on c.id_clasificacion = p.id_clasificacion inner join dbo_categoria ca on ca.id_categoria = p.id_categoria order by id_pelicula;";
            PreparedStatement stm = this.getCnx().prepareStatement(queryM);
            
            ResultSet rs = stm.executeQuery();
            
            while(rs.next()){
                
                dbo_peliculas p = new dbo_peliculas();
                dbo_clasificacion c = new dbo_clasificacion();
                dbo_categoria ca = new dbo_categoria();
                
                p.setId_pelicula(rs.getInt("id_pelicula"));
                p.setNombre_pelicula(rs.getString("nombre_pelicula"));
                p.setSinopsis(rs.getString("sinopsis"));
                c.setClasificacion(rs.getString("clasificacion"));
                p.setClasificacion(c);
                ca.setCategoria(rs.getString("categoria"));
                p.setCategoria(ca);
                p.setAge_estreno(rs.getInt("age_estreno"));
                lista.add(p);
                
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            this.Desconectar();
        }
        
        return lista;
    }
    
    public void agregarPelicula(dbo_peliculas p) throws Exception{
        
        dbo_clasificacion c = p.getClasificacion();
        dbo_categoria ca = p.getCategoria();
        
        try {
            this.Conectar();
            String queryI = "insert into dbo_peliculas(nombre_pelicula,sinopsis,id_clasificacion,id_categoria,age_estreno) values(?,?,?,?,?);";
            PreparedStatement stm = this.getCnx().prepareStatement(queryI);
            stm.setString(1, p.getNombre_pelicula());
            stm.setString(2, p.getSinopsis());
            stm.setInt(3, c.getId_clasificacion());
            stm.setInt(4, ca.getId_categoria());
            stm.setInt(5, p.getAge_estreno());
            stm.executeUpdate();
            
        } catch (Exception e) {
            throw e;
        } finally {
            this.Desconectar();
        }
        
    }
        
    public void eliminarPelicula(int id) throws Exception{
        
        try {
            this.Conectar();
            String queryD = "delete from dbo_peliculas where id_pelicula=?";
            PreparedStatement stm = this.getCnx().prepareStatement(queryD);
            stm.setInt(1, id);
            stm.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.Desconectar();
        }
        
    }
    
    public dbo_peliculas filaPelicula(int id) throws Exception{
        
        dbo_peliculas p = new dbo_peliculas();
        dbo_clasificacion cl = new dbo_clasificacion();
        dbo_categoria ca = new dbo_categoria();
        
        try {
            this.Conectar();
            String queryfila="select * from dbo_peliculas where id_pelicula = ?;";
            PreparedStatement stm = this.getCnx().prepareStatement(queryfila);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            
            while(rs.next()){
                
                p.setId_pelicula(rs.getInt("id_pelicula"));
                p.setNombre_pelicula(rs.getString("nombre_pelicula"));
                p.setSinopsis(rs.getString("sinopsis"));
                cl.setId_clasificacion(rs.getInt("id_clasificacion"));
                p.setClasificacion(cl);
                ca.setId_categoria(rs.getInt("id_categoria"));
                p.setCategoria(ca);
                p.setAge_estreno(rs.getInt("age_estreno"));
                
            }
        } catch (Exception e) {
            throw e;
        } finally {
            this.Desconectar();
        }
        
        return p;
        
    }
    
    public void actualizarPelicula(dbo_peliculas p) throws Exception{
        
        dbo_clasificacion cl = p.getClasificacion();
        dbo_categoria ca = p.getCategoria();
        
        try {
            this.Conectar();
            String queryA = "update dbo_peliculas set nombre_pelicula =? , sinopsis =? , id_clasificacion =? , id_categoria =? , age_estreno =? where id_pelicula = ?;";
            PreparedStatement stm = this.getCnx().prepareStatement(queryA);
            stm.setString(1, p.getNombre_pelicula());
            stm.setString(2, p.getSinopsis());
            stm.setInt(3, cl.getId_clasificacion());
            stm.setInt(4, ca.getId_categoria());
            stm.setInt(5, p.getAge_estreno());
            stm.setInt(6, p.getId_pelicula());
            stm.executeUpdate();
            
        } catch (Exception e) {
            throw e;
        }finally{
            this.Desconectar();
        }
        
    }
    
}
