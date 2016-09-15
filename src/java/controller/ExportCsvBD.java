package controller;

import dao.ConnectionClass;
import java.sql.Connection;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class ExportCsvBD extends HttpServlet {

    /*private Connection connection;
    public ExportCsvBD() {
        ConnectionClass con = new ConnectionClass();
        try {
            connection = con.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }*/

    public void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        String filename = "c:\\csv\\myjdbcfile.csv";
        Connection conn = null;
        String url = "jdbc:mysql://localhost:3306/";
        String dbName = "clinica";
        String driver = "com.mysql.jdbc.Driver";
        String userName = "root"; 
        String password = "lkm-98cd";
        Statement stmt;
        try {
            PrintWriter out = response.getWriter();
            FileWriter fw = new FileWriter(filename);
            fw.append("num_sus");
            fw.append(';');
            fw.append("nome");
            fw.append(';');
            fw.append("telefone");
            fw.append('\n');

            Class.forName(driver).newInstance();
            conn = DriverManager.getConnection
             (url+dbName,userName,password);
            String query = "select * from clinica.pacientes";
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                fw.append(rs.getString(1));
                fw.append(',');
                fw.append(rs.getString(2));
                fw.append(',');
                fw.append(rs.getString(3));
                fw.append('\n');
            }
            fw.flush();
            fw.close();
            conn.close();
            out.println("<b>You are Successfully Created Csv file.</b>");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
