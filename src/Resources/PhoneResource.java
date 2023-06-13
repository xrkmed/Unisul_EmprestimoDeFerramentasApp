package Resources;

public class PhoneResource {
    // Esta classe serve para validar e formatar numeros de telefone

    public static boolean isValidPhoneNumber(String phoneNumber) {
        // Implementação da validação do número de telefone
        return phoneNumber.matches("\\d{11}");
    }

    public static String unformatPhoneNumber(String phoneNumber) {
        return phoneNumber.replaceAll("[^\\d]", "");
    }

    public static String formatPhoneNumber(String phoneNumber) {
        StringBuilder formattedText = new StringBuilder();
        formattedText.append("(");
        formattedText.append(phoneNumber.substring(0, 2));
        formattedText.append(") ");
        formattedText.append(phoneNumber.substring(2, 6));
        formattedText.append("-");
        formattedText.append(phoneNumber.substring(6));
        return formattedText.toString();
    }

    public static boolean verificarNomeCompleto(String nome) {
        return nome.length() > 3 && nome.length() <= 64 && nome.matches("^[a-zA-Z\\s]+$");
    }

    public static boolean verificarTelefone(String telefone) {
        String numeros = telefone.replaceAll("[^0-9]", "");
        return numeros.matches("^\\d{10,11}$");
    }

}
