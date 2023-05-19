package Resources;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import jdk.nashorn.api.scripting.JSObject;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class CEPResource {

    public static AddressResource buscarCEP(Integer cep) throws IOException, ScriptException{
            URL url = new URL("https://viacep.com.br/ws/" + cep + "/json/");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String line;

                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }

                reader.close();

                ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
                String script = "JSON.parse('" + response.toString() + "')";
                JSObject jsObject = (JSObject) engine.eval(script);

                String rua = jsObject.getMember("logradouro").toString().equalsIgnoreCase("undefined") ?  "" : jsObject.getMember("logradouro").toString();
                String bairro = jsObject.getMember("bairro").toString().equalsIgnoreCase("undefined") ?  "" : jsObject.getMember("bairro").toString();
                String cidade = jsObject.getMember("localidade").toString();
                String estado = jsObject.getMember("uf").toString();
                String complemento = jsObject.getMember("complemento").toString().equalsIgnoreCase("undefined") ?  "" : jsObject.getMember("complemento").toString();

                if(estado.equalsIgnoreCase("undefined") || cidade.equalsIgnoreCase("undefined")){
                    throw new IOException("CEP inválido");
                }

                connection.disconnect();
                return new AddressResource(rua, bairro, cidade, estado, null, complemento, cep);
            } else {
                connection.disconnect();
                throw new IOException("Erro ao consultar o CEP. Código de resposta: " + responseCode);
            }
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

    public static String returnTelefoneFormat(String telefone) throws IllegalArgumentException{
        if (telefone.charAt(2) != '9') {
            telefone = telefone.substring(0, 2) + "9" + telefone.substring(2);
        }

        if(telefone.length() != 11){
            throw new IllegalArgumentException("Telefone inválido");
        }

        String ddd = telefone.substring(0, 2);
        String parte1 = telefone.substring(2, 7);
        String parte2 = telefone.substring(7, 11);
        String numeroFormatado = "(" + ddd + ") " + parte1 + "-" + parte2;
        return numeroFormatado;
    }
    
}
