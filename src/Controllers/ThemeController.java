package Controllers;

import javax.swing.JFrame;
import javax.swing.LookAndFeel;
import javax.swing.UIManager;

import Resources.Enum_Themes;
import Views.TelaInicial;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import com.formdev.flatlaf.themes.FlatMacLightLaf;

public class ThemeController {

    private static ThemeController instance;
    private Enum_Themes theme = Enum_Themes.LIGHT;

    private ThemeController(){

    }

    public static ThemeController getInstance(){
        if(instance == null){
            instance = new ThemeController();
        }
        return instance;
    }

    public Enum_Themes getTheme() {
        return theme;
    }

    public LookAndFeel getLookAndFeel(Enum_Themes theme){
        switch(theme){
            case DARK:
                return new FlatMacDarkLaf();
            case LIGHT:
                return new FlatMacLightLaf();
            default: break;
        }

        return null;
    }

    public LookAndFeel getLookAndFeel(){
        return getLookAndFeel(getTheme());
    }

    public void setTheme(Enum_Themes theme, JFrame parent) {
        if(this.theme == theme){
            return;
        }
        
        getInstance().theme = theme;

        try{
            UIManager.setLookAndFeel(getLookAndFeel(theme));
        }catch(Exception e){
            e.printStackTrace();
        }
        
        parent.dispose();
        new TelaInicial().setVisible(true);
    }

    
    
}
