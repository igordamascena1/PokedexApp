package com.example.pokdexapp;

import java.io.Serializable;

/**
 * Modelo Pokémon conforme estrutura definida na atividade PDM.
 * Suporta imagens locais (res/drawable) ou URLs remotas via Glide.
 */
public class Pokemon implements Serializable {

    private String nome;
    private String tipo;
    private String descricao;
    private int imagem;
    private String imagemUrl;

    public Pokemon(String nome, String tipo, String descricao, int imagem) {
        this.nome = nome;
        this.tipo = tipo;
        this.descricao = descricao;
        this.imagem = imagem;
    }

    public Pokemon(String nome, String tipo, String descricao, String imagemUrl) {
        this.nome = nome;
        this.tipo = tipo;
        this.descricao = descricao;
        this.imagemUrl = imagemUrl;
    }

    public String getNome() {
        return nome;
    }

    public String getTipo() {
        return tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getImagem() {
        return imagem;
    }

    public String getImagemUrl() {
        return imagemUrl;
    }
}
