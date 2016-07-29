package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Paciente;

/**
 *
 * @author Rodrigo
 */
public class PacienteDAO {
    private Connection connection;
    
    public PacienteDAO() {
        ConnectionClass con = new ConnectionClass();
        try {
            connection = con.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public int addPaciente(Paciente paciente) {
        int id = 0;
        try {          
            String query = "INSERT INTO pacientes"
                    +"("
                    + "num_sus, "
                    + "nome, "
                    + "telefone, "
                    + "dt_nasc, "
                    + "idade, "
                    + "sexo, "
                    + "rg, "
                    + "dt_emissao, "
                    + "org_emissor, "
                    + "nome_pai, "
                    + "nome_mae, "
                    + "profissao, "
                    + "raca_cor, "
                    + "cep, "
                    + "endereco, "
                    + "numero_casa, "
                    + "bairro, "
                    + "uf, "
                    + "cidade, "
                    + "diag_clinico, "
                    + "diag_fiso, "
                    + "anamnese, "
                    + "hma, "
                    + "hmp, "
                    + "ant_hereditario, "
                    + "alg_cirurgia, "
                    + "qual_Cirurgia, "
                    + "tabagista, "
                    + "num_cigarros, "
                    + "etilista, "
                    + "qtd_etilista, "
                    + "sedentario, "
                    + "freq_sendentario, "
                    + "medicamentos, "
                    + "quais_medicamentos, "
                    + "inicio_sintoma, "
                    + "mecanismo_sintoma, "
                    + "acomp_sintoma, "
                    + "qual_sintoma, "
                    + "localizacao_dor, "
                    + "carater_dor, "
                    + "irradiacao_dor, "
                    + "local_dor, "
                    + "movimento_dor, "
                    + "qual_dor, "
                    + "repouso_dor, "
                    + "climatica_dor, "
                    + "esforco_dor, "
                    + "qual_esforco, "
                    + "escala_eva, "
                    + "inspecao_exame, "
                    + "tonus_exame, "
                    + "carac_exame, "
                    + "qtd_sessoes, "
                    + "dias_sessoes, "
                    + "hora_sessoes) VALUES "
                    + "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            
            PreparedStatement stmt = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, paciente.getNum_sus()); 
            stmt.setString(2, paciente.getNome()); 
            stmt.setInt(3, paciente.getTelefone()); 
            stmt.setString(4, paciente.getDt_nasc()); 
            stmt.setInt(5, paciente.getIdade()); 
            stmt.setString(6, paciente.getSexo()); 
            stmt.setInt(7, paciente.getRg());
            stmt.setString(11111, paciente.getDt_emissao());
            stmt.setString(8, paciente.getOrg_emissor()); 
            stmt.setString(9, paciente.getNome_pai()); 
            stmt.setString(10, paciente.getNome_mae()); 
            stmt.setString(11, paciente.getProfissao()); 
            stmt.setString(12, paciente.getRaca_cor()); 
            stmt.setInt(13, paciente.getCep());
            stmt.setString(14, paciente.getEndereco());
            stmt.setInt(15, paciente.getNumero_casa());
            stmt.setString(16, paciente.getBairro());
            stmt.setString(17, paciente.getUf());
            stmt.setString(18, paciente.getCidade());
            stmt.setString(19, paciente.getDiag_clinico());
            stmt.setString(20, paciente.getDiag_fiso());
            stmt.setString(21, paciente.getAnamnese());
            stmt.setString(22, paciente.getHma());
            stmt.setString(23, paciente.getHmp());
            stmt.setString(24, paciente.getAnt_hereditario());
            stmt.setInt(25, paciente.getAlg_cirurgia());
            stmt.setString(26, paciente.getQual_cirurgia());
            stmt.setInt(27, paciente.getTabagista());
            stmt.setString(28, paciente.getNum_cigarros());
            stmt.setInt(29, paciente.getEtilista());
            stmt.setString(30, paciente.getQtd_etilista());
            stmt.setInt(31, paciente.getSedentario());
            stmt.setString(32, paciente.getFreq_sendentario());
            stmt.setInt(33, paciente.getMedicamentos());
            stmt.setString(34, paciente.getQuais_medicamentos());
            stmt.setString(35, paciente.getInicio_sintoma());
            stmt.setString(36, paciente.getMecanismo_sintoma());
            stmt.setInt(37, paciente.getAcomp_sintoma());
            stmt.setString(38, paciente.getQual_sintoma());
            stmt.setString(39, paciente.getLocalizacao_dor());
            stmt.setString(40, paciente.getCarater_dor());
            stmt.setString(41, paciente.getIrradiacao_dor());
            stmt.setString(42, paciente.getLocal_dor());
            stmt.setInt(43, paciente.getMovimento_dor());
            stmt.setString(44, paciente.getQual_dor());
            stmt.setInt(45, paciente.getRepouso_dor());
            stmt.setInt(46, paciente.getClimatica_dor());
            stmt.setInt(47, paciente.getEsforco_dor());
            stmt.setString(48, paciente.getQual_esforco());
            stmt.setInt(49, paciente.getEscala_eva());
            stmt.setString(50, paciente.getInspecao_exame());
            stmt.setString(51, paciente.getTonus_exame());
            stmt.setInt(52, paciente.getCarac_exame());
            stmt.setInt(53, paciente.getQtd_sessoes());
            stmt.setString(54, paciente.getDias_sessoes());
            stmt.setString(55, paciente.getHora_sessoes());
            stmt.executeUpdate();
            
            ResultSet keyResultSet = stmt.getGeneratedKeys();
            if (keyResultSet.next()) {
                id = (int) keyResultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }     
        return id;
    }
    
    /*public void updatePaciente(Paciente paciente) {
        String query = "update pacientes set pacientes.nome='" 
                + paciente.getNome() + "',"
                + " '" + paciente.getEmail() + "',"
                + "'" + paciente.getSenha() + "'"
                + ", '" + paciente.getCpf() + "',"
                + ", '" + paciente.getCargo() + "',"
                + "'" + paciente.getTelefone() + 
                "' where cliente.idCliente = " + paciente.getIdFuncionario() + " ";
        
        System.out.println(query);
        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }*/
    
    /*public ArrayList<Funcionario> getPaciente() throws SQLException {
        String query = "select * from pacientes";
        ArrayList<Funcionario> Funcionarios = new ArrayList<Funcionario>();
        Statement stmt = connection.createStatement();
        ResultSet res = stmt.executeQuery(query);
        while (res.next()) {
            Funcionario funcionario = new Funcionario();
            funcionario.setNome(res.getString("nome"));
            funcionario.setEmail(res.getString("email"));
            funcionario.setSenha(res.getString("senha"));
            funcionario.setCpf(res.getString("cpf"));
            funcionario.setCargo(res.getString("cargo"));
            funcionario.setTelefone(res.getString("telefone"));
            funcionario.setIdFuncionario(res.getInt("idFuncionario"));
            Funcionarios.add(funcionario);
        }
        return Funcionarios;
    }*/

    
}
