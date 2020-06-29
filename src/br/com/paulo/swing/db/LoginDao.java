package br.com.paulo.swing.db;

import br.com.paulo.swing.exceptions.StandardException;
import br.com.paulo.swing.models.Login;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;


public class LoginDao {
    
    private Connection conn;
    
    public LoginDao(Connection conn){
        this.conn = conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }
    
    
    public Login getLogin(String login, String senha){
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            ps = conn.prepareStatement("SELECT NM_LOGIN, PW_LOGIN "
                    + "FROM TB_LOGIN tl WHERE "
                    + "tl.NM_LOGIN = ? AND tl.PW_LOGIN = ?");
            ps.setString(1, login);
            ps.setString(2, senha);
            
            rs = ps.executeQuery();
            
            if(rs.next())
                return instanciarLogin(rs);
            else
                throw new StandardException("Usuario ou senha invalidos!");
            
        } catch(SQLException e){
            throw new StandardException(e.getMessage());
        } finally{
            DB.close(rs);
            DB.close(ps);
        }
    }
    
    private Login instanciarLogin(ResultSet rs) throws SQLException{
        Login login = new Login();
        login.setLogin(rs.getString("NM_LOGIN"));
        login.setSenha(rs.getString("PW_LOGIN"));
        return login;
    }
    
}
