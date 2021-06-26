package payroll.model.employee;

import payroll.model.services.SaleResult;

import java.util.ArrayList;
import java.util.UUID;

public class Commissioned extends Employee {

    private Double fixedSalary;

    private Double commission;

    private ArrayList<SaleResult> saleResults;

    public Commissioned(){

    }

    public Commissioned(Double fixedSalary, Double commission){
        this.fixedSalary = fixedSalary;
        this.commission = commission;
        this.saleResults = new ArrayList<SaleResult>();
    }

    public Commissioned(UUID id, String name, String address, Syndicate syndicate,
                        Double fixedSalary, Double commission) {
        super(id, name, address, syndicate);
        this.fixedSalary = fixedSalary;
        this.commission = commission;
        this.saleResults = new ArrayList<SaleResult>();
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

    public ArrayList<SaleResult> getSaleResults() {
        return saleResults;
    }

    public void setSaleResults(ArrayList<SaleResult> saleResults) {
        this.saleResults = saleResults;
    }

    @Override
    public String toString() {
        return super.toString() + "Comissionado{" +
                " Salário fixo: " + getFixedSalary() +
                ", Comissão: " + getCommission() +
                ", Resultado das vendas: " + getSaleResults() +
                '}';
    }
}
