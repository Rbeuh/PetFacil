package br.com.rbeuh.petfacil.Controller;

import android.content.Context;

import br.com.rbeuh.petfacil.Factory.UsuarioFactory;
import br.com.rbeuh.petfacil.Model.Usuario;
import br.com.rbeuh.petfacil.Util.ShowMessage;

/**
 * Created by enzo on 22/07/2015.
 */
public class UsuarioController
{
    private Context context;

    public UsuarioController(Context context)
    {
        this.context = context;
    }

    public void cadastrar(String nome, String email, String senha, String confSenha)
    {
        try
        {
            Usuario u = UsuarioFactory.gerarUsuario(nome, email, senha, confSenha);
        }
        catch(Exception e)
        {
            ShowMessage.showDialog(context, "Atenção!!!", e.getMessage());
        }
    }
}
