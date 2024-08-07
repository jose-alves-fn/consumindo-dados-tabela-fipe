package br.com.alura.consultando_tabela_fipe.principal;

import br.com.alura.consultando_tabela_fipe.model.DadosModelos;
import br.com.alura.consultando_tabela_fipe.model.Dados;
import br.com.alura.consultando_tabela_fipe.model.DadosVeiculo;
import br.com.alura.consultando_tabela_fipe.service.ConsumoAPI;
import br.com.alura.consultando_tabela_fipe.service.ConverteDados;
import br.com.alura.consultando_tabela_fipe.service.Menu;
import br.com.alura.consultando_tabela_fipe.service.Validador;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Principal {

    // Documentação da API: https://deividfortuna.github.io/fipe/

    // Instâncias fixas
    private Scanner leitura = new Scanner(System.in);
    private ConsumoAPI consumo = new ConsumoAPI();
    private ConverteDados conversor = new ConverteDados();
    private Menu menu = new Menu();
    private Validador validador = new Validador();

    private final String MODELOS = "/modelos/";
    private final String ANOS = "/anos/";

    public void exibeMenu() {

        int escolhaMenu = menu.obterEscolhaMenu(); // Coleta a escolha do usuário
        String endereco = validador.validarEscolha(escolhaMenu); // Validação da escolha

        // Busca inicial: tipo de veículo
        String json = consumo.obterDadosAPI(endereco); // Endereço retorna uma lista de objetos
        List<Dados> escolhaVeiculo = conversor.obterLista(json, Dados.class);
        escolhaVeiculo.stream()
            .sorted(Comparator.comparing(Dados::codigo))
                    .forEach(System.out::println);

        // Segunda busca: marcas
        System.out.println("\n***********************************************");
        System.out.println("Informe o código da marca que deseja pesquisar:");
        String escolhaMarca = leitura.nextLine();
        endereco = endereco + escolhaMarca + MODELOS;

        json = consumo.obterDadosAPI(endereco); // Endereço retorna objeto JSON com um dois atributos
        DadosModelos modelosLista = conversor.obterDados(json, DadosModelos.class);

        modelosLista.modelos().stream()
                .sorted(Comparator.comparing(Dados::codigo))
                .forEach(System.out::println);

        // Terceira busca: modelo do veículo por nome (auxilia o usuario a decidir o codigo)
        System.out.println("\n***********************************************");
        System.out.println("Informe o nome do veículo que deseja pesquisar:");
        String nomeVeiculo = leitura.nextLine();

        List<Dados> modelosFiltrados = modelosLista.modelos().stream()
                .filter(m -> m.nome().toLowerCase().contains(nomeVeiculo.toLowerCase()))
                .collect(Collectors.toList());

        System.out.println("\nModelos filtrados");
        System.out.println("\n***********************************************");
        modelosFiltrados.forEach(System.out::println);

        // Quarta busca: escolha do modelo pelo codigo
        System.out.println("\n***********************************************");
        System.out.println("Informe código do modelo para buscar os valores de avaliacao:");
        String codModelo = leitura.nextLine();
        endereco = endereco + codModelo + ANOS;
        json = consumo.obterDadosAPI(endereco);
        List<Dados> anosModelos = conversor.obterLista(json, Dados.class);


        // Criando uma lista que receberá o dado do modelo para cada ano que tenha avaliação
        List<DadosVeiculo> listaDeVeiculos = new ArrayList<>();

        for (int i = 0; i < anosModelos.size(); i++) {
            var enderecoAnos = endereco + anosModelos.get(i).codigo();
            json = consumo.obterDadosAPI(enderecoAnos);
            DadosVeiculo infoVeiculo = conversor.obterDados(json, DadosVeiculo.class);
            listaDeVeiculos.add(infoVeiculo);
        }

        System.out.println("\nAnos e avaliações para o veículo solicitado:");
        System.out.println("***********************************************");
        listaDeVeiculos.forEach(System.out::println);
    }
}
