package controller;

import dao.PacienteDAO;
import dao.validacao;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "controllerListaFunc", urlPatterns = {"/controllerListaFunc"})
public class controllerListaFunc extends HttpServlet {
    //private static final long serialVersionUID = 1L;
    private static String insert_or_edit = "/sif/agenda.jsp";
    private static String lista_paciente = "/sif/agenda.jsp";
    private PacienteDAO PacienteDAO;

        
    public controllerListaFunc(){
        super();
        PacienteDAO = new PacienteDAO();
    }
     
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //validacao.ValidaSessao(request, response);
        String forward = lista_paciente;
        String pesquisa = request.getParameter("pesquisa");
        
        //Paciente dadosPaciente = null;
        //HttpSession session = request.getSession();  
        // dadosPaciente = (Paciente)session.getAttribute("dadosPaciente");
        
        String action = request.getParameter("action");
        String jsonObject = "[\"Rodrigo\",\"Alexandre\",\"Andre\",\"Leanderson\",\"Claiton\",\"Eduardo\",\"Patricia\",\"Erika\",\"Mario\",\"Silvanei\"]";
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        out.print(jsonObject);
        out.flush();
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