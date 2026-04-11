package RaizDoBem.model.vo;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/* Classe de conexão com o banco de dados. Esta classe é responsável por estabelecer a conexão com o banco de dados utilizando as informações de configuração fornecidas em um arquivo "config.properties". Ela utiliza a classe DriverManager para obter a conexão e retorna um objeto Connection que pode ser utilizado para realizar operações de banco de dados.
 * @author Paulo
 * @since 2026-03
 */
public class Conexao {
    public static Connection conectarAoBanco() {
        try {

            String url = "jdbc:oracle:thin:@//oracle.fiap.com.br:1521/orcl";
            String usuario = "usuario";
            String senha ="****";

            return DriverManager.getConnection(url, usuario, senha);
        } catch (Exception exception) {
            throw new RuntimeException("Erro: ", exception);
        }
    }
}
