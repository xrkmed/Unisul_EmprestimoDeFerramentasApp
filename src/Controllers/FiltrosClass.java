package Controllers;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.Function;

public class FiltrosClass {

    private final String filterName;
    private final FiltrosEnum type;

    public FiltrosClass(String name, FiltrosEnum type) {
        this.filterName = name;
        this.type = type;
    }

    public FiltrosClass(String value) {
        this.filterName = value;
        this.type = null;
        //this.screen = null;
    }

    public boolean run(Object[] data) {
        return false;
    }

    public ArrayList<? extends Object> run(){
        return null;
    }

    public int compare(Object[] data1, Object[] data2) {
        return 0;
    }

    public FiltrosEnum getType() {
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
