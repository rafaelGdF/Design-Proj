package org.example.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String URL = "jdbc:mysql://127.0.0.1:3306/loja_db"; // URL do banco de dados
    private static final String USER = "root"; // Nome do usuário
    private static final String PASSWORD = ""; // Senha (vazia)

    public static Connection getConnection() {
        try {
            // Carregar o driver JDBC do MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Estabelecer a conexão
            return DriverManager.getConnection(URL, USER, PASSWORD);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Driver do MySQL não encontrado", e);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao conectar ao banco de dados", e);
        }
    }
}