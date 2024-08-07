package br.com.alura.consultando_tabela_fipe.model;

public record Dados(String codigo, String nome) {

    @Override
    public String toString() {
        return "Cód: " + codigo + " Descrição: " + nome;
    }
}


