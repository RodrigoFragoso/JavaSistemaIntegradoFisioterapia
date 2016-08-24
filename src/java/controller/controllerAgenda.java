package controller;

import dao.PacienteDAO;
import dao.validacao;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Paciente;

/**
 *
 * @author rodrigo
 */
@WebServlet(name = "controllerAgenda", urlPatterns = {"/controllerAgenda"})
public class controllerAgenda extends HttpServlet {
    //private static final long serialVersionUID = 1L;
    private static String insert_or_edit = "/sif/agenda.jsp";
    private static String lista_paciente = "/sif/agenda.jsp";
    private PacienteDAO PacienteDAO;

        
    public controllerAgenda(){
        super();
        PacienteDAO = new PacienteDAO();
    }
     
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        validacao.ValidaSessao(request, response);
        String forward = lista_paciente;
        String pesquisa = request.getParameter("pesquisa");
        
        Paciente dadosPaciente = null;
        HttpSession session = request.getSession();  
        dadosPaciente = (Paciente)session.getAttribute("dadosPaciente");
        
        
        String action = request.getParameter("action");
        if(action != null && action.equals("comp")){ 
            String Idpacientes = request.getParameter("idpacientes");
            PacienteDAO.UpdateStatus(Idpacientes,"Compareceu");
        }else if(action != null && action.equals("ncomp")){ 
            String Idpacientes = request.getParameter("idpacientes");
            PacienteDAO.UpdateStatus(Idpacientes,"Não Compareceu");
        }
                
        try {
            ArrayList<Paciente> lista;
            if (pesquisa != null && !pesquisa.equals("")){
            lista = PacienteDAO.listaPaciente();
            
            }else{
            lista = PacienteDAO.listaPaciente();
            }
            
            request.setAttribute("pacientes", lista);    
            } catch (SQLException e ) {
                e.printStackTrace();
            }
        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
  }
    
    @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        validacao.ValidaSessao(request, response);
        Paciente paciente = new Paciente();
        //Integer prazoLavagem = new Integer(request.getParameter("dtPedido"));
        //pedido.setIdCadastroPedido(request.getInt("idCadastroPedido"));
        //pedido.setQtdRoupa(request.getParameter("qtdRoupa"));
        //paciente.setStatusLavagem(request.getParameter("status"));
        
    }
    
}