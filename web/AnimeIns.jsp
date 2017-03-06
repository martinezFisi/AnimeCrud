<%-- 
    Document   : AnimeIns
    Created on : 04-mar-2017, 19:36:57
    Author     : Sammy Guergachi <sguergachi at gmail.com>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form style="margin: auto; display: table; width: 30%" action="Anime">
            
            <input hidden="hidden" name="accion" value="INS">
            
            <fieldset>
                <legend>Anime</legend>
                <table>
                    
                    <input hidden="hidden" name="id" value="${anime.idAnime}">
                    
                    <tr>
                        <td>Nombre</td>
                        <td>
                            <input name="nombre" type="text" value="${anime.nombre}">
                        </td>
                    </tr>
                    <tr>
                        <td>Año de estreno</td>
                        <td>
                            <input name="anioEstreno" type="text" value="${anime.anioEstreno}">
                        </td>
                    </tr>
                    <tr>
                        <td>Género</td>
                        <td>
                            <input name="genero" type="text" value="${anime.genero}"> 
                        </td>
                    </tr>
                    <tr>
                        <td>Rating</td>
                        <td>
                            <input name="rating" type="number" min="1" max="5" value="${anime.rating}">
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <input type="submit" value="Insertar">
                        </td>
                    </tr>
                </table>
            </fieldset>
        </form>
        
        <p style="text-align: center">
            <span>${msg}</span>
        </p>
        
        <p style="text-align: center">
            <a href="index.jsp">Cancelar</a>
        </p>
        
    </body>
</html>
