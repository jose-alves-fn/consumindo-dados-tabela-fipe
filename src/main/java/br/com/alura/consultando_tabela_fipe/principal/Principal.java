package br.com.alura.consultando_tabela_fipe.principal;

import br.com.alura.consultando_tabela_fipe.model.DadosVeiculo;
import br.com.alura.consultando_tabela_fipe.service.ConsumoAPI;
import br.com.alura.consultando_tabela_fipe.service.ConverteDados;

import java.util.List;
import java.util.Scanner;

public class Principal {

    private Scanner leitura = new Scanner(System.in);
    private ConsumoAPI consumo = new ConsumoAPI();
    private ConverteDados conversor = new ConverteDados();

    private final String URL_BASE = "https://parallelum.com.br/fipe/api/v1/";
    private final String MARCAS = "/marcas";

    public void exibeMenu() {
        System.out.println("\n*************** Consulta a Tabela Fipe ***************");
        System.out.println("Digite o tipo de veículo que deseja pesquisar o valor: \n" +
                "Carro\n" + "Caminhão\n" + "Moto");
        var escolhaMenu = leitura.nextLine();
        String endereco = "";

        if (escolhaMenu.toLowerCase().contains("carr")) {
            endereco = URL_BASE + "carros" + MARCAS;
        } else if (escolhaMenu.toLowerCase().contains("mot")) {
            endereco = URL_BASE + "motos" + MARCAS;
        } else if (escolhaMenu.toLowerCase().contains("caminh")) {
            endereco = URL_BASE + "caminhoes" + MARCAS;
        } else
            System.out.println("Busca inválida");

        String json = consumo.obterDados(endereco);
        List<DadosVeiculo> marcas = conversor.obterLista(json, DadosVeiculo.class);
        System.out.println(marcas);





    }
}
