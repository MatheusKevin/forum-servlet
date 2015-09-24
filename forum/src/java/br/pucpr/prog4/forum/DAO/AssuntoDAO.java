package br.pucpr.prog4.forum.DAO;

import br.pucpr.prog4.forum.model.Assunto;
import java.sql.ResultSet;
import java.util.List;


public interface AssuntoDAO{
    
    List<Assunto> obterTodos();
    Assunto popularObjeto(ResultSet rs);
}
