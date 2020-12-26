package br.com.alura.jdbc;

import br.com.alura.jdbc.factory.ConnectionFactory;

import java.sql.*;


public class TestaConexao {

    public static void main(String[] args) throws SQLException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = connectionFactory.recuperarConexao();

        System.out.println("Fechando conexão!");

        connection.close();

    }
}
