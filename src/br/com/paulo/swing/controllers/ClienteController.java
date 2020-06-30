package br.com.paulo.swing.controllers;

import br.com.paulo.swing.dao.Dao;
import br.com.paulo.swing.models.Cliente;
import java.util.List;

public class ClienteController{

    private Dao<Cliente> dao;
    
    public ClienteController(Dao dao){
        this.dao = dao;
    }
    
    public Cliente insert(Cliente obj){
        return dao.insert(obj);
    }

    public List<Cliente> findAll() {
        return dao.findAll();
    }

    public Cliente findByCodigo(Long codigo) {
        return dao.findByCodigo(codigo);
    }

    public Cliente update(Cliente obj) {
        return dao.update(obj);
    }

    public void delete(Cliente obj) {
        dao.delete(obj);
    }

    public Cliente findByNome(String nome) {
        return dao.findByNome(nome);
    }
    
}
