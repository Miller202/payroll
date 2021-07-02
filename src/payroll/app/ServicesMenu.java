package payroll.app;

import payroll.model.employee.Commissioned;
import payroll.model.employee.Employee;
import payroll.model.employee.Hourly;
import payroll.model.services.SaleResult;
import payroll.model.services.TimeCard;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ServicesMenu {

    public static void postTimeCard(Scanner input, ArrayList<Employee> Employees){
        System.out.println("Digite o ID do empregado:");
        String id = input.nextLine();

        Predicate<Employee> empFilter = employee -> employee instanceof Hourly;
        ArrayList<Employee> hourlyList = Employees.stream().filter(empFilter).
                collect(Collectors.toCollection(ArrayList::new));

        Hourly employeeToPost = null;
        for(Employee hourly : hourlyList){
            if(hourly.getId().toString().equals(id)){
                employeeToPost = (Hourly) hourly;
            }
        }

        if(employeeToPost == null){
            System.out.println("Empregado não encontrado na lista de Horistas!");
        }else{

            System.out.println("Digite o dia (número):");
            int day = input.nextInt();
            System.out.println("Digite o mês (número):");
            int month = input.nextInt();
            System.out.println("Digite o ano:");
            int year = input.nextInt();
            input.nextLine();
            LocalDate date = LocalDate.of(year, month, day);

            System.out.println("Digite a hora de entrada:");
            int hourEntry = input.nextInt();
            System.out.println("Digite o minuto de entrada:");
            int minuteEntry = input.nextInt();
            LocalTime timeEntry = LocalTime.of(hourEntry, minuteEntry);

            System.out.println("Digite a hora de saída:");
            int hourOut = input.nextInt();
            System.out.println("Digite o minuto de saída:");
            int minuteOut = input.nextInt();
            LocalTime timeOut = LocalTime.of(hourOut, minuteOut);

            TimeCard timeCard = new TimeCard(date, timeEntry, timeOut);
            employeeToPost.getTimeCards().add(timeCard);
            System.out.println("Cartão de ponto registrado!");
        }

    }

    public static void postSaleResult(Scanner input, ArrayList<Employee> Employees){
        System.out.println("Digite o ID do empregado:");
        String id = input.nextLine();

        Predicate<Employee> empFilter = employee -> employee instanceof Commissioned;
        ArrayList<Employee> commissionedList = Employees.stream().filter(empFilter).
                collect(Collectors.toCollection(ArrayList::new));

        Commissioned employeeToPost = null;
        for(Employee commissioned : commissionedList){
            if(commissioned.getId().toString().equals(id)){
                employeeToPost = (Commissioned) commissioned;
            }
        }

        if(employeeToPost == null){
            System.out.println("Empregado não encontrado na lista de Comissionados!");
        }else{
            System.out.println("Digite o dia (número):");
            int day = input.nextInt();
            System.out.println("Digite o mês (número):");
            int month = input.nextInt();
            System.out.println("Digite o ano:");
            int year = input.nextInt();
            input.nextLine();
            LocalDate date = LocalDate.of(year, month, day);

            System.out.println("Digite o valor da venda:");
            Double value = input.nextDouble();

            SaleResult saleResult =  new SaleResult(value, date);
            employeeToPost.getSaleResults().add(saleResult);
            System.out.println("Resultado da venda registrado!");
        }
    }
}
