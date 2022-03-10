package com.mycompany.sistemalogin.presenter.telaPrincipal;

import com.mycompany.sistemalogin.presenter.AbstractPresenter;
import com.mycompany.sistemalogin.presenter.manterUsuario.BuscarUsuarioPresenter;
import com.mycompany.sistemalogin.view.TelaPrincipalView;
import java.awt.event.ActionEvent;
import javax.swing.JInternalFrame;

public class TelaPrincipalPresenter extends AbstractPresenter {
    
    protected static TelaPrincipalPresenter presenter;

    protected static TelaPrincipalView view;
    
    private TelaPrincipalPresenter() {
        initView();
    }
    
    public static TelaPrincipalPresenter getInstancia() {
        if (presenter == null) {
            presenter = new TelaPrincipalPresenter();
        }
        return presenter;
    }
    
    @Override
    protected void initView() {
        view = TelaPrincipalView.getInstancia();
        
        view.addActionListenerBuscarUsuario((ActionEvent e) -> {
            opcaoBuscar();
        });
        
        view.addActionListenerLerNotif((ActionEvent e) -> {
            opcaoLer();
        });
        
        view.addActionListenerNovaMensagem((ActionEvent e) -> {
            opcaoNovaMensagem();
        });
        
        view.addActionListenerSair((ActionEvent e) -> {
            opcaoSair();
        });
    }
    
    @Override
    public void abrirView(boolean b) {
        view.setVisible(b);
    }
    
    public void addToDesktop(JInternalFrame frame) {
        view.addToDesktop(frame);
    }

    private void opcaoBuscar() {
        var buscarUsuario = BuscarUsuarioPresenter.getInstancia();
        buscarUsuario.abrirView(true);
        presenter.addToDesktop(buscarUsuario.getFrame());
    }

    private void opcaoLer() {
        /*var buscarUsuario = BuscarUsuarioPresenter.getInstancia();
        presenter.addToDesktop(buscarUsuario.getFrame());
        buscarUsuario.getFrame().setVisible(true);*/
    }
    
    private void opcaoNovaMensagem() {
    }

    private void opcaoSair() {
        view.dispose();
    }
}