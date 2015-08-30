package br.com.rbeuh.petfacil.Factory;

import br.com.rbeuh.petfacil.Model.Usuario;

/**
 * Created by enzo on 22/07/2015.
 */
public class UsuarioFactory
{
    public static Usuario gerarUsuario(String nome, String email, String senha, String confSenha)
    {
        Usuario usuario = null;

        if (nome.trim().length() > 150 || nome.trim().length() < 3)
            throw new IllegalArgumentException("Máximo de caracteres: 150, mínimo: 2");

        if(email.trim().length() > 150 || email.trim().length() < 3)
        {
          throw new IllegalArgumentException("Máximo de caractéres:150, mpinimo:3 ");
        }

        if(senha.trim().length() > 350 || senha.trim().length() < 6)
        {
            throw new IllegalArgumentException("Máximo de caractéres: 350, mínimo: 6");
        }

        if(confSenha.trim() != senha.trim())
        {
            throw  new IllegalArgumentException("Senhas divergentes!");
        }

        return usuario;
    }


}
