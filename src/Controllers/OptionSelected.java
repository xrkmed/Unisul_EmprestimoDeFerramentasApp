package Controllers;


public class OptionSelected {
    
    private static String selecionado = "amigos";
    
    public static void setOption(String opção){  
        
        selecionado = opção;
    }
    
    public static String getOption(){
    return selecionado;
    }
    
    public static void setButtons(){
    
    }

}
