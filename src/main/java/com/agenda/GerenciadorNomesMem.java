//Nicolas Gonçalves - 10418047


package com.agenda;

import java.util.ArrayList;
import java.util.List;

public class GerenciadorNomesMem implements GerenciadorNomes {
    private List<String> nomes = new ArrayList<>();

    @Override
    public List<String> obterNomes() {
        return nomes;
    }

    @Override
    public void adicionarNome(String nome) {
        if (nome.length() <= MAX_CARACTERES_NOMES) {
            nomes.add(nome);
        } else {
            System.out.println("Erro: Nome ultrapassa o limite de caracteres.");
        }
    }
}
