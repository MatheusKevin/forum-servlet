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
        String sql;
        sql = "INSERT INTO respostas ("
                + "idTopico,"
                + "nome,"
                + "data,"
                + "mensagem)"
                + "VALUES (?,?,?,?)";
        PreparedStatement ps;
        try {
            ps = conexao.prepareStatement(sql);
            ps.setInt(1, resposta.getIdTopico());
            ps.setString(2, resposta.getNome());
            ps.setDate(3, new java.sql.Date(resposta.getData().getTime()));
            ps.setString(4, resposta.getMensagem());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(JbdcRespostaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
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
