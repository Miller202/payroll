package payroll.model.employee;

import payroll.model.payments.PaymentData;
import payroll.model.services.TimeCard;

import java.util.ArrayList;
import java.util.UUID;

public class Hourly extends Employee {

    private Double HourlySalary;

    ArrayList<TimeCard> timeCards;

    public Hourly(){

    }

    public Hourly(Double hourlySalary){
        this.HourlySalary = hourlySalary;
        this.timeCards = new ArrayList<TimeCard>();
    }

    public Hourly(UUID id, String name, String address, Syndicate syndicate,
                  PaymentData paymentData, Double hourlySalary) {
        super(id, name, address, syndicate, paymentData);
        HourlySalary = hourlySalary;
        this.timeCards = new ArrayList<TimeCard>();
    }

    public Double getHourlySalary() {
        return HourlySalary;
    }

    public void setHourlySalary(Double hourlySalary) {
        HourlySalary = hourlySalary;
    }

    public ArrayList<TimeCard> getTimeCards() {
        return timeCards;
    }

    public void setTimeCards(ArrayList<TimeCard> timeCards) {
        this.timeCards = timeCards;
    }

    @Override
    public String toString() {
        return super.toString() + "\nHorista: {" +
                " Salário por hora: " + getHourlySalary() +
                ", Cartões de ponto: " + getTimeCards() +
                '}';
    }

}
