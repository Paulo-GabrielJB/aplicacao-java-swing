package br.com.paulo.swing.dao.impl;

import br.com.paulo.swing.dao.Dao;
import br.com.paulo.swing.db.DB;
import br.com.paulo.swing.exceptions.DataIntegrityException;
import br.com.paulo.swing.exceptions.StandardException;
import br.com.paulo.swing.models.Cliente;
import java.sql.Statement;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClienteDaoJDBC implements Dao<Cliente>{
    
    private Connection conn;
    
    public ClienteDaoJDBC(Connection conn){
        this.conn = conn;
    }

    @Override
    public List<Cliente> findAll() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            ps = conn.prepareStatement("SELECT CD_CLIENTE, "
                    + "NM_CLIENTE, "
                    + "NR_CPF, "
                    + "DT_NASCIMENTO, "
                    + "SX_CLIENTE, "
                    + "NR_TELEFONE FROM TB_CLIENTE");
            rs = ps.executeQuery();
            
            List<Cliente> clientes = new ArrayList<>();
            
            while(rs.next())
                clientes.add(instanciarCliente(rs));
            
            return clientes;   
        } catch (SQLException e){
            throw new StandardException("Erro " + e.getMessage().toLowerCase());
        } finally {
            DB.close(rs);
            DB.close(ps);
        }
    }

    @Override
    public Cliente findByCodigo(Long codigo) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            ps = conn.prepareStatement("SELECT CD_CLIENTE, "
                    + "NM_CLIENTE, "
                    + "NR_CPF, "
                    + "DT_NASCIMENTO, "
                    + "SX_CLIENTE, "
                    + "NR_TELEFONE FROM TB_CLIENTE "
                    + "WHERE CD_CLIENTE = ?");
            ps.setLong(1, codigo);
            rs = ps.executeQuery();
            
            if(rs.next())
                return instanciarCliente(rs);
            else
                throw new StandardException("Nenhuum cliente encontrado");
            
            
        } catch (SQLException e){
            throw new StandardException("Erro " + e.getMessage().toLowerCase());
        } finally {
            DB.close(rs);
            DB.close(ps);
        }
    }

    @Override
    public Cliente insert(Cliente obj) {
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement("INSERT INTO TB_CLIENTE (NM_CLIENTE, NR_CPF, DT_NASCIMENTO, SX_CLIENTE, NR_TELEFONE) "
                    + "VALUES(?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, obj.getNome());
            ps.setString(2, obj.getCpf());
            ps.setDate(3, obj.getNascimento());
            ps.setString(4, obj.getSexo().toString());
            ps.setString(5, obj.getTelefone());
            
            int rows = ps.executeUpdate();
            
            if(rows > 0){
                rs = ps.getGeneratedKeys();
                if(rs.next())
                    obj.setCodigo(rs.getLong(1));
                
            } else
                throw new StandardException("Erro ao inserir o novo registro");
            
            return obj;
        } catch (SQLException e){
            throw new StandardException("Erro " + e.getMessage().toLowerCase());
        } finally {
            DB.close(rs);
            DB.close(ps);
        }
    }

    @Override
    public Cliente update(Cliente obj) {
        
        findByCodigo(obj.getCodigo());
        PreparedStatement ps = null;
        
        try {
            ps = conn.prepareStatement("UPDATE TB_CLIENTE SET NM_CLIENTE = ?, "
                    + "DT_NASCIMENTO = ?, "
                    + "SX_CLIENTE = ?, "
                    + "NR_TELEFONE = ? "
                    + "WHERE CD_CLIENTE = ?");
            
            ps.setString(1, obj.getNome());
            ps.setDate(2, obj.getNascimento());
            ps.setString(3, obj.getSexo().toString());
            ps.setString(4, obj.getTelefone());
            ps.setLong(5, obj.getCodigo());
            
            ps.executeUpdate();
            
            return obj;
            
        } catch (SQLException e){
            throw new StandardException("Erro " + e.getMessage().toLowerCase());
        } finally {
            DB.close(ps);
        }
    }

    @Override
    public void delete(Cliente obj) {
        
        findByCodigo(obj.getCodigo());
        
        PreparedStatement ps = null;
        
        try {
            ps = conn.prepareStatement("DELETE FROM TB_CLIENTE WHERE CD_CLIENTE = ?");
            ps.setLong(1, obj.getCodigo());
            ps.executeUpdate();
        } catch (SQLException e){
            throw new DataIntegrityException("Erro ao deletar o registro");
        }
        
    }
    
    @Override
    public Cliente findByNome(String nome){
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            ps = conn.prepareStatement("SELECT CD_CLIENTE, "
                    + "NM_CLIENTE, "
                    + "NR_CPF, "
                    + "DT_NASCIMENTO, "
                    + "SX_CLIENTE, "
                    + "NR_TELEFONE FROM TB_CLIENTE "
                    + "WHERE NM_CLIENTE = ?");
            ps.setString(1, nome);
            rs = ps.executeQuery();
            
            if(rs.next())
                return instanciarCliente(rs);
            else
                throw new StandardException("Nenhuum cliente encontrado");
            
            
        } catch (SQLException e){
            throw new StandardException("Erro " + e.getMessage().toLowerCase());
        } finally {
            DB.close(rs);
            DB.close(ps);
        }
    }
    
    private Cliente instanciarCliente(ResultSet rs) throws SQLException{
        Cliente cliente = new Cliente();
        
        cliente.setCodigo(rs.getLong("CD_CLIENTE"));
        cliente.setNome(rs.getString("NM_CLIENTE"));
        cliente.setNascimento(rs.getDate("DT_NASCIMENTO"));
        cliente.setCpf(rs.getString("NR_CPF"));
        cliente.setSexo(rs.getString("SX_CLIENTE").charAt(0));
        cliente.setTelefone(rs.getString("NR_TELEFONE"));
        
        return cliente;
        
    }

}
