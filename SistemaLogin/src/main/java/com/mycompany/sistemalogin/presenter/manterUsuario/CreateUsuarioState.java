package com.mycompany.sistemalogin.presenter.manterUsuario;

import com.mycompany.sistemalogin.model.UsuarioModel;
import com.mycompany.sistemalogin.repository.UsuarioRepository;
import com.mycompany.sistemalogin.util.PopUpUtil;
import com.mycompany.sistemalogin.util.Tratadores;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CreateUsuarioState extends ManterUsuarioState {

    public CreateUsuarioState() {
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
        Tratadores tratador = Tratadores.getInstancia();
        var usuario = new UsuarioModel();
        //preenchendo novo usuario
        usuario.setUserLogin(presenter.getCampoValores().get("login"));
        usuario.setUserNome(presenter.getCampoValores().get("nome"));
        usuario.setDataCadastro(presenter.getData());
        usuario.setNotifEnviada(0);
        usuario.setNotifRecebida(0);
        usuario.setUserSenha(presenter.getCampoValores().get("senha"));
        
        try {
            //def tipo usuario
            if(presenter.getListaUsuario().isEmpty())
                usuario.setTipoUsuario("ADM");
            else
                usuario.setTipoUsuario("USER");
        } catch (SQLException ex) {
            Logger.getLogger(CreateUsuarioState.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //validando campos
        boolean valida = tratador.tratadorUsuario(
                presenter.getFrame(),
                presenter.getCampoValores().get("login"),
                presenter.getCampoValores().get("nome"),
                presenter.getCampoValores().get("senha"), 
                presenter.getCampoValores().get("csenha")
        );
        
        if (!valida) {
            //popUp aparece
        } else {
            repository = UsuarioRepository.getInstancia();
            try {
                if(repository.inserirUsuario(usuario)) {
                    PopUpUtil.mostrarPopUpSucesso(presenter.getFrame(), "Usuário Cadastrado com Sucesso");
                    presenter.limpaCampos();
                    presenter.getFrame().dispose();
                } else
                    PopUpUtil.mostrarPopUpErro(presenter.getFrame(), "Algo deu errado. Tente novamente!");
            } catch (SQLException ex) {
                Logger.getLogger(CreateUsuarioState.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void opcaoExcluir() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
