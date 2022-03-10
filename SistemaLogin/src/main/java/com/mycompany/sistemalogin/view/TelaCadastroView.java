package com.mycompany.sistemalogin.view;

import java.awt.event.ActionListener;
import java.util.HashMap;

public class TelaCadastroView extends javax.swing.JFrame {

    private static TelaCadastroView instancia;
    
    public static TelaCadastroView getInstancia() {
        if (instancia == null) {
            instancia = new TelaCadastroView();
        }
        return instancia;
    }
    
    private TelaCadastroView() {
        initComponents();
        setLocationRelativeTo(null);
    }
    
    public void limpaCampos() {
        jtfUsuario.setText("");
        jtfNome.setText("");
        jpSenha.setText("");
        jpConfirmarSenha.setText("");
    }
    
    public HashMap<String, String> getCampoValores() {
        HashMap<String, String> valores = new HashMap<String, String>();
        valores.put("login", jtfUsuario.getText());
        valores.put("nome", jtfNome.getText());
        valores.put("senha", String.valueOf(jpSenha.getPassword()));
        valores.put("csenha", String.valueOf(jpConfirmarSenha.getPassword()));
        return valores;
    }
    
    public String getCampoUsuario() {
        return jtfUsuario.getText();
    }
    
    public String getCampoNome() {
        return jtfNome.getText();
    }
    
    public String getCampoSenha() {
        return (String.valueOf(jpSenha.getPassword()));
    }
    
    public String getCampoConfirmaSenha() {
        return (String.valueOf(jpConfirmarSenha.getPassword()));
    }
    
    public void addActionListenerCancelar(ActionListener e) {
        jbCancelar.addActionListener(e);
    }
    
    public void addActionListenerSalvar(ActionListener e) {
        jbSalvar.addActionListener(e);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jbSalvar = new javax.swing.JButton();
        jbCancelar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jpSenha = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();
        jpConfirmarSenha = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jtfUsuario = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jtfNome = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jbSalvar.setText("Cadastrar");

        jbCancelar.setText("Cancelar");

        jLabel4.setText("Senha");

        jLabel5.setText("Confimar Senha");

        jLabel1.setText("Usuário");

        jLabel2.setText("Nome");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(96, 96, 96)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbCancelar)
                        .addGap(132, 132, 132)
                        .addComponent(jbSalvar))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addGap(18, 18, 18)
                            .addComponent(jpConfirmarSenha, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(29, 29, 29))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(18, 18, 18)))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addGap(27, 27, 27)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jtfUsuario)
                                .addComponent(jtfNome)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGap(46, 46, 46)
                                    .addComponent(jpSenha, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE))))))
                .addContainerGap(125, Short.MAX_VALUE))
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
                    .addComponent(jLabel4)
                    .addComponent(jpSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jpConfirmarSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbCancelar)
                    .addComponent(jbSalvar))
                .addContainerGap(70, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JButton jbCancelar;
    private javax.swing.JButton jbSalvar;
    private javax.swing.JPasswordField jpConfirmarSenha;
    private javax.swing.JPasswordField jpSenha;
    private javax.swing.JTextField jtfNome;
    private javax.swing.JTextField jtfUsuario;
    // End of variables declaration//GEN-END:variables
}
