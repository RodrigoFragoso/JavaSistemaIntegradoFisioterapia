package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Funcionario;

/**
 *
 * @author rodrigo
 */
public class FuncionarioDAO {
    private Connection connection;
    
    public FuncionarioDAO() {
        ConnectionClass con = new ConnectionClass();
        try {
            connection = con.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
  
    public int addFuncionario(Funcionario funcionario) {
        int id = 0;
        try {
            String query = "insert into funcionario"
                    + "("
                    + "nome, "
                    + "email, "
                    + "senha, "
                    + "cpf, "
                    + "cargo, "
                    + "telefone) values "
                    + "(?,?,md5(?),?,?,?)";

            PreparedStatement stmt = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            stmt.setString(1, funcionario.getNome()); 
            stmt.setString(2, funcionario.getEmail());
            stmt.setString(3, funcionario.getSenha());
            stmt.setString(4, funcionario.getCpf());
            stmt.setString(5, funcionario.getCargo());
            stmt.setString(6, funcionario.getTelefone());
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
        
    public void updateFuncionario(Funcionario funcionario) {
        String query = "update funcionario set funcionario.nome='" + funcionario.getNome() + "',"
                + " '" + funcionario.getEmail() + "',"
                + "'" + funcionario.getSenha() + "'"
                + ", '" + funcionario.getCpf() + "',"
                + ", '" + funcionario.getCargo() + "',"
                + "'" + funcionario.getTelefone() + 
                "' where cliente.idCliente = " + funcionario.getIdFuncionario() + " ";
        
        System.out.println(query);
        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public ArrayList<Funcionario> getFuncionario() throws SQLException {
        String query = "select * from funcionario";
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
    }
    
    public static boolean validateEmail(String email) {		
		boolean status = false;
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		ConnectionClass conexao = new ConnectionClass();
		try {
			conn = conexao.getConnection();

			pst = conn.prepareStatement("select * from funcionario where email=?");
			pst.setString(1, email);

			rs = pst.executeQuery();
                        
			status = rs.next();

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pst != null) {
				try {
					pst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return status;
	}
}