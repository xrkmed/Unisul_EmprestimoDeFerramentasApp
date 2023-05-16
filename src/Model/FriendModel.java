package Model;

import Resources.AddressResource;
import java.util.Objects;

public class FriendModel {

    private Integer id;
    private String name;
    private AddressResource address;
    private String phone;

    public FriendModel(){

    }

    public FriendModel(String name, AddressResource address, String phone){
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public FriendModel(Integer id, String name, AddressResource address, String phone){
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public Integer getId(){
        return this.id;
    }

    public void setId(int id){
        if(this.id == null)
            this.id = id;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public AddressResource getAddress(){
        return this.address;
    }

    public String getPhone(){
        return this.phone;
    }

    public void setPhone(String phone){
        this.phone = phone;
    }

    public void updateAddress(AddressResource e){
        this.address = e;
    }

    @Override
    public String toString() {
        return "FriendModel{" + "id=" + id + ", name=" + name + ", address=" + address + ", phone=" + phone + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final FriendModel other = (FriendModel) obj;
        return Objects.equals(this.id, other.id);
    }


    
}
