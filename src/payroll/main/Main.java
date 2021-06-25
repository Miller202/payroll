package payroll.main;

import payroll.app.EmployeeMenu;
import payroll.model.Employee;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        System.out.println("Folha de pagamento");

        Scanner input = new Scanner(System.in);

        ArrayList<Employee> Employees = new ArrayList<Employee>();

        Employees.add(EmployeeMenu.register(input, Employees));
    }

}
