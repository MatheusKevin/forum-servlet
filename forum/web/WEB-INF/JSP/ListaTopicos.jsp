<%-- 
    Document   : ListaTopicos
    Created on : 25/09/2015, 12:55:09
    Author     : Matheus
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Topicos</title>
    </head>
    <body>
        <h1>Tópicos</h1>
        <div>
            <c:forEach var="topico" items="${topicos}">
                Tópico: ${topicos.titulo}<br />
                Autor: ${topicos.autor}
                <a href="respostas?topico=${topicos.id}">Acessar</a>
            </c:forEach>
        </div>
    </body>
</html>
