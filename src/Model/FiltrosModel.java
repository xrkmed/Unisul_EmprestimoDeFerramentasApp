package Model;

import Enums.Filtros;
import java.util.ArrayList;

public class FiltrosModel {

    //Classe pai de Filtros, as classes herdadas se encontram em Controllers.Filtros
    private final String filterName;
    private final Filtros type;

    public FiltrosModel(String name, Filtros type) {
        this.filterName = name;
        this.type = type;
    }

    public FiltrosModel(String value) {
        this.filterName = value;
        this.type = null;
        //this.screen = null;
    }

    public boolean run(Object[] data) {
        return false;
    }

    public ArrayList<? extends Object> run() {
        return null;
    }

    public int compare(Object[] data1, Object[] data2) {
        return 0;
    }

    public Filtros getType() {
        return type;
    }

    public String getFilterName() {
        return filterName;
    }

    @Override
    public String toString() {
        return getFilterName();
    }

}
