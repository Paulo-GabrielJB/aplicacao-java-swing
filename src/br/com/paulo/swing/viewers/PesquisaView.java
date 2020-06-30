package br.com.paulo.swing.viewers;

import br.com.paulo.swing.controllers.ClienteController;
import br.com.paulo.swing.controllers.PesquisaController;
import br.com.paulo.swing.dao.DaoFactory;
import br.com.paulo.swing.listeners.DataChangeListener;
import br.com.paulo.swing.models.Cliente;
import br.com.paulo.swing.utils.Util;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;


public class PesquisaView extends javax.swing.JFrame implements DataChangeListener{
    
    private PesquisaController pesquisaController;
    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private Cliente cliente;

    public PesquisaView() {
        initComponents();
        limparCampos();
        updateTable();
    }
    
    public PesquisaView(PesquisaController pesquisaController){
        this.pesquisaController = pesquisaController;
        initComponents();
        limparCampos();
        updateTable();
    }

  
    @SuppressWarnings("unchecked")
    private void initComponents() {//GEN-BEGIN:initComponents

        lblNome = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbClientes = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        lblNome.setText("Nome:");
        lblNome.setName("lblNome"); // NOI18N

        txtNome.setName("txtNome"); // NOI18N

        btnBuscar.setText("Buscar");
        btnBuscar.setToolTipText("");
        btnBuscar.setName("btnBuscar"); // NOI18N
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnLimpar.setText("Limpar");
        btnLimpar.setName("btnLimpar"); // NOI18N
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        tbClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nome", "CPF", "Sexo", "Dt. Nascimento", "Telefone"
            }
        ));
        tbClientes.setName("tbClientes"); // NOI18N
        tbClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbClientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbClientes);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(lblNome)
                .addGap(18, 18, 18)
                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnBuscar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLimpar)
                .addContainerGap(336, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNome)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar)
                    .addComponent(btnLimpar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 383, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }//GEN-END:initComponents

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        limparCampos();
    }//GEN-LAST:event_btnLimparActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        updateTable();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void tbClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbClientesMouseClicked
        ListSelectionModel tableSelectionModel = tbClientes.getSelectionModel();
        
        tbClientes.setSelectionModel(tableSelectionModel);
        
        instanciarCliente();
        
        ClienteView cv = new ClienteView(new ClienteController(DaoFactory.getClienteDao()), cliente);
        cv.addListener(this);
        cv.show();
    }//GEN-LAST:event_tbClientesMouseClicked

 
    public static void main(String args[]) {
     
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PesquisaView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblNome;
    private javax.swing.JTable tbClientes;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
    
    private void limparCampos(){
        txtNome.setText("");
    }
    
    private void updateTable() {
        List<Cliente> clientes = pesquisaController.buscarClientePorNome(txtNome.getText());
        DefaultTableModel model = (DefaultTableModel)tbClientes.getModel();
  
        int rowCount = model.getRowCount();
        
        for(int i = rowCount - 1; i >= 0; i--)
            model.removeRow(i);
        
        for(Cliente c: clientes)
            model.addRow(
                    new Object[]{
                        c.getCodigo(),
                        c.getNome(),
                        c.getCpf(),
                        c.getSexo().toString(),
                        sdf.format(c.getNascimento()),
                        c.getTelefone()
                    }
            );
    }
    
     private void instanciarCliente(){
        
        cliente = new Cliente();       

        cliente.setCodigo(Util.parseLong(tbClientes.getValueAt(tbClientes.getSelectedRow(), 0)));
        
        cliente.setNome(Util.parseString(tbClientes.getValueAt(tbClientes.getSelectedRow(), 1)));
        
        cliente.setCpf(Util.parseString(tbClientes.getValueAt(tbClientes.getSelectedRow(), 2)));
        
        cliente.setSexo(Util.parseChar(tbClientes.getValueAt(tbClientes.getSelectedRow(), 3)));
        
        cliente.setTelefone(Util.parseString(tbClientes.getValueAt(tbClientes.getSelectedRow(), 5)));
            
        try {
            cliente.setNascimento(Util.parseSqlDate( sdf.parse( tbClientes.getValueAt(tbClientes.getSelectedRow(), 4).toString() )));
        } catch(ParseException e){
            cliente.setNascimento(Util.parseSqlDate(new Date()));
        }
    }

    @Override
    public void onDataChange() {
        updateTable();
    }
    
}
