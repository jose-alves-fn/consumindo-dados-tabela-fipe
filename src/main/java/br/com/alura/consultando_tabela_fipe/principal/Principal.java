package br.com.alura.consultando_tabela_fipe.principal;

import br.com.alura.consultando_tabela_fipe.model.DadosVeiculo;
import br.com.alura.consultando_tabela_fipe.service.ConsumoAPI;
import br.com.alura.consultando_tabela_fipe.service.ConverteDados;

import java.util.Comparator;
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

        String json = consumo.obterDadosAPI(endereco);
        List<DadosVeiculo> marcas = conversor.obterLista(json, DadosVeiculo.class);
        marcas.stream()
            .sorted(Comparator.comparing(DadosVeiculo::codigo))
                    .forEach(System.out::println);

        System.out.println("\n***********************************************");
        System.out.println("Informe o código do veículo que deseja pesquisar:");
        String escolhaCOD = leitura.nextLine();
        endereco = URL_BASE + escolhaMenu + MARCAS + escolhaCOD + "/modelos";

        json = consumo.obterDadosAPI(endereco);
        List<DadosVeiculo> modelos = conversor.obterLista(json, DadosVeiculo.class);
        modelos.stream()
                .sorted(Comparator.comparing(DadosVeiculo::codigo))
                .forEach(System.out::println);


    }
}
