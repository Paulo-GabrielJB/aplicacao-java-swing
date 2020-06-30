package br.com.paulo.swing.dao;

import br.com.paulo.swing.dao.impl.ClienteDaoJDBC;
import br.com.paulo.swing.dao.impl.LoginDao;
import br.com.paulo.swing.db.DB;

public class DaoFactory {
    
    public static LoginDao getLoginDao(){
        return new LoginDao(DB.getConnection());
    }
    
    public static Dao getClienteDao(){
        return new ClienteDaoJDBC(DB.getConnection());
    }

}
