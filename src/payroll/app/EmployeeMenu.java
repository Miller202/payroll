package payroll.app;

import payroll.model.*;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class EmployeeMenu {

    public static Employee register(Scanner input, ArrayList<Employee> Employees){
        Employee employee = null;
        Syndicate syndicate = null;
        int answer = 0;

        int id = EmployeeIdGenerate(Employees);

        System.out.println("\nDigite o nome do empregado:");
        String name = input.nextLine();
        System.out.println();

        System.out.println("Digite o endereço:");
        String address = input.nextLine();
        System.out.println();

        System.out.println("Qual o tipo de empregado?");
        System.out.printf("[1] Horista\n[2] Salariado\n[3] Comissionado\n");
        answer = input.nextInt();
        System.out.println();

        if(answer == 1){
            System.out.println("Digite o salário por hora:");
            Double hourlySalary = input.nextDouble();
            input.nextLine();
            System.out.println();

            employee = new Hourly(id, name, address, syndicate, hourlySalary);
        }
        else if(answer == 2){
            System.out.println("Digite o salário:");
            Double salary = input.nextDouble();
            input.nextLine();
            System.out.println();

            employee = new Salaried(id, name, address, syndicate, salary);
        }
        else if(answer == 3){
            input.nextLine();
            System.out.println("Digite o salário fixo:");
            Double fixedSalary = input.nextDouble();
            System.out.println();

            System.out.println("Digite a taxa de comissão:");
            Double commission = input.nextDouble();
            input.nextLine(); // to read the 'Enter'
            System.out.println();

            employee = new Commissioned(id, name, address, syndicate, fixedSalary, commission);
        }

        System.out.println(employee.toString());

        return employee;
    }

    public static int EmployeeIdGenerate(ArrayList<Employee> Employees) {
        Random random = new Random();
        int id = random.nextInt(1000) + random.nextInt(35) + random.nextInt(849);
        int size = Employees.size();
        for(int i = 0; i < size; i++) {
            if(id == Employees.get(i).getId()) {
                id = random.nextInt(1000) + random.nextInt(35) + random.nextInt(849);
                i = 0;
            }
        }
        return id;
    }

    public int SyndicateIdGenerate(ArrayList<Syndicate> SyndicateMembers) {
        Random random = new Random();
        int id = random.nextInt(1000) + random.nextInt(35) + random.nextInt(849);
        int size = SyndicateMembers.size();
        for(int i = 0; i < size; i++) {
            if(id == SyndicateMembers.get(i).getId()) {
                id = random.nextInt(1000) + random.nextInt(35) + random.nextInt(849);
                i = 0;
            }
        }
        return id;
    }

}
