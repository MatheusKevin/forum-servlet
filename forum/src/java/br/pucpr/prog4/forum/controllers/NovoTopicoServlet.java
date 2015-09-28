package br.pucpr.prog4.forum.controllers;

import br.pucpr.prog4.forum.model.Assunto;
import br.pucpr.prog4.forum.model.AssuntoManager;
import br.pucpr.prog4.forum.model.AssuntoManagerImpl;
import br.pucpr.prog4.forum.model.Topico;
import br.pucpr.prog4.forum.model.TopicoManager;
import br.pucpr.prog4.forum.model.TopicoManagerImpl;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NovoTopicoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        AssuntoManager manager = new AssuntoManagerImpl();
        List<Assunto> assuntos;
        assuntos = manager.listarTodos();
        
        request.setAttribute("assuntos", assuntos);
        RequestDispatcher rd;
        rd = request.getRequestDispatcher("/WEB-INF/JSP/TopicoForm.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Topico topico = new Topico();
        
        String idAssunto = request.getParameter("assunto");
        topico.setAutor(request.getParameter("autor"));
        topico.setTitulo(request.getParameter("titulo"));
        topico.setIdAssunto(Integer.parseInt(idAssunto));
        topico.setVisualizacoes(0);
        
        TopicoManager manager = new TopicoManagerImpl();
        manager.cadastrar(topico);
        
        response.sendRedirect("topicos?id="+idAssunto);
    }

}
