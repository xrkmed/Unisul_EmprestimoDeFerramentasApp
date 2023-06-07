package Resources;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import Model.CNPJModel;
import Exceptions.CNPJNotFound;

public class CNPJResource {

    public static boolean validarCNPJ(String cnpj) {
        // Remove caracteres especiais
        cnpj = cnpj.replaceAll("[^\\d]", "");

        // Verifica se a quantidade de dígitos é igual a 14
        if (cnpj.length() != 14) {
            return false;
        }

        // Verifica se todos os dígitos são iguais
        if (cnpj.matches("(\\d)\\1*")) {
            return false;
        }

        // Calcula o primeiro dígito verificador
        int soma = 0;
        int peso = 2;
        for (int i = 11; i >= 0; i--) {
            int num = cnpj.charAt(i) - '0';
            soma += num * peso;
            peso = (peso + 1) % 10;
            if (peso == 0) {
                peso = 2;
            }
        }
        int digitoVerificador1 = (soma % 11) < 2 ? 0 : 11 - (soma % 11);

        // Calcula o segundo dígito verificador
        soma = 0;
        peso = 2;
        for (int i = 12; i >= 0; i--) {
            int num = cnpj.charAt(i) - '0';
            soma += num * peso;
            peso = (peso + 1) % 10;
            if (peso == 0) {
                peso = 2;
            }
        }
        int digitoVerificador2 = (soma % 11) < 2 ? 0 : 11 - (soma % 11);

        // Verifica se os dígitos verificadores calculados são iguais aos dígitos informados
        if ((cnpj.charAt(12) - '0') != digitoVerificador1 || (cnpj.charAt(13) - '0') != digitoVerificador2) {
            return false;
        }

        return true;
    }

    public static String returnCNPJFormat(String cnpj) throws IllegalArgumentException {
        while (cnpj.length() < 14) {
            cnpj = "0" + cnpj;
        }

        return cnpj.substring(0, 2) + "." + cnpj.substring(2, 5) + "." + cnpj.substring(5, 8) + "/" + cnpj.substring(8, 12) + "-" + cnpj.substring(12);
    }

    public static String returnCNPJUnformat(String cnpj) throws IllegalArgumentException {
        if (cnpj.length() != 18) {
            throw new IllegalArgumentException("CNPJ inválido");
        }

        return cnpj.substring(0, 2) + cnpj.substring(3, 6) + cnpj.substring(7, 10) + cnpj.substring(11, 15) + cnpj.substring(16, 18);
    }

    public static boolean verificarNomeFantasia(String nome) {
        return nome.length() > 3 && nome.length() <= 64;
    }

    public static CNPJModel consultarCNPJ(String cnpj) throws CNPJNotFound {
        try {
            String urlConsulta = "https://www.receitaws.com.br/v1/cnpj/" + cnpj;

            URL url = new URL(urlConsulta);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            if (conn.getResponseCode() == 200) {
                JsonParser parser = new JsonParser();
                JsonElement jsonElement = parser.parse(new InputStreamReader(conn.getInputStream()));

                String sampleAddressStr = jsonElement.getAsJsonObject().get("logradouro").getAsString() + ", " + jsonElement.getAsJsonObject().get("numero").getAsString() + " - " + jsonElement.getAsJsonObject().get("bairro").getAsString() + ", " + jsonElement.getAsJsonObject().get("municipio").getAsString() + " - " + jsonElement.getAsJsonObject().get("uf").getAsString() + ", " + jsonElement.getAsJsonObject().get("cep").getAsString();
                CNPJModel cnpjObject = new CNPJModel(jsonElement.getAsJsonObject().get("nome").getAsString(), jsonElement.getAsJsonObject().get("telefone").getAsString(), Double.parseDouble(jsonElement.getAsJsonObject().get("capital_social").getAsString()), sampleAddressStr, jsonElement.getAsJsonObject().get("status").getAsString(), jsonElement.getAsJsonObject().get("situacao").getAsString(), jsonElement.getAsJsonObject().get("cnpj").getAsString());

                conn.disconnect();
                return cnpjObject;
            } else {
                conn.disconnect();
                throw new IllegalArgumentException("Erro de conexao: " + conn.getResponseCode() + ", contacte o administrador do sistema e verifique sua conexao com a internet.");
            }
        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }
}
