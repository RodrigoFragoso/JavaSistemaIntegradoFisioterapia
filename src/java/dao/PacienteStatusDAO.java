/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.PacienteStatus;

/**
 *
 * @author Rodrigo
 */
public class PacienteStatusDAO {
    private Connection connection;
    
    public PacienteStatusDAO() {
        ConnectionClass con = new ConnectionClass();
        try {
            connection = con.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    //esse select tras apenas o resultado e não monta o array
    public PacienteStatus listaPacienteStatus() throws SQLException{
        //este select seleciona a qtd de pacientes atendidos, a codição CASE verifica se status for Compareceu soma 1 caso não é 0 ate o final do resultado
        String query = "SELECT SUM(CASE status WHEN 'Compareceu' THEN 1 ELSE 0 END) AS 'compareceu', SUM(CASE status WHEN 'Não Compareceu' THEN 1 ELSE 0 END) AS 'ncompareceu' FROM pacientes where data = curdate()";
        
        PacienteStatus pacientestatus = new PacienteStatus();
        Statement stmt = connection.createStatement();
        ResultSet res = stmt.executeQuery(query);
        if (res.next()) {
            pacientestatus.setCompareceu(res.getInt("compareceu"));
            pacientestatus.setNcompareceu(res.getInt("ncompareceu"));
        }
        return pacientestatus;
    }
    
}
