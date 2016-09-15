package controller;

import dao.RelatoriosDAO;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.RelatorioPacientes;

/**
 *
 * @author Rodrigo
 */
@WebServlet(name = "ExportCSV", urlPatterns = {"/ExportCSV"})
public class ExportCSV extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {

    private RelatoriosDAO relatoriosDAO;

    public ExportCSV() {
        super();
        relatoriosDAO = new RelatoriosDAO();
    }

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        System.out.println("************** doGet ************");
        response.setContentType("text/csv; charset=Cp1252");
        PrintWriter out = response.getWriter();
        response.setDateHeader("Expires", 0);

        //int idpacientes = Integer.parseInt(request.getParameter("idpacientes"));
        //int idpacientes = 1;
        String status = request.getParameter("status");
        if (request.getParameter("status") == "ncompareceu"){
            String status = "Não Compareceu";
        }
        
        //DATA INICIAL
        String dataInicial = request.getParameter("dataInicial");
        SimpleDateFormat dtinicial = new java.text.SimpleDateFormat("dd/MM/yyyy");
        try {
            Date date;
            date = (Date) dtinicial.parse(dataInicial);
            SimpleDateFormat formatDate = new java.text.SimpleDateFormat("yyyy-MM-dd");
            String DisplayDateInicial = formatDate.format(date);
            //System.out.println(DisplayDateInicial);
            dataInicial = DisplayDateInicial;
        } catch (ParseException ex) {
            Logger.getLogger(ExportCSV.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //DATA FINAL
        String dataFinal = request.getParameter("dataFinal");
        SimpleDateFormat dtfinal = new java.text.SimpleDateFormat("dd/MM/yyyy");
        try {
            Date date;
            date = (Date) dtfinal.parse(dataFinal);
            SimpleDateFormat formatDate = new java.text.SimpleDateFormat("yyyy-MM-dd");
            String DisplayDateFinal = formatDate.format(date);
            //System.out.println(DisplayDateFinal);
            dataFinal = DisplayDateFinal;
        } catch (ParseException ex) {
            Logger.getLogger(ExportCSV.class.getName()).log(Level.SEVERE, null, ex);
        }

        ArrayList<RelatorioPacientes> ListaRelatorioPacientes = new ArrayList<RelatorioPacientes>();
        try {
            //ArrayList<RelatorioPacientes> ListaRelatorioPacientes = relatoriosDAO.getRelatorioPacientes(idpacientes, status, dataInicial, dataFinal);
            ListaRelatorioPacientes = relatoriosDAO.getRelatorioPacientes(status, dataInicial, dataFinal);
        } catch (SQLException ex) {
            Logger.getLogger(ExportCSV.class.getName()).log(Level.SEVERE, null, ex);
        }

        StringBuffer fileNameFormat = new StringBuffer();
        fileNameFormat.append("attachment; filename= RelatorioDePacientes");
        fileNameFormat.append(".csv");
        response.setHeader("Content-disposition", fileNameFormat.toString());

        StringBuffer totalString = new StringBuffer();
        StringBuffer header = new StringBuffer();
        header.append("PACIENTES " + "\n");
        header.append("ID_PACIENTE");
        header.append(";");
        header.append("PACIENTE");
        header.append(";");
        header.append("DATA");
        header.append(";");
        header.append("STATUS");
        header.append(";");
        StringBuffer body = new StringBuffer();

        //este for chama a model RelatorioPacientes e monta os dados dentro do ListaRelatorioPacientes
        for (RelatorioPacientes r : ListaRelatorioPacientes) {
            body.append(r.getIdpacientes());
            body.append(";");
            body.append(r.getNome());
            body.append(";");
            body.append(r.getData());
            body.append(";");
            body.append(r.getStatus());
            body.append(";");
            body.append("\n");
        }

        totalString.append(header.toString());
        totalString.append("\n");
        totalString.append(body.toString());
        out.write(totalString.toString());

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// TODO Auto-generated method stub
        System.out.println("************** doPost ************");
        doGet(request, response);
    }
}
