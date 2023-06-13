package Model;

import java.util.ArrayList;

public class ToolboxModel {

    //Esta classe serve para reunir varias ferramentas em um unico objeto, nao deve ser subentendido apenas com um List<> dentro de LoanModel, pois tambem e usado para comparar emprestimos e alteracoes de emprestimos sem ter que efetivamente criar outra classe LoanModel
    private final ArrayList<ToolModel> tools = new ArrayList<>();

    public ToolboxModel() {
    }

    public void addTool(ToolModel e) {
        this.tools.add(e);
    }

    public void removeTool(ToolModel e) {
        this.tools.remove(e);
    }

    public ArrayList<ToolModel> getTools() {
        return new ArrayList<>(this.tools);
    }

    public boolean containsTool(int e) {
        return this.tools.stream().anyMatch(t -> t.getId() == e);
    }

    public int size() {
        return this.tools.size();
    }

}
