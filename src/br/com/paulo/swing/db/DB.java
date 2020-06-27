package br.com.paulo.swing.db;

import br.com.paulo.swing.exceptions.StandardException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class DB {
    
    private static Connection conn;
    private static final String URL = "jdbc:mysql://localhost:3306/curso_swing";
    private static final String USER = "root";
    private static final String PASSWORD = "1234567";
    
    public static Connection getConnection() {
        if(conn == null)
            try{
                conn = DriverManager.getConnection(URL, USER, PASSWORD);
            } catch(SQLException e){
                JOptionPane.showConfirmDialog(null, "Erro na conexao: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                throw new StandardException(e.getMessage());
            }
        return conn;
    }
    
    public static void closeConnection(){
        if(conn != null)
            try{
                conn.close();
            } catch(SQLException e){
                throw new StandardException(e.getMessage());
            }
    }
    
    public static void close(ResultSet rs){
        if(rs != null)
            try{
                rs.close();
            } catch(SQLException e){
                throw new StandardException(e.getMessage());
            }
    }
    
        public static void close(Statement st){
        if(st != null)
            try{
                st.close();
            } catch(SQLException e){
                throw new StandardException(e.getMessage());
            }
    }
    
}
