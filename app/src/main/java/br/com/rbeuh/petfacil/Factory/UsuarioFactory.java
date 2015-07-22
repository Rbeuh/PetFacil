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

        

        return usuario;
    }
}
