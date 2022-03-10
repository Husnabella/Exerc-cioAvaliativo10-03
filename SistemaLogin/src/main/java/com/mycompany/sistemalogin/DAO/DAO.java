package com.mycompany.sistemalogin.DAO;

import java.sql.SQLException;
import java.util.List;

public interface DAO<T>{
    
   public boolean create(T objeto) throws SQLException;
   
   public Object get(int i) throws SQLException;
    
   public boolean insert(T objeto) throws SQLException;
   
   public boolean update(int i) throws SQLException;
   
   public boolean delete(int i) throws SQLException;
   
   public List<T> consulta() throws SQLException;
}
