package com.mycompany.sistemalogin.view;

import java.awt.event.ActionListener;
import javax.swing.JInternalFrame;

public class TelaPrincipalView extends javax.swing.JFrame {

    private static TelaPrincipalView instancia;

    public static TelaPrincipalView getInstancia() {
        if (instancia == null) {
            instancia = new TelaPrincipalView();
        }
        return instancia;
    }

    private TelaPrincipalView() {
        initComponents();
        setLocationRelativeTo(null);
    }
    
    public void addToDesktop(JInternalFrame frame) {
        //desktop.remove(frame);
        desktop.add(frame);
    }
    
    public void addActionListenerSair(ActionListener e) {
        jmSair.addActionListener(e);
    }
    
    public void addActionListenerBuscarUsuario(ActionListener e) {
        jmiBuscarUsuario.addActionListener(e);
    }
    
    public void addActionListenerLerNotif(ActionListener e) {
        jmiLerNotificacoes.addActionListener(e);
    }
    
    public void addActionListenerNovaMensagem(ActionListener e) {
        jmiNovaMensagem.addActionListener(e);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktop = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jmUsuario = new javax.swing.JMenu();
        jmiBuscarUsuario = new javax.swing.JMenuItem();
        jmNotificacoes = new javax.swing.JMenu();
        jmiLerNotificacoes = new javax.swing.JMenuItem();
        jmiNovaMensagem = new javax.swing.JMenuItem();
        jmSair = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout desktopLayout = new javax.swing.GroupLayout(desktop);
        desktop.setLayout(desktopLayout);
        desktopLayout.setHorizontalGroup(
            desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 752, Short.MAX_VALUE)
        );
        desktopLayout.setVerticalGroup(
            desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 530, Short.MAX_VALUE)
        );

        jmUsuario.setText("Usuário");

        jmiBuscarUsuario.setText("Buscar Usuários");
        jmUsuario.add(jmiBuscarUsuario);

        jMenuBar1.add(jmUsuario);

        jmNotificacoes.setText("Notificações");

        jmiLerNotificacoes.setText("Visualizar Notificações");
        jmNotificacoes.add(jmiLerNotificacoes);

        jmiNovaMensagem.setText("Nova Mensagem");
        jmNotificacoes.add(jmiNovaMensagem);

        jMenuBar1.add(jmNotificacoes);

        jmSair.setText("Sair");
        jMenuBar1.add(jmSair);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktop)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktop)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane desktop;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jmNotificacoes;
    private javax.swing.JMenu jmSair;
    private javax.swing.JMenu jmUsuario;
    private javax.swing.JMenuItem jmiBuscarUsuario;
    private javax.swing.JMenuItem jmiLerNotificacoes;
    private javax.swing.JMenuItem jmiNovaMensagem;
    // End of variables declaration//GEN-END:variables
}
