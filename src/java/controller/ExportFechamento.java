package controller;

import dao.RelatoriosDAO;
import dao.validacao;
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
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.RelatorioFechamento;

/**
 *
 * @author Rodrigo
 */
@WebServlet(name = "ExportFechamento", urlPatterns = {"/ExportFechamento"})
public class ExportFechamento extends HttpServlet {

    private RelatoriosDAO relatoriosDAO;

    public ExportFechamento() {
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
        validacao.ValidaSessao(request, response);
        System.out.println("************** doGet ************");
        response.setContentType("text/csv; charset=Cp1252");
        PrintWriter out = response.getWriter();
        response.setDateHeader("Expires", 0);

        //String status = request.getParameter("status");
        //DATA INICIAL FECHAMENTO
        String dataInicialFec = request.getParameter("dataInicialFec");
        SimpleDateFormat dtinicial = new java.text.SimpleDateFormat("dd/MM/yyyy");
        try {
            Date date;
            date = (Date) dtinicial.parse(dataInicialFec);
            SimpleDateFormat formatDate = new java.text.SimpleDateFormat("yyyy-MM-dd");
            String DisplayDateInicial = formatDate.format(date);
            //System.out.println(DisplayDateInicial);
            dataInicialFec = DisplayDateInicial;
        } catch (ParseException ex) {
            Logger.getLogger(ExportCSV.class.getName()).log(Level.SEVERE, null, ex);
        }

        //DATA FINAL FECHAMENTO
        String dataFinalFec = request.getParameter("dataFinalFec");
        SimpleDateFormat dtfinal = new java.text.SimpleDateFormat("dd/MM/yyyy");
        try {
            Date date;
            date = (Date) dtfinal.parse(dataFinalFec);
            SimpleDateFormat formatDate = new java.text.SimpleDateFormat("yyyy-MM-dd");
            String DisplayDateFinal = formatDate.format(date);
            //System.out.println(DisplayDateFinal);
            dataFinalFec = DisplayDateFinal;
        } catch (ParseException ex) {
            Logger.getLogger(ExportCSV.class.getName()).log(Level.SEVERE, null, ex);
        }

        ArrayList<RelatorioFechamento> ListaRelatorioFechamento = new ArrayList<RelatorioFechamento>();
        try {
            //ArrayList<RelatorioPacientes> ListaRelatorioPacientes = relatoriosDAO.getRelatorioPacientes(idpacientes, status, dataInicial, dataFinal);
            ListaRelatorioFechamento = relatoriosDAO.getRelatorioFechamento(dataInicialFec, dataFinalFec);
        } catch (SQLException ex) {
            Logger.getLogger(ExportCSV.class.getName()).log(Level.SEVERE, null, ex);
        }

        StringBuffer fileNameFormat = new StringBuffer();
        fileNameFormat.append("attachment; filename= RelatorioDeFechamento");
        fileNameFormat.append(".csv");
        response.setHeader("Content-disposition", fileNameFormat.toString());

        StringBuffer totalString = new StringBuffer();
        StringBuffer header = new StringBuffer();
        header.append(";");
        header.append("CÓD. DATASUL: 03020500-19 | 03020600-14 | 03020500-27 - 3 GUIAS - 30 SESSÕES" + "\n");
        header.append("ID_PACIENTE");
        header.append(";");
        header.append("PACIENTES");
        header.append(";");
        header.append("QTD_SESSOES");
        header.append(";");
        StringBuffer body = new StringBuffer();

        //este for chama a model RelatorioFechamento e monta os dados dentro do ListaRelatorioFechamento
        for (RelatorioFechamento r : ListaRelatorioFechamento) {
            body.append(r.getIdpacientes());
            body.append(";");
            body.append(r.getPaciente());
            body.append(";");
            body.append(r.getSessoes());
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
