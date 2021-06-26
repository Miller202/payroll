package payroll.model.services;

import java.time.LocalDate;

public class ServiceTax {

    public Double value;

    public LocalDate date;

    public ServiceTax(){

    }

    public ServiceTax(Double value, LocalDate date) {
        this.value = value;
        this.date = date;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

}
