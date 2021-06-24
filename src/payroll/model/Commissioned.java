package payroll.model;

public class Commissioned extends Employee{

    private Double fixedSalary;

    private Double commission;

    public Commissioned(){

    }

    public Commissioned(Double fixedSalary, Double commission){
        this.fixedSalary = fixedSalary;
        this.commission = commission;
    }

    public Commissioned(int id, String name, String address, Syndicate syndicate,
                        Double fixedSalary, Double commission) {
        super(id, name, address, syndicate);
        this.fixedSalary = fixedSalary;
        this.commission = commission;
    }

    public Double getFixedSalary() {
        return fixedSalary;
    }

    public void setFixedSalary(Double fixedSalary) {
        this.fixedSalary = fixedSalary;
    }

    public Double getCommission() {
        return commission;
    }

    public void setCommission(Double commission) {
        this.commission = commission;
    }

    @Override
    public String toString() {
        return super.toString() + "Comissionado{" +
                "Salário fixo=" + fixedSalary +
                ", Comissão=" + commission +
                '}';
    }
}
