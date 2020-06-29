package br.com.paulo.swing.models;

public class Login {
    
    private Long codigo;
    private String login;
    private String senha;

    public Login() {
    }

    public Login(Long codigo, String login, String senha) {
        this.codigo = codigo;
        this.login = login;
        this.senha = senha;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    
    
}
