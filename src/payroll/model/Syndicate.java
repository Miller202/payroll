package payroll.model;

import java.util.ArrayList;

public class Syndicate {

    private int id;

    private int EmployeeId;

    private boolean active;

    private Double tax;

    private ArrayList<ServiceTax> serviceTaxes;

    public Syndicate(){

    }

    public Syndicate(int id, int EmployeeId, boolean active, Double tax) {
        this.id = id;
        this.EmployeeId = EmployeeId;
        this.active = active;
        this.tax = tax;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEmployeeId() {
        return EmployeeId;
    }

    public void setEmployeeId(int employeeId) {
        EmployeeId = employeeId;
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Double getTax() {
        return tax;
    }

    public void setTax(Double tax) {
        this.tax = tax;
    }

    public ArrayList<ServiceTax> getServiceTaxes() {
        return serviceTaxes;
    }

    public void setServiceTaxes(ArrayList<ServiceTax> serviceTaxes) {
        this.serviceTaxes = serviceTaxes;
    }

    @Override
    public String toString() {
        String str = "\nId no sindicato: " + getId();
        str += "\nMembro ativo do sindicato: " + getActive();
        str += "\nTaxa do sindicato: " + getTax();
        str += "\nTaxas de serviço: {" + getServiceTaxes() + "}";
        return str;
    }

}
