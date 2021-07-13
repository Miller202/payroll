package payroll.model.employee;

import payroll.model.payments.PaymentData;
import payroll.model.services.TimeCard;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
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

    @Override
    public Double getGrossPayment(LocalDate paymentDate) {
        ArrayList<TimeCard> timeCards = this.getTimeCards();
        double grossPayment = 0.0, hours = 0.0, extraHours = 0.0;

        for(TimeCard tc : timeCards){
            LocalTime timeEntry = tc.getTimeEntry();
            LocalTime timeOut = tc.getTimeOut();
            Duration time = Duration.between(timeEntry, timeOut);
            hours = (double) time.getSeconds() / 3600;

            if(hours > 8.0){
                extraHours = hours - 8.0;
                grossPayment += 8.0 * this.getHourlySalary();
                grossPayment += extraHours * 1.5 * this.getHourlySalary();
            }
            else if(hours >= 0.0){
                grossPayment += hours * this.getHourlySalary();
            }
        }

        return grossPayment;
    }

}
