package br.pucpr.prog4.forum.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JbdcDaoManager implements IDaoManager{
    private Connection conexao;
    private JbdcAssuntoDAO assuntoDao;

    public JbdcDaoManager() {
    }
    
    @Override
    public void iniciar() throws DaoException{
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String url;
            url = "jdbc:mysql://localhost:3306/forum";
            conexao = DriverManager.getConnection(url, "root", "root");
            conexao.setAutoCommit(false);
            assuntoDao = new JbdcAssuntoDAO(conexao);
        }catch(Exception e){
            System.out.println(e.getMessage());
            throw new DaoException("Ocorreu um erro ao conectar ao banco de dados"+
                e.getMessage());
            
        }
    }

    @Override
    public void encerrar() {
        try{
            if(!conexao.isClosed()){
                conexao.isClosed();
            }
        } catch (SQLException ex) {

        }
    }

    @Override
    public void confirmarTransacao() {
        try{
            conexao.commit();
        }catch(SQLException e){
            
        }
    }

    @Override
    public void abortarTransacao() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public AssuntoDAO getAssuntoDAO() {
        return assuntoDao;
    }
    
}
