<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="pt-br">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>S.I.F - Sistema Integrado de Fisioterapia</title>
    <link href="/clinica/sif/css/bootstrap.min.css" rel="stylesheet">
    <link href="/clinica/sif/css/sb-admin.css" rel="stylesheet">
    <link href="/clinica/sif/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">	
    <link href="/clinica/sif/css/plugins/morris.css" rel="stylesheet">
    <script src="/clinica/sif/js/jquery.js"></script>
    <script src="/clinica/sif/js/bootstrap.min.js"></script>
    <script src="/clinica/sif/js/plugins/morris/raphael.min.js"></script>
    <script src="/clinica/sif/js/plugins/morris/morris.min.js"></script>
    <script src="/clinica/sif/js/plugins/morris/morris-data.js"></script>
	<script>
		$('.collapse').collapse();
	</script>
        <script>
        function cadastraFunc(){
                var nome=$('#nome').val();
                var matricula=$('#email').val();
                    alert("O Funcionario: "+nome+"\n"+"do E-mail: "+email+"\n\n"+"Cadastrado com Sucesso !");
                    return true;
            }
	</script>
        <script>
            function validaEmail(){
                $.ajax({
                    method: "POST",
                    url: "/clinica/ValidaEmail",
                    data: { email: $('#email').val() },

                    success: function( retorno ) {
                        console.log(retorno.length);
                        if(retorno.length == 5){
                          alert( "Email Já Cadastrado! Por favor digite outro." );
                        }else{
                          frmAddFuncionario.submit();
                        }
                    }
                });
            }    
        </script>
</head>

<body>
    <div id="wrapper">    
		<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <a class="navbar-brand" href="/clinica/sif/agenda.jsp">S.I.F - Sistema Integrado de Fisioterapia</a>
            </div>
            
			<!-- Top Menu Items -->
            <ul class="nav navbar-right top-nav">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user"></i> ${dadosFuncionario.nome} <b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li>
                            <a href="#"><i class="fa fa-fw fa-user"></i> Profile</a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="/clinica/sif/loginCli.jsp"><i class="fa fa-fw fa-power-off"></i> Log Out</a>
                        </li>
                    </ul>
                </li>
            </ul>
            <!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->
            <div class="collapse navbar-collapse navbar-ex1-collapse">
                <ul class="nav navbar-nav side-nav">
                    <li>
                        <a href="/clinica/sif/agenda.jsp"><i class="fa fa-fw fa-table"></i> Agenda</a>
                    </li>
                    <li>
                        <a href="/clinica/sif/cadastraPaciente.jsp"><i class="fa fa-fw fa-edit"></i> Cadastro de Pacientes</a>
                    </li>
                    <li>
                        <a href="/clinica/sif/listaPaciente.jsp"><i class="glyphicon glyphicon-list-alt"></i> Pacientes</a>
                    </li>
                    <li class="active">
                        <a href="/clinica/sif/cadastraFuncionario.jsp"><i class="fa fa-fw fa-edit"></i> Cadastro de Funcion&aacute;rios</a>
                    </li>
                    <li>
                        <a href="/clinica/sif/listaFuncionario.jsp"><i class="glyphicon glyphicon-list-alt"></i> Funcion&aacute;rios</a>
                    </li>
                    <li>
                        <a href="/clinica/sif/relatorios.jsp"><i class="fa fa-fw fa-bar-chart-o"></i> Relat&oacute;rios</a>
                    </li>
                    <li>
                        <a href="/clinica/sif/loginCli.jsp"><i class="glyphicon glyphicon-off"></i> SAIR</a>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </nav>
		<div id="page-wrapper">
			<ol class="breadcrumb">
			  <li><a href="#">In&iacute;cio</a></li>
			  <li class="active"><i class="fa fa-fw fa-edit"></i> Cadastrar Funcion&aacute;rios</a></li>
			</ol>
			<div class="alert alert-danger" role="alert">
			  <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
				Cadastre as informações do funcion&aacute;rio e n&atilde;o esque&ccedil;a de preencher a <b><u>senha de acesso</u></b>!
			</div>
			<!-- Page Heading -->
            <div class="row">
                <div class="col-lg-12">
                   <h1 class="page-header">Cadastrar Funcion&aacute;rios</h1>
                </div>
            </div>
			
			<div class="panel panel-primary">
				<div class="panel-heading">
					<h3 class="panel-title">Dados do funcion&aacute;rio</h3>
				</div>
			<form method="POST" action='../funcionarioController' name="frmAddFuncionario" id="frmAddFuncionario" role="form" onsubmit="cadastraFunc()">	
                            <div class="panel-body">
					<div class="form-group col-md-4">
					   <label for="campo1">Nome/Usu&aacute;rio: </label>
					   <input type="text" name="nome" id="nome" value="<c:out value="${funcionario.nome}" />" class="form-control" id="campo1" required>
					</div>
					<div class="form-group col-md-4">
					   <label for="campo1">e-Mail: </label>
					   <input type="text" name="email" id="email" value="<c:out value="${funcionario.email}" />" class="form-control" id="campo1" required>
					</div>
					<div class="form-group col-md-4">
					   <label for="campo1">Senha de acesso: </label>
					   <input type="password" name="senha" id="senha" value="<c:out value="${funcionario.senha}" />" class="form-control" id="campo1" required>
					</div>
					<div class="form-group col-md-4">
					   <label for="campo1">CPF: </label>
					   <input type="text" name="cpf" id="cpf" value="<c:out value="${funcionario.cpf}" />" class="form-control" id="campo1">
					</div>
					<div class="form-group col-md-4">
						<label for="sel1">Cargo:</label>
						<select class="form-control" name="cargo" id="sel1">
							<option>Selecionar</option>
							<option value="Fisioterapeuta">Fisioterapeuta</option>
							<option value="Secretária">Secret&aacute;ria</option>
							<option value="Auxiliar de Serviços Gerais">Auxiliar de servi&ccedil;os gerais</option>
						</select>
					</div>
					<div class="form-group col-md-4">
					   <label for="campo1">Telefone: </label>
					   <input type="text" name="telefone" id="telefone" value="<c:out value="${funcionario.telefone}" />" class="form-control" id="campo1">
					</div>
					<div class="form-group col-md-6">
						<button type="button" class="btn btn-DANGER">CANCELAR</button>
						<button type="button" class="btn btn-SUCCESS" onclick="validaEmail()">CADASTRAR <i class="glyphicon glyphicon-floppy-disk"></i></button>
					</div>
				</div>
                            </form>
			</div>
		</div>
	
	</div>
</body>
</html>