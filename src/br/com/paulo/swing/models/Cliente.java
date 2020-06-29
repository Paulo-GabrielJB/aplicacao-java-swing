package br.com.paulo.swing.models;

import java.sql.Date;

public class Cliente {
    
    
    private Long codigo;
    private String nome;
    private String cpf;
    private Date nascimento;
    private Character sexo;
    private String telefone;
    
    public Cliente(){}

    public Cliente(Long codigo, String nome, String cpf, Date nascimento, Character sexo, String telefone) {
        this.codigo = codigo;
        this.nome = nome;
        this.cpf = cpf;
        this.nascimento = nascimento;
        this.sexo = sexo;
        this.telefone = telefone;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public Character getSexo() {
        return sexo;
    }

    public void setSexo(Character sexo) {
        this.sexo = sexo;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    
    
}
