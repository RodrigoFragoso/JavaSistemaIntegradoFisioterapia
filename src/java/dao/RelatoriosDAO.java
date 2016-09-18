package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.RelatorioFechamento;
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
    
    public ArrayList<RelatorioFechamento> getRelatorioFechamento(String dataInicialFec, String dataFinalFec) throws SQLException {
        String query = "select pct.idpacientes as 'ID_PACIENTE', concat_ws('','NUM SUS: ' ,pct.num_sus, '  NOME: ', pct.nome, "
                + "'  Data Nascimento: ', pct.dt_nasc, '  Idade: ', pct.idade, '  Sexo: ', pct.sexo, '  R.G: ',pct.rg, "
                + "'  Data da emissão: ', pct.dt_emissao, '  Orgão Emissor: ', pct.org_emissor, '  Nome do Pai: ', pct.nome_pai, "
                + "'  Nome da mãe: ', pct.nome_mae, '  C.E.P: ', pct.cep, '  Endereço: ', pct.endereco, "
                + "'  Número da Casa: ', pct.numero_casa, '  Bairro: ', pct.bairro, '  Cidade: ', pct.cidade, "
                + "'  UF: ', pct.uf) as 'PACIENTES', count(idpacientes) as 'SESSOES'"
                + " from clinica.pacientes pct "
                + " inner join clinica.pacientesessoes pctss using(idpacientes) "
                + " where pctss.status = 'Compareceu' "
                + " and pctss.data between '"+ dataInicialFec +"' and '"+ dataFinalFec +"' group by pctss.idpacientes"
                + "";
        ArrayList<RelatorioFechamento> relatorioFechamento = new ArrayList<RelatorioFechamento>();
        Statement stmt = connection.createStatement();
        ResultSet res = stmt.executeQuery(query);
        while (res.next()) {
            RelatorioFechamento relatorios = new RelatorioFechamento();
            relatorios.setIdpacientes(res.getInt("ID_PACIENTE"));
            relatorios.setPaciente(res.getString("PACIENTES"));
            relatorios.setSessoes(res.getInt("SESSOES"));
            relatorioFechamento.add(relatorios);
        }
        return relatorioFechamento;
    }
    
}
