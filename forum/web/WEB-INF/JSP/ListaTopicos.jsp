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
            <a href="novo-topico">Novo tópico</a>
        </div>
        <div>
            <c:forEach var="topico" items="${topicos}">
                Tópico: ${topico.titulo}<br />
                Autor: ${topico.autor}
                <a href="respostas?topico=${topico.id}">Acessar</a>
            </c:forEach>
        </div>
    </body>
</html>
