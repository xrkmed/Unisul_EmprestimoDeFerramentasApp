package Database;

public class DBTreatment {
    //@xrkmed
    
    public static String safeString(String input){
        return input.replaceAll("[;\"']", "");
    }
    
}
