package Resources;

import Controllers.CNPJEntity;

public class ManufacturerResource {

    private Integer id;
    private String name;
    private String cnpj;

    public ManufacturerResource(){

    }

    public ManufacturerResource(String name, String cnpj) throws IllegalArgumentException{
        this.name = name;
        this.setCNPJ(cnpj);
    }

    public ManufacturerResource(Integer id, String name, String cnpj) throws IllegalArgumentException{
        this.id = id;
        this.name = name;
        this.setCNPJ(cnpj);
    }

    public Integer getId(){
        return this.id;
    }

    public void setId(int id){
        if(this.id == null){
            this.id = id;
        }
    }

    public String getName(){
        return this.name;
    }

    public String getCNPJ(){
        return this.cnpj;
    }

    public void setCNPJ(String cnpj) throws IllegalArgumentException{
        if(CNPJResource.validarCNPJ(cnpj)){
            this.cnpj = cnpj;
        }else{
            throw new IllegalArgumentException("Invalid CNPJ");
        }
    }
    
}
