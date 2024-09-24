package com.github.art5hur.sprint_3.controller.dto;

import com.github.art5hur.sprint_3.model.Treinamento;

public class FormTreinamento {
    private Long id;
    private String nome;
    private String descricao;
    private String area;
    private String instrutor;
    private String data;

    // Getters e Setters


    // Converte a entidade Treinamento para o FormTreinamento (usado no update)
    public FormTreinamento toForm(Treinamento treinamento) {
        this.id = treinamento.getId();
        this.nome = treinamento.getNome();
        this.descricao = treinamento.getDescricao();
        this.instrutor = treinamento.getInstrutor();
        this.area = treinamento.getArea();
        this.data = treinamento.getData();
        return this;
    }
    public Treinamento toModel() {
        Treinamento treinamento = new Treinamento();
        treinamento.setId(this.id);
        treinamento.setNome(this.nome);
        treinamento.setDescricao(this.descricao);
        treinamento.setInstrutor(this.instrutor);
        treinamento.setArea(this.area);
        treinamento.setData(this.data);
        return treinamento;
    }
}
