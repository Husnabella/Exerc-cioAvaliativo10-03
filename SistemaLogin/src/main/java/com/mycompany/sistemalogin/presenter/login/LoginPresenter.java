package com.mycompany.sistemalogin.presenter.login;

import com.mycompany.sistemalogin.presenter.AbstractPresenter;
import com.mycompany.sistemalogin.presenter.login.TelaCadastroPresenter;
import com.mycompany.sistemalogin.view.LoginView;
import java.awt.event.ActionEvent;

public class LoginPresenter extends AbstractPresenter {

    protected static LoginPresenter presenter;
    
    protected static LoginView view;

    public LoginPresenter() {
        initView();
    }
    
    public static LoginPresenter getInstancia() {
        if (presenter == null) {
            presenter = new LoginPresenter();
        }
        return presenter;
    }
    
    @Override
    protected void initView() {
        view = LoginView.getInstancia();
        
        view.addActionListenerEntrar((ActionEvent e) -> {
            opcaoEntrar();
        });
        
        view.addActionListenerSair((ActionEvent e) -> {
            opcaoSair();
        });
        
        view.addActionListenerCadastre((ActionEvent e) -> {
            opcaoCadastre();
        });
    }

    @Override
    public void abrirView(boolean b) {
        view.setVisible(b);
    }

    private void opcaoEntrar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void opcaoSair() {
        view.dispose();
    }

    private void opcaoCadastre() {
        var cadastre = TelaCadastroPresenter.getInstancia();
        cadastre.abrirView(true);
    }
    
}
