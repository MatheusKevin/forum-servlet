package br.pucpr.prog4.forum.DAO;

import br.pucpr.prog4.forum.model.Assunto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JbdcAssuntoDAO implements AssuntoDAO{
    private Connection conexao;

    public JbdcAssuntoDAO(Connection conexao) {
        this.conexao = conexao;
    }

    @Override
    public List<Assunto> obterTodos() {
        String sql;
        sql = "SELECT * FROM assuntos";
        PreparedStatement ps;
        ResultSet rs;
        List<Assunto> assuntos = new ArrayList<Assunto>();
        try{
            ps = conexao.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                assuntos.add(popularObjeto(rs));
            }
        }catch(Exception e){
            
        }
        return assuntos;
    }

    @Override
    public Assunto popularObjeto(ResultSet rs) {
        Assunto assunto = new Assunto();
        try {
            assunto.setId(rs.getInt("id"));
            assunto.setNome(rs.getString("assunto"));
        } catch (SQLException ex) {
            
        }
        return assunto;
    }
    
}
