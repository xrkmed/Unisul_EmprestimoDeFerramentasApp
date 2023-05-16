package DAO;

import java.util.ArrayList;
import java.util.stream.Collectors;

import Model.ToolModel;
import Resources.ManufacturerResource;

public class ToolsDAO {

    //Simulated Database
    private final ArrayList<ToolModel> tools = new ArrayList<>();

    //Singleton Class
    private static ToolsDAO instance;

    private ToolsDAO(){

    }

    public static ToolsDAO getInstance(){
        if(instance == null){
            instance = new ToolsDAO();
        }
        return instance;
    }

    //Methods

    public void addTool(ToolModel e) throws IllegalArgumentException{
        if(e.getId() == null){
            e.setId(tools.size() + 1);
        }
        if(getTool(e.getId()) != null){
            throw new IllegalArgumentException("Tool with id " + e.getId() + " already exists");
        }

        this.tools.add(e);
    }

    public void removeTool(ToolModel e){
        this.tools.remove(e);
    }

    public ArrayList<ToolModel> getTools(){
        return new ArrayList<>(this.tools);
    }

    public ToolModel getTool(int id){
        return tools.stream().filter(e -> e.getId() == id).findFirst().orElse(null);
    }

    public ToolModel getTool(String name){
        return tools.stream().filter(e -> e.getNome().toUpperCase().equals(name.toUpperCase())).findFirst().orElse(null);
    }

    public ArrayList<ToolModel> getToolsByManufacturer(int manufacturerId){
        return new ArrayList<>(tools.stream().filter(e -> e.getManufacturer() != null && e.getManufacturer().getId() == manufacturerId).collect(Collectors.toList()));
    }

    public ArrayList<ToolModel> getToolsWithoutManufacturer(){
        return new ArrayList<>(tools.stream().filter(e -> e.getManufacturer() == null).collect(Collectors.toList()));
    }

    
}
