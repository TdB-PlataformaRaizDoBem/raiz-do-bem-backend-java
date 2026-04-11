package RaizDoBem.model.bo;

import RaizDoBem.model.vo.ViaCep;
import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * Classe BO responsavel pelas validacoes e regras de negocio de ViaCepBO.
 * Camada: BO.
 */
public class ViaCepBO {
    /**
     * Realiza a busca de dados conforme o criterio recebido.
     * @param cep parametro da operacao.
     * @return resultado da operacao.
     */
    public ViaCep buscarInformacoesEndereco(String cep) {
        String urlApi = "https://viacep.com.br/ws/" + cep + "/json/";

        try{
            HttpClient cliente = HttpClient.newHttpClient(); 
            
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(urlApi))
                    .build();

            HttpResponse<String> response = cliente
                    .send(request, HttpResponse.BodyHandlers.ofString());

            Gson gson = new Gson();
            return gson.fromJson(response.body(), ViaCep.class);

        } catch (Exception e) {
            throw new RuntimeException("Erro ao consultar Api: " + e.getMessage());
        }
    }
}
