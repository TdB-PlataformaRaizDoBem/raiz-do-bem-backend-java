package RaizDoBem.controller;

import RaizDoBem.model.bo.EnderecoBO;
import RaizDoBem.model.vo.ViaCep;
import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/** * Classe de controle para a API ViaCep. Esta classe é responsável por gerenciar as operações relacionadas à consulta de informações de endereço com base no CEP (Código de Endereçamento Postal) utilizando a API ViaCep. Ela atua como uma camada intermediária entre a interface do usuário e a API, garantindo que as regras de negócio sejam aplicadas corretamente.
 * @author Paulo
 * @since 2025-10
 */
public class ViaCepController {
    EnderecoBO bo = new EnderecoBO();
    public ViaCep buscarInformacoesEndereco(String cep) {
        String urlApi = "https://viacep.com.br/ws/" + cep + "/json/";

        if (bo.validarCep(cep)) {
            try (HttpClient cliente = HttpClient.newHttpClient();) {

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
        return null;
    }
}
