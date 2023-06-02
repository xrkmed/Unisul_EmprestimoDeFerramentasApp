package Resources;

public class ManufacturerResource {

    private Integer id;
    private String name;
    private String cnpj;

    public ManufacturerResource() {

    }

    public ManufacturerResource(String name, String cnpj) {
        this.name = name;
        this.setCNPJ(cnpj);
    }

    public ManufacturerResource(Integer id, String name, String cnpj) {
        this.id = id;
        this.name = name;
        this.setCNPJ(cnpj);
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(int id) {
        if (this.id == null) {
            this.id = id;
        }
    }

    public String getName() {
        return this.name;
    }

    public String getCNPJ() {
        return this.cnpj != null ? this.cnpj : "00.000.000/0000-00";
    }

    public void setCNPJ(String cnpj) {
        if (!cnpj.equals("00.000.000/0000-00") && !CNPJResource.validarCNPJ(cnpj)) {
            cnpj = "00.000.000/0000-00";
        }

        this.cnpj = cnpj;
    }

}
