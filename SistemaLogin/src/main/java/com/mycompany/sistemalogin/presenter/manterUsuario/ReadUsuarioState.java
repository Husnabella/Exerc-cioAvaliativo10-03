package com.mycompany.sistemalogin.presenter.manterUsuario;

import com.mycompany.sistemalogin.model.UsuarioModel;
import com.mycompany.sistemalogin.util.PopUpUtil;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReadUsuarioState extends ManterUsuarioState {
    
    private UsuarioModel usuario;

    public ReadUsuarioState(UsuarioModel usuario) {
        super();
        this.usuario = usuario;
        configTela();
    }
    
    @Override
    public void configTela() {
        presenter.configuraVisualizar(usuario.getTipoUsuario());
    }
    
    @Override
    public void opcaoCancelar() {
        presenter.getFrame().dispose();
    }

    @Override
    public void opcaoSalvar() {
    }

    @Override
    public void opcaoExcluir() {
        PopUpUtil.mostrarPopUpConfirmacao(presenter.getFrame(), "Deseja excluir esse usuário?");
            try {
                if(repository.deletarUsuario(usuario.getIdUsuario()))
                    PopUpUtil.mostrarPopUpConfirmacao(presenter.getFrame(), "Usuário excluído com sucesso");
            } catch (SQLException ex) {
                Logger.getLogger(ReadUsuarioState.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    public void preencheCampos() {
        Map<String, String> valores = new HashMap<>();
        
        valores.put("login", usuario.getUserLogin());
        valores.put("nome", usuario.getUserNome());
        
        presenter.preencheCampos(valores);
    }
}
