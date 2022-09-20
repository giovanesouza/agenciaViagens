<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="ISO-8859-1">

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
    <link rel="stylesheet" href="css/perfil.css">
    
<title>Perfil</title>
</head>
<body>

  <header class="container mt-2">

        <div class="row container">

            <div class="col-6 text-light mt-2 mb-2">

                <img src="img/icon_goto.png" alt="logo" id="logo">
                <span>Go To Viagens - Sua Agência de Turismo</span>

            </div>

            <div class="col-4 text-light d-flex flex-column align-items-center justify-content-center">

                <span>Olá, ${Usuario.nome}NOME. Seja bem vindo(a)!</span>
                <span><strong>Data:</strong><span id="data"></span>.</span>
                <span><strong>Hora:</strong> <span id="hora"></span>.</span>

            </div>

            <div class="col-2 text-light d-flex align-items-center justify-content-end mt-2 mb-2">

                <a href=""><i class="ri-logout-box-line"></i></a>

            </div>

        </div>
    </header>
    
    <span>${Usuario.nome}</span>
    <span>${Usuario.email}</span>
    <span>${Usuario.senha}</span>


    <script src="js/perfil.js"></script>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>

</body>
</html>