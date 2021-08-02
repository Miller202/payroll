package payroll.main;

import payroll.control.PaymentsControl;
import payroll.model.employee.Employee;
import payroll.model.payments.PaymentList;
import payroll.model.payments.PaymentSchedule;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args){

        Enterprise enterprise = new Enterprise();

        ArrayList<Employee> employees = new ArrayList<>();
        ArrayList<PaymentList> paymentsLists = new ArrayList<>();
        ArrayList<PaymentSchedule> paymentSchedules = PaymentsControl.startSchedules();

        Menu.menu(employees, paymentsLists, paymentSchedules);

    }

}
