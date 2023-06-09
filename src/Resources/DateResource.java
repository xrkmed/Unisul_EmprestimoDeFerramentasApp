package Resources;

import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateResource {

    public static String formatDateString(String text) {
        // Remove qualquer caractere não numérico
        String digitsOnly = text.replaceAll("\\D", "");

        if (digitsOnly.length() >= 2) {
            if (Integer.parseInt(digitsOnly.substring(0, 2)) > 31) {
                digitsOnly = "31" + digitsOnly.substring(2);
            }
        }

        if (digitsOnly.length() >= 4) {
            if (Integer.parseInt(digitsOnly.substring(2, 4)) > 12) {
                digitsOnly = digitsOnly.substring(0, 2) + "12" + digitsOnly.substring(4);
            }
        }

        if (digitsOnly.length() >= 6) {
            if (Integer.parseInt(digitsOnly.substring(4, 6)) > 9999) {
                digitsOnly = digitsOnly.substring(0, 4) + "9999" + digitsOnly.substring(6);
            }
        }

        // Formata a string de dígitos como dd/MM/YYYY
        StringBuilder formattedText = new StringBuilder();
        for (int i = 0; i < digitsOnly.length(); i++) {
            char c = digitsOnly.charAt(i);
            if (i == 2 || i == 4) {
                formattedText.append('/');
            }
            formattedText.append(c);
        }

        if (formattedText.length() > 10) {
            formattedText.delete(10, formattedText.length());
        }

        return formattedText.toString();
    }

    public static Date unformatDateString(String text) throws ParseException, NullPointerException {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        return format.parse(text);
    }

    public static String convertDatabaseData(String data) throws ParseException, NullPointerException {
        DateFormat formatoEntrada = new SimpleDateFormat("yyyy-MM-dd");
        DateFormat formatoSaida = new SimpleDateFormat("dd/MM/yyyy");
        Date date = formatoEntrada.parse(data);

        return formatoSaida.format(date);
    }
}
