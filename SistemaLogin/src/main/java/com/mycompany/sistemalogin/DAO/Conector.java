package com.mycompany.sistemalogin.DAO;

import com.mycompany.sistemalogin.util.ConexaoSQLite;

public class Conector extends ConexaoSQLite {
    
    private static Conector conector;
    
    public static Conector getInstancia() {
        if (conector == null) {
            conector = new Conector();
        }
        return conector;
    }
}
