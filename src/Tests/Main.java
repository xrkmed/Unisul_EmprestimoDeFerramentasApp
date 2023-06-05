package Tests;

import DAO.FriendsDAO;
import DAO.LoansDAO;
import DAO.ToolsDAO;
import Database.Database;
import Views.TelaInicial;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import javax.swing.UIManager;

public class Main {

    public static LoansDAO loans = LoansDAO.getInstance();
    public static FriendsDAO friends = FriendsDAO.getInstance();
    public static ToolsDAO tools = ToolsDAO.getInstance();
    public static TelaInicial tela;

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new FlatMacLightLaf());
        } catch (Exception e) {
            e.printStackTrace();
        }

        Main.tela = new TelaInicial();
        Main.tela.setVisible(true);

        //SMTP.send("particular.guilherme.martins@gmail.com", "noreply (A3 Grupo Supimpa)", "Seja bem vindo ao aplicativo!\nVoce tem <strong>3 emprestimos em aberto</strong> para gerenciar.");
        //Initialize Connection
        Database.getInstance().getConnection();
    }

}

/*
- Função filtrar texto digitado em todas as telas
- Colocar função do botão de pesquisar "Lupa"
- Alterar ToolTip botão de "Deletar" para "Finalizar Empréstimo"
- Alterar ícone do botão de "Deletar" na janela "Empréstimos em Aberto"
- Exception ao usar botão "Visualizar" em "TelaAmigos" sem amigo selecionado
- Rever todas as "ToolTips"
- Adicionar função aos botões de "Editar" e "Visualizar" em todas as telas exeto em "Tela Amigos"
- Remover mensagnes sem sentido no "Sys.out"
- Revisar textos e mensagens nas exceptions
- Adicionar legenda das cores nas tabelas (Ex.: Tela Empréstimos em Aberto -> Amarelo == Data Entrega D-7)
- Deixar tom do vermelho mais claro
- Adicionar botão de atribuição de ferramentas a um fabricante
- Alterar layout da tela menciona acima
- Fazer "Integração" com Google Agendas
- Remover telas de "Relatório" e telas repetidas



*/