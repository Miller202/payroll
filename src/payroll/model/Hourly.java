package payroll.model;

public class Hourly extends Employee {

    private Double HourlySalary;

    public Hourly(){

    }

    public Hourly(Double hourlySalary){
        this.HourlySalary = hourlySalary;
    }

    public Hourly(int id, String name, String address, Syndicate syndicate, Double hourlySalary) {
        super(id, name, address, syndicate);
        HourlySalary = hourlySalary;
    }

    public Double getHourlySalary() {
        return HourlySalary;
    }

    public void setHourlySalary(Double hourlySalary) {
        HourlySalary = hourlySalary;
    }

    @Override
    public String toString() {
        return super.toString() + "\nHorista{" +
                "Salário por hora=" + getHourlySalary() +
                '}';
    }

}
