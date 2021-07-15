package payroll.control;

import payroll.main.GeneralUtils;
import payroll.model.employee.Employee;
import payroll.model.payments.PayCheck;
import payroll.model.payments.PaymentList;
import payroll.model.payments.PaymentSchedule;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Scanner;

public class PaymentsControl {

    public static PaymentList payroll(Scanner input, ArrayList<Employee> employees){
        int i, week = -1;
        PayCheck payCheck;
        PaymentList paymentList = null;
        ArrayList<PayCheck> payCheckList = new ArrayList<>();

        System.out.println("\nDigite a primeira data do mês referente ao pagamento: ");
        LocalDate firstDate = GeneralUtils.readData(input);
        System.out.println("\nDigite a última data do mês referente ao pagamento: ");
        LocalDate lastDate = GeneralUtils.readData(input);

        long size = ChronoUnit.DAYS.between(firstDate, lastDate.plusDays(1));

        for(i = 0; i < size; i++){
            LocalDate current = firstDate.plusDays(i);

            if(current.getDayOfWeek() == firstDate.getDayOfWeek()){
                week += 1;
            }

            for(Employee emp : employees){
                if(verifyPayDate(emp, week, current)){
                    payCheck = emp.makePayment(current);
                    System.out.println(payCheck.toString());
                    payCheckList.add(payCheck);
                }
            }
        }

        if(!payCheckList.isEmpty()) {
            paymentList = new PaymentList(payCheckList, lastDate);
        }

        return paymentList;
    }

    public static boolean verifyPayDate(Employee employee, int week, LocalDate current){
        boolean alreadyPay = false;
        boolean dateInSchedule = false;
        PaymentSchedule empSchedule = employee.getPaymentData().getSchedule();

        switch (empSchedule.getSchedule()) {
            case "Mensal":
                if (empSchedule.getMonthDay() == null) {
                    dateInSchedule = current.isEqual(GeneralUtils.
                            getLastJobDay(current.with(TemporalAdjusters.lastDayOfMonth())));
                } else {
                    dateInSchedule = (empSchedule.getMonthDay() == current.getDayOfMonth());
                }
                break;
            case "Semanal":
                dateInSchedule = (empSchedule.getWeekDay() == current.getDayOfWeek());
                break;
            case "Bisemanal":
                dateInSchedule = (empSchedule.getWeekDay() == current.getDayOfWeek() && week%2==0);
                break;
        }

        for(PayCheck pc : employee.getPaymentData().getPayChecks()){
            if (pc.getDate() == current) {
                alreadyPay = true;
                break;
            }
        }

        return (dateInSchedule && (!alreadyPay));
    }

    public static ArrayList<PaymentSchedule> startSchedules(){
        ArrayList<PaymentSchedule> paymentSchedules = new ArrayList<>();

        paymentSchedules.add(new PaymentSchedule(null, null, "Mensal"));
        paymentSchedules.add(new PaymentSchedule(null, DayOfWeek.FRIDAY, "Semanal"));
        paymentSchedules.add(new PaymentSchedule(null, DayOfWeek.FRIDAY, "Bisemanal"));

        return paymentSchedules;
    }

}
