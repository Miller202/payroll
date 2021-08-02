package payroll.model;

public class Enterprise {

    private ArrayList<Employee> employees;

    private ArrayList<PaymentList> paymentsLists;

    private ArrayList<PaymentSchedule> paymentSchedules;


    public Enterprise(){
        this.employees = new ArrayList<>();
        this.paymentsLists = new ArrayList<>();
        this.paymentSchedules = PaymentsControl.startSchedules();
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(ArrayList<Employee> employees) {
        this.employees = employees;
    }

    public void addEmployee(Employee employee) {
        this.employees.add(employee);
    }

    public ArrayList<PaymentList> getPaymentsLists() {
        return paymentsLists;
    }

    public void setPaymentsLists(ArrayList<PaymentList> paymentLists) {
        this.paymentsLists = paymentsLists;
    }

    public ArrayList<PaymentSchedule> getPaymentSchedules() {
        return paymentSchedules;
    }

    public void setPaymentSchedules(ArrayList<PaymentSchedule> paymentSchedules) {
        this.paymentSchedules = paymentSchedules;
    }

}
