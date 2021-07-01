package payroll.model.payments;

public class PaymentData {

    private int bank;

    private int agency;

    private int account;

    private String paymentMethod;

    private String schedule;

    public PaymentData(){

    }

    public PaymentData(int bank, int agency, int account, String paymentMethod, String schedule) {
        this.bank = bank;
        this.agency = agency;
        this.account = account;
        this.paymentMethod = paymentMethod;
        this.schedule = schedule;
    }

    public int getBank() {
        return bank;
    }

    public void setBank(int bank) {
        this.bank = bank;
    }

    public int getAgency() {
        return agency;
    }

    public void setAgency(int agency) {
        this.agency = agency;
    }

    public int getAccount() {
        return account;
    }

    public void setAccount(int account) {
        this.account = account;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    @Override
    public String toString() {
        return " {" +
                "Banco: " + getBank() +
                ", Agencia: " + getAgency() +
                ", Conta: " + getAccount() +
                ", Método de pagamento: '" + getPaymentMethod() + '\'' +
                ", Agenda: '" + getSchedule() + '\'' +
                '}';
    }
}
