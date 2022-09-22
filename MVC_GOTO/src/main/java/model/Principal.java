package model;

import java.util.Date;

//import java.lang.runtime.SwitchBootstraps;
import java.util.Scanner;

/*
import model.ClienteDAO;
import model.DepartamentoDAO;
import model.DestinoDAO;
import model.EmpresaDAO;
import model.FuncionarioDAO;
import model.PassagemDAO;
import model.PedidoDAO;
import model.UsuarioDAO;

import model.Cliente;
import model.Departamento;
import model.Destino;
import model.Empresa;
import model.Funcionario;
import model.Passagem;
import model.Pedido;
import model.Usuario;
*/

public class Principal {

	public static void main(String[] args) {
	
		// CLASSES DAO
		EmpresaDAO empresaDAO = new EmpresaDAO();
		DepartamentoDAO departamentoDAO = new DepartamentoDAO();
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		
		DestinoDAO destinoDAO = new DestinoDAO();
		PassagemDAO passagemDAO = new PassagemDAO();
		PedidoDAO pedidoDAO = new PedidoDAO();
		
		ClienteDAO clienteDAO = new ClienteDAO();
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		
		
		// CLASSES PARA CRIAR UM NOVO REGISTRO NO BD
		
		Empresa empresa = new Empresa();
		Departamento departamento = new Departamento();
		Funcionario funcionario = new Funcionario();
		
		Destino destino = new Destino();
		Passagem passagem = new Passagem();
		Pedido pedido = new Pedido();
		
		Cliente cliente = new Cliente();
		Usuario usuario = new Usuario();

		
		
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
		
		
	    // VARIÁVEIS DESTINO
	    String nomeDestino, categoriaDestino, condicao;
	    float precoDestino;
	    int qtdDisponivel;
	    
	    
	    
		// VARIÁVEIS PARA CLIENTE
		String cpf = "", nome = "", email = "", telefone = "";
		
		// VARIÁVEIS PARA USUÁRIO - CPF DE CLIENTE FOI UTILIZADO PARA USUÁRIO
		String emailUsuario, senhaUsuario;
		
		
		// VARIÁVEIS PEDIDO
		float total;
		String formaPagamento, status;
		
				
		// VARIÁVEIS PARA PASSAGEM
		int qtd, idPassagem;
		
		
		
		// VARIÁVLE ID GLOGAL
		int id;

		// VARIÁVEL PARA O LOOP CADASTRO
		int opcao = 0;
				
		// VARIÁVEL PARA O MENU PRINCIPAL
		int menu = 0;
		
		
		
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("=== INFORME ABAIXO ONDE DESEJA REALIZAR UM CADASTRO: \n");

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
							
					System.out.println("Digite o TELEFONE da unidade:");
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
					empresa.setUnidade(unidade);
					
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
									
					for (Empresa und : empresaDAO.getEmpresas()){

						System.out.println("CÓDIGO DA UNIDADE: " + und.getCodUnid());
						System.out.println("UNIDADE: " + und.getUnidade());
						System.out.println("TELEFONE: " + und.getTelefone());
						System.out.println("E-MAIL: " + und.getEmail());
						System.out.println("ENDEREÇO: " + und.getEndereco());
						
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
					
					System.out.println("Digite o CÓDIGO da nova UNIDADE: ");
					codUnid = entrada.nextInt();
					departamento.setCodUnid(codUnid);
					
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

					System.out.println("CÓDIGO DO DEPARTAMENTO: " + codDepartamento);
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
					funcionario.setCargo(cargo);
					
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
			
			do {

				System.out.println("===== DESTINO =====");
				System.out.println("1 - Cadastro de destino");
				System.out.println("2 - Excluir cadastro");
				System.out.println("3 - Atualizar cadastro");
				System.out.println("4 - Mostrar cadastro");
				System.out.println("5 - Buscar cadastro por id");
				System.out.println("6 - Sair");
				opcao = entrada.nextInt();

				switch (opcao) {
				
				case 1: {
					
					System.out.println("Digite o NOME do destino:");
					nomeDestino = entrada.next();
					destino.setNomeDestino(nomeDestino);
					
					System.out.println("Digite o PREÇO do destino:");
					precoDestino = entrada.nextFloat();
					destino.setPrecoUnit(precoDestino);

					System.out.println("Digite a CATEGORIA do destino:");
					categoriaDestino = entrada.next();
					destino.setCategoriaDestino(categoriaDestino);
					
					System.out.println("Digite a QUANTIDADE:");
					qtdDisponivel = entrada.nextInt();
					destino.setQtdDisponivel(qtdDisponivel);
					
					System.out.println("Digite a CONDIÇÃO:");
					condicao = entrada.next();
					destino.setCondicao(condicao);
					
					destinoDAO.save(destino);
					break;
				}
				case 2: {
					
					System.out.println("Digite o id do destino para exclusao: ");
					try {
						
						id = entrada.nextInt();
						
						destinoDAO.removeById(id);
						
					} catch (Exception e) {
						// e.getMessage();
						 
						System.out.println("Nenhum destino para excluir ");
					}

					break;
				}
				case 3: {

					System.out.println("Digite o id do destino para atualizar: ");
					id = entrada.nextInt();

					System.out.println("Digite o novo NOME do destino: ");
					nomeDestino = entrada.next();
					destino.setNomeDestino(nomeDestino);
					
					System.out.println("Digite o novo PREÇO: ");
					precoDestino = entrada.nextFloat();
					destino.setPrecoUnit(precoDestino);;
					
					System.out.println("Digite a nova CATEGORIA do destino: ");
					categoriaDestino = entrada.next();
					 destino.setCategoriaDestino(categoriaDestino);
					
					System.out.println("Digite a nova QUANTIDADE DISPONÍVEL para destino: ");
					qtdDisponivel = entrada.nextInt();
					destino.setQtdDisponivel(qtdDisponivel);
					
					System.out.println("Digite a nova CONDIÇÃO para o destino: ");
					condicao = entrada.next();
					destino.setCondicao(condicao);
					

					destino.setIdDestino(id);
					destinoDAO.update(destino);
				}
				case 4: {
					for (Destino des : destinoDAO.getDestinos()) {

						System.out.println("NOME DESTINO: " + des.getNomeDestino());
						System.out.println("PRECO R$: " + des.getPrecoUnit());
						System.out.println("CATEGORIA: " + des.getCategoriaDestino());
						System.out.println("QUANTIDADE DISPONÍVEL: " + des.getQtdDisponivel());			
						System.out.println("CONDIÇÃO: " + des.getCondicao());
						
						System.out.println("----------------------------------- ");

					}
					break;
				}
				case 5: {

					System.out.print("Digite o id para buscar: ");
					id = entrada.nextInt();
					
					Destino des = new Destino();

					des = destinoDAO.getDestinoById(id);

					System.out.println("NOME DESTINO: " + des.getNomeDestino());
					System.out.println("PRECO R$: " + des.getPrecoUnit());
					System.out.println("CATEGORIA: " + des.getCategoriaDestino());
					System.out.println("QUANTIDADE DISPONÍVEL: " + des.getQtdDisponivel());			
					System.out.println("CONDIÇÃO: " + des.getCondicao());

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
		
		
		// PASSAGEM
		case 5: {
			
			do {

				System.out.println("===== PASSAGEM =====");
				System.out.println("1 - Cadastro de passagem com base em um DESTINO");
				System.out.println("2 - Excluir passagem");
				System.out.println("3 - Atualizar passagem");
				System.out.println("4 - Mostrar passagem");
				System.out.println("5 - Buscar por id");
				System.out.println("6 - Sair");
				opcao = entrada.nextInt();

				switch (opcao) {
				
				case 1: {
					System.out.println("Digite a QUANTIDADE de passagens:");
					qtd = entrada.nextInt();
					passagem.setQuantidade(qtd);
					
					System.out.println("Digite o id do destino:");
					id = entrada.nextInt();
					passagem.setIdDestino(id);
				
					passagemDAO.save(passagem);
					break;
				}
				case 2: {
					
					System.out.println("Digite o id da passagem para exclusao: ");
					try {
						
						id = entrada.nextInt();
						
						passagemDAO.removeById(id);
						
					} catch (Exception e) {
						// e.getMessage();
						 
						System.out.println("Nenhuma passagem para excluir ");
					}

					break;
				}
				case 3: {

					System.out.println("Digite o id da passagem para atualizar: ");
					idPassagem = entrada.nextInt();

					System.out.println("Digite a QUANTIDADE de passagens: ");
					qtd = entrada.nextInt();
					passagem.setQuantidade(qtd);
					
					System.out.println("Digite o novo id do destino: ");
					id = entrada.nextInt();
					passagem.setIdDestino(id);


					passagem.setIdPassagem(idPassagem);
					passagemDAO.update(passagem);
				}
				case 4: {
					for (Passagem pas : passagemDAO.getPassagens()) {

						System.out.println("QUANTIDADE: " + pas.getQuantidade());
						System.out.println("ID DESTINO: " + pas.getIdDestino());
												
						System.out.println("----------------------------------- ");

					}
					break;
				}
				case 5: {

					System.out.print("Digite o id para buscar: ");
					id = entrada.nextInt();
					
					Passagem pas = new Passagem();

					pas = passagemDAO.getPassagemById(id);

					System.out.println("QUANTIDADE: " + pas.getQuantidade());
					System.out.println("ID DESTINO: " + pas.getIdDestino());

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
		
		
		// PEDIDO
		case 6: {
			
			do {

				System.out.println("===== PEDIDO =====");
				System.out.println("1 - Cadastro de pedido");
				System.out.println("2 - Excluir pedido");
				System.out.println("3 - Atualizar pedido");
				System.out.println("4 - Mostrar pedido");
				System.out.println("5 - Buscar pedido pelo número");
				System.out.println("6 - Sair");
				opcao = entrada.nextInt();

				switch (opcao) {
				
				case 1: {
					
					pedido.setDataPedido(new Date());
					
					
					System.out.println("Digite a MATRÍCULA do funcionário: ");
					matricula = entrada.nextInt();
					pedido.setMatFunc(matricula);
					
					System.out.println("Digite o ID do usuário:");
					id = entrada.nextInt();
					pedido.setIdUsuario(id);
					
					System.out.println("Digite o PREÇO TOTAL do pedido:");
					total = entrada.nextFloat();
					pedido.setPrecoTotal(total);
					
					System.out.println("Digite a FORMA DE PAGAMENTO:");
					formaPagamento = entrada.next();
					pedido.setPagamento(formaPagamento);
							
					
					pedidoDAO.save(pedido);
					break;
				}
				case 2: {
					
					System.out.println("Digite o NÚMERO DO PEDIDO para exclusao: ");
					try {
						
						id = entrada.nextInt();
						
						pedidoDAO.removeById(id);
						
					} catch (Exception e) {
						// e.getMessage();
						 
						System.out.println("Nenhum pedido para excluir ");
					}

					break;
				}
				case 3: {

					System.out.println("Digite o NÚMERO DO PEDIDO para atualizar: ");
					id = entrada.nextInt();

					System.out.println("Digite o novo PREÇO do pedido: ");
					total = entrada.nextFloat();
					pedido.setPrecoTotal(total);
					
					System.out.println("Digite a nova FORMA DE PAGAMENTO: ");
					formaPagamento = entrada.next();
					pedido.setPagamento(formaPagamento);
					
					System.out.println("Digite o novo STATUS do pedido: ");
					status = entrada.next();
					pedido.setStatusPedido(status);
							
										
					pedido.setIdPedido(id);
					pedidoDAO.update(pedido);
				}
				case 4: {
					for (Pedido ped : pedidoDAO.getPedidos()) {

						System.out.println("PREÇO TOTAL R$: " + ped.getPrecoTotal());
						System.out.println("FORMA DE PAGAMENTO: " + ped.getPagamento());
						System.out.println("MATR. DO FUNCIONÁRIO: " + ped.getMatFunc());

						System.out.println("DATA DO PEDIDO: " + ped.getDataPedido());
						
						System.out.println("----------------------------------- ");

					}
					break;
				}
				case 5: {

					System.out.print("Digite o NÚMERO do pedido para buscar: ");
					id = entrada.nextInt();
					
					Pedido ped = new Pedido();

					ped = pedidoDAO.getPedidoById(id);

					System.out.println("PREÇO TOTAL R$: " + ped.getPrecoTotal());
					System.out.println("FORMA DE PAGAMENTO: " + ped.getPagamento());
					System.out.println("MATR. DO FUNCIONÁRIO: " + ped.getMatFunc());

					System.out.println("DATA DO PEDIDO: " + ped.getDataPedido());

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
				System.out.println("6 - Realizar Login");
				System.out.println("7 - Sair");
				opcao = entrada.nextInt();

				switch (opcao) {
				
				case 1: {

					System.out.println("Digite seu CPF:");
					cpf = entrada.next();
					usuario.setCpf(cpf);
					
					System.out.println("Digite seu NOME:");
					nome = entrada.next();
					usuario.setNome(nome);
					
					System.out.println("Digite seu TELEFONE:");
					telefone = entrada.next();
					usuario.setTelefone(telefone);
					
					
					System.out.println("Digite um E-MAIL para usuário:");
					emailUsuario = entrada.next();
					usuario.setEmail(emailUsuario);
					
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
					
					System.out.println("Digite o novo número de TELEFONE: ");
					telefone = entrada.next();
					usuario.setTelefone(telefone);
					
					System.out.println("Digite o novo E-MAIL do usuário: ");
					emailUsuario = entrada.next();
					usuario.setEmail(emailUsuario);
					
					System.out.println("Digite uma nova SENHA para o usuário: ");
					senhaUsuario = entrada.next();
					usuario.setSenha(senhaUsuario);
					
					usuario.setDataAtualizacaoCadastro(new Date());
					
					
					usuario.setId(id);
					usuarioDAO.update(usuario);
				}
				case 4: {
					for (Usuario usu : usuarioDAO.getUsuarios()) {

						System.out.println("CPF: " + usu.getCpf());
						System.out.println("NOME: " + usu.getNome());
						System.out.println("TELEFONE: " + usu.getTelefone());
						System.out.println("EMAIL: " + usu.getEmail());
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

					usu = usuarioDAO.getUsuarioById(id);

					System.out.println("CPF: " + usu.getCpf());
					System.out.println("NOME: " + usu.getNome());
					System.out.println("EMAIL: " + usu.getEmail());
					System.out.println("SENHA: " + usu.getSenha());
					System.out.println("DATA DE CADASTRO: " + usu.getDataCadastro());
					
					System.out.println("----------------------------------- ");
					
					break;
				}
					
				case 6: {

					System.out.print("Digite o EMAIL do usuario: ");
					emailUsuario = entrada.next();
					
					System.out.print("Digite a SENHA do usuario: ");
					senhaUsuario = entrada.next();
									
					Usuario u = new Usuario();

					u = usuarioDAO.buscarUsuarioPorEmail(emailUsuario);

					boolean logado = false;


					if(u != null && u.getSenha().equals(senhaUsuario)) {
						
						logado = true;
												
					} 
					
					if (logado) {			
						
						System.out.println("== USUÁRIO LOGADO ==");

						System.out.println("ID: " + u.getId());
						System.out.println("CPF: " + u.getCpf());
						System.out.println("NOME: " + u.getNome());
						System.out.println("EMAIL: " + u.getEmail());
						System.out.println("SENHA: " + u.getSenha());
						System.out.println("DATA DE CADASTRO: " + u.getDataCadastro());
						
						System.out.println("----------------------------------- ");
						
					} else {
						
						logado = false; 
						
						System.out.println("USUÁRIO LOGADO: " + u.getLogado());
						System.out.println("E-mail e/ou senha incorretos.");
					}			
							
					
					break;
				}
		
				case 7: {
					System.out.println(" === Agradecemos pela preferência! === ");
					break;
				}
				default:
					System.out.println("Opcao invalida: ");

				};

			} while (opcao != 7);

			
			break;

			}
		

		}

	entrada.close();

}

}
