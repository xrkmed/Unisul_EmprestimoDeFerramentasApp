package Controllers.Filtros;

import java.util.function.Function;

import Controllers.FiltrosClass;
import Controllers.FiltrosEnum;

public class FiltrosFiltrar extends FiltrosClass {

    private Function<? super Object[], Boolean> predicate;
    
    public FiltrosFiltrar(String name, Function<? super Object[], Boolean> func) {
        super(name, FiltrosEnum.FILTRO_FILTRAR);
        this.predicate = func;
    }

    public FiltrosFiltrar(String value) {
        super(value);
    }

    @Override
    public boolean run(Object[] data) {
        if (predicate == null || getType() != FiltrosEnum.FILTRO_FILTRAR) {
            return true;
        }

        return predicate.apply(data);
    }
    
}
