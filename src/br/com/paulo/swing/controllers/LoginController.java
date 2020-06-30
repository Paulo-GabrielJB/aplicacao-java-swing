package br.com.paulo.swing.controllers;

import br.com.paulo.swing.dao.impl.LoginDao;
import br.com.paulo.swing.models.Login;

public class LoginController {
    
    private LoginDao loginDao;
    
    public LoginController(LoginDao loginDao){
        this.loginDao = loginDao;
    }

    public void setLoginDao(LoginDao loginDao) {
        this.loginDao = loginDao;
    }
    
    
    public Login getLoginn(String login, String senha){
        return loginDao.getLogin(login, senha);
    }

}
