package com.mycompany.sistemalogin.presenter.manterUsuario;

import com.mycompany.sistemalogin.model.UsuarioModel;
import com.mycompany.sistemalogin.presenter.AbstractPresenter;
import com.mycompany.sistemalogin.presenter.telaPrincipal.TelaPrincipalPresenter;
import com.mycompany.sistemalogin.repository.UsuarioRepository;
import com.mycompany.sistemalogin.view.IFrmBuscarUsuarioView;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JInternalFrame;

public class BuscarUsuarioPresenter extends AbstractPresenter {

    protected static BuscarUsuarioPresenter presenter;
    
    protected static TelaPrincipalPresenter tela;
    
    protected static IFrmBuscarUsuarioView view;
    
    protected static UsuarioRepository repository;
    
    protected List<UsuarioModel> listaUsuario;

    public BuscarUsuarioPresenter() {
        initView();
    }
    
    public static BuscarUsuarioPresenter getInstancia() {
        if (presenter == null) {
            presenter = new BuscarUsuarioPresenter();
        }
        return presenter;
    }
        
    @Override
    protected void initView() {
        view = IFrmBuscarUsuarioView.getInstancia();
        
        view.addActionListenerBuscar((ActionEvent e) -> {
            opcaoBuscar();
        });
        
        view.addActionListenerFechar((ActionEvent e) -> {
            opcaoFechar();
        });
        
        view.addActionListenerNovo((ActionEvent e) -> {
            opcaoNovo();
        });
        
        view.addActionListenerVisualizar((ActionEvent e) -> {
            opcaoViualizar();
        });
    }

    @Override
    public void abrirView(boolean b) {
        view.setVisible(b);
    }

    public JInternalFrame getFrame() {
        view = IFrmBuscarUsuarioView.getInstancia();
        return view;
    }
    
    public List<UsuarioModel> getListaUsuario() throws SQLException {
        return repository.listarUsuario();
    }
    
    public void preencheTabelaUsuarios() throws SQLException {
        view.preencheTabelaUsuarios();
    }
    
    public UsuarioModel getUsuario(int idUsuario) {
        repository = UsuarioRepository.getInstancia();
        return repository.getUsuario(idUsuario);
    }
    
    public int getIdUsuario() {
        return view.getIdUsuario();
    }
    
    public String getCampoBusca() {
        return view.getCampoBusca();
    }
    
    public String getBoxBusca() {
        return view.getBoxBusca();
    }

    private void opcaoBuscar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void opcaoFechar() {
        view.dispose();
    }

    private void opcaoNovo() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void opcaoViualizar() {
        var manterUsuario = new ReadUsuarioState(presenter.getUsuario(presenter.getIdUsuario()));
        tela = TelaPrincipalPresenter.getInstancia();
        //tela.addToDesktop(manterUsuario.getFrame());
        //manterUsuario.abrirView(true);
    }
    
}
