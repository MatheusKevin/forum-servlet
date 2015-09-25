package br.pucpr.prog4.forum.DAO;

import br.pucpr.prog4.forum.model.Topico;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JbdcTopicoDAO implements TopicoDAO{
    private Connection conexao;

    public JbdcTopicoDAO(Connection conexao) {
        this.conexao = conexao;
    }

    @Override
    public void inserir(Topico topico) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Topico> obterPorAssunto(int id) {
        String sql;
        sql = "SELECT * FROM topicos";
//                + "WHERE idAssunto = 1";
        PreparedStatement ps;
        ResultSet rs;
        List<Topico> topicos = new ArrayList<Topico>();
        try{
            ps = conexao.prepareStatement(sql);
//            ps.setInt(1, id);
            rs = ps.executeQuery();
            while(rs.next()){
                topicos.add(popularObjeto(rs));
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return topicos;
    }

    @Override
    public Topico obterPorId(int id){
        String sql;
        sql = "SELECT * FROM topicos"
                + "WHERE id=?";
        Topico topico = new Topico();
        ResultSet rs;
        PreparedStatement ps;
        try {
            ps = conexao.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            topico = popularObjeto(rs);
        } catch (SQLException ex) {
            Logger.getLogger(JbdcTopicoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return topico;
    }

    @Override
    public Topico popularObjeto(ResultSet rs) {
        Topico topico = new Topico();
        IDaoManager manager = new JbdcDaoManager();
        try {
            manager.iniciar();
            topico.setId(rs.getInt("id"));
            topico.setIdAssunto(rs.getInt("idAssunto"));
            topico.setAutor(rs.getString("autor"));
            topico.setDataCriacao(rs.getDate("dataCriacao"));
            topico.setNota(rs.getDouble("nota"));
            topico.setVisualizacoes(rs.getInt("visualizacoes"));
            topico.setNomeUltAcesso(rs.getString("nomeUltimoAcesso"));
            topico.setDataUltAcesso(rs.getDate("dataUltimoAcesso"));
            topico.setRespostas(manager.getRespostaDAO().obterPorTopico(rs.getInt("id")));
            manager.encerrar();
        } catch (SQLException ex) {

        }
        return topico;
    }
    
}
