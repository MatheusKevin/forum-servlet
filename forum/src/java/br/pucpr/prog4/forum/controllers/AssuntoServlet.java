package br.pucpr.prog4.forum.controllers;

import br.pucpr.prog4.forum.model.Assunto;
import br.pucpr.prog4.forum.model.AssuntoManager;
import br.pucpr.prog4.forum.model.AssuntoManagerImpl;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Matheus
 */
public class AssuntoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        AssuntoManager manager = new AssuntoManagerImpl();
        List<Assunto> assuntos;
        assuntos = manager.listarTodos();
        
        request.setAttribute("assuntos", assuntos);
        RequestDispatcher rd;
        rd = request.getRequestDispatcher("/WEB-INF/JSP/Assuntos.jsp");
        rd.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}
