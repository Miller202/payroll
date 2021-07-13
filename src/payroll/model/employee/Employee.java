package payroll.model.employee;

import payroll.model.payments.PayCheck;
import payroll.model.payments.PaymentData;
import payroll.model.services.ServiceTax;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.UUID;
import java.util.function.Predicate;

import static java.util.stream.Collectors.toCollection;

public abstract class Employee {

    private UUID id;

    private String name;

    private String address;

    private Syndicate syndicate;

    private PaymentData paymentData;

    public Employee(){

    }

    public Employee(UUID id, String name, String address, Syndicate syndicate, PaymentData paymentData) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.syndicate = syndicate;
        this.paymentData = paymentData;
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

    public PaymentData getPaymentData() {
        return paymentData;
    }

    public void setPaymentData(PaymentData paymentData) {
        this.paymentData = paymentData;
    }

    @Override
    public String toString() {
        String str = "Id no sistema: " + getId();
        str += "\nNome: " + getName();
        str += "\nEndereço: " + getAddress();
        if(getSyndicate() != null){
            str += getSyndicate().toString();
        }else{
            str += "\nNão é membro do sindicato";
        }
        str += "\nDados de pagamento:" + getPaymentData().toString();
        return str;
    }

    public Double getSyndicateTax() {
        Double tax = 0.0;

        if (this.getSyndicate() != null) {
            if (this.getSyndicate().isActive()) {
                tax += this.getSyndicate().getTax();
            }
        }

        return tax;
    }

    public Double calcServicesTaxes(){
        ArrayList<ServiceTax> serviceTaxes;
        ArrayList<PayCheck> payChecks = this.getPaymentData().getPayChecks();
        Double taxes = 0.0;

        if(this.getSyndicate() != null){

            if (payChecks.isEmpty()) {
                serviceTaxes = this.getSyndicate().getServiceTaxes();
            } else {
                LocalDate lastDate = payChecks.get(payChecks.size() - 1).getDate();
                Predicate<ServiceTax> dateFilter = tax -> tax.getDate().isAfter(lastDate);

                serviceTaxes = this.getSyndicate().getServiceTaxes().stream().filter(dateFilter).
                        collect(toCollection(ArrayList::new));
            }

            for(ServiceTax stax : serviceTaxes){
                taxes += stax.getValue();
            }
        }

        return taxes;
    }

    public abstract Double getGrossPayment(LocalDate paymentDate);

    public PayCheck makePayment(LocalDate paymentDate){
        PayCheck payCheck;
        Double paymentValue = getGrossPayment(paymentDate);
        Double taxSyndicate = getSyndicateTax();
        Double taxes = calcServicesTaxes();
        boolean haveTax = false;

        if(taxSyndicate > 0.0){
            taxes += taxSyndicate;
            haveTax = true;
        }

        payCheck = new PayCheck(this, paymentValue, taxes, haveTax, paymentDate);
        this.getPaymentData().getPayChecks().add(payCheck);
        return payCheck;
    }

}
