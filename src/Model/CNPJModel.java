package Model;

public class CNPJModel {
    
    //Esta classe serve de retorno para a consulta api de CNPJ, retornando uma classe CNPJModel da consulta e integrando no JFrame.

    private String nome;
    private String telefone;
    private double capitalSocial;
    private String sampleAddress;
    private String status;
    private String situacao;
    private String cnpj;

    public CNPJModel() {
    }

    public CNPJModel(String nome, String telefone, double capitalSocial, String sampleAddress, String status, String situacao, String cnpj) {
        this.nome = nome;
        this.telefone = telefone;
        this.capitalSocial = capitalSocial;
        this.sampleAddress = sampleAddress;
        this.status = status;
        this.situacao = situacao;
        this.cnpj = cnpj;
    }

    public String getNome() {
        return this.nome;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public double getCapitalSocial() {
        return this.capitalSocial;
    }

    public String getSampleAddress() {
        return this.sampleAddress;
    }

    public String getStatus() {
        return this.status;
    }

    public String getSituacao() {
        return this.situacao;
    }

    public String getCNPJ() {
        return this.cnpj;
    }
}
