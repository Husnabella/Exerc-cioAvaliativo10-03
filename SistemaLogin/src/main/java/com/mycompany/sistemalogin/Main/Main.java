package com.mycompany.sistemalogin.Main;

import com.mycompany.sistemalogin.presenter.login.LoginPresenter;
import com.mycompany.sistemalogin.presenter.telaPrincipal.TelaPrincipalPresenter;

public class Main {
    
    public static void main(String args[]) {
        LoginPresenter menu = LoginPresenter.getInstancia();
        TelaPrincipalPresenter tela = TelaPrincipalPresenter.getInstancia();
        menu.abrirView(true);
    }
    
}

