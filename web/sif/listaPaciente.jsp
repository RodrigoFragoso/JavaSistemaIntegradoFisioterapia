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
        <script src="/clinica/sif/js/bootstrap.min.js"></script>

        <script>
            function cadastraPaciente() {
                var nome = $('#nome').val();
                var matricula = $('#email').val();
                alert("O Funcionario: " + nome + "\n" + "do E-mail: " + email + "\n\n" + "Cadastrado com Sucesso !");
                return true;
            }
        </script>
        <script>
            $('.collapse').collapse();
        </script>
        <script>
            /*avança do dados do paciente para ficha de avaliação*/
            $(document).ready(function () {
                $('#avancar1').on('click', function () {
                    $('#aprofile').trigger('click');
                });
            });

            /*Avança do Ficha de avaliação para Disponibilidade para sessões*/
            $(document).ready(function () {
                $('#avancar2').on('click', function () {
                    $('#amessages').trigger('click');
                });
            });
            /*Volta da ficha de avaliação para Dados do paciente*/
            $(document).ready(function () {
                $('#voltar1').on('click', function () {
                    $('#ahome').trigger('click');
                });
            });
            /*Volta da Disponibilidade de sessões para ficha de avaliação*/
            $(document).ready(function () {
                $('#voltar2').on('click', function () {
                    $('#aprofile').trigger('click');
                });
            });
        </script>
        <script language='JavaScript'>
            function SomenteNumero(e) {
                var tecla = (window.event) ? event.keyCode : e.which;
                if ((tecla > 47 && tecla < 58))
                    return true;
                else {
                    if (tecla == 8 || tecla == 0)
                        return true;
                    else
                        return false;
                }
            }
        </script>
        <script>jQuery(function ($) {
                //$("#cpf").mask("999.999.999-99");
                $("#cep").mask("99999-999");
                $("#dt_nasc").mask("99/99/9999", {placeholder: "mm/dd/yyyy"});
                $("#dt_emissao").mask("99/99/9999", {placeholder: "mm/dd/yyyy"});
                $("#telefone").mask("(99) 9999-9999");
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
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user"></i>  ${dadosFuncionario.nome} <b class="caret"></b></a>
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
                        <li class="active">
                            <a href="/clinica/sif/cadastraPaciente.jsp"><i class="fa fa-fw fa-edit"></i> Cadastro de Pacientes</a>
                        </li>
                        <!--li class="active">
                            <a href="/clinica/sif/listaPaciente.jsp"><i class="glyphicon glyphicon-list-alt"></i> Pacientes</a>
                        </li-->
                        <li>
                            <a href="/clinica/sif/cadastraFuncionario.jsp"><i class="fa fa-fw fa-edit"></i> Cadastro de Funcion&aacute;rios</a>
                        </li>
                        <li>
                            <a href="/clinica/controllerListaFunc"><i class="glyphicon glyphicon-list-alt"></i> Funcion&aacute;rios</a>
                        </li>
                        <li>
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
                    <li class="active"><i class="fa fa-fw fa-table"></i> Agenda</a></li>
                    <li class="active"><i class="fa fa-fw fa-edit"></i> Listar Pacientes</a></li>
                </ol>
                <div class="alert alert-danger" role="alert">
                    <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
                    Cadastre as informa&ccedil;&otilde;es do pacientes e <b><u>agende o dia e hora</u></b> para as sess&otilde;es!
                </div>
                <!-- Page Heading -->
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">Paciente: ${paciente.nome} - Nº SUS: ${paciente.num_sus}</h1>
                        <!--h1 class="page-header">ID: ${paciente.idpacientes}</h1-->
                    </div>
                </div>
                <form method="POST" action='/clinica/pacienteUpdateController' name="frmUpdatePaciente" id="frmUpdatePaciente" role="form">
                    <div>
                        <!-- Nav tabs -->
                        <ul class="nav nav-tabs nav-justified " role="tablist" id="myTabs">
                            <li role="presentation" class="active"><a href="#home" id="ahome" aria-controls="home" role="tab" data-toggle="tab"><b>DADOS DO PACIENTE</b></a></li>
                            <li role="presentation"><a href="#profile" id="aprofile" aria-controls="profile" role="tab" data-toggle="tab"><b>FICHA DE AVALI&Ccedil;&Atilde;O</b></a></li>
                            <!--li role="presentation"><a href="#messages" id="amessages" aria-controls="messages" role="tab" data-toggle="tab"><b>DISPONIBILIDADE PARA SESS&Otilde;ES</b></a></li-->
                        </ul>
                        <!-- Tab panes -->
                        <div class="tab-content">
                            <!-- DADOS DO PACIENTE-->
                            <div role="tabpanel" class="tab-pane active" id="home"></br>
                                <div>
                                    <div class="row">
                                        <input type="hidden" value="${paciente.idpacientes}" name="idpacientes">
                                        <input type="hidden" name="action" value="atualiza">
                                        <div class="form-group col-md-3">
                                            <label for="num_sus">Nº Cart&atilde;o SUS: </label>
                                            <input type="text" class="form-control" value="${paciente.num_sus}" name="num_sus" id="num_sus" maxlength="20" onkeypress="return SomenteNumero(event)" required/>
                                        </div>
                                        <div class="form-group col-md-6">
                                            <label for="nome">Nome Completo: </label>
                                            <input type="text" class="form-control" name="nome" value="${paciente.nome}" id="nome" maxlength="40" required/>
                                        </div>

                                        <div class="form-group col-md-3">
                                            <label for="telefone">Telefone</label>
                                            <input type="text" class="form-control" name="telefone" id="telefone" value="${paciente.telefone}" maxlength="14" onkeypress="return SomenteNumero(event)">
                                        </div>
                                        <div class="form-group col-md-2">
                                            <label for="dt_nasc">Data Nascimento</label>
                                            <input type="text" class="form-control" name="dt_nasc" value="${paciente.dt_nasc}" id="dt_nasc" maxlength="10" onkeypress="return SomenteNumero(event)">
                                        </div>
                                        <div class="form-group col-md-1">
                                            <label for="idade">Idade</label>
                                            <input type="text" class="form-control" name="idade" value="${paciente.idade}" id="idade" maxlength="3" onkeypress="return SomenteNumero(event)">
                                        </div>
                                        <div class="form-group col-md-3">
                                            <label for="sexo">Sexo</label>
                                            <select class="form-control" name="sexo" id="sexo">
                                                <option value="Masculino" value="${paciente.sexo}" <c:out value="${Masculino}"/>>Masculino</option>
                                                <option value="Feminino" value="${paciente.sexo}" <c:out value="${Feminino}"/>>Feminino</option>
                                            </select>
                                        </div>							
                                        <div class="form-group col-md-2">
                                            <label for="rg">R.G: </label>
                                            <input type="text" class="form-control" name="rg" value="${paciente.rg}" id="rg" maxlength="10">
                                        </div>
                                        <div class="form-group col-md-2">
                                            <label for="dt_emissao">Data de Emiss&atilde;o: </label>
                                            <input type="text" class="form-control" name="dt_emissao" value="${paciente.dt_emissao}" id="dt_emissao" maxlength="10">
                                        </div>
                                        <div class="form-group col-md-2">
                                            <label for="org_emissor">Org&atilde;o Emissor: </label>
                                            <input type="text" class="form-control" name="org_emissor" value="${paciente.org_emissor}" id="org_emissor" maxlength="10">
                                        </div>
                                        <div class="form-group col-md-3">
                                            <label for="nome_pai">Nome do Pai:</label>
                                            <input type="text" class="form-control" name="nome_pai" value="${paciente.nome_pai}" id="nome_pai" maxlength="40">
                                        </div>
                                        <div class="form-group col-md-3">
                                            <label for="nome_mae">Nome da M&atilde;e:</label>
                                            <input type="text" class="form-control" name="nome_mae" value="${paciente.nome_mae}" id="nome_mae" maxlength="40">
                                        </div>
                                        <div class="form-group col-md-3">
                                            <label for="profissao">Profiss&atilde;o:</label>
                                            <input type="text" class="form-control" name="profissao" value="${paciente.profissao}" id="profissao" maxlength="40">
                                        </div>
                                        <div class="form-group col-md-3">
                                            <label for="raca_cor">Ra&ccedil;a/Cor:</label>
                                            <select class="form-control" name="raca_cor" id="raca_cor">
                                                <option value="Branco" value="${paciente.raca_cor}" <c:out value="${Branco}"/>>Branco</option>
                                                <option value="Negro" value="${paciente.raca_cor}" <c:out value="${Negro}"/>>Negro</option>
                                                <option value="Pardo" value="${paciente.raca_cor}" <c:out value="${Pardo}"/>>Pardo</option>
                                                <option value="Amarelo" value="${paciente.raca_cor}" <c:out value="${Amarelo}"/>>Amarelo</option>
                                                <option value="Ignorar" value="${paciente.raca_cor}" <c:out value="${Ignorar}"/>>Ignorar</option>
                                            </select>
                                        </div>
                                        <div class="form-group col-md-2">
                                            <label for="cep">C.E.P</label>
                                            <input type="text" class="form-control" name="cep" value="${paciente.cep}" id="cep" maxlength="8" onkeypress="return SomenteNumero(event)">
                                        </div>
                                        <div class="form-group col-md-3">
                                            <label for="endereco">Endere&ccedil;o</label>
                                            <input type="text" class="form-control" name="endereco" value="${paciente.endereco}" id="endereco" maxlength="40">
                                        </div>
                                        <div class="form-group col-md-1">
                                            <label for="numero_casa">N&ordm;:</label>
                                            <input type="text" class="form-control" name="numero_casa" value="${paciente.numero_casa}" id="numero_casa" maxlength="4" onkeypress="return SomenteNumero(event)">
                                        </div>
                                        <div class="form-group col-md-3">
                                            <label for="bairro">Bairro</label>
                                            <input type="text" class="form-control" name="bairro" value="${paciente.bairro}" id="bairro" maxlength="40">
                                        </div>
                                        <div class="form-group col-md-1">
                                            <label for="uf">UF</label>
                                            <input type="text" class="form-control" name="uf" value="${paciente.uf}" id="uf" maxlength="2">
                                        </div>
                                        <div class="form-group col-md-2">
                                            <label for="cidade">Cidade</label>
                                            <input type="text" class="form-control" name="cidade" value="${paciente.cidade}" id="cidade" maxlength="40">
                                            </label>
                                        </div>
                                    </div>
                                </div>
                                <div>
                                    <button type="button" id="avancar1" class="btn btn-primary">AVAN&Ccedil;AR 1 <i class="glyphicon glyphicon-chevron-right"></i></button>
                                </div>
                            </div>
                            <!-- FIM DADOS DO PACIENTE-->


                            <!-- FICHA CADASTRAL-->
                            <div role="tabpanel" class="tab-pane" id="profile"></br>
                                <div>
                                    <div class="form-group col-md-6">
                                        <label for="diag_clinico">Diagn&oacute;stico Cl&iacute;nico </label>
                                        <input type="text" class="form-control" name="diag_clinico" value="${paciente.diag_clinico}" id="diag_clinico" maxlength="40">
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label for="diag_fiso">Diagn&oacute;stico fisioterap&ecirc;utico </label>
                                        <input type="text" class="form-control" name="diag_fiso" value="${paciente.diag_fiso}" id="diag_fiso" maxlength="40">
                                    </div>
                                    <div class="form-group col-md-4">
                                        <label for="anamnese">ANAMNESE </label>
                                        <input type="text" class="form-control" name="anamnese" value="${paciente.anamnese}" id="anamnese" maxlength="40">
                                    </div>
                                    <div class="form-group col-md-4">
                                        <label for="hma">H.M.A</label>
                                        <input type="text" class="form-control" name="hma" value="${paciente.hma}" id="hma" maxlength="40">
                                    </div>
                                    <div class="form-group col-md-4">
                                        <label for="hmp">H.M.P</label>
                                        <input type="text" class="form-control" name="hmp" value="${paciente.hmp}" id="hmp" maxlength="40">
                                    </div>
                                    <div class="form-group col-md-4">
                                        <label for="ant_hereditario">Antecedentes heredit&aacute;rios</label>
                                        <input type="text" class="form-control" name="ant_hereditario" value="${paciente.ant_hereditario}" id="ant_hereditario" maxlength="40">
                                    </div>
                                    <div class="form-group col-md-4">
                                        <label for="alg_cirurgia">Algum tipo de Cirurgia?</label>
                                        <select class="form-control" name="alg_cirurgia" id="alg_cirurgia">
                                            <option value="1" value="${paciente.alg_cirurgia}" <c:out value="${cirurgia_sim}"/> >Sim</option>
                                            <option value="0" value="${paciente.alg_cirurgia}" <c:out value="${cirurgia_nao}"/> >N&atilde;o</option>
                                        </select>
                                    </div>
                                    <div class="form-group col-md-4">
                                        <label for="qual_cirurgia">Quais?</label>
                                        <input type="text" class="form-control" name="qual_cirurgia" value="${paciente.qual_cirurgia}" id="qual_cirurgia" maxlength="40">
                                    </div>
                                    <!-- HABITOS DE VIDA-->
                                    <br />
                                    <h5 class="page-header"><b><u>HABITOS DE VIDA</u></b></h5>
                                    <div class="form-group col-md-3">
                                        <label for="tabagista">Tabagista?</label>
                                        <select class="form-control" name="tabagista" id="tabagista">
                                            <option value="1" value="${paciente.tabagista}"<c:out value="${cirurgia_sim}"/> >Sim</option>
                                            <option value="0" value="${paciente.tabagista}"<c:out value="${tabagista_nao}"/>>N&atilde;o</option>
                                        </select>
                                    </div>
                                    <div class="form-group col-md-3">
                                        <label for="num_cigarros">N&ordm; cigarros dia?</label>
                                        <input type="text" class="form-control" name="num_cigarros" value="${paciente.num_cigarros}" id="num_cigarros" maxlength="4" onkeypress="return SomenteNumero(event)">
                                    </div>
                                    <div class="form-group col-md-3">
                                        <label for="etilista">Etilista?</label>
                                        <select class="form-control" name="etilista" id="etilista">
                                            <option value="1" value="${paciente.etilista}"<c:out value="${etilista_sim}"/> >Sim</option>
                                            <option value="0" value="${paciente.etilista}"<c:out value="${etilista_nao}"/> >N&atilde;o</option>
                                        </select>
                                    </div>
                                    <div class="form-group col-md-3">
                                        <label for="qtd_etilista">Quantidade?</label>
                                        <input type="text" class="form-control" name="qtd_etilista" value="${paciente.qtd_etilista}" id="qtd_etilista" maxlength="4" onkeypress="return SomenteNumero(event)">
                                    </div>
                                    <div class="form-group col-md-3">
                                        <label for="sedentario">Sedent&aacute;rio?</label>
                                        <select class="form-control" name="sedentario" id="sedentario">
                                            <option value="1" value="${paciente.sedentario}" value="${sedentario.etilista}" <c:out value="${sedentario_sim}"/> >Sim</option>
                                            <option value="0" value="${paciente.sedentario}" value="${sedentario.etilista}" <c:out value="${sedentario_nao}"/> >N&atilde;o</option>
                                        </select>
                                    </div>
                                    <div class="form-group col-md-3">
                                        <label for="freq_sendentario">Frequ&ecirc;ncia:</label>
                                        <input type="text" class="form-control" name="freq_sendentario" value="${paciente.freq_sendentario}" id="freq_sendentario" maxlength="40">
                                    </div>
                                    <div class="form-group col-md-3">
                                        <label for="medicamentos">Medicamentos?</label>
                                        <select class="form-control" name="medicamentos" id="medicamentos">
                                            <option value="1" value="${paciente.medicamentos}" <c:out value="${medicamentos_sim}"/> >Sim</option>
                                            <option value="0" value="${paciente.medicamentos}" <c:out value="${medicamentos_nao}"/> >N&atilde;o</option>
                                        </select>
                                    </div>
                                    <div class="form-group col-md-3">
                                        <label for="quais_medicamentos">Quais:</label>
                                        <input type="text" class="form-control" name="quais_medicamentos" value="${paciente.quais_medicamentos}" id="quais_medicamentos" maxlength="40" >
                                        </BR>
                                    </div>

                                    <!-- ANALISE DO SINTOMA PRINCIPAL-->
                                    <br />
                                    <h5 class="page-header"><b><u>ANALISE DO SINTOMA PRINCIPAL</u></b></h5>
                                    <div class="form-group col-md-3">
                                        <label for="inicio_sintoma">In&iacute;cio</label>
                                        <select class="form-control" name="inicio_sintoma" value="${paciente.inicio_sintoma}" id="inicio_sintoma">
                                            <option value="Gradual" value="${paciente.inicio_sintoma}" <c:out value="${gradual}"/> >Gradual</option>
                                            <option value="Repentino" value="${paciente.inicio_sintoma}" <c:out value="${repentino}"/> >Repentino</option>
                                        </select>
                                    </div>
                                    <div class="form-group col-md-3">
                                        <label for="mecanismo_sintoma">Mecanismo que leva ao sintoma:</label>
                                        <input type="text" class="form-control" name="mecanismo_sintoma" value="${paciente.mecanismo_sintoma}" id="mecanismo_sintoma" maxlength="40" >
                                    </div>
                                    <div class="form-group col-md-3">
                                        <label for="acomp_sintoma">Acompanha outros sintomas?</label>
                                        <select class="form-control" name="acomp_sintoma" id="acomp_sintoma" >
                                            <option value="1" value="${paciente.acomp_sintoma}" <c:out value="${acomp_sintoma_sim}"/>>Sim</option>
                                            <option value="0" value="${paciente.acomp_sintoma}" <c:out value="${acomp_sintoma_nao}"/> >N&atilde;o</option>
                                        </select>
                                    </div>
                                    <div class="form-group col-md-3">
                                        <label for="qual_sintoma">Qual?</label>
                                        <input type="text" class="form-control" name="qual_sintoma" value="${paciente.qual_sintoma}" id="qual_sintoma" maxlength="40">
                                        </br>
                                    </div>


                                    <!-- CLASSIFICAÃÃO DA DOR -->
                                    <br />
                                    <h5 class="page-header"><b><u>CLASSIFICA&Ccedil;&Atilde;O DA DOR</u></b></h5>
                                    <div class="form-group col-md-4">
                                        <label for="localizacao_dor">Localiza&ccedil;&atilde;o:</label>
                                        <input type="text" class="form-control" name="localizacao_dor" value="${paciente.localizacao_dor}" id="localizacao_dor" maxlength="40" >
                                    </div>
                                    <div class="form-group col-md-2">
                                        <label for="carater_dor">C&aacute;rater:</label>
                                        <select class="form-control" name="carater_dor" id="carater_dor">
                                            <option value="Aguda" value="${paciente.carater_dor}" <c:out value="${aguda}"/>>Aguda</option>
                                            <option value="Cronica" value="${paciente.carater_dor}" <c:out value="${cronica}"/>>Cr&ocirc;nica</option>
                                        </select>
                                    </div>
                                    <div class="form-group col-md-2">
                                        <label for="irradiacao_dor">Irradia&ccedil;&atilde;o:</label>
                                        <select class="form-control" name="irradiacao_dor" id="irradiacao_dor">
                                            <option value="1" value="${paciente.irradiacao_dor}" <c:out value="${irradiacao_dor_sim}"/>>Sim</option>
                                            <option value="0" value="${paciente.irradiacao_dor}" <c:out value="${irradiacao_dor_nao}"/>>N&atilde;o</option>
                                        </select>
                                    </div>
                                    <div class="form-group col-md-4">
                                        <label for="local_dor">Local:</label>
                                        <input type="text" class="form-control" name="local_dor" value="${paciente.local_dor}" id="local_dor" maxlength="40" >
                                    </div>

                                    <div class="form-group col-md-2">
                                        <label for="movimento_dor">Ao movimento:</label>
                                        <select class="form-control" name="movimento_dor" id="movimento_dor">
                                            <option value="1" value="${paciente.movimento_dor}" <c:out value="${movimento_dor_sim}"/>>Sim</option>
                                            <option value="0" value="${paciente.movimento_dor}" <c:out value="${movimento_dor_nao}"/>>N&atilde;o</option>
                                        </select>
                                    </div>
                                    <div class="form-group col-md-4">
                                        <label for="qual_dor">Qual?</label>
                                        <input type="text" class="form-control" name="qual_dor" value="${paciente.qual_dor}" id="qual_dor" maxlength="40" >
                                    </div>

                                    <div class="form-group col-md-3">
                                        <label for="repouso_dor">Ao repouso:</label>
                                        <select class="form-control" name="repouso_dor" id="repouso_dor">
                                            <option value="1" value="${paciente.repouso_dor}" <c:out value="${repouso_dor_sim}"/>>Sim</option>
                                            <option value="0" value="${paciente.repouso_dor}" <c:out value="${repouso_dor_nao}"/>>N&atilde;o</option>
                                        </select>
                                    </div>
                                    <div class="form-group col-md-3">
                                        <label for="climatica_dor">Clim&aacute;tica:</label>
                                        <select class="form-control" name="climatica_dor" id="climatica_dor">
                                            <option value="1" value="${paciente.climatica_dor}" <c:out value="${climatica_dor_sim}"/>>Sim</option>
                                            <option value="0" value="${paciente.climatica_dor}" <c:out value="${climatica_dor_nao}"/>>N&atilde;o</option>
                                        </select>
                                    </div>

                                    <div class="form-group col-md-3">
                                        <label for="esforco_dor">Esforço:</label>
                                        <select class="form-control" name="esforco_dor" id="esforco_dor">
                                            <option value="1" value="${paciente.esforco_dor}" <c:out value="${esforco_sim}"/>>Sim</option>
                                            <option value="0" value="${paciente.esforco_dor}" <c:out value="${esforco_dor_nao}"/>>N&atilde;o</option>
                                        </select>
                                    </div>
                                    <div class="form-group col-md-4">
                                        <label for="qual_esforco">Qual?</label>
                                        <input type="text" class="form-control" name="qual_esforco" value="${paciente.qual_esforco}" id="qual_esforco" maxlength="40" >
                                    </div>

                                    <div class="form-group">
                                        <label>Escala da dor EVA:</label>
                                        <div>
                                            <label class="radio-inline">
                                                <input type="radio" name="escala_eva" id="escala_eva1" value="1" value="${paciente.escala_eva}"
                                                       <c:out value="${radio_resultado_1}"/>>1
                                            </label>
                                            <label class="radio-inline">
                                                <input type="radio" name="escala_eva" id="escala_eva2" value="2" value="${paciente.escala_eva}" 
                                                       <c:out value="${radio_resultado_2}"/>>2
                                            </label>
                                            <label class="radio-inline">
                                                <input type="radio" name="escala_eva" id="escala_eva3" value="3" value="${paciente.escala_eva}"
                                                       <c:out value="${radio_resultado_3}"/>>3
                                            </label>
                                            <label class="radio-inline">
                                                <input type="radio" name="escala_eva" id="escala_eva4" value="4" value="${paciente.escala_eva}"
                                                       <c:out value="${radio_resultado_4}"/>>4
                                            </label>
                                            <label class="radio-inline">
                                                <input type="radio" name="escala_eva" id="escala_eva5" value="5" value="${paciente.escala_eva}"
                                                       <c:out value="${radio_resultado_5}"/>>5
                                            </label>
                                            <label class="radio-inline">
                                                <input type="radio" name="escala_eva" id="escala_eva6" value="6" value="${paciente.escala_eva}"
                                                       <c:out value="${radio_resultado_6}"/>>6
                                            </label>
                                            <label class="radio-inline">
                                                <input type="radio" name="escala_eva" id="escala_eva7" value="7" value="${paciente.escala_eva}"
                                                       <c:out value="${radio_resultado_7}"/>>7
                                            </label>
                                            <label class="radio-inline">
                                                <input type="radio" name="escala_eva" id="escala_eva8" value="8" value="${paciente.escala_eva}"
                                                       <c:out value="${radio_resultado_8}"/>>8
                                            </label>
                                            <label class="radio-inline">
                                                <input type="radio" name="escala_eva" id="escala_eva9" value="9" value="${paciente.escala_eva}"
                                                       <c:out value="${radio_resultado_9}"/>>9
                                            </label>
                                            <label class="radio-inline">
                                                <input type="radio" name="escala_eva" id="escala_eva10" value="10" value="${paciente.escala_eva}"
                                                       <c:out value="${radio_resultado_10}"/>>10
                                            </label>
                                        </div>
                                        </br>
                                        </br>
                                    </div>


                                    <!-- EXAME FISICO -->
                                    <h5 class="page-header"><b><u>EXAME F&Iacute;SICO</u></b></h5>
                                    <div class="form-group">
                                        <label>Inspe&ccedil;&atilde;o(atrav&eacute;s da vis&atilde;o):</label>
                                        <label class="checkbox-inline">
                                            <input type="checkbox" name="inspecao_exame" id="Edema" value="Edema" value="${paciente.inspecao_exame}"
                                                   <c:out value="${edema}"/> >Edema
                                        </label>
                                        <label class="checkbox-inline">
                                            <input type="checkbox" name="inspecao_exame" id="Hematoma" value="Hematoma" value="${paciente.inspecao_exame}"
                                                   <c:out value="${hematoma}"/>>Hematoma
                                        </label>
                                        <label class="checkbox-inline">
                                            <input type="checkbox" name="inspecao_exame" id="Hiperemia" value="Hiperemia" value="${paciente.inspecao_exame}"
                                                   <c:out value="${hiperamia}"/>>Hiperemia
                                        </label>
                                        <label class="checkbox-inline">
                                            <input type="checkbox" name="inspecao_exame" id="Atrofia" value="Atrofia" value="${paciente.inspecao_exame}"
                                                   <c:out value="${atrofia}"/>>Atrofia
                                        </label>
                                        <label class="checkbox-inline">
                                            <input type="checkbox" name="inspecao_exame" id="Cicatriz" value="Cicatriz" value="${paciente.inspecao_exame}"
                                                   <c:out value="${cicatriz}"/>>Cicatriz
                                        </label>
                                    </div>


                                    <div class="form-group">
                                        <label><u>Palpa&ccedil;&atilde;o(atrav&eacute;s do tato)</u></label></br>
                                        <label>Tonus:</label>
                                        <label class="checkbox-inline">
                                            <input type="checkbox" name="tonus_exame" id="Normal" value="Normal" value="${paciente.inspecao_exame}"
                                                   <c:out value="${normal}"/>>Normal
                                        </label>
                                        <label class="checkbox-inline">
                                            <input type="checkbox" name="tonus_exame" id="Aumentando" value="Aumentando" value="${paciente.inspecao_exame}"
                                                   <c:out value="${aumentando}"/>>Aumentando
                                        </label>
                                        <label class="checkbox-inline">
                                            <input type="checkbox" name="tonus_exame" id="Diminuindo" value="Diminuindo" value="${paciente.inspecao_exame}"
                                                   <c:out value="${diminuindo}"/>>Diminu&iacute;ndo
                                        </label>
                                        <label class="checkbox-inline">
                                            <input type="checkbox" name="tonus_exame" id="Ausente" value="Ausente" value="${paciente.inspecao_exame}"
                                                   <c:out value="${ausente}"/>>Ausente
                                        </label>
                                    </div>

                                    <div class="form-group">
                                        <label>Caracter&iacute;stica da regi&atilde;o apalpada:</label>
                                        <label class="radio-inline">
                                            <input type="radio" name="carac_exame" id="Temperatura" value="Temperatura" value="${paciente.carac_exame}"
                                                   <c:out value="${temperatura}"/>>Temperatura
                                        </label>
                                        <label class="radio-inline">
                                            <input type="radio" name="carac_exame" id="Deformidade" value="Deformidade" value="${paciente.carac_exame}"
                                                   <c:out value="${deformidade}"/>>Deformidade
                                        </label>
                                        <label class="radio-inline">
                                            <input type="radio" name="carac_exame" id="Aderencia" value="Aderencia" value="${paciente.carac_exame}"
                                                   <c:out value="${aderencia}"/>>Aderencia
                                        </label>
                                        <label class="radio-inline">
                                            <input type="radio" name="carac_exame" id="Dor" value="Dor" value="${paciente.carac_exame}"
                                                   <c:out value="${dor}"/>>Dor
                                        </label>
                                    </div>

                                    <!--ANVAÃAR 2 >> PARA MARCAR HORARIOS-->
                                    <div>
                                        <button type="button" id="voltar1" class="btn btn-primary "><i class="glyphicon glyphicon-chevron-left"></i>VOLTAR</button>
                                        <button type="submit" class="btn btn-info">SALVAR E ATUALIZAR PACIENTE <i class="glyphicon glyphicon-refresh"></i></button>
                                        <button type="submit" class="btn btn-success">2º VIA FICHA DE PRESENÇA <i class="glyphicon glyphicon-floppy-disk"></i></button>
                                    </div>

                                </div>	
                            </div>
                            <!-- FIM FICHA CADASTRAL-->					
                            <!-- COMEÇO DISPONBILIDADE PARA SESSÃES-->
                            <!-- FIM DISPONBILIDADE PARA SESSÃES-->

                        </div>
                    </div>
                </form>
            </div>
        </div>
    </body>
</html>