package br.pucpr.prog4.forum.model;

import java.util.List;

public interface TopicoManager {
    void cadastrar(Topico topico);
    List<Topico> listarPorAssunto(int idAssunto);
    Topico obterTopico(int id);
}
