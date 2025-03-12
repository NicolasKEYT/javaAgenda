package com.agenda;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GerenciadorNomes gerenciador;

        System.out.println("Escolha o tipo de armazenamento:");
        System.out.println("(1) Memória");
        System.out.println("(2) Banco de Dados");
        int escolha = scanner.nextInt();
        scanner.nextLine();

        if (escolha == 1) {
            gerenciador = new GerenciadorNomesMem();
        } else {
            gerenciador = new GerenciadorNomesBD();
        }

        Ihm ihm = new Ihm(gerenciador);
        ihm.dialogar();
        scanner.close();
    }
}
