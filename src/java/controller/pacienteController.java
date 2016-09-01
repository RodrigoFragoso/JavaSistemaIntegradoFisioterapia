package controller;
import dao.PacienteDAO;
import dao.validacao;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Arrays;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Paciente;

@WebServlet(name = "pacienteController", urlPatterns = {"/pacienteController"})
public class pacienteController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static String insert_or_edit = "/Paciente.jsp";
    private static String list_person = "/sif/listaPaciente.jsp";
    private PacienteDAO pacientedao;
    
    public pacienteController(){
        super();
        pacientedao = new PacienteDAO();
    }
        
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        validacao.ValidaSessao(request, response);
        String forward = "";
        String action = request.getParameter("action");
        
        int idPacientes = Integer.parseInt(request.getParameter("idpacientes"));
        if (action.equalsIgnoreCase("delete")) {

        forward = list_person;
            try {
                request.setAttribute("paciente", pacientedao.getPaciente(idPacientes));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        else if (action.equalsIgnoreCase("paciente")) {
            forward = list_person;
            try {
                Paciente paciente = pacientedao.getPaciente(idPacientes);
                request.setAttribute("paciente", paciente);
                
                //contains = verifica se o valor esta dentro do getInspecao, é uma operação de comparação
                /*VIEW RADIO BUTTON ESCALA EVA -- VERIFICAR SE ESTA CHECADO*/
                request.setAttribute("radio_resultado_1", (paciente.getEscala_eva() == 1) ? "checked" : "");
                request.setAttribute("radio_resultado_2", (paciente.getEscala_eva() == 2) ? "checked" : "");
                request.setAttribute("radio_resultado_3", (paciente.getEscala_eva() == 3) ? "checked" : "");
                request.setAttribute("radio_resultado_4", (paciente.getEscala_eva() == 4) ? "checked" : "");
                request.setAttribute("radio_resultado_5", (paciente.getEscala_eva() == 5) ? "checked" : "");
                request.setAttribute("radio_resultado_6", (paciente.getEscala_eva() == 6) ? "checked" : "");
                request.setAttribute("radio_resultado_7", (paciente.getEscala_eva() == 7) ? "checked" : "");
                request.setAttribute("radio_resultado_8", (paciente.getEscala_eva() == 8) ? "checked" : "");
                request.setAttribute("radio_resultado_9", (paciente.getEscala_eva() == 9) ? "checked" : "");
                request.setAttribute("radio_resultado_10", (paciente.getEscala_eva() == 10) ? "checked" : "");
                
                /*VIEW CHECKBOX - INSPECAO*/
                request.setAttribute("edema", (Arrays.asList(paciente.getInspecao()).contains("Edema")) ? "checked" : "");
                request.setAttribute("hematoma",(Arrays.asList(paciente.getInspecao()).contains("Hematoma")) ? "checked" : "");
                request.setAttribute("hiperemia",(Arrays.asList(paciente.getInspecao()).contains("Hiperemia")) ? "checked" : "");
                request.setAttribute("atrofia",(Arrays.asList(paciente.getInspecao()).contains("Atrofia")) ? "checked" : "");
                request.setAttribute("cicatriz",(Arrays.asList(paciente.getInspecao()).contains("Cicatriz")) ? "checked" : "");
                
                /*VIEW CHECKBOX DO TONUS*/
                request.setAttribute("normal",(Arrays.asList(paciente.getTonus()).contains("Normal")) ? "checked" : "");
                request.setAttribute("aumentando",(Arrays.asList(paciente.getTonus()).contains("Aumentando")) ? "checked" : "");
                request.setAttribute("diminuindo",(Arrays.asList(paciente.getTonus()).contains("Diminuindo")) ? "checked" : "");
                request.setAttribute("ausente",(Arrays.asList(paciente.getTonus()).contains("Ausente")) ? "checked" : "");
                
                /*VIEW RADIO BUTTON CARAC_EXAME*/
                request.setAttribute("temperatura", ("Temperatura".equals(paciente.getCarac_exame())) ? "checked" : "");
                request.setAttribute("deformidade", ("Deformidade".equals(paciente.getCarac_exame())) ? "checked" : "");
                request.setAttribute("aderencia", ("Aderencia".equals(paciente.getCarac_exame())) ? "checked" : "");
                request.setAttribute("dor", ("Dor".equals(paciente.getCarac_exame())) ? "checked" : "");
                
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }        
        else {
            forward = insert_or_edit;
        }
        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }
        
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Paciente paciente = new Paciente();
            paciente.setNum_sus(Integer.parseInt(request.getParameter("num_sus")));
            paciente.setNome(request.getParameter("nome"));
            paciente.setTelefone(request.getParameter("telefone")); 
            paciente.setDt_nasc(request.getParameter("dt_nasc"));
            paciente.setIdade(Integer.parseInt(request.getParameter("idade")));
            paciente.setSexo(request.getParameter("sexo"));
            paciente.setRg(Integer.parseInt(request.getParameter("rg")));
            paciente.setDt_emissao(request.getParameter("dt_emissao"));
            paciente.setOrg_emissor(request.getParameter("org_emissor"));
            paciente.setNome_pai(request.getParameter("nome_pai"));
            paciente.setNome_mae(request.getParameter("nome_mae"));
            paciente.setProfissao(request.getParameter("profissao"));
            paciente.setRaca_cor(request.getParameter("raca_cor"));
            paciente.setCep(request.getParameter("cep"));
            paciente.setEndereco(request.getParameter("endereco"));
            paciente.setNumero_casa(Integer.parseInt(request.getParameter("numero_casa")));
            paciente.setBairro(request.getParameter("bairro"));
            paciente.setUf(request.getParameter("uf"));
            paciente.setCidade(request.getParameter("cidade"));
            paciente.setDiag_clinico(request.getParameter("diag_clinico"));
            paciente.setDiag_fiso(request.getParameter("diag_fiso"));
            paciente.setAnamnese(request.getParameter("anamnese"));
            paciente.setHma(request.getParameter("hma"));
            paciente.setHmp(request.getParameter("hmp"));
            paciente.setAnt_hereditario(request.getParameter("ant_hereditario"));
            paciente.setAlg_cirurgia(Integer.parseInt(request.getParameter("alg_cirurgia")));
            paciente.setQual_cirurgia(request.getParameter("qual_cirurgia"));
            paciente.setTabagista(Integer.parseInt(request.getParameter("tabagista")));
            paciente.setNum_cigarros(request.getParameter("num_cigarros"));
            paciente.setEtilista(Integer.parseInt(request.getParameter("etilista")));
            paciente.setQtd_etilista(request.getParameter("qtd_etilista"));
            paciente.setSedentario(Integer.parseInt(request.getParameter("sedentario")));
            paciente.setFreq_sendentario(request.getParameter("freq_sendentario"));
            paciente.setMedicamentos(Integer.parseInt(request.getParameter("medicamentos")));
            paciente.setQuais_medicamentos(request.getParameter("quais_medicamentos"));
            paciente.setInicio_sintoma(request.getParameter("inicio_sintoma"));
            paciente.setMecanismo_sintoma(request.getParameter("mecanismo_sintoma"));
            paciente.setAcomp_sintoma(Integer.parseInt(request.getParameter("acomp_sintoma")));
            paciente.setQual_sintoma(request.getParameter("qual_sintoma"));
            paciente.setLocalizacao_dor(request.getParameter("localizacao_dor"));
            paciente.setCarater_dor(request.getParameter("carater_dor"));
            paciente.setIrradiacao_dor(request.getParameter("irradiacao_dor"));
            paciente.setLocal_dor(request.getParameter("local_dor"));
            paciente.setMovimento_dor(Integer.parseInt(request.getParameter("movimento_dor")));
            paciente.setQual_dor(request.getParameter("qual_dor"));
            paciente.setRepouso_dor(Integer.parseInt(request.getParameter("repouso_dor")));
            paciente.setClimatica_dor(Integer.parseInt(request.getParameter("climatica_dor")));
            paciente.setEsforco_dor(Integer.parseInt(request.getParameter("esforco_dor")));
            paciente.setQual_esforco(request.getParameter("qual_esforco"));
            paciente.setEscala_eva(Integer.parseInt(request.getParameter("escala_eva")));

            String[] inspecao_exame = request.getParameterValues("inspecao_exame");
            StringBuilder inspecao = new StringBuilder();
            for(String s : inspecao_exame){
                inspecao.append(s).append(";");
            }
            paciente.setInspecao_exame(inspecao.toString());

            String[] tonus_exame = request.getParameterValues("tonus_exame");
            StringBuilder tonus = new StringBuilder();
            for(String s : tonus_exame){
                tonus.append(s).append(";");
            }
            paciente.setTonus_exame(tonus.toString());

            paciente.setCarac_exame(request.getParameter("carac_exame"));

            /*SESSÕES*/
            paciente.setQtd_sessoes(Integer.parseInt(request.getParameter("qtd_sessoes")));
            if(request.getParameter("segunda")==null){
                paciente.setSegunda("0");
            }else{
                paciente.setSegunda(request.getParameter("segunda"));
            }
            if(request.getParameter("quarta")==null){
                paciente.setQuarta("0");
            }else{
                paciente.setQuarta(request.getParameter("quarta"));
            }
            if(request.getParameter("sexta")==null){
                paciente.setSexta("0");
            }else{
                paciente.setSexta(request.getParameter("sexta"));
            }
            paciente.setHora_sessoes(request.getParameter("hora_sessoes"));
            String idpacientes = request.getParameter("idpacientes");
        System.out.println("Paciente Cadastrado !");
        System.out.println(idpacientes);
        if (idpacientes == null || idpacientes.isEmpty()) {
            pacientedao.addPaciente(paciente);
        } else {
            paciente.setIdpacientes(Integer.parseInt(idpacientes));
            pacientedao.updatePaciente(paciente);
        }
        response.sendRedirect(request.getContextPath() + "/controllerAgenda");
        //response.sendRedirect(request.getContextPath() + "/LoginCli");
    }                
}