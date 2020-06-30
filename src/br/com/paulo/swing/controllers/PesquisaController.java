package br.com.paulo.swing.controllers;

import br.com.paulo.swing.dao.Dao;
import br.com.paulo.swing.models.Cliente;
import java.util.List;

public class PesquisaController {
    
    private Dao<Cliente> dao;
    
    public PesquisaController(Dao dao){
        this.dao = dao;
    }

    public void setDao(Dao<Cliente> dao) {
        this.dao = dao;
    }
    
    public List<Cliente> buscarClientePorNome(String nome){
        return dao.findByNome(nome);
    }

}
