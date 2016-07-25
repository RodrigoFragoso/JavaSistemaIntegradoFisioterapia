<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>S.I.F - Sistema integrado de Fisioterapia</title>
    <link href="/ClinicaFisioterapia/sif/css/bootstrapLogin.css" rel="stylesheet">
    <link href="/ClinicaFisioterapia/sif/css/bootstrapLogin.min.css" rel="stylesheet">
    <link href="/ClinicaFisioterapia/sif/css/bootstrapLogin-theme.css" rel="stylesheet">
    <link href="/ClinicaFisioterapia/sif/css/bootstrapLogin-theme.min.css" rel="stylesheet">
    <script src="/ClinicaFisioterapia/sif/js/jquery.js"></script>
    <script src="/ClinicaFisioterapia/sif/js/bootstrap.js"></script>
    <script src="/ClinicaFisioterapia/sif/js/bootstrap.min.js"></script>
    <script src="/ClinicaFisioterapia/sif/js/npm.js"></script>
</head>
<body>
	</br></br></br></br>
<div class="container">
    <!--form method="post" action="agenda.html" class="form-signin"-->
		<div class="panel panel-primary">
		  <div class="panel-heading"> 
                    <h3 class="panel-title">Login</h3>
		  </div>
			<h1 class="form-signin-heading" align="center">S.I.F</h1>
			<h2 class="form-signin-heading" align="center">SISTEMA INTEGRADO DE FISIOTERAPIA</h2>
                        <c:choose> 
                            <c:when test="${ifdo eq '1'}">
                               <br /> <h4><center style="color:red">Cadastro realizado com sucesso!</center></h4>
                            </c:when>
                        </c:choose>
			<div class="bs-example" data-example-id="navbar-form" align="center">
				<nav class="navbar navbar-default">
                                <form action="/ClinicaFisioterapia/LoginCli" method="POST" class="form-signin">
                                    <div class="container-fluid"></br>
					<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-2">
                                            <div class="form-group" align="center">
                                                <input type="text" name="username" id="email" class="form-control" placeholder="Digite seu e-Mail ou Usuário" maxlength="30" required>
                                                  </br>
                                                <input type="password" name="userpass" class="form-control" placeholder="Digite sua senha" maxlength="30" required>
                                                <label>
                                                    <a href="#" type="text">Esqueceu sua senha?</a>
                                                </label>
                                            </div>
                                          <button type="submit" class="btn btn-primary">ENTRAR</button>
					</div>
                                    </div><br>
                                </form>
				</nav>
			</div>
			<h5 class="form-signin-heading" align="center"><a href="www.cavichiolloramos.com.br">www.cavichiolloramos.com.br</a></h5>
                </div>
</div>
</body>
</html>