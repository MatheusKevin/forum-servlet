package br.pucpr.prog4.forum.DAO;

import br.pucpr.prog4.forum.model.Resposta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JbdcRespostaDAO implements RespostaDAO{
    private Connection conexao;

    public JbdcRespostaDAO(Connection conexao) {
        this.conexao = conexao;
    }

    @Override
    public void inserir(Resposta resposta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Resposta> obterPorTopico(int id) {
        String sql;
        sql = "SELECT * FROM respostas "
                + "WHERE idTopico=?";
        PreparedStatement ps;
        ResultSet rs;
        List<Resposta> respostas = new ArrayList<Resposta>();
        try{
            ps = conexao.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while(rs.next()){
                respostas.add(popularObjeto(rs));
            }
        }catch(SQLException ex){
            
        }
        return respostas;
    }

    @Override
    public Resposta popularObjeto(ResultSet rs) {
        Resposta resposta = new Resposta();
        try {
            resposta.setId(rs.getInt("id"));
            resposta.setIdTopico(rs.getInt("idTopico"));
            resposta.setNome(rs.getString("nome"));
            resposta.setData(rs.getDate("data"));
            resposta.setMensagem(rs.getString("mensagem"));
        } catch (SQLException ex) {
        }
        return resposta;
    }
}
