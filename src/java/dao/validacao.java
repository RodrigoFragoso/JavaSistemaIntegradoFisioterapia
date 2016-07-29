package dao;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Funcionario;

/**
 *
 * @author rodrigo
 */
public class validacao {
    public static void ValidaSessao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        HttpSession session = request.getSession();
        Funcionario funcionario = (Funcionario)session.getAttribute("dadosFuncionario");
            if(funcionario == null){
                RequestDispatcher view = request.getRequestDispatcher("/LoginCli");
                view.forward(request, response);
            }
    }
    //validacao.ValidaSessao(request, response);
        
    /*public static void ValidaSessaoEmp(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        HttpSession session = request.getSession();
        Funcionario funcionario = (Funcionario)session.getAttribute("dadosFuncionarioooo");
            if(funcionario == null){
                RequestDispatcher view = request.getRequestDispatcher("/LoginEmpresa");
                view.forward(request, response);
            }
    }*/
    //validacao.ValidaSessaoEmp(request, response);   
}