<%-- 
    Document   : TopicoForm
    Created on : 27/09/2015, 17:09:38
    Author     : Matheus
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Novo Topico</title>
    </head>
    <body>
        <h1>Novo Tópico</h1>
        <form action="novo-topico" method="POST">
            <label for="autor">Seu Nome:</label><input type="text" name="autor" id="autor">
            <label for="titulo">Título:</label>
            <textarea rows="3" cols="30" name="titulo" id="titulo"></textarea>
            <label for="assunto">Assunto:</label>
            <select id="assunto" name="assunto">
                <c:forEach var="assunto" items="${assuntos}">
                    <option value="${assunto.id}">${assunto.nome}</option>
                </c:forEach>
            </select>
            <input type="submit" value="Publicar">
        </form>
    </body>
</html>