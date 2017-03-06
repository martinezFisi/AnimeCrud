
package web.servlet;

import dao.DaoAnime;
import dao.impl.DaoAnimeImpl;
import dto.Anime;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sun.rmi.server.Dispatcher;

@WebServlet(name = "AnimeServlet", urlPatterns = {"/Anime"})
public class AnimeServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String accion = request.getParameter("accion");
        String target = "index.jsp";
        String result = null;
        DaoAnime daoAnime = null;
        Anime anime = null;
        
        switch(accion){
            case "QRY"://Solicitado desde index.jsp
                daoAnime = new DaoAnimeImpl();
                //Lista de animes registrados en bd
                List<Anime> list = daoAnime.AnimeQry();
                
                //Si la lista esta llena
                if(list != null){
                   request.setAttribute("list", list);
                }
                else{
                   result = daoAnime.getMessage();
                }
                
                //Redirigimos a AnimeQry.jsp
                target = "AnimeQry.jsp";
                
                break;
                
            case "INS"://Solicitado desde AnimeIns.jsp
                daoAnime = new DaoAnimeImpl();
                anime = new Anime();
                anime.setNombre(request.getParameter("nombre"));
                anime.setAnioEstreno(request.getParameter("anioEstreno"));
                anime.setGenero(request.getParameter("genero"));
                anime.setRating(Integer.parseInt(request.getParameter("rating")));
            
                result = daoAnime.AnimeIns(anime);
                
                if(result != null)
                {
                    //Si hay error redirigimos a la misma página
                    target = "AnimeIns.jsp";
                }
                break;
                
            case "DEL"://Solicitado desde AnimeQry.jsp
                daoAnime = new DaoAnimeImpl();
                List<Integer> ids = new LinkedList();
                String sb = request.getParameter("ids");

                StringTokenizer st = new StringTokenizer(sb,",");
                
                while(st.hasMoreTokens()){
                    ids.add( Integer.parseInt(st.nextToken()) );
                }
                
                result = daoAnime.AnimeDel(ids);
                
                if(result != null){
                    target = "AnimeQry.jsp";
                }
                
                break;
                
            case "GET":
                daoAnime = new DaoAnimeImpl();
                Integer id = Integer.parseInt(request.getParameter("id"));
                System.out.println("Id: "+id);
                anime = daoAnime.AnimeGet(id);
                
                if(anime == null){
                    System.out.println("Anime null");
                    result = daoAnime.getMessage();
                    System.out.println("Error: "+result);
                    target = "AnimeQry.jsp";
                } else {
                    System.out.println("Anime no null");
                    target = "AnimeIns.jsp";
                }
                
                break;
                
            default:
                result = "Petición no valida";
            
        }
        
        if(result != null){
            request.setAttribute("msg", result);
        }
        
        //Redirección hacia el target(por defecto index.jsp), pasamos el request y response
        RequestDispatcher dispatcher = request.getRequestDispatcher(target);
        dispatcher.forward(request, response);
        
        
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
}
