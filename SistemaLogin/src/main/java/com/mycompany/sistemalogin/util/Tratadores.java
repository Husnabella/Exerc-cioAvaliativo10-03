package com.mycompany.sistemalogin.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.pss.senha.validacao.ValidadorSenha;
import java.awt.Container;
import java.util.ArrayList;
import java.util.List;


public class Tratadores {
    
    private static Tratadores tratador;

    public static Tratadores getInstancia() {
        if (tratador == null) {
            return tratador = new Tratadores();
        }
        return tratador;
    }
    
    public boolean tratadorUsuario(Container view, String login, String nome, String senha, String csenha) {
        List<String> resultado = new ArrayList<String>();
        String erros = "";
        /*if(!validarLogin(login).isEmpty())
            resultado.addAll(validarLogin(login));
        if(!validarNome(nome).isEmpty())
            resultado.addAll(validarNome(nome));*/
        if(!validarSenha(senha, csenha).isEmpty())
            resultado.addAll(validarSenha(senha, csenha));
        if (!resultado.isEmpty()) {
            for (int i = 0; i < resultado.size(); i++) {
                erros += resultado.get(i);
            }
            PopUpUtil.mostrarPopUpErro(view, erros);
            return false;
        } else 
            return true;
    }
    
    public String temEspecial(String txt) {
        Pattern especiais = Pattern.compile("[!@#$%&*/()_+=|<>?{}\\[\\]~-]");
        Matcher temEspecial = especiais.matcher(txt);
        if(temEspecial.find()) {
            return "Campos Nome e Usuário não devem conter caracteres especiais\n";
        }
        return "";
    }
    
    public String temEspaco(String txt) {
        Pattern WHITE_SPACE = Pattern.compile("\\s+");
        Matcher temEspaco = WHITE_SPACE.matcher(txt);
        if(temEspaco.find()) {
            return "O campo Usuário não deve conter espaços\n";
        }
        return "";
    }
    
    public String temNumero(String txt) {
        Pattern especiais = Pattern.compile("[0-9]");
        Matcher temNumero = especiais.matcher(txt);
        if(temNumero.find()) {
            return "O campo Nome não deve conter números\n";
        }
        return "";
    }
    
    public List<String> validarSenha(String senha, String csenha) {
        List<String> erros = new ValidadorSenha().validar(senha);
        if(!senha.equals(csenha))
            erros.add("Senhas Incompatíveis;");
        return erros;
    }
    
    public String campoVazio(String txt, String tipo) {
        if (txt == null)
            return ("Insira um " + tipo + "\n");
        if (txt.isEmpty())
            return ("Insira um " + tipo + "\n");
        return "";
    }
    
    public List<String> validarLogin(String login) {
        List<String> resultado = new ArrayList<>();
        resultado.add(campoVazio(login, "login"));
        resultado.add(temEspecial(login));
        resultado.add(temEspaco(login));
        return resultado;
    }
    
    public List<String> validarNome(String nome) {
        List<String> resultado = new ArrayList<>();
        resultado.add(campoVazio(nome, "nome"));
        resultado.add(temEspecial(nome));
        resultado.add(temNumero(nome));
        return resultado;
    }
} 
