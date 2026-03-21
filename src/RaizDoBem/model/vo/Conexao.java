package RaizDoBem.model.vo;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 * Responsável por estabelecer a conexão com o banco de dados.
 * Ela lê as configurações do arquivo "config.properties" e utiliza essas informações para criar uma conexão.
 * @author Paulo
 * @since 2025-09
 * O metodo conectarAoBanco() retorna um objeto Connection que pode ser utilizado para realizar operações no banco de dados. Em caso de erro, uma RuntimeException é lançada com a mensagem de erro.
 * O arquivo "config.properties" deve conter as seguintes propriedades:
 * db.url=jdbc:mysql://localhost:3306/raiz_do_bem
 * db.user=seu_usuario
 * db.password=sua_senha
 * Certifique-se de substituir "seu_usuario" e "sua_senha" pelas credenciais corretas para acessar o banco de dados.
 */
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
