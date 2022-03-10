package com.mycompany.sistemalogin.view.manterUsuario;

import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class IFrmManterUsuarioView extends javax.swing.JInternalFrame {
    
    private static IFrmManterUsuarioView instancia;
    
    public static IFrmManterUsuarioView getInstancia() {
        if (instancia == null) {
            instancia = new IFrmManterUsuarioView();
        }
        return instancia;
    }

    public IFrmManterUsuarioView() {
        initComponents();
    }
    
    public void preencheCampos(Map<String, String> valores) {
        jtfUsuario.setText(valores.get("login"));
        jtfNome.setText(valores.get("nome"));
    }
    
    public HashMap<String, String> getCampoValores() {
        HashMap<String, String> valores = new HashMap<String, String>();
        valores.put("login", jtfUsuario.getText());
        valores.put("nome", jtfNome.getText());
        valores.put("senha", String.valueOf(jpSenha.getPassword()));
        valores.put("csenha", String.valueOf(jpConfirmarSenha.getPassword()));
        return valores;
    }
    
    public void limpaCampos() {
        jtfUsuario.setText("");
        jtfNome.setText("");
        jpSenha.setText("");
        jpConfirmarSenha.setText("");
    }
    
    // configuracoes de tela
    
    public void configuraVisualizar(String tipoUsuario) {
        jbSalvar.setText("Editar");
        jbCancelar.setText("Fechar");
        camposSenhaVisible(false);
        if(tipoUsuario.equals("ADM")){
            jbSalvar.isEnabled();
            jbExcluir.isEnabled();
        }
    }
    
    public void configuraEditarNovo() {
        jbSalvar.setText("Salvar");
        jbCancelar.setText("Cancelar");
        camposSenhaVisible(true);
        jbExcluir.setVisible(false);
    }
    
    public void camposSenhaVisible(boolean b) {
        jpConfirmarSenha.setVisible(b);
        jpSenha.setVisible(b);
        jLabelSenha.setVisible(b);
        jLabelCSenha.setVisible(b);
    }
    
    // acao botoes
    
    public void addActionListenerExcluir(ActionListener e) {
        jbExcluir.addActionListener(e);
    }
    
    public void addActionListenerSalvar(ActionListener e) {
        jbSalvar.addActionListener(e);
    }
    
    public void addActionListenerCancelar(ActionListener e) {
        jbCancelar.addActionListener(e); 
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jtfUsuario = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jtfNome = new javax.swing.JTextField();
        jbSalvar = new javax.swing.JButton();
        jbCancelar = new javax.swing.JButton();
        jLabelSenha = new javax.swing.JLabel();
        jpSenha = new javax.swing.JPasswordField();
        jLabelCSenha = new javax.swing.JLabel();
        jpConfirmarSenha = new javax.swing.JPasswordField();
        jbExcluir = new javax.swing.JButton();

        setTitle("Manter Usuário");
        setToolTipText("");

        jLabel1.setText("Usuário");

        jLabel2.setText("Nome");

        jbSalvar.setText("Salvar");
        jbSalvar.setEnabled(false);

        jbCancelar.setText("Cancelar");

        jLabelSenha.setText("Senha");

        jLabelCSenha.setText("Confimar Senha");

        jbExcluir.setText("Excluir");
        jbExcluir.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(96, 96, 96)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addGap(29, 29, 29))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addGap(18, 18, 18)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelSenha)
                                .addGap(27, 27, 27)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtfUsuario)
                            .addComponent(jtfNome)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addComponent(jpSenha, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelCSenha)
                            .addComponent(jbCancelar))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jpConfirmarSenha))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(jbExcluir)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                                .addComponent(jbSalvar)))))
                .addContainerGap(109, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelSenha)
                    .addComponent(jpSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCSenha)
                    .addComponent(jpConfirmarSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbCancelar)
                    .addComponent(jbSalvar)
                    .addComponent(jbExcluir))
                .addGap(38, 38, 38))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelCSenha;
    private javax.swing.JLabel jLabelSenha;
    private javax.swing.JButton jbCancelar;
    private javax.swing.JButton jbExcluir;
    private javax.swing.JButton jbSalvar;
    private javax.swing.JPasswordField jpConfirmarSenha;
    private javax.swing.JPasswordField jpSenha;
    private javax.swing.JTextField jtfNome;
    private javax.swing.JTextField jtfUsuario;
    // End of variables declaration//GEN-END:variables
}
