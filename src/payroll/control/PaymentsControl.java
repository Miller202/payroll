package payroll.control;

import payroll.main.GeneralUtils;
import payroll.model.employee.Employee;
import payroll.model.payments.PayCheck;
import payroll.model.payments.PaymentList;
import payroll.model.payments.PaymentSchedule;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class PaymentsControl {

    public static PaymentList payroll(Scanner input, ArrayList<Employee> employees){
        PayCheck payCheck;
        PaymentList paymentList;
        ArrayList<PayCheck> payCheckList = new ArrayList<>();

        LocalDate payDate = GeneralUtils.readData(input);
        for(Employee emp : employees){
            payCheck = emp.makePayment(payDate);
            System.out.println(payCheck.toString());
            payCheckList.add(payCheck);
        }

        paymentList = new PaymentList(payCheckList, payDate);
        return paymentList;
    }

    public static ArrayList<PaymentSchedule> startSchedules(){
        ArrayList<PaymentSchedule> paymentSchedules = new ArrayList<>();

        paymentSchedules.add(new PaymentSchedule(null, null, "Mensal"));
        paymentSchedules.add(new PaymentSchedule(null, DayOfWeek.FRIDAY, "Semanal"));
        paymentSchedules.add(new PaymentSchedule(null, DayOfWeek.FRIDAY, "Bisemanal"));

        return paymentSchedules;
    }

}
