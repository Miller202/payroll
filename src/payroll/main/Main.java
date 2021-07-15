package payroll.main;

import payroll.control.EmployeeControl;
import payroll.control.PaymentsControl;
import payroll.control.ServicesControl;
import payroll.model.employee.Employee;
import payroll.model.payments.PaymentList;
import payroll.model.payments.PaymentSchedule;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        Scanner input = new Scanner(System.in);

        ArrayList<Employee> employees = new ArrayList<>();
        ArrayList<PaymentList> paymentsLists = new ArrayList<>();
        ArrayList<PaymentSchedule> paymentSchedules = PaymentsControl.startSchedules();

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
            System.out.println("[7] - Editar dados do empregado");
            System.out.println("[8] - Rodar folha de pagamento");
            System.out.println("[9] - Imprimir listas dos pagamentos");
            System.out.println("[10] - Mudar agenda de pagamento");
            System.out.println("[11] - Sair\n");

            option = input.nextInt();
            input.nextLine();

            if(option == 1){
                employees.add(EmployeeControl.register(input, paymentSchedules));
            }
            else if(option == 2){
                EmployeeControl.removeEmployee(input, employees);
            }
            else if(option == 3){
                if(!employees.isEmpty()){
                    EmployeeControl.listEmployees(employees);
                }else{
                    System.out.println("Não há empregados cadastrados!");
                }
            }
            else if(option == 4){
                ServicesControl.postTimeCard(input, employees);
            }
            else if(option == 5){
                ServicesControl.postSaleResult(input, employees);
            }
            else if(option == 6){
                ServicesControl.postServiceTax(input, employees);
            }
            else if(option == 7){
                EmployeeControl.editEmployee(input, employees);
            }
            else if(option == 8){
                if(!employees.isEmpty()){
                    paymentsLists.add(PaymentsControl.payroll(input, employees));
                }else{
                    System.out.println("Não há empregados cadastrados!");
                }
            }
            else if(option == 9){
                System.out.println("\n----Relatório com as listas dos pagamentos----\n");
                System.out.println(paymentsLists);
            }
            else if(option == 10){
                EmployeeControl.editEmployeeSchedule(input, employees, paymentSchedules);
            }
        }
    }
}
