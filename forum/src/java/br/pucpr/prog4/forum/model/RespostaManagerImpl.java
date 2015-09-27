package br.pucpr.prog4.forum.model;

import br.pucpr.prog4.forum.DAO.IDaoManager;
import br.pucpr.prog4.forum.DAO.JbdcDaoManager;
import br.pucpr.prog4.forum.DAO.RespostaDAO;

public class RespostaManagerImpl implements RespostaManager{

    public RespostaManagerImpl() {
    }
    
    @Override
    public void inserirEmTopico(Resposta resposta) {
        IDaoManager manager = new JbdcDaoManager();
        try{
            manager.iniciar();
            RespostaDAO dao = manager.getRespostaDAO();
            dao.inserir(resposta);
            manager.confirmarTransacao();
            manager.encerrar();
        }catch(Exception ex){
            manager.abortarTransacao();
            manager.encerrar();
        }
    }    
}
