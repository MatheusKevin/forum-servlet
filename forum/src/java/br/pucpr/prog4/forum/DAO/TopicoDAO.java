package br.pucpr.prog4.forum.DAO;

import br.pucpr.prog4.forum.model.Topico;
import java.sql.ResultSet;
import java.util.List;

public interface TopicoDAO {

    void inserir(Topico topico);
    List<Topico> obterPorAssunto(int id);
    Topico obterPorId(int id);
    Topico popularObjeto(ResultSet rs);
}
