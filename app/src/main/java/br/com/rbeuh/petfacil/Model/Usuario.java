package br.com.rbeuh.petfacil.Model;

/**
 * Created by enzo on 22/07/2015.
 */
public class Usuario
{
    private int id;
    private String nome;
    private String email;
    private String senha;

    public Usuario(String nome, String email, String senha)
    {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public String getSenha()
    {
        return senha;
    }

    public void setSenha(String senha)
    {
        this.senha = senha;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getNome()
    {
        return nome;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }
}
