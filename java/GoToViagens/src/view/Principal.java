package view;

//import java.lang.runtime.SwitchBootstraps;
import java.util.Scanner;

import controller.ClienteDAO;
import gotoviagens.Cliente;

public class Principal {

	public static void main(String[] args) {
	
		ClienteDAO clienteDAO = new ClienteDAO();
		
		// Cria um contato e salva no banco
		Cliente cliente = new Cliente();

		Scanner entrada = new Scanner(System.in);
		
		// VARIÁVEL PARA O LOOP CADASTRO
		int opcao = 0;
		
		// VARIÁVEL PARA O MENU PRINCIPAL
		int menu = 0;
		
		// VARIÁVEIS PARA CLIENTE
		String cpf = "", nome = "", email = "", telefone = "";
		

		
		System.out.println("=== INFORME ABAIXO ONDE DESEJA REALIZAR UM CADASTRO: ===");

		System.out.println("=> 1 - EMPRESA ==");
		System.out.println("=> 2 - DEPARTAMENTO ==");
		System.out.println("=> 3 - FUNCIONÁRIO ==");
		System.out.println("=> 4 - DESTINO ==");
		System.out.println("=> 5 - PASSAGEM ==");
		System.out.println("=> 6 - PEDIDO ==");
		
		System.out.println("=> 7 - CLIENTE ==");
		System.out.println("=> 8 - USUÁRIO ==");
		menu = entrada.nextInt();
		
		
		switch (menu) {
		
		case 1: {
			
			System.out.println("=== CADASTRO EMPRESA ===");
			
			break;

			}
		
		case 2: {
			
			System.out.println("===== DEPARTAMENTO =====");

			
			break;

			}
		
		case 3: {
			
			System.out.println("=== CADASTRO FUNCIONÁRIO ===");
			
			break;

			}
		
		case 4: {
			
			System.out.println("=== CADASTRO DESTINO ===");
			
			break;

			}
		
		case 5: {
			
			System.out.println("=== CADASTRO PASSAGEM ===");
			
			break;

			}
		
		
		case 6: {
			
			System.out.println("=== CADASTRO PEDIDO ===");
			
			break;

			}
		
		case 7: {
			
			do {

				System.out.println("===== CLIENTE =====");
				System.out.println("1 - Cadastro de cliente");
				System.out.println("2 - Excluir cadastro");
				System.out.println("3 - Atualizar cadastro");
				System.out.println("4 - Mostrar cadastro");
				System.out.println("5 - Buscar por CPF");
				System.out.println("6 - Sair");
				opcao = entrada.nextInt();

				switch (opcao) {
				
				case 1: {
					System.out.println("Digite o CPF do cliente:");
					cpf = entrada.next();
					cliente.setCpf(cpf);
					
					System.out.println("Digite o NOME do cliente:");
					nome = entrada.next();
					cliente.setNome(nome);

					System.out.println("Digite o E-MAIL do cliente:");
					email = entrada.next();
					cliente.setEmail(email);
					
					System.out.println("Digite o TELEFONE do cliente:");
					telefone = entrada.next();
					cliente.setTelefone(telefone);
					
					clienteDAO.save(cliente);
					break;
				}
				case 2: {
					
					System.out.println("Digite o CPF do cliente para exclusao: ");
					try {
						
						cpf = entrada.next();
						
						clienteDAO.removeByCpf(cpf);
						
					} catch (Exception e) {
						// e.getMessage();
						 
						System.out.println("Nenhum contato para excluir ");
					}

					break;
				}
				case 3: {

					System.out.println("Digite o CPF do contato para atualizar: ");
					cpf = entrada.next();

					System.out.println("Digite o novo NOME do cliente: ");
					nome = entrada.next();
					cliente.setNome(nome);
					
					System.out.println("Digite o novo E-MAIL do cliente: ");
					email = entrada.next();
					cliente.setEmail(email);
					
					System.out.println("Digite o novo TELEFONE do cliente: ");
					telefone = entrada.next();
					cliente.setTelefone(telefone);
					

					cliente.setCpf(cpf);
					clienteDAO.update(cliente);
				}
				case 4: {
					for (Cliente cli : clienteDAO.getClientes()) {

						System.out.println("NOME: " + cli.getNome());
						System.out.println("EMAIL: " + cli.getEmail());
						System.out.println("TELEFONE: " + cli.getTelefone());
						
						System.out.println("----------------------------------- ");

					}
					break;
				}
				case 5: {

					System.out.print("Digite o CPF para buscar: ");
					cpf = entrada.next();
					
					Cliente cli = new Cliente();

					cli = clienteDAO.getContatoByCpf(cpf);

					System.out.println("NOME: " + cli.getNome());
					System.out.println("E-MAIL: " + cli.getEmail());
					System.out.println("TELEFONE: " + cli.getTelefone());

					System.out.println("----------------------------------- ");
				}
					break;

				case 6: {
					System.out.println(" === Agradecemos pela preferência! === ");
					break;
				}
				default:
					System.out.println("Opcao invalida: ");

				};

			} while (opcao != 6);
			
			
			
			break;

			}
		
		case 8: {
			
			System.out.println("=== CADASTRO USUÁRIO ===");
			
			break;

			}
		

		}
		
		

	
		entrada.close();



	}

}
