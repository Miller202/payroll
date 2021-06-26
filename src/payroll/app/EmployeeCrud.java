package payroll.app;

import payroll.model.employee.*;

import java.util.Scanner;
import java.util.UUID;

public class EmployeeCrud {

    public static Employee register(Scanner input){
        Employee employee;
        Syndicate syndicate = null;
        int answer = 0;

        UUID id = UUID.randomUUID();

        System.out.println("\nDigite o nome do empregado:");
        String name = input.nextLine();

        System.out.println("Digite o endereço:");
        String address = input.nextLine();

        System.out.println("Qual o tipo de empregado?");
        System.out.printf("[1] - Horista, [2] - Salariado, [3] - Comissionado\n");
        answer = input.nextInt();

        if(answer == 1){
            System.out.println("Digite o salário por hora:");
            Double hourlySalary = input.nextDouble();

            employee = new Hourly(id, name, address, syndicate, hourlySalary);
        }
        else if(answer == 2){
            System.out.println("Digite o salário:");
            Double salary = input.nextDouble();

            employee = new Salaried(id, name, address, syndicate, salary);
        }
        else if(answer == 3){
            System.out.println("Digite o salário fixo:");
            Double fixedSalary = input.nextDouble();

            System.out.println("Digite a taxa de comissão:");
            Double commission = input.nextDouble();

            employee = new Commissioned(id, name, address, syndicate, fixedSalary, commission);
        }else{
            System.out.println("Digite o salário:");
            Double salary = input.nextDouble();

            employee = new Salaried(id, name, address, syndicate, salary);
        }

        System.out.println("O empregado é membro do sindicato? ([1] - Sim, [2] - Não): ");
        int aux = input.nextInt();

        if (aux == 1){
            UUID syndicateId = UUID.randomUUID();
            System.out.println("Digite a taxa sindical:");
            Double tax = input.nextDouble();
            syndicate = new Syndicate(syndicateId, id, true, tax);
            employee.setSyndicate(syndicate);
        }

        input.nextLine();
        System.out.println();
        System.out.println("Empregado cadastrado com sucesso!");
        System.out.println(employee.toString());

        return employee;
    }

}
