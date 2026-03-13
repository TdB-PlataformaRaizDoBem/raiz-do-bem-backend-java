package RaizDoBem.Model;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class Conexao {
    public static Connection conectarAoBanco() {
        try {
            Properties prop = new Properties();
            prop.load(new FileInputStream("config.properties"));

            String url = prop.getProperty("db.url");
            String usuario = prop.getProperty("db.user");
            String senha = prop.getProperty("db.password");

            Connection conexao = DriverManager.getConnection(url, usuario, senha);

            System.out.println("Projeto conectado ao banco de dados!!");
            return conexao;
        } catch (Exception exception) {
            throw new RuntimeException("Erro: ", exception);
        }
    }
}
