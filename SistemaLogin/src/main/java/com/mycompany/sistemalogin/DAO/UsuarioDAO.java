package com.mycompany.sistemalogin.DAO;

import com.mycompany.sistemalogin.model.UsuarioModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UsuarioDAO implements DAO<UsuarioModel> {
    
    private static Conector conector;
    
    private static UsuarioDAO DAO;
    
    public static UsuarioDAO getInstancia() {
        if (DAO == null) {
            DAO = new UsuarioDAO();
        }
        return DAO;
    }

    @Override
    public boolean create(UsuarioModel objeto) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public UsuarioModel get(int idUsuario) {
        UsuarioModel usuario = new UsuarioModel();
        conector = Conector.getInstancia();
        conector.conectar();
        ResultSet resultSet;
        PreparedStatement ps;
        
        String sql = "SELECT pk_user_id, "
                + "user_usuario, "
                + "user_nome, "
                + "senha "
                + "FROM tbl_usuario WHERE pk_usu_id = '"+idUsuario+"'";
        
        ps = conector.criarPreparedStatement(sql);
        
        try {
            resultSet = ps.executeQuery();
            
            while (resultSet.next()) {
                usuario = new UsuarioModel();
                usuario.setIdUsuario(resultSet.getInt(1));
                usuario.setUserLogin(resultSet.getString(2));
                usuario.setUserNome(resultSet.getString(3));
                usuario.setUserSenha(resultSet.getString(4));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception e) {
            System.err.println(e);
        }
        conector.desconectar();
        return usuario;
    }
    
    @Override
    public boolean insert(UsuarioModel objeto) {
        conector = Conector.getInstancia();
        conector.conectar();
        
        String sql = "INSERT INTO tbl_usuario ("
                + "user_usuario, "
                + "user_nome, "
                + "user_data_cadastro, "
                + "user_n_enviadas, "
                + "user_n_lidas, "
                + "user_senha, "
                + "user_tipo) "
                + "VALUES (?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement = conector.criarPreparedStatement(sql, Statement.RETURN_GENERATED_KEYS);
        try {
            //preparedStatement.setString(1, String.valueOf(usuario.getIdUsuario()));
            preparedStatement.setString(1, objeto.getUserLogin());
            preparedStatement.setString(2, objeto.getUserNome());
            preparedStatement.setString(3, objeto.getDataCadastro());
            preparedStatement.setString(4, String.valueOf(objeto.getNotifEnviada()));
            preparedStatement.setString(5, String.valueOf(objeto.getNotifRecebida()));
            preparedStatement.setString(6, objeto.getUserSenha());
            preparedStatement.setString(7, objeto.getTipoUsuario());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        conector.desconectar();
        return true;
    }

    @Override
    public boolean update(int idUsuario) throws SQLException {
        conector = Conector.getInstancia();
        conector.conectar();
        ResultSet resultSet;
        PreparedStatement ps;
        
        String sql = "SELECT pk_user_id, "
                + "user_usuario, "
                + "user_nome, "
                + "senha "
                + "FROM tbl_usuario WHERE pk_usu_id = '"+idUsuario+"'";
        
        ps = conector.criarPreparedStatement(sql);
        
        try {
            resultSet = ps.executeQuery();
            
            while (resultSet.next()) {
                var usuario = new UsuarioModel();
                usuario.setIdUsuario(resultSet.getInt(1));
                usuario.setUserLogin(resultSet.getString(2));
                usuario.setUserNome(resultSet.getString(3));
                usuario.setUserSenha(resultSet.getString(4));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }finally{
            if (ps != null) {
                ps.close();
            }
        }
        conector.desconectar();
        return true;
    }

    @Override
    public boolean delete(int idUsuario) throws SQLException {
        conector = Conector.getInstancia();
        conector.conectar();
        PreparedStatement ps;
        
        String sql = "DELETE FROM tbl_usuario WHERE pk_user_id = '"+idUsuario+"'";
        
        ps = conector.criarPreparedStatement(sql);
        
        try {
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }finally{
            if (ps != null) {
                ps.close();
            }
        }
        conector.desconectar();
        return true;
    }

    @Override
    public List<UsuarioModel> consulta() throws SQLException {
        List<UsuarioModel> listaUsuario = new ArrayList<>();
        UsuarioModel usuario;
        conector = Conector.getInstancia();
        conector.conectar();
        ResultSet resultSet;
        PreparedStatement ps;
        
        String sql = "SELECT pk_user_id, "
                + "user_usuario, "
                + "user_nome, "
                + "user_data_cadastro, "
                + "n_enviadas, "
                + "n_lidas "
                + "FROM tbl_usuario"
                + "VALUES (?,?,?,?,?)";
        try {
            ps = conector.criarPreparedStatement(sql);
            resultSet = ps.executeQuery();
            while (resultSet.next()) {
                usuario = new UsuarioModel();
                usuario.setIdUsuario(resultSet.getInt(1));
                usuario.setUserLogin(resultSet.getString(2));
                usuario.setUserNome(resultSet.getString(3));
                usuario.setDataCadastro(resultSet.getString(4));
                usuario.setNotifEnviada(resultSet.getInt(5));
                usuario.setNotifRecebida(resultSet.getInt(6));
                listaUsuario.add(usuario);
            }
        } catch (Exception e) {
            System.err.println(e);
        }
        conector.desconectar();
        return listaUsuario;
    }
}
