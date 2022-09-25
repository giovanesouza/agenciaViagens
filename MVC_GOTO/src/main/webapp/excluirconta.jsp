<!-- IMPORTAÇÃO DA CLASS USUÁRIO -->
<%@page import="model.Usuario"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl"%>

<%
String sucesso = (String) request.getAttribute("sucesso");
%>

<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<meta charset="ISO-8859-1">

<!-- ICON GO TO -->
<link rel="shortcut icon" href="img/icon_goto.png" type="image/x-icon">

<!-- BOOTSTRAP -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">

<!-- GOOGLE ICON -->
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />

<!-- CSS EXTERNO -->
<link rel="stylesheet" href="css/profile.css">


<title>Excluir conta</title>
</head>
<body>


	<header class="container">

		<div class="row container p-2">

			<div class="col-md-3 mt-2 mb-2 logo">

				<img src="img/agencia_viagens_small.png" alt="logo" id="logo">

			</div>

			<div
				class="col-md-7 d-flex flex-column align-items-start justify-content-center">

				<!-- PEGA O ATRIBUTO QUE ESTÁ DENTRO DA SESSÃO LOGADO -->
				<%
				Usuario u = (Usuario) session.getAttribute("usuarioLogado");
				// out.print(u.getNome());
				%>

				<span>Olá, <strong><%=u.getNome()%></strong>. Seja bem vindo(a)!
				</span>

				<div class="datahora">
					<span><strong>Data:</strong> <span id="data"></span>.</span> <span><strong>Hora:</strong>
						<span id="hora"></span>.</span>
				</div>

			</div>

			<div
				class="col-md-2 text-light d-flex align-items-center justify-content-end mt-2 mb-2">

				<a href="Index"> <span class="material-symbols-outlined logout">logout</span>
				</a>

			</div>

		</div>

	</header>


	<div class="container grid-container">

		<div class="menu">

			<ul>
				<a href="perfil.jsp"> <span class="material-symbols-outlined">
						home </span>

					<li>Início</li>

				</a>

				<a href="minhasviagens.jsp"> <span
					class="material-symbols-outlined"> flight </span>

					<li>Minhas viagens</li>

				</a>

				<a href="Destinos"> <span class="material-symbols-outlined">
						shopping_cart_checkout </span>

					<li class="viagens">Comprar passagem</li>
				</a>

				<a href="infocadastrais.jsp"> <span
					class="material-symbols-outlined"> info </span>

					<li>Info. Cadastrais</li>
				</a>

				<a href="#"> <span class="material-symbols-outlined">
						cancel </span>

					<li>Excluir minha conta</li>
				</a>

			</ul>

		</div>


		<div class="principal">

			<h2 class="text-center mt-2 mb-3">Excluir conta</h2>
			<p class="text-center text-primary">
				Para excluir a sua conta <strong>marque a opção sim</strong> e
				clique em <strong>excluir conta</strong>.
			</p>


			<div class="row text-center">

				<div class="col-12">

					<form action="ExcluirConta" method="get">

						<input type="hidden" name="id" class="mt-4 p-2"
							value="<%=u.getId()%>" />

						<div class="row mt-5">
							<p class="mb-5 text-danger">
								<strong>Tem certeza que deseja excluir a sua conta?</strong>
							</p>

							<div class="col-6">
								<label for="sim">Sim</label> <input type="radio" id="sim"
									name="opc" value="sim" />
							</div>

							<div class="col-6">
								<label for="nao">Não</label> <input type="radio" id="nao"
									name="opc" value="nao" checked />
							</div>
						</div>

						<input type="submit" id="botao"
							class="mt-5 mb-4 bg-danger text-light p-3 btn" style="font-size: 1.6rem"
							value="Excluir conta">


					</form>



				</div>


			</div>


		</div>


	</div>

	<script>
	// CÓDIGO PARA HABILITAR/DESABILITAR O BOTÃO DE EXCLUIR CONTA
		let sim = document.getElementById('sim');
		let nao = document.getElementById('nao');
		let btn = document.getElementById('botao');

		btn.disabled = true;

		sim.addEventListener("change", escolha);
		nao.addEventListener("change", escolha);

		function escolha() {
			if (document.querySelector("#sim").checked == true) {
				btn.disabled = false;
			} else {
				btn.disabled = true;
			}
		}
		
	</script>



	<script src="js/perfil.js"></script>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>


</body>
</html>