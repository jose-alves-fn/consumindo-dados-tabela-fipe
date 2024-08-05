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

    private final String ENDERECO = "https://parallelum.com.br/fipe/api/v1/";
    private final String MARCAS = "/marcas";

    public void exibeMenu() {
        System.out.println("\n*************** Consulta a Tabela Fipe ***************");
        System.out.println("Digite o tipo de veículo que deseja pesquisar o valor: \n" +
                "Carro\n" + "Caminhão\n" + "Moto");
        String escolhaMenu = leitura.nextLine();



    }
}
