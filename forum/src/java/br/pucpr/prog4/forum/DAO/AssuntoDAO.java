package br.pucpr.prog4.forum.DAO;

import br.pucpr.prog4.forum.model.Assunto;
import java.util.List;


public interface AssuntoDAO{
    
    public List<Assunto> obterTodos();
}
