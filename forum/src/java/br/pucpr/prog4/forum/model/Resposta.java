package br.pucpr.prog4.forum.model;

import java.sql.Date;

public class Resposta {
    private Integer id;
    private Integer idTopico;
    private String nome;
    private Date data;
    private String mensagem;

    public Resposta() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdTopico() {
        return idTopico;
    }

    public void setIdTopico(Integer idTopico) {
        this.idTopico = idTopico;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String Mensagem) {
        this.mensagem = Mensagem;
    }
    
}
