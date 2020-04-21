package factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public Connection getConnection() {

        Connection conexao = null;
        try {
            String banco = System.getenv("tipoBanco");
            conexao = DriverManager.getConnection(String.format("jdbc:%s://licalhost/banco", banco), "usuario", "senha");
            return conexao;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

    }
}
