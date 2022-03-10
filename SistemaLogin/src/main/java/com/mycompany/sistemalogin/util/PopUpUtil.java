package com.mycompany.sistemalogin.util;

import java.awt.Container;
import javax.swing.JOptionPane;

public class PopUpUtil {

    public static void mostrarPopUpSucesso(Container view, String mensagem) {
        JOptionPane.showMessageDialog(
                view,
                mensagem,
                "Sucesso",
                JOptionPane.INFORMATION_MESSAGE
        );
    }

    public static boolean mostrarPopUpConfirmacao(Container view, String mensagem) {
        int resposta = JOptionPane.showConfirmDialog(
                view,
                mensagem,
                "Sucesso",
                JOptionPane.YES_NO_OPTION
        );
        return resposta == JOptionPane.YES_OPTION;
    }

    public static void mostrarPopUpErro(Container view, String mensagem) {
        JOptionPane.showMessageDialog(
                view,
                mensagem,
                "Erro",
                JOptionPane.ERROR_MESSAGE
        );
    }

}