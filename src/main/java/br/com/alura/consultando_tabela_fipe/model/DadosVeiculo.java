package br.com.alura.consultando_tabela_fipe.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosVeiculo(@JsonAlias("Modelo") String modelo,
                           @JsonAlias("AnoModelo") String ano,
                           @JsonAlias("Marca") String marca,
                           @JsonAlias("Valor") String valor,
                           @JsonAlias("Combustivel") String combustivel) {

    @Override
    public String toString() {
        return modelo + ", Montadora: " + marca + ", Ano: " + ano + ", Valor: " + valor + ", Combustível: " + combustivel;
    }
}