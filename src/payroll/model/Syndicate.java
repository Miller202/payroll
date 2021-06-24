package payroll.model;

public class Syndicate {

    private int id;

    private int EmployeeId;

    private boolean active;

    private Double tax;

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

    @Override
    public String toString() {
        String str = "\nId no sindicato: " + getId();
        str += "\nMembro ativo do sindicato: " + getActive();
        str += "\nTaxa do sindicato: " + getTax();
        return str;
    }

}
