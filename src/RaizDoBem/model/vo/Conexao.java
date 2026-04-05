package RaizDoBem.model.vo;

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

            return DriverManager.getConnection(url, usuario, senha);
        } catch (Exception exception) {
            throw new RuntimeException("Erro: ", exception);
        }
    }
}
