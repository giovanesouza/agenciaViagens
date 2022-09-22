<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <%
    String erro = (String) request.getAttribute("erro");
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

    <!-- REMIX ICON -->
    <link href="https://cdn.jsdelivr.net/npm/remixicon@2.5.0/fonts/remixicon.css" rel="stylesheet">

    <!-- CSS EXTERNO -->
    <link rel="stylesheet" href="css/all.css">

    <title> Login - Go To | Agência de Viagens </title>
    
</head>
<body>


    <!-- CABEï¿½ALHO -->

    <div class="container-fluid mt-3">

        <header class="row">


            <div class="col-sm-6 mb-2 text-justify">
                <a href="index.html">
                    <img src="img/agencia_viagens_small.png" alt="Logo" height="60px">
                </a>
            </div>

            <div class="col-sm-6 text-center">

                <h5> Pensou em viajar?! </h5>
                <p class="small"> A Go To Viagens te leva aonde você quer chegar! </p>

            </div>


        </header>

        <!-- FIM CABEï¿½ALHO -->


        <!-- INï¿½CIO MENUS -->

        <nav class="navbar navbar-expand-sm navbar-light bg-light">
            <a class="navbar-brand" href="#"></a>
            <button class="navbar-toggler d-lg-none" type="button" data-bs-toggle="collapse"
                data-bs-target="#collapsibleNavId" aria-controls="collapsibleNavId" aria-expanded="false"
                aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse relative" id="collapsibleNavId">
                <ul class="navbar-nav me-auto mt-2 mt-lg-0">
                    <li class="nav-item active text-center">
                        <a class="nav-link btn-hover" href="index.html"> HOME <span
                                class="visually-hidden">(current)</span></a>
                    </li>
                    <li class="nav-item text-center">
                        <a class="nav-link btn-hover" href="promocoes.html">PROMOÇÕES</a>
                    </li>
                    <li class="nav-item text-center">
                        <a class="nav-link btn-hover" href="destinos.html">DESTINOS</a>
                    </li>
                    <li class="nav-item text-center">
                        <a class="nav-link btn-hover" href="contato.html">CONTATO</a>
                    </li>
                    <li class="nav-item text-center">
                        <a class="nav-link absolute-right bg-active" href="#">LOGIN</a>
                    </li>
                </ul>

            </div>

        </nav>

    </div>

    <!-- FIM MENUS -->



    <!-- ï¿½REA LOGIN -->
    <div class="container">


        <div class="row mt-5 mb-5">


            <div class="col-md-6">

                <img class="img_login img-fluid"
                    src="https://img.freepik.com/free-vector/tiny-man-buying-ticket-online-via-laptop-monitor-plane-baggage-flat-vector-illustration-travelling-digital-technology_74855-8621.jpg?w=740&t=st=1656546362~exp=1656546962~hmac=21772148eee30138a03402a80befb34beb3239d839b7e4dd85ed0eb3ac12e8b7"
                    alt="Imagem login">

            </div>

            <div class="col-md-6">


                <div class="d-flex justify-content-between">

                    <h3 class="text-login">Login</h3>
                    <span>ou</span>

                    <!-- Button trigger modal -->
                    <h3 class="text-registrar" type="button" class="btn" data-bs-toggle="modal"
                        data-bs-target="#exampleModal">
                        Registrar
                    </h3>

                    <!-- Modal -->
                    <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel"
                        aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">

                                <div class="modal-header">
                                    <h5 class="modal-title" id="exampleModalLabel">Cadastre-se abaixo: </h5>
                                    <button type="button" class="btn-close text-light" data-bs-dismiss="modal"
                                        aria-label="Close"></button>
                                </div>
                                <div class="modal-body bg-modal">

                                    <!-- INÃCIO forms cadastro usuÃ¡rio -->
                                    <form action="CadastrarUsuario" method="post">

                                        <label class="mt-2" for="nome"> <strong> Nome completo: </strong> </label>

                                        <input type="text" class="form-control" name="nome" id="nome_login"
                                            aria-describedby="helpId" placeholder="Digite seu nome completo"
                                            maxlength="60" required="">


                                        <label class="mt-2" for="cpf"> <strong> CPF: </strong> </label>

                                        <input type="tel" class="form-control" name="cpf" id="cliente_cadastrar"
                                            aria-describedby="helpId" placeholder="Digite seu CPF (APENAS Nï¿½MEROS)"
                                            maxlength="11" required="">


                                        <label class="mt-2" for="senha"> <strong> Digite seu e-mail (Serï¿½ utilizado para o Login): </strong> </label>

                                        <input type="email" class="form-control" name="email" id="email_login"
                                            aria-describedby="helpId" placeholder="Digite seu e-mail (nome@dominio.com)"
                                            maxlength="50" required="">


                                        <label class="mt-2" for="senha"> <strong> Senha: </strong> </label>

                                        <input type="password" class="form-control" name="senha" id="senha"
                                            aria-describedby="helpId" placeholder="Digite sua senha (4 a 12 digitos)"
                                            minlength="4" maxlength="12" required>

                                        <label class="mt-2" for="senhaConfirmacao"> <strong> Repita a senha: </strong> </label>

                                        <input type="password" class="form-control" name="senhaConfirmacao" id="senhaconfirm" onchange="verificaSenhaCad()"
                                            aria-describedby="helpId"
                                            placeholder="Digite sua senha novamente (4 a 12 digitos)" minlength="4" maxlength="12"
                                            required>


                                        <div class="col-12 text-center mt-3">

                                            <button class="btn bg-cadastrar" type="submit">Cadastrar</button>

                                        </div>


                                    </form>
                                    <!-- FIM forms cadastro usuÃ¡rio -->

                                </div>
                                <div class="modal-footer">

                                    <button type="button" class="btn btn-secondary"
                                        data-bs-dismiss="modal">cancelar</button>


                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- FIM Button trigger modal -->

                </div>


                <form action="Logar" method="post">

                    <div class="row mb-2 mt-2">

                        <input type="email" class="form-control" name="email" id="email_login" aria-describedby="helpId"
                            placeholder="Digite seu e-mail (nome@dominio.com)" maxlength="50" required="">

                    </div>

                    <div class="row">

                        <input type="password" class="form-control" name="senha" id="senha_login"
                            aria-describedby="helpId" minlength="4" maxlength="12" placeholder="Digite sua senha (4 a 12 digitos)" required="">

                    </div>


                    <div class="row mt-2">

                        <div>
                            <input type="checkbox" name="lembrar" id="lembrar_login"> <span>Lembre-me</span>
                        </div>

                        <div>
                            <a class="link_rodape" href="#"> Esqueci minha senha </a>
                        </div>

                    </div>


                    <div class="row">

                        <button class="botao_login" type="submit"> Entrar </button>
							
						<p class="text-center text-danger mt-2">
						 <strong>
						 	<%
						 	if (erro != null) {	out.print(erro); }
						 	%>	
						 	</strong>
						 </p>
							
                    </div>


                </form>


            </div>


        </div>



    </div>
    <!-- FIM ï¿½REA LOGIN -->


    <!-- ICON SCROLL TOP -->

    <i onclick="subirTela()" class="ri-arrow-up-s-line" id="icon-top"></i>

    <!-- ICON SCROLL TOP -->


    <!-- RODAPï¿½ -->
    <footer class="container-fluid bg-light">


        <div class="row mb-3">

            <div class="col-sm-6 mb-2 text-right">
                <a href="index.html">
                    <img src="img/agencia_viagens_small.png" alt="logo" width="150px">
                </a>
            </div>

            <div class="col-sm-6 text-justify">

                <h5> Go To Viagens </h5>
                <p class="m-0 small">CNPJ 12.123.123/0001-12</p>
                <p class="m-0 small">Rua Giovane Souza, 0010 - HTML CSS BOOTSTRAP</p>
                <p class="m-0 small">CEP: 10100-011, Internet/JS</p>

            </div>


        </div>


        <div class="row">

            <div class="col-12">

                <div class="accordion" id="accordionExample">
                    <div class="accordion-item">
                        <h2 class="accordion-header" id="headingOne">
                            <button class="accordion-button bg-light text-primary" type="button"
                                data-bs-toggle="collapse" data-bs-target="#collapseOne" aria-expanded="true"
                                aria-controls="collapseOne">
                                FORMAS DE PAGAMENTO
                            </button>
                        </h2>
                        <div id="collapseOne" class="accordion-collapse collapse show" aria-labelledby="headingOne"
                            data-bs-parent="#accordionExample">
                            <div class="accordion-body text-center">

                                <img class="img-fluid"
                                    src="https://i0.wp.com/urucuna.com/wp-content/uploads/2021/02/bandeiras-cartoes-credito.png?ssl=1"
                                    alt="formas de pagamento">

                            </div>
                        </div>
                    </div>

                </div>



            </div>

        </div>



        <div class="row mt-4 mb-2">


            <div class="col-lg-2 col-sm-4 small"> <a class="link_rodape" href="quemsomos.html"> Quem somos </a> </div>
            <div class="col-lg-2 col-sm-4 small"> <a class="link_rodape" href="centralajuda.html"> Central de ajuda </a>
            </div>
            <div class="col-lg-2 col-sm-4 small"> <a class="link_rodape" href="termoscondicoes.html"> Termos e condiï¿½ï¿½es
                </a> </div>
            <div class="col-lg-2 col-sm-4 small"> <a class="link_rodape" href="duvidas.html"> Dï¿½vidas </a> </div>
            <div class="col-lg-2 col-sm-4 small"> <a class="link_rodape" href="contato.html"> Clique para falar conosco
                </a> </div>
            <div class="col-lg-2 col-sm-4 small"> <a class="link_rodape" href="trabalheconosco.html"> Trabalhe conosco
                </a> </div>

        </div>



        <div class="row mt-4 mb-3">
            <div class="col-12 text-center"> &copy 2022 - Go To Agï¿½ncia de Viagens </div>
        </div>



    </footer>

    <script src="js/all.js"></script>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>

</body>
</html>