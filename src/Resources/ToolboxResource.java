package Resources;

import java.util.ArrayList;

import Model.ToolModel;

public class ToolboxResource {

    private final ArrayList<ToolModel> tools = new ArrayList<>();

    public ToolboxResource(){
    }

    public void addTool(ToolModel e){
        this.tools.add(e);
    }

    public void removeTool(ToolModel e){
        this.tools.remove(e);
    }

    public ArrayList<ToolModel> getTools(){
        return new ArrayList<>(this.tools);
    }

    public boolean containsTool(int e){
        return this.tools.stream().anyMatch(t -> t.getId() == e);
    }

    public int size(){
        return this.tools.size();
    }
    
}
