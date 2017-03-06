

package dao.impl;

import dao.DaoAnime;
import dto.Anime;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import sql.ConectDb;

public class DaoAnimeImpl implements DaoAnime{

    //ConectDb
    private ConectDb db;
    //String sql
    private StringBuilder sql;
    //Message error
    private String message;

    public DaoAnimeImpl() {
        db = new ConectDb();
        sql = new StringBuilder();
    }
    
    @Override
    public List<Anime> AnimeQry() {
        List<Anime> list = null;
        sql.delete(0, sql.length())
                .append("SELECT ")
                .append("idAnime, ")
                .append("nombre, ")
                .append("anioEstreno, ")
                .append("genero, ")
                .append("rating ")
                .append("FROM ")
                .append("anime ");      
        
        try(Connection cn = db.getConnection();
                PreparedStatement ps = cn.prepareStatement(sql.toString());
                ResultSet rs = ps.executeQuery();
                ){
        
            list = new LinkedList<>();
            
            while(rs.next()){
                Anime anime = new Anime();
                anime.setIdAnime(rs.getInt(1));
                anime.setNombre(rs.getString(2));
                anime.setAnioEstreno(rs.getString(3));
                anime.setGenero(rs.getString(4));
                anime.setRating(rs.getInt(5));
                
                list.add(anime);
            }
            
        }catch(SQLException e){
            message = e.getMessage();
        }
        
        return list;
    }
    
    @Override
    public String AnimeIns(Anime anime) {
        
        sql.delete(0, sql.length())
                .append("INSERT INTO anime2 (")
                .append("nombre,")
                .append("anioEstreno,")
                .append("genero,")
                .append("rating")
                .append(") VALUES(?,?,?,?) ");
                
        try(Connection cn = db.getConnection();
            PreparedStatement ps = cn.prepareStatement(sql.toString());
                ){
            
            //Ingresar parámetros
            ps.setString(1, anime.getNombre());
            ps.setString(2, anime.getAnioEstreno());
            ps.setString(3, anime.getGenero());
            ps.setInt(4, anime.getRating());
            
            //Si se ingresaron filas devuelve 1
            int rs = ps.executeUpdate();
            
            if(rs == 0){
                throw new SQLException("0 filas afectadas");
            }
            
        } catch(SQLException e){
            message = e.getMessage();
        }
        
        return message;
    }

    @Override
    public String AnimeDel(List<Integer> ids) {
        sql.delete(0, sql.length())
                .append("DELETE FROM anime WHERE idanime = ?");
        
        try (Connection cn = db.getConnection();
             PreparedStatement ps = cn.prepareStatement(sql.toString());
                ){
        
            //Deshabilitar autocommit
            cn.setAutoCommit(false);
            
            boolean ok = true;
            
            //Recorrer los ids
            for(Integer id : ids){
                ps.setInt(1, id);
                
                //Si se eliminaron filas devuelve 1
                int rs = ps.executeUpdate();
                
                if(rs == 0){
                    ok = false;
                    message = "Id " + id + " no encontrado";
                    break;
                }
            }
            
            if(ok == true){
                cn.commit();
            }
            else{
                cn.rollback();
            }
            
            cn.setAutoCommit(true);
            
        } catch (SQLException e){
            message = e.getMessage();
        } 
        
        return message;
    }

    @Override
    public Anime AnimeGet(Integer id) {
        Anime anime = null;
        
        sql.delete(0, sql.length())
                .append("SELECT ")
                .append("idAnime, ")
                .append("nombre, ")
                .append("anioEstreno, ")
                .append("genero, ")
                .append("rating ")
                .append("FROM anime WHERE id = ?");
        
        try (Connection cn = db.getConnection();
             PreparedStatement ps = cn.prepareStatement(sql.toString());
                ){
            
            ps.setInt(1, id);
            
            try (ResultSet rs = ps.executeQuery()){
                
                if(rs.next()){
                    anime = new Anime();
                    anime.setIdAnime(rs.getInt(1));
                    anime.setNombre(rs.getString(2));
                    anime.setAnioEstreno(rs.getString(2));
                    anime.setGenero(rs.getString(4));
                    anime.setRating(rs.getInt(5));
                }
                
            } catch(SQLException e) {
                message = e.getMessage();
            }
            
            
        } catch (SQLException e){
            message = e.getMessage();
        }
        
        return anime;
    }

    @Override
    public String AnimeUpd(Anime anime) {
        return null;
    }

    @Override
    public String getMessage() {
        return null;
    }

}
