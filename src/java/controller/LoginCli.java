package controller;

import dao.LoginCliDao;
import dao.validacao;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "LoginCli", urlPatterns = {"/LoginCli"})
public class LoginCli extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //response.setContentType("text/html;charset=UTF-8");
        RequestDispatcher view = request.getRequestDispatcher("sif/loginCli.jsp");
        view.forward(request, response);

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");    
        PrintWriter out = response.getWriter();    
          
        String n=request.getParameter("username");    
        String p=request.getParameter("userpass");       
        
        if(LoginCliDao.validate(n, p)){    
            
            Funcionario dados = LoginCliDao.getDados(n);
            
            HttpSession session = request.getSession();
            if(session!=null)  
            session.setAttribute("dadosFuncionario", dados);
            
            response.sendRedirect("controllerAgenda");//Redireciona para a pagina View agenda.jsp
        }
        else{    
            out.print("<p align=\"center\" style=\"color:red\">DESCULPE LOGIN OU SENHA INCORRETOS !!!</p>");
            RequestDispatcher rd=request.getRequestDispatcher("/sif/loginCli.jsp");    
            rd.forward(request,response);    
        }    
  
        out.close();
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}