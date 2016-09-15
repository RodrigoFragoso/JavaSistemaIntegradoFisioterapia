package dao;

import java.sql.SQLException;

public class testador {

    public testador() {
    }

    public static void main(String[] args) throws SQLException {
        LoginCliDao p = new LoginCliDao();
        System.out.println("Conectado com o Banco de dados Mysql!");
    }
}
