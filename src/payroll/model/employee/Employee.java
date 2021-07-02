package payroll.model.employee;

import payroll.model.payments.PaymentData;

import java.util.UUID;

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

}
