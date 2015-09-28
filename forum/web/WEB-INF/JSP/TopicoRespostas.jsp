<%-- 
    Document   : TopicoRespostas
    Created on : 25/09/2015, 23:47:11
    Author     : Matheus
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Respostas</title>
    </head>
    <body>
        <h1>${topico.titulo}</h1>
        <div>
            <c:forEach var="resposta" items="${topico.respostas}">
                <div>
                    ${resposta.nome}<br />
                    ${resposta.mensagem}
                </div>
            </c:forEach>
            <div>
                <form action="respostas" method="POST">
                    <input type="hidden" name="idTopico" value="${topico.id}"
                    <label for="nome">Nome:</label>
                    <input type="text" name="nome" id="nome"><br />
                    <label for="msg">Mensagem:</label>
                    <textarea rows="5" cols="50" name="msg" id="msg"></textarea><br />
                    <input type="submit" value="Publicar">
                </form>
            </div>
        </div>
    </body>
</html>
