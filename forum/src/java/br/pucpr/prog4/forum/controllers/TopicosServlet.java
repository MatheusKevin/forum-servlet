package br.pucpr.prog4.forum.controllers;

import br.pucpr.prog4.forum.model.Topico;
import br.pucpr.prog4.forum.model.TopicoManager;
import br.pucpr.prog4.forum.model.TopicoManagerImpl;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TopicosServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int idAssunto;
        String param = request.getParameter("id");
        idAssunto = Integer.parseInt(param);
        
        List<Topico> topicos = new ArrayList<Topico>();
        TopicoManager manager = new TopicoManagerImpl();
        topicos = manager.listarPorAssunto(idAssunto);
        
        request.setAttribute("topicos", topicos);
        RequestDispatcher rd;
        rd = request.getRequestDispatcher("/WEB-INF/JSP/ListaTopicos.jsp");
        rd.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
