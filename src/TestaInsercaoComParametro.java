import java.sql.*;

public class TestaInsercaoComParametro {

    public static void main (String [] args) throws SQLException {

        String nome = "Mouse'";
        String descricacao = "Mouse sem fio); delete from Produto;";
        ConnectionFactory factory = new ConnectionFactory();
        Connection connection = factory.recuperarConexao();

        PreparedStatement stm =
                connection.prepareStatement("INSERT INTO PRODUTO (nome, descricacao) VALUES (? , ?)", Statement.RETURN_GENERATED_KEYS);

        stm.setString(1,nome);
        stm.setString(2,descricacao);

        stm.execute();

        ResultSet rst = stm.getGeneratedKeys();
        while (rst.next()) {
            Integer id = rst.getInt(1);
            System.out.println("O id criado foi: " + id);
        }
    }
}
