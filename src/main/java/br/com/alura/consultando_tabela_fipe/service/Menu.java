package br.com.alura.consultando_tabela_fipe.service;

import java.util.Scanner;

public class Menu {

    private Scanner leitura = new Scanner(System.in);

    public int obterEscolhaMenu() {
        while (true) {
            System.out.println("\n*************** Consulta a Tabela Fipe ***************");
            System.out.println("Qual o tipo de veículo que deseja pesquisar: \n" +
                    "[ 1 ] Carro\n" +
                    "[ 2 ] Moto\n" +
                    "[ 3 ] Caminhão\n");
            System.out.print("Digite sua escolha: ");

            String input = leitura.nextLine();

            try {
                int escolhaMenu = Integer.parseInt(input);
                if (escolhaMenu >= 1 && escolhaMenu <= 3) {
                    return escolhaMenu;
                } else {
                    System.out.println("Opção inválida! Por favor, insira um número entre 1 e 3.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida! Por favor, insira um número.");
            }
        }
    }
}

