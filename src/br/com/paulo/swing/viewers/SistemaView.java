package br.com.paulo.swing.viewers;

import br.com.paulo.swing.controllers.ClienteController;
import br.com.paulo.swing.controllers.PesquisaController;
import br.com.paulo.swing.dao.DaoFactory;
import javax.swing.JOptionPane;


public class SistemaView extends javax.swing.JFrame {

    public SistemaView() {
        initComponents();
    }

  
    @SuppressWarnings("unchecked")
    private void initComponents() {//GEN-BEGIN:initComponents

        btnCadastrarClientes = new javax.swing.JButton();
        mbPrincipal = new javax.swing.JMenuBar();
        mCadastro = new javax.swing.JMenu();
        miCadastrarCliente = new javax.swing.JMenuItem();
        mPesquisar = new javax.swing.JMenu();
        miPesquisarCliente = new javax.swing.JMenuItem();
        mSair = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        btnCadastrarClientes.setText("Clientes");
        btnCadastrarClientes.setName("btnCadastrarClientes"); // NOI18N
        btnCadastrarClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarClientesActionPerformed(evt);
            }
        });

        mbPrincipal.setName("mbPrincipal"); // NOI18N

        mCadastro.setText("Cadastro");
        mCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mCadastroActionPerformed(evt);
            }
        });

        miCadastrarCliente.setText("Cliente");
        miCadastrarCliente.setName("miCadastrarCliente"); // NOI18N
        miCadastrarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miCadastrarClienteActionPerformed(evt);
            }
        });
        mCadastro.add(miCadastrarCliente);

        mbPrincipal.add(mCadastro);

        mPesquisar.setText("Pesquisar");

        miPesquisarCliente.setLabel("Cliente");
        miPesquisarCliente.setName("miPesquisarCliente"); // NOI18N
        miPesquisarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miPesquisarClienteActionPerformed(evt);
            }
        });
        mPesquisar.add(miPesquisarCliente);

        mbPrincipal.add(mPesquisar);

        mSair.setText("Sair");
        mSair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mSairMouseClicked(evt);
            }
        });
        mSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mSairActionPerformed(evt);
            }
        });
        mbPrincipal.add(mSair);

        setJMenuBar(mbPrincipal);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(btnCadastrarClientes)
                .addContainerGap(453, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(btnCadastrarClientes)
                .addContainerGap(252, Short.MAX_VALUE))
        );

        pack();
    }//GEN-END:initComponents

    private void miCadastrarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miCadastrarClienteActionPerformed
        new ClienteView(new ClienteController(DaoFactory.getClienteDao())).show();
    }//GEN-LAST:event_miCadastrarClienteActionPerformed

    private void btnCadastrarClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarClientesActionPerformed
        new ClienteView(new ClienteController(DaoFactory.getClienteDao())).show();
    }//GEN-LAST:event_btnCadastrarClientesActionPerformed

    private void mCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mCadastroActionPerformed
        new ClienteView(new ClienteController(DaoFactory.getClienteDao())).show();
    }//GEN-LAST:event_mCadastroActionPerformed

    private void miPesquisarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miPesquisarClienteActionPerformed
        new PesquisaView(new PesquisaController(DaoFactory.getClienteDao())).show();
    }//GEN-LAST:event_miPesquisarClienteActionPerformed

    private void mSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mSairActionPerformed
 
    }//GEN-LAST:event_mSairActionPerformed

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
     
    }//GEN-LAST:event_formMouseClicked

    private void mSairMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mSairMouseClicked
        String msg = "Deseja realmente sair?";
        int opt = JOptionPane.showConfirmDialog(null, msg, "Sistema", JOptionPane.YES_NO_OPTION);
        
        if(opt == JOptionPane.YES_OPTION)
            System.exit(0);
    }//GEN-LAST:event_mSairMouseClicked

   
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SistemaView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrarClientes;
    private javax.swing.JMenu mCadastro;
    private javax.swing.JMenu mPesquisar;
    private javax.swing.JMenu mSair;
    private javax.swing.JMenuBar mbPrincipal;
    private javax.swing.JMenuItem miCadastrarCliente;
    private javax.swing.JMenuItem miPesquisarCliente;
    // End of variables declaration//GEN-END:variables
}
