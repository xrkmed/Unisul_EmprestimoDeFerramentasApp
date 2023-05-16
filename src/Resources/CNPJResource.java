package Resources;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import jdk.nashorn.api.scripting.JSObject;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.swing.JOptionPane;
import javax.xml.ws.http.HTTPException;

import Controllers.CNPJEntity;
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

    public static String returnCNPJFormat(String cnpj) throws IllegalArgumentException{
        if(cnpj.length() != 14){
            throw new IllegalArgumentException("CNPJ inválido");
        }

        return cnpj.substring(0, 2) + "." + cnpj.substring(2, 5) + "." + cnpj.substring(5, 8) + "/" + cnpj.substring(8, 12) + "-" + cnpj.substring(12);
    }

    public static String returnCNPJUnformat(String cnpj) throws IllegalArgumentException{
        if(cnpj.length() != 18){
            throw new IllegalArgumentException("CNPJ inválido");
        }

        return cnpj.substring(0, 2) + cnpj.substring(3, 6) + cnpj.substring(7, 10) + cnpj.substring(11, 15) + cnpj.substring(16, 18);
    }

    public static boolean verificarNomeFantasia(String nome) {
        return nome.length() > 3 && nome.length() <= 64;
    }

    public static CNPJEntity consultarCNPJ(String cnpj) throws CNPJNotFound, HTTPException{
        try {
            // Monta a URL da API de consulta
            String urlConsulta = "https://www.receitaws.com.br/v1/cnpj/" + cnpj;

            // Faz a requisição GET para a API
            URL url = new URL(urlConsulta);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            // Verifica se a requisição foi bem-sucedida (código 200)
            if (conn.getResponseCode() == 200) {
                // Lê a resposta da API
                BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();

                ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
                String script = "JSON.parse('" + response.toString() + "')";
                JSObject jsObject = (JSObject) engine.eval(script);

                // Verifica se a consulta foi realizada com sucesso
                if (jsObject.getMember("status").toString().equals("OK")) {
                    String sampleAddressStr = jsObject.getMember("logradouro").toString() + ", " + jsObject.getMember("numero").toString() + " - " + jsObject.getMember("bairro").toString() + ", " + jsObject.getMember("municipio").toString() + " - " + jsObject.getMember("uf").toString() + ", " + jsObject.getMember("cep").toString();
                    //CNPJEntity(String nome, String telefone, double capitalSocial, String sampleAddress, int status, String situacao, String cnpj)
                    CNPJEntity cnpjObject = new CNPJEntity(jsObject.getMember("nome").toString(), jsObject.getMember("telefone").toString(), Double.parseDouble(jsObject.getMember("capital_social").toString()), sampleAddressStr, jsObject.getMember("status").toString(), jsObject.getMember("situacao").toString(), jsObject.getMember("cnpj").toString());

                    conn.disconnect();
                    return cnpjObject;
                } else {
                    conn.disconnect();
                    throw new CNPJNotFound(jsObject.getMember("message").toString());
                }
            } else {
                conn.disconnect();
                throw new HTTPException(conn.getResponseCode());
            }

            // Fecha a conexão
            
        }catch(Exception e){
            throw new IllegalArgumentException(e.getMessage());
        }
    }
}
