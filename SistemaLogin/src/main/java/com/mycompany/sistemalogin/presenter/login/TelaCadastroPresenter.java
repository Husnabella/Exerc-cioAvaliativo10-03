package com.mycompany.sistemalogin.presenter.login;

import com.mycompany.sistemalogin.model.UsuarioModel;
import com.mycompany.sistemalogin.presenter.AbstractPresenter;
import com.mycompany.sistemalogin.repository.UsuarioRepository;
import com.mycompany.sistemalogin.util.PopUpUtil;
import com.mycompany.sistemalogin.util.Tratadores;
import com.mycompany.sistemalogin.view.TelaCadastroView;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TelaCadastroPresenter extends AbstractPresenter {
    
    protected static TelaCadastroPresenter presenter;
    
    protected static TelaCadastroView view;
    
    protected static UsuarioRepository repository;

    public TelaCadastroPresenter() {
        initView();
    }
    
    public static TelaCadastroPresenter getInstancia() {
        if (presenter == null) {
            presenter = new TelaCadastroPresenter();
        }
        return presenter;
    }

    @Override
    protected void initView() {
        view = TelaCadastroView.getInstancia();
        
        view.addActionListenerCancelar((ActionEvent e) -> {
            opcaoCancelar();
        });
        
        view.addActionListenerSalvar((ActionEvent e) -> {
            try {
                opcaoSalvar();
            } catch (SQLException ex) {
                Logger.getLogger(TelaCadastroPresenter.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }
    
    public HashMap<String, String> getCampoValores() {
        return view.getCampoValores();
    }
    
    public void limpaCampos() {
        view.limpaCampos();
    }
    
    public List<UsuarioModel> getListaUsuario() throws SQLException {
        repository = UsuarioRepository.getInstancia();
        return repository.listarUsuario();
    }
    
    public String getCampoUsuario() {
        return view.getCampoUsuario();
    }
    
    public String getCampoNome() {
        return view.getCampoNome();
    }
    
    public String getCampoSenha() {
        return view.getCampoSenha();
    }
    
    public String getCampoConfirmaSenha() {
        return view.getCampoConfirmaSenha();
    }
    
    public String getData() {
        String data;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        data = dtf.format(LocalDateTime.now());
        return data;
    }

    @Override
    public void abrirView(boolean b) {
        view.setVisible(b);
    }

    private void opcaoCancelar() {
        view.dispose();
    }

    private void opcaoSalvar() throws SQLException {
        Tratadores tratador = Tratadores.getInstancia();
        var usuario = new UsuarioModel();
        //preenchendo novo usuario
        usuario.setUserLogin(presenter.getCampoValores().get("login"));
        usuario.setUserNome(presenter.getCampoValores().get("nome"));
        usuario.setDataCadastro(presenter.getData());
        usuario.setNotifEnviada(0);
        usuario.setNotifRecebida(0);
        usuario.setUserSenha(presenter.getCampoValores().get("senha"));
        
        //def tipo usuario
        if(presenter.getListaUsuario().isEmpty()) {
            usuario.setTipoUsuario("ADM");
        } else {
            usuario.setTipoUsuario("USER");
        }
        
        //validando campos
        boolean valida = tratador.tratadorUsuario(
                view,
                getCampoValores().get("login"),
                getCampoValores().get("nome"),
                getCampoValores().get("senha"), 
                getCampoValores().get("csenha")
        );
        
        if (!valida) {
            //popUp aparece
        } else {
            repository = UsuarioRepository.getInstancia();
            if(repository.inserirUsuario(usuario)) {
                PopUpUtil.mostrarPopUpSucesso(view, "Usuário Cadastrado com Sucesso");
                presenter.limpaCampos();
                view.dispose();
            } else 
                PopUpUtil.mostrarPopUpErro(view, "Algo deu errado. Tente novamente!");
        }
        
    }
}
