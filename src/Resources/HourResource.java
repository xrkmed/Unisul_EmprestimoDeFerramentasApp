/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Resources;

/**
 *
 * @author lucas
 */
public class HourResource {

    public static String formatHourString(String text) {
        String digitsOnly = text.replaceAll("\\D", "");
        if (digitsOnly.length() >= 2) {
            if (Integer.parseInt(digitsOnly.substring(0, 2)) >= 24) {
                digitsOnly = "00" + digitsOnly.substring(2);
            }
        }
        if (digitsOnly.length() == 4) {
            if (Integer.parseInt(digitsOnly.substring(2, 4)) >= 24) {
                digitsOnly = digitsOnly.substring(0,2)+"00";
            }
        }
StringBuilder formattedText = new StringBuilder();
        for (int i = 0; i < digitsOnly.length(); i++) {
            char c = digitsOnly.charAt(i);
            if (i == 2 ) {
                formattedText.append(':');
            }
            formattedText.append(c);
        }
         if (formattedText.length() > 5) {
            formattedText.delete(5, formattedText.length());
        }
         return formattedText.toString();
    }
}
