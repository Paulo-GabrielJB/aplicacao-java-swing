package br.com.paulo.swing.application;

import br.com.paulo.swing.controllers.LoginController;
import br.com.paulo.swing.dao.DaoFactory;
import br.com.paulo.swing.viewers.LoginView;


public class Program {

    public static void main(String[] args){
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginView(new LoginController(DaoFactory.getLoginDao())).setVisible(true);
            }
        });
    }
    
}
