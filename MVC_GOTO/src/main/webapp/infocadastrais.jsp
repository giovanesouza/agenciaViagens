<!-- IMPORTA��O DA CLASS USU�RIO -->
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
<meta charset="ISO-8859-1">
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

 <!-- ICON GO TO -->
    <link rel="shortcut icon" href="img/icon_goto.png" type="image/x-icon">

    <!-- BOOTSTRAP -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

    <!-- GOOGLE ICON -->
    <link rel="stylesheet"
        href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />

<!-- CSS EXTERNO -->
<link rel="stylesheet" href="css/profile.css">


<title>Informa��es cadastrais</title>

</head>
<body>

	<header class="container">

		<div class="row container p-2">

			<div class="col-md-3 mt-2 mb-2 logo">

				<img src="img/agencia_viagens_small.png" alt="logo" id="logo">

			</div>

			<div
				class="col-md-7 d-flex flex-column align-items-start justify-content-center">

				<%
				Usuario u = (Usuario) session.getAttribute("usuarioLogado");
				// out.print(u.getNome());
				%>

				<span>Ol�, <%=u.getNome()%>. Seja bem vindo(a)!
				</span>

				<div class="datahora">
					<span><strong>Data:</strong> <span id="data"></span>.</span> <span><strong>Hora:</strong>
						<span id="hora"></span>.</span>
				</div>

			</div>

			<div
				class="col-md-2 text-light d-flex align-items-center justify-content-end mt-2 mb-2">

				<a href="Index"><i class="ri-logout-box-line"></i></a>

			</div>

		</div>
	</header>


	<div class="container grid-container">

		<div class="menu">

			<ul>
				<a href="#"> <span class="material-symbols-outlined">
						home </span>

					<li>In�cio</li>

				</a>

				<a href="minhasviagens.jsp"> <span
					class="material-symbols-outlined"> flight </span>

					<li>Minhas viagens</li>

				</a>

				<a href="Destinos"> <span class="material-symbols-outlined">
						shopping_cart_checkout </span>

					<li class="viagens">Comprar passagem</li>
				</a>

				<a href="#"> <span class="material-symbols-outlined">
						info </span>

					<li>Info. Cadastrais</li>
				</a>

				<a href="excluirconta.jsp"> <span
					class="material-symbols-outlined"> cancel </span>

					<li>Excluir minha conta</li>
				</a>

			</ul>

		</div>


		<div class="principal">

			<h2 class="text-center mt-2 mb-2">Informa��es cadastrais</h2>
			<p class="infoCad">Caso deseje realizar uma atualiza��o cadastral
				basta alterar os dados e clicar no bot�o "atualizar dados".</p>

			<form action="Atualizar" method="post">


				<div class="row mt-5 mb-3">

					<input type="hidden" name="id" value="<%=u.getId()%>" />

					<div class="col-md-2">

						<label for="cpf">CPF:</label>

					</div>

					<div class="col-md-10">
						<input type="text" name="cpf" disabled value="<%=u.getCpf()%>" />

					</div>


				</div>

				<div class="row mb-3">
					<div class="col-md-2">
						<label for="nome">Nome:</label>
					</div>
					<div class="col-md-10">
						<input type="text" maxlength="50" name="nome"
							value="<%=u.getNome()%>" />
					</div>
				</div>


				<div class="row mb-3">

					<div class="col-md-2">
						<label for="email">E-mail:</label>
					</div>
					<div class="col-md-10">
						<input type="text" maxlength="50" name="email"
							value="<%=u.getEmail()%>" />
					</div>
				</div>

				<div class="row mb-3">

					<div class="col-md-2">
						<label for="telefone">Telefone:</label>
					</div>
					<div class="col-md-10">
						<input type="text" maxlength="11" name="tel"
							value="<%=u.getTelefone()%>" />
					</div>

				</div>

				<div class="row mb-5">

					<div class="col-md-2">
						<label for="senha">Senha:</label>
					</div>
					<div class="col-md-10">
						<input type="text" minlength="4" maxlength="12" name="senha"
							value="<%=u.getSenha()%>" />
					</div>

				</div>

				<div class="row mb-3">

					<div class="col-12 text-success">

						<%
						if (sucesso != null) {
							out.print(sucesso);
						}
						%>

					</div>

					<div class="col-12 text-right">

						<button type="submit">Atualizar dados</button>

					</div>

				</div>


			</form>



		</div>


	</div>


	<script src="js/perfil.js"></script>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>


</body>
</html>