package br.pucpr.prog4.forum.DAO;

import br.pucpr.prog4.forum.model.Resposta;
import java.sql.ResultSet;
import java.util.List;

public interface RespostaDAO {
    
    void inserir(Resposta resposta);
    List<Resposta> obterPorTopico(int id);
    Resposta popularObjeto(ResultSet rs);
}
