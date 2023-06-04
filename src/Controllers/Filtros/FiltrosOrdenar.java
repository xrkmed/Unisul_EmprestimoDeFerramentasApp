package Controllers.Filtros;

import java.util.Comparator;

import Controllers.FiltrosClass;
import Controllers.FiltrosEnum;

public class FiltrosOrdenar extends FiltrosClass {
    private Comparator<? super Object[]> comparator;
    
    public FiltrosOrdenar(String name, Comparator<? super Object[]> comparator) {
        super(name, FiltrosEnum.FILTRO_ORDENAR);
        this.comparator = comparator;
    }

    public FiltrosOrdenar(String value) {
        super(value);
    }

    @Override
    public int compare(Object[] data, Object[] data2) {
        if (comparator == null || getType() != FiltrosEnum.FILTRO_ORDENAR) {
            return 0;
        }

        return comparator.compare(data, data2);
    }
}
