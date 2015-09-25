<%-- 
    Document   : Assuntos
    Created on : 24/09/2015, 22:29:52
    Author     : Matheus
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Assuntos</title>
    </head>
    <body>
        <h1>Assuntos</h1>
        <div>
            <ul>
                <c:forEach var="assunto" items="${assuntos}">
                    <li>
                        <a href="topicos?id=${assunto.id}">
                            ${assunto.nome}
                        </a>
                    </li>
                </c:forEach>
            </ul>
        </div>
    </body>
</html>
