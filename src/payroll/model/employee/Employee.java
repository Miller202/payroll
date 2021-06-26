package payroll.model.employee;

import java.util.UUID;

public abstract class Employee {

    private UUID id;

    private String name;

    private String address;

    private Syndicate syndicate;

    public Employee(){

    }

    public Employee(UUID id, String name, String address, Syndicate syndicate) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.syndicate = syndicate;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Syndicate getSyndicate() {
        return syndicate;
    }

    public void setSyndicate(Syndicate syndicate) {
        this.syndicate = syndicate;
    }

    @Override
    public String toString() {
        String str = "Id no sistema: " + getId();
        str += "\nNome: " + getName();
        str += "\nEndereço: " + getAddress();
        str += "\n";
        if(getSyndicate() != null){
            str += getSyndicate().toString();
        }else{
            str += "Não é membro do sindicato";
        }
        return str;
    }

}
