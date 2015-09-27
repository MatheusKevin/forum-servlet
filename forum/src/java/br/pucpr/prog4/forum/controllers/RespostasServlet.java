package br.pucpr.prog4.forum.controllers;

import br.pucpr.prog4.forum.model.Resposta;
import br.pucpr.prog4.forum.model.RespostaManager;
import br.pucpr.prog4.forum.model.RespostaManagerImpl;
import br.pucpr.prog4.forum.model.Topico;
import br.pucpr.prog4.forum.model.TopicoManager;
import br.pucpr.prog4.forum.model.TopicoManagerImpl;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class RespostasServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int idTopico;
        String param = request.getParameter("topico");
        idTopico = Integer.parseInt(param);
        
        TopicoManager manager = new TopicoManagerImpl();
        Topico topico = new Topico();
        topico = manager.obterTopico(idTopico);
        
        request.setAttribute("topico", topico);
        RequestDispatcher rd;
        rd = request.getRequestDispatcher("/WEB-INF/JSP/TopicoRespostas.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Resposta resposta = new Resposta();
        String topicoParam = request.getParameter("idTopico");
        resposta.setIdTopico(Integer.parseInt(topicoParam));
        resposta.setNome(request.getParameter("nome"));
        resposta.setMensagem(request.getParameter("msg"));
        
        RespostaManager manager = new RespostaManagerImpl();
        manager.inserirEmTopico(resposta);
        
        RequestDispatcher rd;
        rd = request.getRequestDispatcher("/WEB-INF/JSP/TopicoRespostas.jsp");
        rd.forward(request, response);
    }

}
