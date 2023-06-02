package Controllers.Filtros;

import java.util.ArrayList;
import java.util.function.Function;
import java.util.function.Supplier;

import Controllers.FiltrosClass;
import Controllers.FiltrosEnum;

public class FiltrosGerar extends FiltrosClass {

    private Supplier<ArrayList<? extends Object>> function;
    
    public FiltrosGerar(String name, Supplier<ArrayList<? extends Object>> func) {
        super(name, FiltrosEnum.FILTRO_GERAR);
        this.function = func;
    }

    public FiltrosGerar(String value) {
        super(value);
    }

    @Override
    public ArrayList<? extends Object> run() {
        if (function == null || getType() != FiltrosEnum.FILTRO_GERAR) {
            return null;
        }

        return function.get();
    }
    
}
