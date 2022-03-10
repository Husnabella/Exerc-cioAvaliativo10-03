package com.mycompany.sistemalogin.view;

import com.mycompany.sistemalogin.presenter.manterUsuario.BuscarUsuarioPresenter;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class IFrmBuscarUsuarioView extends javax.swing.JInternalFrame {
    
    private BuscarUsuarioPresenter presenter;

    private static IFrmBuscarUsuarioView instancia;
    
    public static IFrmBuscarUsuarioView getInstancia() {
        if (instancia == null) {
            instancia = new IFrmBuscarUsuarioView();
        }
        return instancia;
    }
    
    private IFrmBuscarUsuarioView() {
        initComponents();
    }
    
    public void configuraBuscaAdm() {
        jbNovo.isEnabled();
    }
    
    public int getIdUsuario() {
        int linha = jtTabelaUsuarios.getSelectedRow();
        if (linha < 0)
            JOptionPane.showMessageDialog(this, "Selecione um usuário.");
        return (int) jtTabelaUsuarios.getValueAt(0, linha);
    }
    
    // manipula tabela usuarios
    public void preencheTabelaUsuarios() {
        presenter = BuscarUsuarioPresenter.getInstancia();
        var lista = presenter.getListaUsuario();
        var model = (DefaultTableModel) jtTabelaUsuarios.getModel();
        model.setRowCount(0);
        for (int i = 0; i < lista.size(); i++) {
            model.addRow(new Object[]{
                lista.get(i).getIdUsuario(),
                lista.get(i).getUserLogin(),
                lista.get(i).getUserNome(),
                lista.get(i).getDataCadastro(),
                lista.get(i).getNotifEnviada(),
                lista.get(i).getNotifRecebida()
            });
        }
    }
    
    // botoes
    
    public void addActionListenerBuscar(ActionListener e) {
        jbBuscar.addActionListener(e);
    }
    
    public void addActionListenerNovo(ActionListener e) {
        jbNovo.addActionListener(e);
    }
    
    public void addActionListenerVisualizar(ActionListener e) {
        jbVisualizar.addActionListener(e);
    }
    
    public void addActionListenerFechar(ActionListener e) {
        jbFechar.addActionListener(e);
    }
    
    // pegar campos
    
    public String getCampoBusca() {
        return jtfBusca.getText();
    }
    
    public String getBoxBusca() {
        return (String) jcbBuscarPor.getSelectedItem();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jcbBuscarPor = new javax.swing.JComboBox<>();
        jtfBusca = new javax.swing.JTextField();
        jbBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtTabelaUsuarios = new javax.swing.JTable();
        jbNovo = new javax.swing.JButton();
        jbVisualizar = new javax.swing.JButton();
        jbFechar = new javax.swing.JButton();

        setTitle("Buscar Usuários");

        jLabel1.setText("Buscar por");

        jcbBuscarPor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID", "Usuário", "Nome", "Data de Cadastro", "N. Enviadas", "N. Lidas" }));

        jbBuscar.setText("Buscar");

        jtTabelaUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Usuário", "Nome", "Data de Cadastro", "N. Enviadas", "N. Lidas"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jtTabelaUsuarios);

        jbNovo.setText("Novo");
        jbNovo.setEnabled(false);

        jbVisualizar.setText("Visualizar");

        jbFechar.setText("Fechar");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jcbBuscarPor, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jtfBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jbBuscar))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 695, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(49, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jbFechar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbNovo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbVisualizar)
                        .addGap(40, 40, 40))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jcbBuscarPor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbBuscar))
                .addGap(31, 31, 31)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbVisualizar)
                    .addComponent(jbNovo)
                    .addComponent(jbFechar))
                .addContainerGap(49, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbBuscar;
    private javax.swing.JButton jbFechar;
    private javax.swing.JButton jbNovo;
    private javax.swing.JButton jbVisualizar;
    private javax.swing.JComboBox<String> jcbBuscarPor;
    private javax.swing.JTable jtTabelaUsuarios;
    private javax.swing.JTextField jtfBusca;
    // End of variables declaration//GEN-END:variables
}
