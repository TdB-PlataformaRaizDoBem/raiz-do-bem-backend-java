package RaizDoBem.controller;

import RaizDoBem.model.vo.ViaCep;
import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ViaCepController {
    ViaCep viaCep = new ViaCep();
    EnderecoController enderecoController = new EnderecoController();
    public ViaCep buscarInformacoesEndereco(String cep) {
        String urlApi = "https://viacep.com.br/ws/" + cep + "/json/";

        if (enderecoController.validarCep(cep)) {
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
