package RaizDoBem.model.vo;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Classe utilitaria responsavel por prover conexao JDBC com o banco de dados.
 * Camada: VO.
 */
public class Conexao {
    /**
     * Estabelece conexao com o banco de dados.
     * @return resultado da operacao.
     */
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
