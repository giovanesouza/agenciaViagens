package view;

import java.util.Date;
//import java.lang.runtime.SwitchBootstraps;
import java.util.Scanner;

import controller.ClienteDAO;
import controller.DepartamentoDAO;
import controller.EmpresaDAO;
import controller.FuncionarioDAO;
import controller.UsuarioDAO;

import gotoviagens.Cliente;
import gotoviagens.Departamento;
import gotoviagens.Empresa;
import gotoviagens.Funcionario;
import gotoviagens.Usuario;

public class Principal {

	public static void main(String[] args) {
	
		// CLASSES DAO
		EmpresaDAO empresaDAO = new EmpresaDAO();
		DepartamentoDAO departamentoDAO = new DepartamentoDAO();
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		
		ClienteDAO clienteDAO = new ClienteDAO();
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		
		
		// CLASSES PARA CRIAR UM NOVO REGISTRO NO BD
		
		Empresa empresa = new Empresa();
		Departamento departamento = new Departamento();
		Funcionario funcionario = new Funcionario();
		
		Cliente cliente = new Cliente();
		Usuario usuario = new Usuario();

		
		Scanner entrada = new Scanner(System.in);
		
		// VARIÁVEL PARA O LOOP CADASTRO
		int opcao = 0;
		
		// VARIÁVEL PARA O MENU PRINCIPAL
		int menu = 0;
		
		
		// VARIÁVEIS PARA EMPRESA
	    String unidade = "", endereco = "", telefoneUnid = "", emailUnid = "";
	    int codUnid;
	    
		
	    // VARIÁVEIS DEPARTAMENTO - codUnid ACIMA TAMBÉM FOI UTILIZADO PARA DEPARTAMENTO
	    int codDepartamento;
	    String nomeDepartamento;
	    
	    
	    // VARIÁVEIS FUNCIONÁRIO
	    int matricula;
	    String nomeFunc, cargo;
	    float salario;
		
		
		// VARIÁVEIS PARA CLIENTE
		String cpf = "", nome = "", email = "", telefone = "";
		
		// VARIÁVEIS PARA USUÁRIO - CPF DE CLIENTE FOI UTILIZADO PARA USUÁRIO
		String emailUsuario, senhaUsuario;
		int id;

		
		System.out.println("=== INFORME ABAIXO ONDE DESEJA REALIZAR UM CADASTRO: ===");

		System.out.println("=> 1 - EMPRESA");
		System.out.println("=> 2 - DEPARTAMENTO");
		System.out.println("=> 3 - FUNCIONÁRIO");
		System.out.println("=> 4 - DESTINO");
		System.out.println("=> 5 - PASSAGEM");
		System.out.println("=> 6 - PEDIDO");
		
		System.out.println("=> 7 - CLIENTE");
		System.out.println("=> 8 - USUÁRIO");
		menu = entrada.nextInt();
		
		
		switch (menu) {
		
		
		// EMPRESA
		case 1: {
					
			do {

				System.out.println("===== EMPRESA =====");
				System.out.println("1 - Cadastrar unidade");
				System.out.println("2 - Excluir unidade");
				System.out.println("3 - Atualizar unidade");
				System.out.println("4 - Mostrar informações de unidade");
				System.out.println("5 - Buscar unidade por código");
				System.out.println("6 - Sair");
				opcao = entrada.nextInt();

				switch (opcao) {
				
				case 1: {
															
					System.out.println("Digite o NOME da unidade:");
					unidade = entrada.next();
					empresa.setUnidade(unidade);
							
					System.out.println("Digite a TELEFONE da unidade:");
					telefoneUnid = entrada.next();
					empresa.setTelefone(telefoneUnid);
					
					System.out.println("Digite o E-MAIL da unidade:");
					emailUnid = entrada.next();
					empresa.setEmail(emailUnid);

					System.out.println("Digite o ENDEREÇO da unidade:");
					endereco = entrada.next();
					empresa.setEndereco(endereco);
					
					empresaDAO.save(empresa);
					
					break;
				}
				case 2: {
					
					System.out.println("Digite o CÓDIGO da unidade para exclusao: ");
					try {
						
						codUnid = entrada.nextInt();
						
						empresaDAO.removeByCodUnid(codUnid);
						
					} catch (Exception e) {
						// e.getMessage();
						 
						System.out.println("Nenhuma unidade para excluir ");
					}

					break;
				}
				case 3: {

					System.out.println("Digite o CÓDIGO da unidade para atualizar: ");
					codUnid = entrada.nextInt();

					System.out.println("Digite o novo NOME da unidade: ");
					unidade = entrada.next();
					empresa.setNomeFantasia(unidade);
					
					System.out.println("Digite o novo TELEFONE da unidade: ");
					telefoneUnid = entrada.next();
					empresa.setTelefone(telefoneUnid);
					
					System.out.println("Digite o novo E-MAIL da unidade: ");
					emailUnid = entrada.next();
					empresa.setEmail(emailUnid);
					
					System.out.println("Digite o novo ENDEREÇO da unidade: ");
					endereco = entrada.next();
					empresa.setEndereco(endereco);

					empresa.setCodUnid(codUnid);
					empresaDAO.update(empresa);
				}
				case 4: {
					for (Empresa unid : empresaDAO.getEmpresas()) {

						System.out.println("UNIDADE: " + unid.getUnidade());
						System.out.println("TELEFONE: " + unid.getTelefone());
						System.out.println("E-MAIL: " + unid.getEmail());
						System.out.println("ENDEREÇO: " + unid.getEndereco());
						
						System.out.println("----------------------------------- ");

					}
					break;
				}
				case 5: {

					System.out.print("Digite o CÓDIGO para buscar: ");
					codUnid = entrada.nextInt();
					
					Empresa unid = new Empresa();

					unid = empresaDAO.getUnidadesByCod(codUnid);

					System.out.println("UNIDADE: " + unid.getUnidade());
					System.out.println("TELEFONE: " + unid.getTelefone());
					System.out.println("E-MAIL: " + unid.getEmail());
					System.out.println("ENDEREÇO: " + unid.getEndereco());

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
		
		
		// DEPARTAMENTO
		case 2: {
			
			do {

				System.out.println("===== DEPARTAMENTO =====");
				System.out.println("1 - Cadastro de departamento");
				System.out.println("2 - Excluir departamento");
				System.out.println("3 - Atualizar departamento");
				System.out.println("4 - Mostrar departamento");
				System.out.println("5 - Buscar departamento por CÓDIGO");
				System.out.println("6 - Sair");
				opcao = entrada.nextInt();

				switch (opcao) {
				
				case 1: {
										
					System.out.println("Digite o NOME do departamento:");
					nomeDepartamento = entrada.next();
					departamento.setNomeDepartamento(nomeDepartamento);

					System.out.println("Digite o CÓDIGO da unidade:");
					codUnid = entrada.nextInt();
					departamento.setCodUnid(codUnid);
							
					departamentoDAO.save(departamento);
					break;
				}
				case 2: {
					
					System.out.println("Digite o CÓDIGO do departamento para exclusao: ");
					try {
						
						codDepartamento = entrada.nextInt();
						
						departamentoDAO.removeByCod(codDepartamento);
						
					} catch (Exception e) {
						// e.getMessage();
						 
						System.out.println("Nenhum contato para excluir ");
					}

					break;
				}
				case 3: {

					System.out.println("Digite o CÓDIGO do departamento para atualizar: ");
					codDepartamento = entrada.nextInt();

					System.out.println("Digite o novo NOME do departamento: ");
					nomeDepartamento = entrada.next();
					departamento.setNomeDepartamento(nomeDepartamento);
										

					departamento.setCodDepartamento(codDepartamento);
					departamentoDAO.update(departamento);
				}
				case 4: {
					for (Departamento dep : departamentoDAO.getDepartamento()) {

						System.out.println("CÓDIGO DO DEPARTAMENTO: " + dep.getCodDepartamento());
						System.out.println("NOME: " + dep.getNomeDepartamento());
						System.out.println("UNIDADE: " + dep.getCodUnid());
						
						System.out.println("----------------------------------- ");

					}
					break;
				}
				case 5: {

					System.out.print("Digite o CÓDIGO do departamento: ");
					codDepartamento = entrada.nextInt();
					
					Departamento dep = new Departamento();

					dep = departamentoDAO.getDepartamentoByCod(codDepartamento);

					System.out.println("CÓDIGO DO DEPARTAMENTO: " + dep.getCodDepartamento());
					System.out.println("NOME: " + dep.getNomeDepartamento());
					System.out.println("UNIDADE: " + dep.getCodUnid());

					System.out.println("----------------------------------- ");
				}
					break;

				case 6: {
					System.out.println(" === Até logo! === ");
					break;
				}
				default:
					System.out.println("Opcao invalida: ");

				};

			} while (opcao != 6);


			
			break;

			}
		
		// FUNCIONÁRIO
		case 3: {
						
			do {

				System.out.println("===== FUNCIONÁRIO =====");
				System.out.println("1 - Cadastro de funcionário");
				System.out.println("2 - Excluir funcionário");
				System.out.println("3 - Atualizar cadastro");
				System.out.println("4 - Mostrar cadastro");
				System.out.println("5 - Buscar por matrícula");
				System.out.println("6 - Sair");
				opcao = entrada.nextInt();

				switch (opcao) {
				
				case 1: {
										
					System.out.println("Digite o NOME do funcionário:");
					nomeFunc = entrada.next();
					funcionario.setNome(nomeFunc);

					System.out.println("Digite o CARGO do funcionário:");
					cargo = entrada.next();
					funcionario.setCargo(cargo);
					
					System.out.println("Digite o SALÁRIO do funcionário:");
					salario = entrada.nextFloat();
					funcionario.setSalario(salario);
					
					System.out.println("Digite o CÓDIGO do departamento:");
					codDepartamento = entrada.nextInt();
					funcionario.setCodDepartamento(codDepartamento);
					
					funcionarioDAO.save(funcionario);
					break;
				}
				case 2: {
					
					System.out.println("Digite a MATRÍCULA do funcionário para exclusao: ");
					try {
						
						matricula = entrada.nextInt();
						
						funcionarioDAO.removeByMat(matricula);
						
					} catch (Exception e) {
						// e.getMessage();
						 
						System.out.println("Nenhum contato para excluir ");
					}

					break;
				}
				case 3: {

					System.out.println("Digite a MATRÍCULA do funcionário para atualizar: ");
					matricula = entrada.nextInt();

					System.out.println("Digite o novo CARGO do funcionário: ");
					cargo = entrada.next();
					funcionario.setCargo(cargo);;
					
					System.out.println("Digite o novo SALÁRIO do funcionário: ");
					salario = entrada.nextFloat();
					funcionario.setSalario(salario);
					
					System.out.println("Digite o novo DEPARTAMENTO do funcionário: ");
					codDepartamento = entrada.nextInt();
					funcionario.setCodDepartamento(codDepartamento);
					

					funcionario.setMatricula(matricula);
					funcionarioDAO.update(funcionario);
				}
				case 4: {
					for (Funcionario func : funcionarioDAO.getFuncionarios()) {

						System.out.println("NOME DO FUNCIONÁRIO: " + func.getNome());
						System.out.println("CARGO: " + func.getCargo());
						System.out.println("SALÁRIO: " + func.getSalario());
						System.out.println("CÓDIGO DEPARTAMENTO: " + func.getCodDepartamento());
						
						System.out.println("----------------------------------- ");

					}
					break;
				}
				case 5: {

					System.out.print("Digite a MATRÍCULA para buscar: ");
					matricula = entrada.nextInt();
					
					Funcionario func = new Funcionario();

					func = funcionarioDAO.getFuncionariosByMat(matricula);

					System.out.println("NOME DO FUNCIONÁRIO: " + func.getNome());
					System.out.println("CARGO: " + func.getCargo());
					System.out.println("SALÁRIO: " + func.getSalario());
					System.out.println("CÓDIGO DEPARTAMENTO: " + func.getCodDepartamento());

					System.out.println("----------------------------------- ");
				}
					break;

				case 6: {
					System.out.println(" === Até logo! === ");
					break;
				}
				default:
					System.out.println("Opcao invalida: ");

				};

			} while (opcao != 6);
			
			
			break;

			}
		
		
		// DESTINO
		case 4: {
			
			System.out.println("=== CADASTRO DESTINO ===");
			
			break;

			}
		
		
		// PASSAGEM
		case 5: {
			
			System.out.println("=== CADASTRO PASSAGEM ===");
			
			break;

			}
		
		
		// PEDIDO
		case 6: {
			
			System.out.println("=== CADASTRO PEDIDO ===");
			
			break;

			}
		
		
		// CLIENTE
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
					nome = entrada.nextLine();
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

					cli = clienteDAO.getClienteByCpf(cpf);

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
		
		
		// USUÁRIO
		case 8: {
			
			do {

				System.out.println("===== USUÁRIO =====");
				System.out.println("1 - Cadastro de usuário");
				System.out.println("2 - Excluir usuário");
				System.out.println("3 - Atualizar cadastro");
				System.out.println("4 - Mostrar cadastro");
				System.out.println("5 - Buscar por id");
				System.out.println("6 - Sair");
				opcao = entrada.nextInt();

				switch (opcao) {
				
				case 1: {

					System.out.println("Digite seu CPF:");
					cpf = entrada.next();
					usuario.setCpf(cpf);
					
					
					System.out.println("Digite um E-MAIL para usuário:");
					emailUsuario = entrada.next();
					usuario.setEmailUsuario(emailUsuario);
					
					System.out.println("Digite uma SENHA para o usuário:");
					senhaUsuario = entrada.next();
					usuario.setSenha(senhaUsuario);
					
					usuario.setDataCadastro(new Date());
					
					usuarioDAO.save(usuario);
					break;
				}
				case 2: {
					
					System.out.println("Digite o id do usuário para exclusao: ");
					try {
						
						id = entrada.nextInt();
						
						usuarioDAO.removeById(id);
						
					} catch (Exception e) {
						// e.getMessage();
						 
						System.out.println("Nenhum usuário para excluir ");
					}

					break;
				}
				case 3: {

					System.out.println("Digite o id do usuário para atualizar: ");
					id = entrada.nextInt();

					System.out.println("Digite o novo NOME do usuário: ");
					nome = entrada.next();
					usuario.setNome(nome);
					
					System.out.println("Digite o novo E-MAIL do usuário: ");
					emailUsuario = entrada.next();
					usuario.setEmailUsuario(emailUsuario);
					
					System.out.println("Digite uma nova SENHA para o usuário: ");
					senhaUsuario = entrada.next();
					usuario.setSenha(senhaUsuario);
					

					usuario.setIdUsuario(id);
					clienteDAO.update(cliente);
				}
				case 4: {
					for (Usuario usu : usuarioDAO.getUsuarios()) {

						System.out.println("CPF: " + usu.getCpf());
						System.out.println("NOME: " + usu.getNome());
						System.out.println("EMAIL: " + usu.getEmailUsuario());
						System.out.println("TELEFONE: " + usu.getSenha());
						System.out.println("DATA DE CADASTRO: " + usu.getDataCadastro());
						
						System.out.println("----------------------------------- ");

					}
					break;
				}
				case 5: {

					System.out.print("Digite o id do usuário para buscar: ");
					id = entrada.nextInt();
					
					Usuario usu = new Usuario();

					usu = usuarioDAO.getClienteById(id);

					System.out.println("CPF: " + usu.getCpf());
					System.out.println("NOME: " + usu.getNome());
					System.out.println("EMAIL: " + usu.getEmailUsuario());
					System.out.println("SENHA: " + usu.getSenha());
					System.out.println("DATA DE CADASTRO: " + usu.getDataCadastro());
					
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
		

		}
		

		entrada.close();



	}

}
