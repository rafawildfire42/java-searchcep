import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Searcher {

    public String lookForCep(String cep) {
        HttpClient client = HttpClient.newHttpClient();

        String url = String.format("https://viacep.com.br/ws/%s/json/", cep);

        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url.replace(" ", "")))
                    .build();
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() != 200) {
                System.out.println("Não foi possível identificar o CEP.");
                return "{\"errorMessage\": \"Cep not found\"}";
            }
            return response.body();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
