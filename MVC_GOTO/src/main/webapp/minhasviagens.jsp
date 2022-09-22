<!-- IMPORTAÇÃO DA CLASS USUÁRIO -->
<%@page import="model.Usuario"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl"%>
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

    <!-- REMIX ICON -->
    <link href="https://cdn.jsdelivr.net/npm/remixicon@2.5.0/fonts/remixicon.css" rel="stylesheet">

    <!-- CSS EXTERNO -->
    <link rel="stylesheet" href="css/profile.css">
    <!-- <link rel="stylesheet" href="css/all.css"> -->
<title>Minhas Viagens</title>
</head>
<body>

  <header class="container">

        <div class="row container p-2">

            <div class="col-md-3 mt-2 mb-2 logo">

                <img src="img/agencia_viagens_small.png" alt="logo" id="logo">

            </div>

            <div class="col-md-7 d-flex flex-column align-items-start justify-content-center">

				<%
				Usuario u = (Usuario) session.getAttribute("usuarioLogado");
				// out.print(u.getNome());
				%>

                <span>Olá, <%=u.getNome() %>. Seja bem vindo(a)!</span>
                
                <div class="datahora">
                    <span><strong>Data:</strong> <span id="data"></span>.</span>
                    <span><strong>Hora:</strong> <span id="hora"></span>.</span>
                </div>

            </div>

            <div class="col-md-2 text-light d-flex align-items-center justify-content-end mt-2 mb-2">

                <a href="Index"><i class="ri-logout-box-line"></i></a>

            </div>

        </div>
    </header>


    <div class="container grid-container">

        <div class="menu">

            <ul>
                <a href="perfil.jsp">
                    <li class="home">Início</li>
                </a>
                <a href="#">
                    <li class="viagens">Minhas viagens</li>
                </a>
                <a href="infocadastrais.jsp">
                    <li class="infoIcon">Info. Cadastrais</li>
                </a>

            </ul>
        </div>


        <div class="principal">

            <h2 class="text-center mt-2 mb-2">Minhas viagens</h2>
            <p class="text-center text-danger">No momento você não há compras em seu nome.</p>


        </div>


    </div>


    <script src="js/perfil.js"></script>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>


</body>
</html>