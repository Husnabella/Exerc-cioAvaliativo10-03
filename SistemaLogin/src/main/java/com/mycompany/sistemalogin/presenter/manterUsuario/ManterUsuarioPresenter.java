package com.mycompany.sistemalogin.presenter.manterUsuario;

import com.mycompany.sistemalogin.model.UsuarioModel;
import com.mycompany.sistemalogin.presenter.AbstractPresenter;
import com.mycompany.sistemalogin.presenter.telaPrincipal.TelaPrincipalPresenter;
import com.mycompany.sistemalogin.repository.UsuarioRepository;
import com.mycompany.sistemalogin.view.manterUsuario.IFrmManterUsuarioView;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JInternalFrame;

public class ManterUsuarioPresenter extends AbstractPresenter {
    
    protected static ManterUsuarioPresenter presenter;
    
    protected static UsuarioRepository repository;
    
    protected static TelaPrincipalPresenter tela;
    
    protected static ManterUsuarioState state;
    
    protected static IFrmManterUsuarioView view;
    
    protected UsuarioModel model;

    public ManterUsuarioPresenter() {
        initView();
    }
    
    public static ManterUsuarioPresenter getInstancia() {
        if (presenter == null) {
            presenter = new ManterUsuarioPresenter();
        }
        return presenter;
    }
    
    @Override
    protected void initView() {
        view = IFrmManterUsuarioView.getInstancia();
        
        view.addActionListenerCancelar((ActionEvent e) -> {
            opcaoCancelar();
        });
        
        view.addActionListenerSalvar((ActionEvent e) -> {
            opcaoSalvar();
        });
        
        view.addActionListenerExcluir((ActionEvent e) -> {
            opcaoExcluir();
        });
    }

    @Override
    public void abrirView(boolean b) {
        view.setVisible(b);
    }
    
    public void setState(ManterUsuarioState state) {
        this.state = state;
    }
    
    public HashMap<String, String> getCampoValores() {
        return view.getCampoValores();
    }
    
    public String getData() {
        String data;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        data = dtf.format(LocalDateTime.now());
        return data;
    }
    
    public void limpaCampos() {
        view.limpaCampos();
    }
    
    public void configuraVisualizar(String tipoUsuario) {
        view.configuraVisualizar(tipoUsuario);
    }
    
    public void configuraEditarNovo() {
        view.configuraEditarNovo();
    }
    
    public List<UsuarioModel> getListaUsuario() throws SQLException {
        return repository.listarUsuario();
    }
    
    public void preencheCampos(Map<String, String> valores) {
        view.preencheCampos(valores);
    }

    public JInternalFrame getFrame() {
        view = IFrmManterUsuarioView.getInstancia();
        return view;
    }

    private void opcaoCancelar() {
        state.opcaoCancelar();
    }

    private void opcaoSalvar() {
        state.opcaoSalvar();
    }

    private void opcaoExcluir() {
        state.opcaoExcluir();
    }
}
