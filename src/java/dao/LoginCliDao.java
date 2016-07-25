package dao;

import java.sql.Connection;  
import java.sql.PreparedStatement;  
import java.sql.ResultSet;  
import java.sql.SQLException; 
import model.Funcionario;

public class LoginCliDao {
    
        public static Funcionario getDados(String email){
            Funcionario dados = new Funcionario();
                            
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		ConnectionClass conexao = new ConnectionClass();
		try {
			conn = conexao.getConnection();

			pst = conn.prepareStatement("select * from funcionario where email=?");
			pst.setString(1, email);

			rs = pst.executeQuery();
                        
                        if(rs.next()){
                            dados.setNome(rs.getString("nome"));
                            dados.setIdFuncionario(rs.getInt("idFuncionario"));
                        }

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
            return dados;
        }
    
    	public static boolean validate(String name, String pass) {		
		boolean status = false;
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		ConnectionClass conexao = new ConnectionClass();
		try {
			conn = conexao.getConnection();
                        
			pst = conn.prepareStatement("select * from funcionario where email=? and senha=md5(?)");
			pst.setString(1, name);
			pst.setString(2, pass);

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
        
        public static boolean validateCpf(String cpf) {		
		boolean status = false;
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		ConnectionClass conexao = new ConnectionClass();
		try {
			conn = conexao.getConnection();

			pst = conn
					.prepareStatement("select * from funcionario where cpf=?");
			pst.setString(1, cpf);

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