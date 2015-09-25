package br.pucpr.prog4.forum.model;

import br.pucpr.prog4.forum.DAO.DaoException;
import br.pucpr.prog4.forum.DAO.IDaoManager;
import br.pucpr.prog4.forum.DAO.JbdcDaoManager;
import br.pucpr.prog4.forum.DAO.TopicoDAO;
import java.util.ArrayList;
import java.util.List;

public class TopicoManagerImpl implements TopicoManager{

    public TopicoManagerImpl() {
    }

    @Override
    public void cadastrar(Topico topico) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Topico> listarPorAssunto(int idAssunto) {
        IDaoManager manager = new JbdcDaoManager();
        List<Topico> topicos = new ArrayList<Topico>();
        try{
            manager.iniciar();
            TopicoDAO dao = manager.getTopicoDAO();
            topicos = dao.obterPorAssunto(idAssunto);
            manager.encerrar();
        }catch(Exception e){
            
        }
        return topicos;
    }

    @Override
    public Topico obterTopico(int id) {
        IDaoManager manager = new JbdcDaoManager();
        Topico topico = new Topico();
        try{
            manager.iniciar();
            TopicoDAO dao = manager.getTopicoDAO();
            topico = dao.obterPorId(id);
        }catch(Exception e){
            
        }
        return topico;
    }
    
}
