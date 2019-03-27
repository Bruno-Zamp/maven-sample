/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.upf.ccc.poo.dominio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author jaqson
 */
public class ConexaoSingleton {
    
    private Connection con;

    public Connection getCon() {
        return con;
    }
    
    public Statement getStatement() throws SQLException{
        return con.createStatement();
    }
    
    public PreparedStatement getPreparedStatement(String sql) throws SQLException{
        return con.prepareStatement(sql);
    }
  
    private ConexaoSingleton() {
        try {
            // 1) registrar a classe do driver
            Class.forName("org.postgresql.Driver");
            // 2) Definir a URL JDBC
            String url = "jdbc:postgresql://localhost:5432/aulapoo";
            // 3) Obter a conexão com o BD
            con = DriverManager.getConnection(url, "postgres", "Since2009");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        
    }
    
    public static ConexaoSingleton getInstance() {
        return ConexaoSilgletonHolder.INSTANCE;
    }
    
    private static class ConexaoSilgletonHolder {

        private static final ConexaoSingleton INSTANCE = new ConexaoSingleton();
    }
}
