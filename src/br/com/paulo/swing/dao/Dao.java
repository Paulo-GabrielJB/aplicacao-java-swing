package br.com.paulo.swing.dao;

import java.util.List;


public interface Dao<T> {
    
    List<T> findAll();
    T findByCodigo(Long codigo);
    T insert(T obj);
    T update(T obj);
    void delete(T obj);
    
    default T findByNome(String nome){
        return null;
    }
    
}
