//Nicolas Gonçalves - 10418047


package com.agenda;

import java.util.List;

public interface GerenciadorNomes {
    int MAX_CARACTERES_NOMES = 20;
    List<String> obterNomes();
    void adicionarNome(String nome);
}
