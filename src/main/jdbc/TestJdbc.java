package main.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/hb_student_tracker" +
        "?verifyServerCertificate=false"+
                "&useSSL=false"+
                "&requireSSL=false"+
                "&useLegacyDatetimeCode=false"+
                "&amp"+
                "&serverTimezone=UTC";

        String login = "root";
        String pass = "root";

        try{
            Connection connection = DriverManager.getConnection(jdbcUrl, login, pass);
            System.out.println("Connection successful");
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
