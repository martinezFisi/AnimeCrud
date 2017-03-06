<%-- 
    Document   : Anime
    Created on : 04-mar-2017, 16:34:41
    Author     : Sammy Guergachi <sguergachi at gmail.com>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="jq/jquery-ui.min.css" rel="stylesheet" type="text/css"/>
        
        <script src="jq/jquery-3.1.1.min.js" type="text/javascript"></script>
        <script src="jq/jquery-ui.min.js" type="text/javascript"></script>
        <script src="js/anime.js" type="text/javascript"></script>
    </head>
    <body>
        
        <table style="margin:auto; display: table; text-align: center">
            <thead>
                <tr>
                    <td>Nombre</td>
                    <td>Año Estreno</td>
                    <td>Género</td>
                    <td>Rating</td>
                    <th>
                        <a href="#" onclick="AnimeIns();"><span class="ui-icon ui-icon-plus"></span></a>
                    </th>
                    <th>
                        <a href="#" onclick="AnimeGet();"><span class="ui-icon ui-icon-pencil"></span></a>
                    </th>
                    <th>
                        <a href="#" onclick="AnimeDel();"><span class="ui-icon ui-icon-closethick"></span></a>
                    </th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="anime" items="${list}">
                    <tr>
                        <td>${anime.nombre}</td>
                        <td>${anime.anioEstreno}</td>
                        <td>${anime.genero}</td>
                        <td>${anime.rating}</td>
                        <th>
                            <input name="anime_del" type="checkbox" value="${anime.idAnime}">
                        </th>
                        <th>
                            <input name="anime_get" type="radio" value="${anime.idAnime}">
                        </th>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        
        <p style="text-align: center">
            <span id="message">${msg}</span>
        </p>
        
    </body>
</html>
