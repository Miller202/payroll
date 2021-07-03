package payroll.app;

import payroll.model.employee.*;
import payroll.model.payments.PaymentData;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

public class EmployeeCrud {

    public static Employee register(Scanner input){
        Employee employee;
        Syndicate syndicate = null;
        PaymentData paymentData = null;
        int answer = 0;

        UUID id = UUID.randomUUID();

        System.out.println("\nDigite o nome do empregado:");
        String name = input.nextLine();

        System.out.println("\nDigite o endereço:");
        String address = input.nextLine();

        System.out.println("\nQual o tipo de empregado?");
        System.out.println("[1] - Horista, [2] - Salariado, [3] - Comissionado");
        answer = input.nextInt();

        if(answer == 1){
            System.out.println("Digite o salário por hora:");
            Double hourlySalary = input.nextDouble();

            employee = new Hourly(id, name, address, syndicate, null, hourlySalary);
        }
        else if(answer == 2){
            System.out.println("Digite o salário:");
            Double salary = input.nextDouble();

            employee = new Salaried(id, name, address, syndicate, null, salary);
        }
        else if(answer == 3){
            System.out.println("Digite o salário fixo:");
            Double fixedSalary = input.nextDouble();

            System.out.println("Digite a taxa de comissão:");
            Double commission = input.nextDouble();

            employee = new Commissioned(id, name, address, syndicate, null, fixedSalary, commission);
        }else{
            System.out.println("Digite o salário:");
            Double salary = input.nextDouble();

            employee = new Salaried(id, name, address, syndicate, null, salary);
        }

        System.out.println("\nO empregado é membro do sindicato? ([1] - Sim, [2] - Não): ");
        int aux = input.nextInt();

        if (aux == 1){
            UUID syndicateId = UUID.randomUUID();
            System.out.println("Digite a taxa sindical:");
            Double tax = input.nextDouble();
            syndicate = new Syndicate(syndicateId, id, true, tax);
            employee.setSyndicate(syndicate);
        }

        input.nextLine();

        System.out.println("\nVamos cadastrar os dados de pagamento!");
        System.out.println("Digite o número do banco:");
        int bank = input.nextInt();
        System.out.println("Digite o número da agência:");
        int agency = input.nextInt();
        System.out.println("Digite o número da conta:");
        int account = input.nextInt();

        System.out.println("Qual o método de pagamento?");
        System.out.println("[1] - Cheque nos correios, [2] - Depósito bancário, [3] - Em mãos\n");
        int methodChoiced = input.nextInt();

        String paymethod;

        if(methodChoiced == 1){
            paymethod = "Cheque nos correios";
        }else if(methodChoiced == 2){
            paymethod = "Depósito bancário";
        }else if(methodChoiced == 3){
            paymethod = "Em mãos";
        }else{
            paymethod = "Depósito bancário";
        }

        System.out.println("Como deseja receber o seu salário?");
        System.out.println("[1] - Mensal, [2] - Semanal, [3] - Bisemanal\n");
        int scheduleChoiced = input.nextInt();

        String schedule;

        if(scheduleChoiced == 1){
            schedule = "Mensal";
        }else if(scheduleChoiced == 2){
            schedule = "Semanal";
        }else if(scheduleChoiced == 3){
            schedule = "Bisemanal";
        }else{
            schedule = "Mensal";
        }

        paymentData = new PaymentData(bank, agency, account, paymethod, schedule);

        employee.setPaymentData(paymentData);

        input.nextLine();
        System.out.println();
        System.out.println("Empregado cadastrado com sucesso!");
        System.out.println(employee.toString());

        return employee;
    }

    public static void removeEmployee(Scanner input, ArrayList<Employee> Employees){
        System.out.println("Digite o ID do empregado que deve ser removido:");
        String id = input.nextLine();

        Employee employeeToRemove = null;
        for(Employee employee : Employees){
            if(employee.getId().toString().equals(id)){
                employeeToRemove = employee;
            }
        }
        Employees.remove(employeeToRemove);
        System.out.println("Empregado removido com sucesso!");
    }

    public static void listEmployees(ArrayList<Employee> Employees) {
        int i = 1;
        System.out.println("\n\nListagem de empregados");
        for (Employee employee : Employees) {
            System.out.println("\nEmpregado #" + i);
            System.out.println(employee.toString());
            System.out.println("\n");
            i++;
        }
    }

    public static void editEmployee(Scanner input, ArrayList<Employee> Employees){

        System.out.println("\nDigite o ID do empregado:");
        String id = input.nextLine();

        Employee employeeToEdit = null;
        for(Employee employee : Employees){
            if(employee.getId().toString().equals(id)){
                employeeToEdit = employee;
            }
        }

        if(employeeToEdit == null){
            System.out.println("\nEmpregado não foi encontrado!");
        }
        else{
            System.out.println("\nQual informação deseja editar?");
            System.out.println("[1] Nome");
            System.out.println("[2] Endereço");
            System.out.println("[3] Tipo de empregado");
            System.out.println("[4] Método de pagamento");
            System.out.println("[5] Vínculo ao sindicato");
            System.out.println("[6] Taxa do sindicato");
            int option = input.nextInt();
            input.nextLine();

            if(option == 1){
                System.out.println("Digite o novo nome: ");
                String name = input.nextLine();
                for(Employee employee : Employees){
                    if(employee.getId().toString().equals(id)){
                        employee.setName(name);
                    }
                }
                System.out.println("Nome editado!");
            }
            else if(option == 2){
                System.out.println("Digite o novo endereço: ");
                String address = input.nextLine();
                for(Employee employee : Employees){
                    if(employee.getId().toString().equals(id)){
                        employee.setAddress(address);
                    }
                }
                System.out.println("Endereço editado!");
            }
            else if(option == 3){
                System.out.println("\nEscolha o novo tipo");
                System.out.println("[1] - Horista, [2] - Salariado, [3] - Comissionado");
                int type = input.nextInt();

                for(Employee employee : Employees){
                    if(employee.getId().toString().equals(id)){
                        Employee newEmployee = null;
                        if(type == 1){
                            System.out.println("Digite o salário por hora:");
                            Double hourlySalary = input.nextDouble();
                            System.out.println();

                            newEmployee = new Hourly(employee.getId(), employee.getName(),
                                    employee.getAddress(), employee.getSyndicate(),
                                    employee.getPaymentData(), hourlySalary);
                        }else if(type == 2){
                            System.out.println("Digite o salário:");
                            Double salary = input.nextDouble();
                            System.out.println();

                            newEmployee = new Salaried(employee.getId(), employee.getName(),
                                    employee.getAddress(), employee.getSyndicate(),
                                    employee.getPaymentData(), salary);
                        }else if(type == 3){
                            System.out.println("Digite o salário fixo:");
                            Double fixedSalary = input.nextDouble();
                            System.out.println();

                            System.out.println("Digite a taxa de comissão:");
                            Double commission = input.nextDouble();
                            System.out.println();

                            newEmployee = new Commissioned(employee.getId(), employee.getName(),
                                    employee.getAddress(), employee.getSyndicate(),
                                    employee.getPaymentData(), fixedSalary, commission);
                        }else{
                            System.out.println("Opção inválida!");
                        }

                        Employees.remove(employee);
                        Employees.add(newEmployee);
                        System.out.println("\nTipo de empregado editado com sucesso!");
                    }
                }
            }
            else if(option == 4){
                System.out.println("Qual o método de pagamento?");
                System.out.println("[1] - Cheque nos correios, [2] - Depósito bancário, [3] - Em mãos\n");
                int choice = input.nextInt();

                String method;
                if(choice == 1){
                    method = "Cheque nos correios";
                }else if(choice == 2){
                    method = "Depósito bancário";
                }else if(choice == 3){
                    method = "Em mãos";
                }else{
                    method = "Depósito bancário";
                }

                for(Employee employee : Employees){
                    if(employee.getId().toString().equals(id)){
                        employee.getPaymentData().setPaymentMethod(method);
                    }
                }
                System.out.println("Método de pagamento atualizado!");
            }
            else if(option == 5){
                for(Employee employee : Employees){
                    if(employee.getId().toString().equals(id)){
                        if(employee.getSyndicate() == null){
                            System.out.println("Empregado não pertence ao sindicato, deseja cadastrar?");
                            System.out.println("[1] Sim, [2] Não");
                            int choice = input.nextInt();
                            if(choice == 1){
                                System.out.println("Digite a taxa sindical:");
                                Double tax = input.nextDouble();
                                employee.setSyndicate(new Syndicate(UUID.randomUUID(),
                                        employee.getId(), true, tax));
                            }
                        }else{
                            if(employee.getSyndicate().getActive()){
                                System.out.println("Seu cadastro no sindicato está ativo, deseja desativar?");
                                System.out.println("[1] Sim, [2] Não");
                                int choice = input.nextInt();
                                if(choice == 1){
                                    employee.getSyndicate().setActive(false);
                                }
                            }else{
                                System.out.println("Seu cadastro no sindicato está desativado, deseja ativar?");
                                System.out.println("[1] Sim, [2] Não");
                                int choice = input.nextInt();
                                if(choice == 1){
                                    employee.getSyndicate().setActive(true);
                                }
                            }
                        }
                    }
                }
                System.out.println("Operação realizada com sucesso!");
            }
            else if(option == 6){
                for(Employee employee : Employees){
                    if(employee.getId().toString().equals(id)){
                        if(employee.getSyndicate() == null){
                            System.out.println("Empregado não pertence ao sindicato");
                        }else{
                            System.out.println("Digite a nova taxa sindical:");
                            Double tax = input.nextDouble();
                            employee.getSyndicate().setTax(tax);
                        }
                    }
                }
                System.out.println("Operação realizada com sucesso!");
            }
            else{
                System.out.println("Opção inválida!");
            }
        }

    }
}
