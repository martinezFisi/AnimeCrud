
package dao;

import dto.Anime;
import java.util.List;

public interface DaoAnime {
    
    //AnimeIns inserta
    public String AnimeIns(Anime anime);
    
    //AnimeDel podrá borrar varios animes a la vez
    public String AnimeDel(List<Integer> ids);
    
    //AnimeGet devuelve un objeto Anime 
    public Anime AnimeGet(Integer id);
    
    //AnimeUpd actualiza ese objeto Anime y lo registra en bd
    public String AnimeUpd(Anime anime);
    
    //AnimeQry lista todos los animes
    public List<Anime> AnimeQry();
    
    //Devuelve el mensaje de error ocurrido
    public String getMessage();
}
