package com.mycompany.sistemalogin.presenter.manterUsuario;

import com.mycompany.sistemalogin.repository.UsuarioRepository;

public abstract class ManterUsuarioState {
    
    protected ManterUsuarioPresenter presenter;
    
    protected UsuarioRepository repository;
    
    protected ManterUsuarioState() {
        this.presenter = ManterUsuarioPresenter.getInstancia();
        this.repository = new UsuarioRepository();
    }
    
    public abstract void configTela();
    
    public abstract void opcaoCancelar();

    public abstract void opcaoSalvar();

    public abstract void opcaoExcluir();

}
