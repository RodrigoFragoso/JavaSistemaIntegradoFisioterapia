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
    private static String insert_or_edit = "/listafuncionario.jsp";
    private static String list_person = "/listafuncionario.jsp";
    private FuncionarioDAO funcionariodao;
    
    public funcionarioController(){
        super();
        funcionariodao = new FuncionarioDAO();
    }
        
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        validacao.ValidaSessao(request, response);
        String forward = "/controllerListaFunc";
        
        String action = request.getParameter("action");
        if(action != null && action.equals("delete")){ 
            String Idfuncionario = request.getParameter("idfuncionario");
            funcionariodao.removeFuncionario(Idfuncionario);
        }
        else if (action != null && action.equals("atualiza")) {
            String Idfuncionario = request.getParameter("idfuncionario");
            //funcionariodao.updateFuncionario(Idfuncionario);
            //forward = list_person;
            /*try {
                request.setAttribute("funcionarios", funcionariodao.getFuncionario());
            } catch (SQLException e) {
                e.printStackTrace();
            }*/
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
        String Idfuncionario = request.getParameter("idFuncionario");
        System.out.println("Funcionario Cadastrado !");
        System.out.println(Idfuncionario);
        
        if (Idfuncionario == null || Idfuncionario.isEmpty()) {
            funcionariodao.addFuncionario(funcionario);
        } else {
            funcionario.setIdfuncionario(Integer.parseInt(Idfuncionario));
            funcionariodao.updateFuncionario(funcionario);
        }
        response.sendRedirect(request.getContextPath() + "/controllerAgenda");
    }

}