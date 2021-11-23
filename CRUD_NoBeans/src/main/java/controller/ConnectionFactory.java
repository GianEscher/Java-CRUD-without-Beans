/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionFactory {

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/java";
    private static final String USER = "root";
    private static final String PASS = "";

    //Um método de tipo connection abre uma conexão
    public static Connection getConnection() {
        try {
            Class.forName(DRIVER);

            return DriverManager.getConnection(URL, USER, PASS);

        } catch (ClassNotFoundException | SQLException ex) { // o multicatch funde as entradas dos try cacthes
            throw new RuntimeException("Erro na conexão: ", ex);
        }
    }

    //Ainda é preciso fechar a conexão aberta, a fim de impedir sobrecargas
    public static void closeConnection(Connection con) {//Recebe uma conexão

        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException("encerrando conexão: ", ex);
        }
    }
    
    public static void closeConnection(Connection con, PreparedStatement stmt) {//Recebe uma conexão

        closeConnection(con);
        
        try {
            if (stmt != null) {
                stmt.close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException("encerrando stmt: ", ex);
        }
    }
    
    public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs) {//Recebe uma conexão

        closeConnection(con,stmt);
        
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException("encerrando rs: ", ex);
        }
    }
}
