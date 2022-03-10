package com.mycompany.sistemalogin.repository;

import com.mycompany.sistemalogin.DAO.UsuarioDAO;
import com.mycompany.sistemalogin.model.UsuarioModel;
import java.sql.SQLException;
import java.util.List;

public class UsuarioRepository {
    
    private static UsuarioRepository repository;
    
    private static UsuarioDAO usuarioDAO;

    public static UsuarioRepository getInstancia() {
        if (repository == null) {
            repository = new UsuarioRepository();
        }
        return repository;
    }
    
    public boolean inserirUsuario(UsuarioModel usuario) throws SQLException {
        usuarioDAO = UsuarioDAO.getInstancia();
        return usuarioDAO.insert(usuario);
    }
    
    public List<UsuarioModel> listarUsuario() throws SQLException {
        usuarioDAO = UsuarioDAO.getInstancia();
        return usuarioDAO.consulta();
    }
    
    public boolean deletarUsuario(int idUsuario) throws SQLException {
        usuarioDAO = UsuarioDAO.getInstancia();
        return usuarioDAO.delete(idUsuario);
    }
    
    public UsuarioModel getUsuario(int idUsuario) {
        usuarioDAO = UsuarioDAO.getInstancia();
        return usuarioDAO.get(idUsuario);
    }

}
