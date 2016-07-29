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
                    + "hora_sessoes) values "
                    + "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            
            PreparedStatement stmt = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, paciente.getNum_sus()); 
            stmt.setString(2, paciente.getNome()); 
            stmt.setInt(3, paciente.getTelefone()); 
            stmt.setString(4, paciente.getDt_nasc()); 
            stmt.setInt(5, paciente.getIdade()); 
            stmt.setString(6, paciente.getSexo()); 
            stmt.setInt(7, paciente.getRg());
            stmt.setString(8, paciente.getDt_emissao());
            stmt.setString(9, paciente.getOrg_emissor()); 
            stmt.setString(10, paciente.getNome_pai()); 
            stmt.setString(11, paciente.getNome_mae()); 
            stmt.setString(12, paciente.getProfissao()); 
            stmt.setString(13, paciente.getRaca_cor()); 
            stmt.setInt(14, paciente.getCep());
            stmt.setString(15, paciente.getEndereco());
            stmt.setInt(16, paciente.getNumero_casa());
            stmt.setString(17, paciente.getBairro());
            stmt.setString(18, paciente.getUf());
            stmt.setString(19, paciente.getCidade());
            stmt.setString(20, paciente.getDiag_clinico());
            stmt.setString(21, paciente.getDiag_fiso());
            stmt.setString(22, paciente.getAnamnese());
            stmt.setString(23, paciente.getHma());
            stmt.setString(24, paciente.getHmp());
            stmt.setString(25, paciente.getAnt_hereditario());
            stmt.setInt(26, paciente.getAlg_cirurgia());
            stmt.setString(27, paciente.getQual_cirurgia());
            stmt.setInt(28, paciente.getTabagista());
            stmt.setString(29, paciente.getNum_cigarros());
            stmt.setInt(30, paciente.getEtilista());
            stmt.setString(31, paciente.getQtd_etilista());
            stmt.setInt(32, paciente.getSedentario());
            stmt.setString(33, paciente.getFreq_sendentario());
            stmt.setInt(34, paciente.getMedicamentos());
            stmt.setString(35, paciente.getQuais_medicamentos());
            stmt.setString(36, paciente.getInicio_sintoma());
            stmt.setString(37, paciente.getMecanismo_sintoma());
            stmt.setInt(38, paciente.getAcomp_sintoma());
            stmt.setString(39, paciente.getQual_sintoma());
            stmt.setString(40, paciente.getLocalizacao_dor());
            stmt.setString(41, paciente.getCarater_dor());
            stmt.setString(42, paciente.getIrradiacao_dor());
            stmt.setString(43, paciente.getLocal_dor());
            stmt.setInt(44, paciente.getMovimento_dor());
            stmt.setString(45, paciente.getQual_dor());
            stmt.setInt(46, paciente.getRepouso_dor());
            stmt.setInt(47, paciente.getClimatica_dor());
            stmt.setInt(48, paciente.getEsforco_dor());
            stmt.setString(49, paciente.getQual_esforco());
            stmt.setInt(50, paciente.getEscala_eva());
            stmt.setString(51, paciente.getInspecao_exame());
            stmt.setString(52, paciente.getTonus_exame());
            stmt.setString(53, paciente.getCarac_exame());
            stmt.setInt(54, paciente.getQtd_sessoes());
            stmt.setString(55, paciente.getDias_sessoes());
            stmt.setString(56, paciente.getHora_sessoes());
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
    
    public void updatePaciente(Paciente paciente) {
        String query = "update pacientes set "
                    + " '" + paciente.getNum_sus() + "',"
                    + " '" + paciente.getNome() + "',"
                    + " '" + paciente.getTelefone() + "'," 
                    + " '" + paciente.getDt_nasc() + "',"
                    + " '" + paciente.getIdade() + "',"
                    + " '" + paciente.getSexo() + "',"
                    + " '" + paciente.getRg() + "',"
                    + " '" + paciente.getDt_emissao() + "',"
                    + " '" + paciente.getOrg_emissor() + "',"
                    + " '" + paciente.getNome_pai() + "',"
                    + " '" + paciente.getNome_mae() + "',"
                    + " '" + paciente.getProfissao() + "',"
                    + " '" + paciente.getRaca_cor() + "',"
                    + " '" + paciente.getCep() + "',"
                    + " '" + paciente.getEndereco() + "',"
                    + " '" + paciente.getNumero_casa() + "',"
                    + " '" + paciente.getBairro() + "',"
                    + " '" + paciente.getUf() + "',"
                    + " '" + paciente.getCidade() + "',"
                    + " '" + paciente.getDiag_clinico() + "',"
                    + " '" + paciente.getDiag_fiso() + "',"
                    + " '" + paciente.getAnamnese() + "',"
                    + " '" + paciente.getHma() + "',"
                    + " '" + paciente.getHmp() + "',"
                    + " '" + paciente.getAnt_hereditario() + "',"
                    + " '" + paciente.getAlg_cirurgia() + "',"
                    + " '" + paciente.getQual_cirurgia() + "',"
                    + " '" + paciente.getTabagista() + "',"
                    + " '" + paciente.getNum_cigarros() + "',"
                    + " '" + paciente.getEtilista() + "',"
                    + " '" + paciente.getQtd_etilista() + "',"
                    + " '" + paciente.getSedentario() + "',"
                    + " '" + paciente.getFreq_sendentario() + "',"
                    + " '" + paciente.getMedicamentos() + "',"
                    + " '" + paciente.getQuais_medicamentos() + "',"
                    + " '" + paciente.getInicio_sintoma() + "',"
                    + " '" + paciente.getMecanismo_sintoma() + "',"
                    + " '" + paciente.getAcomp_sintoma() + "',"
                    + " '" + paciente.getQual_sintoma() + "',"
                    + " '" + paciente.getLocalizacao_dor() + "',"
                    + " '" + paciente.getCarater_dor() + "',"
                    + " '" + paciente.getIrradiacao_dor() + "',"
                    + " '" + paciente.getLocal_dor() + "',"
                    + " '" + paciente.getMovimento_dor() + "',"
                    + " '" + paciente.getQual_dor() + "',"
                    + " '" + paciente.getRepouso_dor() + "',"
                    + " '" + paciente.getClimatica_dor() + "',"
                    + " '" + paciente.getEsforco_dor() + "',"
                    + " '" + paciente.getQual_esforco() + "',"
                    + " '" + paciente.getEscala_eva() + "',"
                    + " '" + paciente.getInspecao_exame() + "',"
                    + " '" + paciente.getTonus_exame() + "',"
                    + " '" + paciente.getCarac_exame() + "',"
                    + " '" + paciente.getQtd_sessoes() + "',"
                    + " '" + paciente.getDias_sessoes() + "',"
                    + " '" + paciente.getHora_sessoes() +
                    "' where idpacientes = " + paciente.getIdpacientes() +" ";
        
        System.out.println(query);
        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public ArrayList<Paciente> getPaciente() throws SQLException {
        String query = "select * from pacientes";
        ArrayList<Paciente> Paciente = new ArrayList<Paciente>();
        Statement stmt = connection.createStatement();
        ResultSet res = stmt.executeQuery(query);
        while (res.next()) {
            Paciente paciente = new Paciente();
                paciente.setNum_sus(res.getInt("num_sus"));
                paciente.setNome(res.getString("nome"));
                paciente.setTelefone(res.getInt("telefone")); 
                paciente.setDt_nasc(res.getString("dt_nasc"));
                paciente.setIdade(res.getInt("idade"));
                paciente.setSexo(res.getString("sexo"));
                paciente.setRg(res.getInt("rg"));
                paciente.setDt_emissao(res.getString("dt_emissao"));
                paciente.setOrg_emissor(res.getString("org_emissor"));
                paciente.setNome_pai(res.getString("nome_pai"));
                paciente.setNome_mae(res.getString("nome_mae"));
                paciente.setProfissao(res.getString("profissao"));
                paciente.setRaca_cor(res.getString("raca_cor"));
                paciente.setCep(res.getInt("cep"));
                paciente.setEndereco(res.getString("endereco"));
                paciente.setNumero_casa(res.getInt("numero_casa"));
                paciente.setBairro(res.getString("bairro"));
                paciente.setUf(res.getString("uf"));
                paciente.setCidade(res.getString("cidade"));
                paciente.setDiag_clinico(res.getString("diag_clinico"));
                paciente.setDiag_fiso(res.getString("diag_fiso"));
                paciente.setAnamnese(res.getString("anamnese"));
                paciente.setHma(res.getString("hma"));
                paciente.setHmp(res.getString("hmp"));
                paciente.setAnt_hereditario(res.getString("ant_hereditario"));
                paciente.setAlg_cirurgia(res.getInt("alg_cirurgia"));
                paciente.setQual_cirurgia(res.getString("qual_cirurgia"));
                paciente.setTabagista(res.getInt("tabagista"));
                paciente.setNum_cigarros(res.getString("num_cigarros"));
                paciente.setEtilista(res.getInt("etilista"));
                paciente.setQtd_etilista(res.getString("qtd_etilista"));
                paciente.setSedentario(res.getInt("sedentario"));
                paciente.setFreq_sendentario(res.getString("freq_sendentario"));
                paciente.setMedicamentos(res.getInt("medicamentos"));
                paciente.setQuais_medicamentos(res.getString("quais_medicamentos"));
                paciente.setInicio_sintoma(res.getString("inicio_sintoma"));
                paciente.setMecanismo_sintoma(res.getString("mecanismo_sintoma"));
                paciente.setAcomp_sintoma(res.getInt("acomp_sintoma"));
                paciente.setQual_sintoma(res.getString("qual_sintoma"));
                paciente.setLocalizacao_dor(res.getString("localizacao_dor"));
                paciente.setCarater_dor(res.getString("carater_dor"));
                paciente.setIrradiacao_dor(res.getString("irradiacao_dor"));
                paciente.setLocal_dor(res.getString("local_dor"));
                paciente.setMovimento_dor(res.getInt("movimento_dor"));
                paciente.setQual_dor(res.getString("qual_dor"));
                paciente.setRepouso_dor(res.getInt("repouso_dor"));
                paciente.setClimatica_dor(res.getInt("climatica_dor"));
                paciente.setEsforco_dor(res.getInt("esforco_dor"));
                paciente.setQual_esforco(res.getString("qual_esforco"));
                paciente.setEscala_eva(res.getInt("escala_eva"));
                paciente.setInspecao_exame(res.getString("inspecao_exame"));
                paciente.setTonus_exame(res.getString("tonus_exame"));
                paciente.setCarac_exame(res.getString("carac_exame"));
                paciente.setQtd_sessoes(res.getInt("qtd_sessoes"));
                paciente.setDias_sessoes(res.getString("dias_sessoes"));
                paciente.setHora_sessoes(res.getString("hora_sessoes"));
            Paciente.add(paciente);
        }
        return Paciente;
    }

    
}
