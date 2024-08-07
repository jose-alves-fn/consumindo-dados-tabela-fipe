package br.com.alura.consultando_tabela_fipe.service;

import br.com.alura.consultando_tabela_fipe.principal.Principal;

public class Validador {

    private final String URL_BASE = "https://parallelum.com.br/fipe/api/v1/";
    private final String MARCAS = "/marcas/";
    private final String MODELOS = "/modelos/";
    private final String ANOS = "/anos/";

    public String validarEscolha(int escolhaMenu) {

        switch (escolhaMenu) {
            case 1:
                return URL_BASE + "carros" + MARCAS;
            case 2:
                return URL_BASE + "motos" + MARCAS;
            case 3:
                return URL_BASE + "caminhoes" + MARCAS;
            default:
                return null;
        }
    }
}
