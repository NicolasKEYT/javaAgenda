package com.agenda;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GerenciadorNomesBD implements GerenciadorNomes {
    private final String url = "jdbc:postgresql://<SEU-HOST>.supabase.co:5432/<SEU-BANCO>";
    private final String user = "<SEU-USUARIO>";
    private final String password = "<SUA-SENHA>";

    public GerenciadorNomesBD() {
        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement()) {
            String sql = "CREATE TABLE IF NOT EXISTS nomes (id SERIAL PRIMARY KEY, nome VARCHAR(20) NOT NULL)";
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            System.err.println("Erro ao criar tabela: " + e.getMessage());
        }
    }

    @Override
    public List<String> obterNomes() {
        List<String> nomes = new ArrayList<>();
        String sql = "SELECT nome FROM nomes";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                nomes.add(rs.getString("nome"));
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar nomes: " + e.getMessage());
        }
        return nomes;
    }

    @Override
    public void adicionarNome(String nome) {
        String sql = "INSERT INTO nomes (nome) VALUES (?)";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nome);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao adicionar nome: " + e.getMessage());
        }
    }
}
