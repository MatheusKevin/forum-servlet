package br.pucpr.prog4.forum.model;

import br.pucpr.prog4.forum.DAO.AssuntoDAO;
import br.pucpr.prog4.forum.DAO.IDaoManager;
import br.pucpr.prog4.forum.DAO.JbdcAssuntoDAO;
import br.pucpr.prog4.forum.DAO.JbdcDaoManager;
import java.util.List;

public class AssuntoManagerImpl implements AssuntoManager{

    public AssuntoManagerImpl() {
    }

    @Override
    public List<Assunto> listarTodos() {
        IDaoManager manager = new JbdcDaoManager();
        List<Assunto> assuntos = null;
        try{
            manager.iniciar();
            AssuntoDAO dao = manager.getAssuntoDAO();
            assuntos = dao.obterTodos();
            manager.encerrar();
        }catch(Exception e){
            e.getMessage();
        }
        return assuntos;
    }
    
}
