package payroll.main;

import payroll.control.EmployeeControl;
import payroll.control.PaymentsControl;
import payroll.control.ServicesControl;
import payroll.model.Enterprise;

import java.time.DateTimeException;
import java.util.Scanner;

public class Menu {
    public static void menu(Enterprise enterprise){

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
                    enterprise.getEmployees().add(EmployeeControl.register(input, enterprise.getPaymentSchedules()));
                }
                else if(option == 2){
                    if(!enterprise.getEmployees().isEmpty()){
                        EmployeeControl.removeEmployee(input, enterprise.getEmployees());
                    }else{
                        System.out.println("Não há empregados cadastrados!");
                    }
                }
                else if(option == 3){
                    if(!enterprise.getEmployees().isEmpty()){
                        EmployeeControl.listEmployees(enterprise.getEmployees());
                    }else{
                        System.out.println("Não há empregados cadastrados!");
                    }
                }
                else if(option == 4){
                    if(!enterprise.getEmployees().isEmpty()){
                        ServicesControl.postTimeCard(input, enterprise.getEmployees());
                    }else{
                        System.out.println("Não há empregados cadastrados!");
                    }
                }
                else if(option == 5){
                    if(!enterprise.getEmployees().isEmpty()){
                        ServicesControl.postSaleResult(input, enterprise.getEmployees());
                    }else{
                        System.out.println("Não há empregados cadastrados!");
                    }
                }
                else if(option == 6){
                    if(!enterprise.getEmployees().isEmpty()){
                        ServicesControl.postServiceTax(input, enterprise.getEmployees());
                    }else{
                        System.out.println("Não há empregados cadastrados!");
                    }
                }
                else if(option == 7){
                    if(!enterprise.getEmployees().isEmpty()){
                        EmployeeControl.editEmployee(input, enterprise.getEmployees());
                    }else{
                        System.out.println("Não há empregados cadastrados!");
                    }
                }
                else if(option == 8){
                    if(!enterprise.getEmployees().isEmpty()){
                        enterprise.getPaymentsLists().add(PaymentsControl.payroll(input, enterprise.getEmployees()));
                    }else{
                        System.out.println("Não há empregados cadastrados!");
                    }
                }
                else if(option == 9){
                    System.out.println("\n----Relatório com as listas dos pagamentos----\n");
                    System.out.println(enterprise.getPaymentsLists());
                }
                else if(option == 10){
                    EmployeeControl.editEmployeeSchedule(input, enterprise.getEmployees(), enterprise.getPaymentSchedules());
                    System.out.println("Operação realizada com sucesso!");
                }
                else if(option == 11){
                    enterprise.getPaymentSchedules().add(PaymentsControl.createPaymentSchedule(input));
                    System.out.println("Operação realizada com sucesso!");
                }
            }
        }catch (DateTimeException | IndexOutOfBoundsException err){
            System.out.println("\nData inválida!\n");
            menu(enterprise);
        } catch (NumberFormatException err){
            System.out.println("\nEntrada inválida!\n");
            menu(enterprise);
        }
    }
}
