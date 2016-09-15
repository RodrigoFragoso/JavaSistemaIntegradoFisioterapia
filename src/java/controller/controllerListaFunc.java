package controller;

import dao.FuncionarioDAO;
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
import model.Funcionario;

/**
 *
 * @author rodrigo
 */
@WebServlet(name = "controllerListaFunc", urlPatterns = {"/controllerListaFunc"})
public class controllerListaFunc extends HttpServlet {

    //private static final long serialVersionUID = 1L;
    private static String insert_or_edit = "/sif/listaFuncionario.jsp";
    private static String lista_funcionario = "/sif/listaFuncionario.jsp";
    private FuncionarioDAO FuncionarioDAO;

    public controllerListaFunc() {
        super();
        FuncionarioDAO = new FuncionarioDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        validacao.ValidaSessao(request, response);
        String forward = lista_funcionario;
        String pesquisa = request.getParameter("pesquisa");

        //Funcionario dadosFuncionario = null;
        //HttpSession session = request.getSession();  
        //dadosFuncionario = (Funcionario)session.getAttribute("dadosFuncionario");
        try {
            ArrayList<Funcionario> lista;
            if (pesquisa != null && !pesquisa.equals("")) {
                lista = FuncionarioDAO.listaFuncionario();
            } else {
                lista = FuncionarioDAO.listaFuncionario();
            }
            request.setAttribute("funcionarios", lista);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);

        /*String action = request.getParameter("action");
        String jsonObject = "[\"Rodrigo\",\"Alexandre\",\"Andre\",\"Leanderson\",\"Claiton\",\"Eduardo\",\"Patricia\",\"Erika\",\"Mario\",\"Silvanei\"]";
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        out.print(jsonObject);
        out.flush();*/
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        validacao.ValidaSessao(request, response);
        Funcionario funcionario = new Funcionario();

    }

}
