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
        String sql;
        sql = "INSERT INTO topicos ("
                + "idAssunto,"
                + "autor,"
                + "titulo,"
                + "dataCriacao,"
                + "nota,"
                + "visualizacoes ) "
                + "VALUES (?,?,?,?,?,?)";
        PreparedStatement ps;
        try{
            ps = conexao.prepareStatement(sql);
            ps.setInt(1, topico.getIdAssunto());
            ps.setString(2, topico.getAutor());
            ps.setString(3, topico.getTitulo());
            ps.setDate(4, topico.getDataCriacao());
            ps.setInt(5, topico.getNota());
            ps.setInt(6, topico.getVisualizacoes());
            ps.executeUpdate();
        }catch(SQLException ex){
            
        }
    
    }

    @Override
    public List<Topico> obterPorAssunto(int id) {
        String sql;
        sql = "SELECT * FROM topicos "
                + "WHERE idAssunto = ?";
        PreparedStatement ps;
        ResultSet rs;
        List<Topico> topicos = new ArrayList<Topico>();
        try{
            ps = conexao.prepareStatement(sql);
            ps.setInt(1, id);
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
        sql = "SELECT * FROM topicos "
                + "WHERE id = ?";
        Topico topico = new Topico();
        ResultSet rs;
        PreparedStatement ps;
        try {
            ps = conexao.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if(rs.next()){
                topico = popularObjeto(rs);
            }
        } catch (SQLException ex) {
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
            topico.setTitulo(rs.getString("titulo"));
            topico.setDataCriacao(rs.getDate("dataCriacao"));
            topico.setNota(rs.getInt("nota"));
            topico.setVisualizacoes(rs.getInt("visualizacoes"));
            topico.setRespostas(manager.getRespostaDAO().obterPorTopico(rs.getInt("id")));
            manager.encerrar();
        } catch (SQLException ex) {
            manager.encerrar();
        }
        return topico;
    }
    
}
