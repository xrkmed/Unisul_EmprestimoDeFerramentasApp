package Controllers;

import javax.swing.DefaultComboBoxModel;

import Views.Screens.ScreenAmigos;
import Views.Screens.ScreenEntity;

public class FiltrosEntity {

    public static DefaultComboBoxModel<FiltrosClass> get(ScreenEntity screen) {
        if(screen instanceof ScreenAmigos){ // aqui voce coloca qual o tipo de tela que vai aparecer estes filtros
            return new DefaultComboBoxModel<FiltrosClass>(new FiltrosClass[]{
                new FiltrosClass("Apenas emprestimos em aberto", FiltrosEnum.FILTRO_FILTRAR, (Object[] data) -> { //instancia um novo filtro do tipo FILTRAR
                    return (int)data[4] > 0; // faz a funcao de filtrar
                }),
                new FiltrosClass("Apenas emprestimos em atraso", FiltrosEnum.FILTRO_FILTRAR, (Object[] data) -> {
                    return (int)data[5] > 0;
                }),
                new FiltrosClass("Nomes em ordem crescente", FiltrosEnum.FILTRO_ORDENAR, (data1, data2) -> { // instancia um novo filtro do tipo ordenar
                    return ((String)data1[1]).compareTo((String)data2[1]); // compara dois valores
                }),
                new FiltrosClass("Nomes em ordem decrescente", FiltrosEnum.FILTRO_ORDENAR, (data1, data2) -> {
                    return -((String)data1[1]).compareTo((String)data2[1]);
                }),
            });
        }

        return new javax.swing.DefaultComboBoxModel<>(new FiltrosClass[] { new FiltrosClass("")  });
    }
    
}
