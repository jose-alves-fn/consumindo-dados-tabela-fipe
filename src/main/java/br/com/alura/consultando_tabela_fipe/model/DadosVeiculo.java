package br.com.alura.consultando_tabela_fipe.model;

import com.fasterxml.jackson.annotation.JsonAlias;

public record DadosVeiculo(String codigo, String nome) {
}
