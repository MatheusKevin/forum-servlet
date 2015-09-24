package br.pucpr.prog4.forum.DAO;

public interface IDaoManager {
    
    void iniciar();
    void encerrar();
    void confirmarTransacao();
    void abortarTransacao();
    AssuntoDAO getAssuntoDAO();
}
