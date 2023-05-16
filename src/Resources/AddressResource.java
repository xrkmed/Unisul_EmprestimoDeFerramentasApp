package Resources;

public class AddressResource {

    private String street;
    private String city;
    private String state;
    private String district;
    private Integer number;
    private String complemento;
    private Integer CEP;

    public AddressResource(){

    }

    public AddressResource(String street, String district, String city, String state, Integer number, String complemento, Integer CEP){
        this.street = street;
        this.city = city;
        this.state = state;
        this.district = district;
        this.CEP = CEP;
        this.number = number;
        this.complemento = complemento;
    }

    public String getStreet(){
        return this.street;
    }

    public String getCity(){
        return this.city;
    }

    public String getState(){
        return this.state;
    }

    public Integer getCEP(){
        return this.CEP;
    }

    public String getDistrict(){
        return this.district;
    }

    public Integer getNumber(){
        return this.number;
    }

    public String getComplemento(){
        return this.complemento;
    }

    public void setNumber(Integer number){
        this.number = number;
    }

    public void setComplemento(String complemento){
        this.complemento = complemento;
    }

    public void setStreet(String street){
        this.street = street;
    }

    public void setCity(String city){
        this.city = city;
    }

    public void setState(String state){
        this.state = state;
    }

    public void setDistrict(String district){
        this.district = district;
    }

    public void setCEP(Integer CEP){
        this.CEP = CEP;
    }

    @Override
    public String toString() {
        return street + ", " + number + " - " + district + ", " + city + " - " + state + ", " + CEP;
    }
    
    
    
}
