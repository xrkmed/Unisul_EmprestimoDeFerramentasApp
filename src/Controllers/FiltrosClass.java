package Controllers;

import java.util.Comparator;
import java.util.function.Function;

public class FiltrosClass {

    private Function<? super Object[], Boolean> predicate;
    private Comparator<? super Object[]> comparator;
    private final String filterName;
    private final FiltrosEnum type;

    public FiltrosClass(String name, FiltrosEnum type, Function<? super Object[], Boolean> func) {
        this.predicate = func;
        this.filterName = name;
        this.type = type;
    }

    public FiltrosClass(String name, FiltrosEnum type, Comparator<? super Object[]> func) {
        this.comparator = func;
        this.filterName = name;
        this.type = type;
    }

    public FiltrosClass(String value) {
        this.filterName = value;
        this.type = null;
        //this.screen = null;
    }

    public boolean run(Object[] data) {
        if (predicate == null || type != FiltrosEnum.FILTRO_FILTRAR) {
            return true;
        }

        return predicate.apply(data);
    }

    public int compare(Object[] data1, Object[] data2) {
        if (comparator == null || type != FiltrosEnum.FILTRO_ORDENAR) {
            return 0;
        }

        return comparator.compare(data1, data2);
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
