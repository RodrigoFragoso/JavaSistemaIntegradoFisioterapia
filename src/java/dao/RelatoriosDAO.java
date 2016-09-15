package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.RelatorioPacientes;

/**
 *
 * @author Rodrigo
 */
public class RelatoriosDAO {
    private Connection connection;

    public RelatoriosDAO() {
        ConnectionClass con = new ConnectionClass();
        try {
            connection = con.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public ArrayList<RelatorioPacientes> getRelatorioPacientes(String status, String dataInicial, String dataFinal) throws SQLException {
        String query = "select pctss.idpacientes as 'ID_PACIENTE', pct.nome as 'PACIENTE', pctss.data as 'DATA', pctss.status as 'STATUS' "
                + "from clinica.pacientes pct "
                + "inner join clinica.pacientesessoes pctss using(idpacientes) "
                + "where  "
                + "pctss.status='"+ status +"' "
                + "and pctss.data between '"+ dataInicial +"' and '"+ dataFinal +"' ";
        ArrayList<RelatorioPacientes> relatorioPacientes = new ArrayList<RelatorioPacientes>();
        Statement stmt = connection.createStatement();
        ResultSet res = stmt.executeQuery(query);
        while (res.next()) {
            RelatorioPacientes relatorios = new RelatorioPacientes();
            relatorios.setIdpacientes(res.getInt("ID_PACIENTE"));
            relatorios.setNome(res.getString("PACIENTE"));
            relatorios.setData(res.getString("DATA"));
            relatorios.setStatus(res.getString("STATUS"));
            relatorioPacientes.add(relatorios);
        }
        return relatorioPacientes;
    }
    
    public ArrayList<RelatorioPacientes> getRelatorioPacientesCount(String status, String dataInicial, String dataFinal) throws SQLException {
        String query = "select count(*) as 'PacientesAtendidos' "
                + "from clinica.pacientes pct "
                + "inner join clinica.pacientesessoes pctss using(idpacientes) "
                + "where  pctss.status='Compareceu' "
                + "and pctss.data between '"+ dataInicial +"' and '"+ dataFinal +"' ";
        ArrayList<RelatorioPacientes> relatorioPacientes = new ArrayList<RelatorioPacientes>();
        Statement stmt = connection.createStatement();
        ResultSet res = stmt.executeQuery(query);
        while (res.next()) {
            RelatorioPacientes relatorios = new RelatorioPacientes();
            relatorios.setIdpacientes(res.getInt("count"));
            relatorioPacientes.add(relatorios);
        }
        return relatorioPacientes;
    }
    
}
