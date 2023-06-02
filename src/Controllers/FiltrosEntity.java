package Controllers;

import javax.swing.DefaultComboBoxModel;
import Views.Screens.ScreenAmigos;
import Views.Screens.ScreenEntity;

public class FiltrosEntity {

    public static DefaultComboBoxModel<FiltrosClass> get(ScreenEntity screen) {
        if (screen instanceof ScreenAmigos) {
            return new DefaultComboBoxModel<FiltrosClass>(new FiltrosClass[]{
                new FiltrosClass("Empréstimos em Aberto", FiltrosEnum.FILTRO_FILTRAR, (Object[] data) -> {
                    return (int) data[4] > 0;
                }),
                new FiltrosClass("Empréstimos em Atraso", FiltrosEnum.FILTRO_FILTRAR, (Object[] data) -> {
                    return (int) data[5] > 0;
                }),
                new FiltrosClass("Nome Crescente", FiltrosEnum.FILTRO_ORDENAR, (data1, data2) -> {
                    return ((String) data1[1]).compareTo((String) data2[1]);
                }),
                new FiltrosClass("Nome Decrescente", FiltrosEnum.FILTRO_ORDENAR, (data1, data2) -> {
                    return -((String) data1[1]).compareTo((String) data2[1]);
                }),});
        }
        /*here*/
        return new javax.swing.DefaultComboBoxModel<>(new FiltrosClass[]{new FiltrosClass("")});
    }

}

// if(screen instanceof ScreenEmprestimos){
        //     return new DefaultComboBoxModel<FiltrosClass>(new FiltrosClass[]{
        //         new FiltrosClass(screen, "Filtrar por nome", (ScreenEntity s) -> {
        //             //funcao aqui
        //             return null;
        //         }),
        //     });
        // }
