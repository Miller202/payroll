package payroll.main;

import payroll.control.EmployeeControl;
import payroll.control.ServicesControl;
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
            System.out.println("[1] - Cadastrar empregado");
            System.out.println("[2] - Remover empregado");
            System.out.println("[3] - Listar empregados");
            System.out.println("[4] - Lançar cartão de ponto");
            System.out.println("[5] - Lançar resultado de venda");
            System.out.println("[6] - Lançar taxa de serviço");
            System.out.println("[7] - Editar empregado");
            System.out.println("[11] - Sair\n");

            option = input.nextInt();
            input.nextLine();

            if(option == 1){
                Employees.add(EmployeeControl.register(input));
            }
            else if(option == 2){
                EmployeeControl.removeEmployee(input, Employees);
            }
            else if(option == 3){
                EmployeeControl.listEmployees(Employees);
            }
            else if(option == 4){
                ServicesControl.postTimeCard(input, Employees);
            }
            else if(option == 5){
                ServicesControl.postSaleResult(input, Employees);
            }
            else if(option == 6){
                ServicesControl.postServiceTax(input, Employees);
            }
            else if(option == 7){
                EmployeeControl.editEmployee(input, Employees);
            }
        }
    }

}
