package Database;

public class DBTreatment {

    public static String safeString(String input) {
        return input.replaceAll("[;\"']", "");
    }
}
