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
    <!--link href="css/plugins/morris.css" rel="stylesheet"-->
    <script src="/clinica/sif/js/jquery.js"></script>
    <script src="/clinica/sif/js/bootstrap.min.js"></script>
    <script src="/clinica/sif/js/plugins/morris/raphael.min.js"></script>
    <script src="/clinica/sif/js/plugins/morris/morris.min.js"></script>
    <script src="/clinica/sif/js/plugins/morris/morris-data.js"></script>
	<script>
		$('.collapse').collapse();
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
                            <a href="/clinica/LoginCli"><i class="fa fa-fw fa-power-off"></i> Log Out</a>
                        </li>
                    </ul>
                </li>
            </ul>
            <!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->
            <div class="collapse navbar-collapse navbar-ex1-collapse">
                <ul class="nav navbar-nav side-nav">
                    <li class="active">
                        <a href="/clinica/controllerAgenda"><i class="fa fa-fw fa-table"></i> Agenda</a>
                    </li>
                    <li>
                        <a href="/clinica/sif/cadastraPaciente.jsp"><i class="fa fa-fw fa-edit"></i> Cadastro de Pacientes</a>
                    </li>
                    <!--li>
                        <a href="/clinica/sif/listaPaciente.jsp"><i class="glyphicon glyphicon-list-alt"></i> Pacientes</a>
                    </li-->
                    <li>
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
			  <li class="active"><i class="fa fa-table"></i> Agenda</a></li>
			</ol>
			
            <div class="col-sm-4">
                <div class="panel panel-success">
                    <div class="panel-heading">
                        <h3 class="panel-title">
                            <i class="glyphicon glyphicon-user"></i>
                            Compareceu: <b>10 ${count.pacientes}Atendidos</b>
			</h3>
                    </div>
                </div>
            </div>
            <div class="col-sm-4">
                <div class="panel panel-danger">
                    <div class="panel-heading">
                        <h3 class="panel-title">
			<i class="glyphicon glyphicon-user"></i>
                            Não Compareceu <b>10 ${count.pacientes}Atendidos</b>
			</h3>
                    </div>  
                </div>
            </div>
			
			<!-- Page Heading -->
			<div class="row">
				<div class="col-lg-12">
                                    <h1 class="page-header">Agenda Di&aacute;ria</h1>
				</div>
			</div>
			
			<!-- PACIENTES POR HORAS-->
            <div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
                    <div class="panel-group" id="accordion">
                        <c:set var="aberto" value="0" scope="session"/>
                        <c:set var="horas" value="0" scope="session"/>
                            <c:forEach items="${pacientes}" var="panel">
                                    <c:if test="${aberto eq 1 && horas != panel.hora_sessoes}">
                                            </tbody>
                                        </table>
                                       </div>
                                    </div>
                                   </div>
                                     <c:set var="aberto" value="0" scope="session"/>
                                    </c:if>
                                    <c:if test="${aberto eq 0 && horas != panel.hora_sessoes}">
                                        <c:set var="horas" value="${panel.hora_sessoes}" scope="session"/>
                                        <c:set var="aberto" value="1" scope="session"/>
                                       <div class="panel panel-primary" id="panel_<c:out value="${panel.idpacientes}"/>">
                                            <div class="panel-heading">
                                                 <h4 class="panel-title">
                                                    <a data-toggle="collapse" data-target="#collapseOne" href="#collapseOne">
                                                    <b><c:out value="${panel.hora_sessoes}"/> - PACIENTES DO DIA: <c:out value="${panel.data}"/></b>
                                                    </a>
                                                 </h4>
                                            </div>
                                            <div id="collapseOne" class="panel-collapse collapse in">
                                <div class="table-responsive">
                                    <table class="table table-bordered table-striped js-options-table">
                                        <thead>
                                            <tr>
                                                <th>ID</th> 
                                                <th>N&ordm; SUS</th> 
                                                <th>NOME PACIENTE</th> 
                                                <th>STATUS</th>
                                                <th>A&Ccedil;&Otilde;ES</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            </c:if>
                                            <c:if test="${aberto eq 1}">
                                                <tr>
                                                    <td>
                                                        <c:out value="${panel.idpacientes}"/>
                                                    </td>
                                                    <td>
                                                        <c:out value="${panel.num_sus}"/>
                                                    </td>
                                                    <td>
                                                        <c:out value="${panel.nome}"/>
                                                    </td>
                                                    <td>
                                                        <c:out value="${panel.status}"/>
                                                    </td>
                                                    <td>
                                                        <a class="btn btn-success" href="controllerAgenda?action=comp&idpacientes=<c:out value="${panel.idpacientes}"/>">Compareceu</a>
                                                        <a class="btn btn-danger" href="controllerAgenda?action=ncomp&idpacientes=<c:out value="${panel.idpacientes}"/>">Falta</a>
                                                        <a class="btn btn-info" href="/clinica/pacienteController?action=paciente&idpacientes=<c:out value="${panel.idpacientes}"/>">Editar</a>
                                                    </td>
                                                </tr>
                                            </c:if>
                                        </c:forEach>
				</div>
			</div>
			<!-- FIMPACIENTES POR HORAS-->
		</div>	
	</div>
</body>
</html>