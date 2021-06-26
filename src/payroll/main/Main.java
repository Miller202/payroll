package payroll.main;

import payroll.app.EmployeeCrud;
import payroll.model.employee.Employee;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        Scanner input = new Scanner(System.in);

        ArrayList<Employee> Employees = new ArrayList<Employee>();

        int option = 0;

        while(option != 11){
            System.out.println("\nFolha de pagamento");
            System.out.println("Escolha uma das opções: ");
            System.out.println("[1] - Cadastrar Empregado");
            System.out.println("[11] - Sair\n");

            option = input.nextInt();
            input.nextLine();

            if(option == 1){
                Employees.add(EmployeeCrud.register(input));
            }
        }
    }

}
