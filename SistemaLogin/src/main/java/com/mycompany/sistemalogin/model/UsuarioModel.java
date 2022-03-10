package com.mycompany.sistemalogin.model;

public class UsuarioModel {
    
    private int idUsuario;
    
    private String userLogin;
    
    private String userNome;
    
    private String dataCadastro;
    
    private int notifEnviada;
    
    private int notifRecebida;
    
    private String userSenha;
    
    private String tipoUsuario;

    public UsuarioModel() {
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
    
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public String getUserNome() {
        return userNome;
    }

    public void setUserNome(String userNome) {
        this.userNome = userNome;
    }

    public String getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(String dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public int getNotifEnviada() {
        return notifEnviada;
    }

    public void setNotifEnviada(int notifEnviada) {
        this.notifEnviada = notifEnviada;
    }

    public int getNotifRecebida() {
        return notifRecebida;
    }

    public void setNotifRecebida(int notifRecebida) {
        this.notifRecebida = notifRecebida;
    }

    public String getUserSenha() {
        return userSenha;
    }

    public void setUserSenha(String userSenha) {
        this.userSenha = userSenha;
    }
    
    
}
