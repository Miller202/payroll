package payroll.control;

import payroll.main.GeneralUtils;
import payroll.model.employee.Employee;
import payroll.model.payments.PayCheck;
import payroll.model.payments.PaymentList;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class PaymentsControl {

    public static PaymentList payroll(Scanner input, ArrayList<Employee> employees){
        PayCheck payCheck;
        PaymentList paymentList;
        ArrayList<PayCheck> payCheckList = new ArrayList<>();

        LocalDate paymentDate = GeneralUtils.readData(input);
        for(Employee emp : employees){
            payCheck = emp.makePayment(paymentDate);
            System.out.println(payCheck.toString());
            payCheckList.add(payCheck);
        }

        paymentList = new PaymentList(payCheckList, paymentDate);
        return paymentList;
    }

}
