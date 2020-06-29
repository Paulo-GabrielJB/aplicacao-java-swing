package br.com.paulo.swing.viewers;

import br.com.paulo.swing.controllers.LoginController;
import br.com.paulo.swing.db.DB;
import br.com.paulo.swing.db.LoginDao;
import br.com.paulo.swing.exceptions.StandardException;
import br.com.paulo.swing.models.Login;
import javax.swing.JOptionPane;


public class LoginView extends javax.swing.JFrame {
    
    private LoginController loginController;
    
    public LoginView(LoginController loginController){
        this.loginController = loginController;
    }

    public LoginView() {
        loginController = new LoginController(new LoginDao(DB.getConnection()));
        initComponents();  
        lblError.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {//GEN-BEGIN:initComponents

        lblLogin = new javax.swing.JLabel();
        lblSenha = new javax.swing.JLabel();
        btnLimpar = new javax.swing.JButton();
        javax.swing.JButton btnLogin = new javax.swing.JButton();
        txtLogin = new javax.swing.JTextField();
        txtSenha = new javax.swing.JPasswordField();
        lblError = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName("frmLogin"); // NOI18N

        lblLogin.setText("Login:");
        lblLogin.setName("lblLogin"); // NOI18N

        lblSenha.setText("Senha:");
        lblSenha.setName("lblSenha"); // NOI18N

        btnLimpar.setText("Limpar");
        btnLimpar.setName("btnLimpar"); // NOI18N
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        btnLogin.setText("Login");
        btnLogin.setName("btnLogin"); // NOI18N
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        txtLogin.setName("txtLoginn"); // NOI18N

        txtSenha.setToolTipText("");
        txtSenha.setName("txtSenha"); // NOI18N

        lblError.setBackground(new java.awt.Color(0, 0, 0));
        lblError.setForeground(new java.awt.Color(255, 0, 0));
        lblError.setText("Preencha todos os campos");
        lblError.setName("lblError"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblError)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblSenha)
                                .addComponent(lblLogin))
                            .addGap(32, 32, 32)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtLogin)
                                .addComponent(txtSenha, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)))))
                .addContainerGap(52, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLogin)
                    .addComponent(txtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSenha)
                    .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addComponent(lblError)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnLimpar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pack();
    }//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
       try{
            String login = txtLogin.getText();
            String senha = txtSenha.getText();
            if(login.trim().equals("") || senha.trim().equals("")){
                lblError.setVisible(true);
                return;
            } else{
                lblError.setVisible(false);
                Login l = loginController.getLoginn(login, senha);
                if(l != null){
                    this.dispose();
                    SistemaView s = new SistemaView();
                    s.setVisible(true);
                    s.setLocationRelativeTo(null);
                }
           }
       } catch(StandardException e){
           JOptionPane.showMessageDialog(null, "Erro ao efetuar o login: " + e.getMessage(), "Erro ao logar", JOptionPane.ERROR_MESSAGE);
       }
    }//GEN-LAST:event_btnLoginActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        txtSenha.setText("");
        txtLogin.setText("");
    }//GEN-LAST:event_btnLimparActionPerformed

 
    public static void main(String args[]) {
  
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLimpar;
    private javax.swing.JLabel lblError;
    private javax.swing.JLabel lblLogin;
    private javax.swing.JLabel lblSenha;
    private javax.swing.JTextField txtLogin;
    private javax.swing.JPasswordField txtSenha;
    // End of variables declaration//GEN-END:variables
}
