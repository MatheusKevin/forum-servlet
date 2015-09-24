/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.pucpr.prog4.forum.DAO;

import br.pucpr.prog4.forum.model.Assunto;
import java.sql.Connection;
import java.util.List;

/**
 *
 * @author Matheus
 */
public class JbdcAssuntoDAO implements AssuntoDAO{
    private Connection conexao;

    public JbdcAssuntoDAO(Connection conexao) {
        this.conexao = conexao;
    }

    @Override
    public List<Assunto> obterTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
