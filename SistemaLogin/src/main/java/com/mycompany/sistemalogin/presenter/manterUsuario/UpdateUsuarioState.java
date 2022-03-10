package com.mycompany.sistemalogin.presenter.manterUsuario;

import com.mycompany.sistemalogin.model.UsuarioModel;

public class UpdateUsuarioState extends ManterUsuarioState {
    
    private UsuarioModel usuario;

    public UpdateUsuarioState(UsuarioModel usuario) {
        this.usuario = usuario;
        configTela();
    }
    
    @Override
    public void configTela() {
        presenter.configuraEditarNovo();
    }

    @Override
    public void opcaoCancelar() {
        presenter.getFrame().dispose();
    }

    @Override
    public void opcaoSalvar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void opcaoExcluir() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
