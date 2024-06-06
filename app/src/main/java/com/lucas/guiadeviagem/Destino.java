package com.lucas.guiadeviagem;

public class Destino {
    private String viagem;
    private String id;
    private String hoteis;
    private String atracoes;
    private String lazer;
    private String restaurantes;

    public Destino(String hoteis, String atracoes, String lazer, String restaurantes, String id, String viagem) {
        this.hoteis = hoteis;
        this.atracoes = atracoes;
        this.lazer = lazer;
        this.restaurantes = restaurantes;
        this.id = id;
        this.viagem = viagem;
    }

    public Destino() {
    }

    @Override
    public String toString() {
        return viagem;
    }

    public String getViagem() {
        return viagem;
    }

    public void setViagem(String destino) {
        this.viagem = destino;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHoteis() {
        return hoteis;
    }

    public void setHoteis(String hoteis) {
        this.hoteis = hoteis;
    }

    public String getAtracoes() {
        return atracoes;
    }

    public void setAtracoes(String atracoes) {
        this.atracoes = atracoes;
    }

    public String getLazer() {
        return lazer;
    }

    public void setLazer(String lazer) {
        this.lazer = lazer;
    }

    public String getRestaurantes() {
        return restaurantes;
    }

    public void setRestaurantes(String restaurantes) {
        this.restaurantes = restaurantes;
    }
}
