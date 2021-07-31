package payroll.main;

import payroll.control.EmployeeControl;
import payroll.control.PaymentsControl;
import payroll.control.ServicesControl;
import payroll.model.employee.Employee;
import payroll.model.payments.PaymentList;
import payroll.model.payments.PaymentSchedule;

import java.time.DateTimeException;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    public static void menu(ArrayList<Employee> employees, ArrayList<PaymentList> paymentsLists,
                                ArrayList<PaymentSchedule> paymentSchedules){

        Scanner input = new Scanner(System.in);

        int option = 0;

        try{
            while(option != 12){
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
                System.out.println("[10] - Mudar agenda de pagamentos");
                System.out.println("[11] - Registrar nova agenda de pagamentos");
                System.out.println("[12] - Sair\n");

                option = input.nextInt();
                input.nextLine();

                if(option == 1){
                    employees.add(EmployeeControl.register(input, paymentSchedules));
                }
                else if(option == 2){
                    if(!employees.isEmpty()){
                        EmployeeControl.removeEmployee(input, employees);
                    }else{
                        System.out.println("Não há empregados cadastrados!");
                    }
                }
                else if(option == 3){
                    if(!employees.isEmpty()){
                        EmployeeControl.listEmployees(employees);
                    }else{
                        System.out.println("Não há empregados cadastrados!");
                    }
                }
                else if(option == 4){
                    if(!employees.isEmpty()){
                        ServicesControl.postTimeCard(input, employees);
                    }else{
                        System.out.println("Não há empregados cadastrados!");
                    }
                }
                else if(option == 5){
                    if(!employees.isEmpty()){
                        ServicesControl.postSaleResult(input, employees);
                    }else{
                        System.out.println("Não há empregados cadastrados!");
                    }
                }
                else if(option == 6){
                    if(!employees.isEmpty()){
                        ServicesControl.postServiceTax(input, employees);
                    }else{
                        System.out.println("Não há empregados cadastrados!");
                    }
                }
                else if(option == 7){
                    if(!employees.isEmpty()){
                        EmployeeControl.editEmployee(input, employees);
                    }else{
                        System.out.println("Não há empregados cadastrados!");
                    }
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
                    System.out.println("Operação realizada com sucesso!");
                }
                else if(option == 11){
                    paymentSchedules.add(PaymentsControl.createPaymentSchedule(input));
                    System.out.println("Operação realizada com sucesso!");
                }
            }
        }catch (DateTimeException | IndexOutOfBoundsException err){
            System.out.println("\nData inválida!\n");
            menu(employees, paymentsLists, paymentSchedules);
        } catch (NumberFormatException err){
            System.out.println("\nEntrada inválida!\n");
            menu(employees, paymentsLists, paymentSchedules);
        }
    }
}
