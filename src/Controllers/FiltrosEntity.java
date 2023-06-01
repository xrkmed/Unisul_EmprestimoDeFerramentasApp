package Controllers;

import javax.swing.DefaultComboBoxModel;

import Views.Screens.ScreenAmigos;
import Views.Screens.ScreenEntity;

public class FiltrosEntity {

    public static DefaultComboBoxModel<FiltrosClass> get(ScreenEntity screen) {
        if(screen instanceof ScreenAmigos){
            return new DefaultComboBoxModel<FiltrosClass>(new FiltrosClass[]{
                new FiltrosClass("Apenas emprestimos em aberto", FiltrosEnum.FILTRO_FILTRAR, (Object[] data) -> {
                    return (int)data[4] > 0;
                }),
                new FiltrosClass("Apenas emprestimos em atraso", FiltrosEnum.FILTRO_FILTRAR, (Object[] data) -> {
                    return (int)data[5] > 0;
                }),
                new FiltrosClass("Nomes em ordem crescente", FiltrosEnum.FILTRO_ORDENAR, (data1, data2) -> {
                    return ((String)data1[1]).compareTo((String)data2[1]);
                }),
                new FiltrosClass("Nomes em ordem decrescente", FiltrosEnum.FILTRO_ORDENAR, (data1, data2) -> {
                    return -((String)data1[1]).compareTo((String)data2[1]);
                }),
            });
        }

        // if(screen instanceof ScreenEmprestimos){
        //     return new DefaultComboBoxModel<FiltrosClass>(new FiltrosClass[]{
        //         new FiltrosClass(screen, "Filtrar por nome", (ScreenEntity s) -> {
        //             //funcao aqui
        //             return null;
        //         }),
        //     });
        // }

        return new javax.swing.DefaultComboBoxModel<>(new FiltrosClass[] { new FiltrosClass("")  });
    }
    
}
