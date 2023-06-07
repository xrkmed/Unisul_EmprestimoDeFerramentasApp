package Controllers.Filtros;

import java.util.Comparator;

import Model.FiltrosModel;
import Enums.Filtros;

public class FiltrosOrdenar extends FiltrosModel {
    private Comparator<? super Object[]> comparator;
    
    public FiltrosOrdenar(String name, Comparator<? super Object[]> comparator) {
        super(name, Filtros.FILTRO_ORDENAR);
        this.comparator = comparator;
    }

    public FiltrosOrdenar(String value) {
        super(value);
    }

    @Override
    public int compare(Object[] data, Object[] data2) {
        if (comparator == null || getType() != Filtros.FILTRO_ORDENAR) {
            return 0;
        }

        return comparator.compare(data, data2);
    }
}
