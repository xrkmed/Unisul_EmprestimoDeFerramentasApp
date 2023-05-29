package Resources;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class CEPResource {

    public static AddressResource buscarCEP(Integer cep) throws IOException {
        String urlStr = "https://viacep.com.br/ws/" + cep + "/json/";
        URL url = new URL(urlStr);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Accept", "application/json");

        if (conn.getResponseCode() != 200) {
            throw new IOException("Erro ao fazer a requisição HTTP: " + conn.getResponseCode());
        }

        JsonParser parser = new JsonParser();
        JsonElement jsonElement = parser.parse(new InputStreamReader(conn.getInputStream()));

        String rua = jsonElement.getAsJsonObject().get("logradouro").getAsString();
        String bairro = jsonElement.getAsJsonObject().get("bairro").getAsString();
        String cidade = jsonElement.getAsJsonObject().get("localidade").getAsString();
        String uf = jsonElement.getAsJsonObject().get("uf").getAsString();
        String complemento = jsonElement.getAsJsonObject().get("complemento").getAsString();

        if (uf.equalsIgnoreCase("undefined") || cidade.equalsIgnoreCase("undefined")) {
            throw new IOException("CEP inválido");
        }

        if (rua.equalsIgnoreCase("undefined")) {
            rua = "";
        }

        if (bairro.equalsIgnoreCase("undefined")) {
            bairro = "";
        }

        if (complemento.equalsIgnoreCase("undefined")) {
            complemento = "";
        }

        conn.disconnect();
        return new AddressResource(rua, bairro, cidade, uf, null, complemento, cep);
    }

    public static boolean verificarNomeCompleto(String nome) {
        return nome.length() > 3 && nome.length() <= 64 && nome.matches("^[a-zA-Z\\s]+$");
    }

    public static boolean verificarCEP(String cep) {
        return cep.matches("^\\d{8}$") && cep.length() == 8;
    }

    public static boolean verificarEstado(String cep) {
        return cep.matches("^\\w{2}$") && cep.length() == 2;
    }

    public static boolean verificarNumeroCasa(String numero) {
        return numero.matches("^\\d+$");
    }

    public static boolean verificarRua(String rua) {
        return rua.length() >= 4 && rua.length() <= 64;
    }

    public static boolean verificarCidade(String rua) {
        return rua.length() >= 3 && rua.length() <= 16;
    }

    public static boolean verificarBairro(String rua) {
        return rua.length() >= 3 && rua.length() <= 64;
    }

    public static boolean verificarTelefone(String telefone) {
        String numeros = telefone.replaceAll("[^0-9]", "");
        return numeros.matches("^\\d{10,11}$");
    }
}
