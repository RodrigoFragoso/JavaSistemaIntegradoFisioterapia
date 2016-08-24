package controller;
import dao.FuncionarioDAO;
import dao.validacao;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Funcionario;


@WebServlet(name = "funcionarioController", urlPatterns = {"/funcionarioController"})
public class funcionarioController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static String insert_or_edit = "/Funcionario.jsp";
    private static String list_person = "/ListFuncionario.jsp";
    private FuncionarioDAO funcionariodao;
    
    public funcionarioController(){
        super();
        funcionariodao = new FuncionarioDAO();
    }
        
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        validacao.ValidaSessao(request, response);
        String forward = "";
        String action = request.getParameter("action");
        if (action.equalsIgnoreCase("delete")) {

            int idCadastroFunc = Integer.parseInt(request.getParameter("idFuncionario"));

            forward = list_person;
            try {
                request.setAttribute("funcinarios", funcionariodao.getFuncionario());
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        else if (action.equalsIgnoreCase("listFuncionario")) {
            forward = list_person;
            try {
                request.setAttribute("funcionarios", funcionariodao.getFuncionario());
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            forward = insert_or_edit;
        }
        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }
        
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Funcionario funcionario = new Funcionario();
        funcionario.setNome(request.getParameter("nome"));
        funcionario.setEmail(request.getParameter("email"));
        funcionario.setSenha(request.getParameter("senha"));
        funcionario.setCpf(request.getParameter("cpf"));
        funcionario.setCargo(request.getParameter("cargo"));
        funcionario.setTelefone(request.getParameter("telefone"));
        String idFuncionario = request.getParameter("idFuncionario");
        System.out.println("Funcionario Cadastrado !");
        System.out.println(idFuncionario);
        
        if (idFuncionario == null || idFuncionario.isEmpty()) {
            funcionariodao.addFuncionario(funcionario);
        } else {
            funcionario.setIdFuncionario(Integer.parseInt(idFuncionario));
            funcionariodao.updateFuncionario(funcionario);
        }
        response.sendRedirect(request.getContextPath() + "/controllerAgenda");
    }

}