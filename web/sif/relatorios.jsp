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
        <script src="/clinica/sif/js/jquery.maskedinput.js" type="text/javascript"></script>
        <script src="/clinica/sif/js/bootstrap.min.js"></script><!--responsavel pelo modal da pagina-->
        <script>
            $('.collapse').collapse();
        </script>
        <script>
            $('#myModal').on('shown.bs.modal', function () {
                $('#myInput').focus()
            })
        </script>
        <script>jQuery(function ($) {
                $("#dataInicial").mask("99/99/9999");
                $("#dataFinal").mask("99/99/9999");
            });
        </script>
    </head>

    <body>
        <div id="wrapper">    
            <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <a class="navbar-brand" href="/clinica/controllerAgenda">S.I.F - Sistema Integrado de Fisioterapia</a>
                </div>

                <!-- Top Menu Items -->
                <ul class="nav navbar-right top-nav">
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user"></i> ${dadosFuncionario.nome} <b class="caret"></b></a>
                        <ul class="dropdown-menu">
                            <li>
                                <a href="/clinica/LoginCli"><i class="fa fa-fw fa-power-off"></i> Log Out</a>
                            </li>
                        </ul>
                    </li>
                </ul>
                <!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->
                <div class="collapse navbar-collapse navbar-ex1-collapse">
                    <ul class="nav navbar-nav side-nav">
                        <li>
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
                            <a href="/clinica/controllerListaFunc"><i class="glyphicon glyphicon-list-alt"></i> Funcion&aacute;rios</a>
                        </li>
                        <li class="active">
                            <a href="/clinica/sif/relatorios.jsp"><i class="fa fa-fw fa-bar-chart-o"></i> Relat&oacute;rios</a>
                        </li>
                        <li>
                            <a href="/clinica/LoginCli"><i class="glyphicon glyphicon-off"></i> SAIR</a>
                        </li>
                    </ul>
                </div>
                <!-- /.navbar-collapse -->
            </nav>

            <div id="page-wrapper">
                <ol class="breadcrumb">
                    <li><a href="#">In&iacute;cio</a></li>
                    <li class="active"><i class="fa fa-fw fa-bar-chart-o"></i> Relat&oacute;rios</a></li>
                </ol>
                <!-- Page Heading -->
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">Relat&oacute;rios</h1>
                    </div>
                </div>
                <!--painel do primeiro relatorio-->
                <form method="GET" action='../ExportCSV' name="export" id="export" role="form" accept-charset="UTF-8">
                    <div class="panel panel-primary">
                        <div class="panel-heading">
                            <h3 class="panel-title">RELAT&Oacute;RIO DE PACIENTES</h3>
                        </div>
                        <div class="panel-body">
                            <div class="form-group">
                                <!--label>CaracterÃ­stica da regiÃ£o apalpada:</label-->
                                <label class="radio-inline">
                                    <input type="radio" name="status" id="Compareceu" value="Compareceu">Pacientes Atendidos
                                </label>
                                <label class="radio-inline">
                                    <input type="radio" name="status" id="NCompareceu" value="nCompareceu">Pacientes N&atilde;o Atendidos
                                </label>
                            </div>
                            <div class="form-group col-md-3">
                                <label for="inicio">DE: </label>
                                <input type="text" class="form-control" name="dataInicial" id="dataInicial" OnKeyUp="mascaraData(this);">
                            </div>
                            <div class="form-group col-md-3">
                                <label for="final">AT&Eacute;: </label>
                                <input type="text" class="form-control" name="dataFinal" id="dataFinal" OnKeyUp="mascaraData(this);">
                            </div>
                            <div class="form-group col-md-8">
                                <!--button type="button" class="btn btn-SUCCESS"><a href="7.2_TelaExportarPacientesAtendENaoAtend.png">EXPORTAR PARA EXCEL </a><i class="glyphicon glyphicon-cloud-download"></i></button-->
                                <button type="submit" class="btn btn-SUCCESS">EXPORTAR PARA EXCEL<i class="glyphicon glyphicon-cloud-download"></i></button>
                            </div>
                        </div>
                    </div>
                </form>
                <!--painel do segundo relatorio-->
                <div class="panel panel-primary">
                    <div class="panel-heading">
                        <h3 class="panel-title">RELAT&Oacute;RIO DE FECHAMENTO</h3>
                    </div>
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-lg-8">
                                <div class="input-group">
                                    <input type="text" class="form-control" placeholder="Digite o N&ordm; Cart&atilde;o SUS ou Nome do Paciente">
                                    <span class="input-group-btn">
                                        <button class="btn btn-primary" type="button">BUSCAR</button>
                                    </span>
                                </div><!-- /input-group -->
                            </div>
                        </div></br>

                        <div id="collapseOne" class="panel-collapse collapse in">
                            <div class="table-responsive">
                                <table class="table table-bordered table-striped js-options-table">
                                    <thead>
                                        <tr>
                                            <th>N&ordm; SUS</th> 
                                            <th>NOME PACIENTE</th> 
                                            <th>QUANTIDADE DE SESS&Otilde;ES</th>
                                            <th>A&Ccedil;&Otilde;ES</th>
                                        </tr> 
                                    </thead>
                                    <tbody>
                                        <tr class="warning">
                                            <td>0000000.000.00</td>
                                            <td>Hulk Smash</td>
                                            <td>10</td>
                                            <td>
                                                <button type="button" data-toggle="modal" data-target="#myModal" class="btn btn-info">EDITAR SESS&Otilde;ES</button>
                                                <button type="button" data-toggle="modal" data-target="#myModal" class="btn btn-danger">REMOVER</button>
                                            </td>
                                        </tr>
                                        <tr class="warning">
                                            <td>0000000.000.01</td>
                                            <td>Batman Cavaleiro das trevas</td>
                                            <td>8</td>
                                            <td>
                                                <button type="button" data-toggle="modal" data-target="#myModal" class="btn btn-info">EDITAR SESS&Otilde;ES</button>
                                                <button type="button" data-toggle="modal" class="btn btn-danger">REMOVER</button>
                                            </td>
                                        </tr> 
                                    </tbody>
                                </table>
                            </div>
                            <!-- Modal -->
                            <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                                <div class="modal-dialog" role="document">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                            <h4 class="modal-title" id="myModalLabel">EDITA SESS&Otilde;ES</h4>
                                        </div>

                                        <div id="collapseOne" class="panel-collapse collapse in">
                                            <div class="table-responsive">
                                                <table class="table table-bordered table-striped js-options-table">
                                                    <thead>
                                                        <tr>
                                                            <th>DATA</th>
                                                            <th>A&Ccedil;&Otilde;ES</th>
                                                        </tr> 
                                                    </thead>
                                                    <tbody>
                                                        <tr>
                                                            <td>
                                                                <input type="date" name="dataConsulta" value="dataConsulta">
                                                            </td>
                                                            <td>
                                                                <a class="btn btn-success" href="atualizaDataConsulta.php?id=">Compareceu</a>
                                                                <a class="btn btn-danger" href="atualizaDataConsulta.php?id=">Falta</a>
                                                            </td>
                                                        </tr>
                                                        <tr>
                                                            <td>
                                                                <input type="date" name="dataConsulta" value="dataConsulta">
                                                            </td>
                                                            <td>
                                                                <a class="btn btn-success" href="atualizaDataConsulta.php?id=">Compareceu</a>
                                                                <a class="btn btn-danger" href="atualizaDataConsulta.php?id=">Falta</a>
                                                            </td>
                                                        </tr> 
                                                    </tbody>
                                                </table>
                                            </div>
                                        </div>

                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                            <button type="button" class="btn btn-primary">Salvar</button>
                                        </div>
                                    </div>
                                </div>
                            </div>

                        </div>

                        <div class="form-group">
                            <button type="button" class="btn btn-SUCCESS"><a href="7.1_TelaExportarFechamentoGuias.png">EXPORTAR PARA EXCEL </a><i class="glyphicon glyphicon-cloud-download"></i></button>
                            <!--button type="button" class="btn btn-SUCCESS">EXPORTAR PARA EXCEL <i class="glyphicon glyphicon-cloud-download"></i></button-->
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>