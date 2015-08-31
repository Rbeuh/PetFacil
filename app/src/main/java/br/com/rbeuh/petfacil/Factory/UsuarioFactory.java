package br.com.rbeuh.petfacil.Factory;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.validation.Validator;

import br.com.rbeuh.petfacil.Model.Usuario;
import br.com.rbeuh.petfacil.Util.EmailValidator;

/**
 * Created by enzo on 22/07/2015.
 */
public class UsuarioFactory
{
    public static Usuario gerarUsuario(String nome, String email, String senha, String confSenha) throws IllegalAccessException
    {
        Usuario usuario = null;

        if (nome.trim().length() > 150 || nome.trim().length() < 3)
            throw new IllegalArgumentException("M�ximo de caracteres: 150, m�nimo: 2");


        if((nome.trim() == "") || (email.trim() == "") || (senha.trim() == "") || (confSenha.trim() == ""))
        {
            throw  new IllegalArgumentException("Não pode haver campos em branco!");
        }

        if(email.trim().length() > 150 || email.trim().length() < 3)
        {
          throw new IllegalArgumentException("M�ximo de caract�res:150, mínimo:3 ");
        }

       EmailValidator emailValidator = new EmailValidator();

        emailValidator.validate(email.trim());

        {
            if (senha.trim().length() > 350 || senha.trim().length() < 6)
            {
                throw new IllegalArgumentException("M�ximo de caract�res: 350, m�nimo: 6");
            }
        }

        if(confSenha.trim() != senha.trim())
        {
            throw  new IllegalArgumentException("Senhas divergentes!");
        }

        return usuario;
    }




}
