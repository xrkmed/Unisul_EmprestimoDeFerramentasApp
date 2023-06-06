package Resources;

public class PhoneValidResource {
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

}
