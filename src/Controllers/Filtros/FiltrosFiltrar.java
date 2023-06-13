package Controllers.Filtros;

import java.util.function.Function;
import Model.FiltrosModel;
import Enums.Filtros;

public class FiltrosFiltrar extends FiltrosModel {

    private Function<? super Object[], Boolean> predicate;

    public FiltrosFiltrar(String name, Function<? super Object[], Boolean> func) {
        super(name, Filtros.FILTRO_FILTRAR);
        this.predicate = func;
    }

    public FiltrosFiltrar(String value) {
        super(value);
    }

    @Override
    public boolean run(Object[] data) {
        if (predicate == null || getType() != Filtros.FILTRO_FILTRAR) {
            return true;
        }

        return predicate.apply(data);
    }

}
