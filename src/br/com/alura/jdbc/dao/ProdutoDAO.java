package br.com.alura.jdbc.dao;

import br.com.alura.jdbc.modelo.Categoria;
import br.com.alura.jdbc.modelo.Produto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {

    private Connection connection;

    public ProdutoDAO(Connection connection) {
        this.connection = connection;

    }

    public void salvar(Produto produto) throws SQLException {
        String sql = "INSERT INTO PRODUTO (NOME,DESCRICACAO) VALUES (?, ?)";

        try (PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            pstm.setString(1, produto.getNome());
            pstm.setString(2, produto.getDescricacao());

            pstm.execute();

            try (ResultSet rst = pstm.getGeneratedKeys()) {
                while (rst.next()) {
                    produto.setId(rst.getInt(1));
                }
            }
        }
    }

    public List<Produto> listar() throws SQLException {
        List<Produto> produtos = new ArrayList<Produto>();

        String sql = "SELECT ID, NOME, DESCRICACAO FROM PRODUTO";

        try (PreparedStatement pstm = connection.prepareStatement(sql)) {
            pstm.execute();

            try (ResultSet rst = pstm.getResultSet()) {
                while (rst.next()) {
                    Produto produto =
                            new Produto(rst.getInt(1), rst.getString(2), rst.getString(3));

                    produtos.add(produto);

                }
            }
        }
        return produtos;
    }

    public List<Produto> buscar(Categoria ct) throws SQLException {
        List<Produto> produtos = new ArrayList<Produto>();

        System.out.println("Executando a query de buscar produto por categoria");

        String sql = "SELECT ID, NOME, DESCRICACAO FROM PRODUTO WHERE CATEGORIA_ID = ?";

        try (PreparedStatement pstm = connection.prepareStatement(sql)) {
            pstm.setInt(1, ct.getId());
            pstm.execute();

            try (ResultSet rst = pstm.getResultSet()) {
                while (rst.next()) {
                    Produto produto =
                            new Produto(rst.getInt(1), rst.getString(2), rst.getString(3));

                    produtos.add(produto);

                }
            }
        }
        return produtos;
    }
}
