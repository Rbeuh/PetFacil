package br.com.rbeuh.petfacil.Controller;

import android.content.Context;

import com.google.gson.Gson;

import br.com.rbeuh.petfacil.Factory.UsuarioFactory;
import br.com.rbeuh.petfacil.Model.Response;
import br.com.rbeuh.petfacil.Model.Usuario;
import br.com.rbeuh.petfacil.Requistion.RequisitionTask;
import br.com.rbeuh.petfacil.Util.ShowMessage;
import br.com.rbeuh.petfacil.Util.SystemURL;

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

    public void cadastrar(String nome, String email, String senha, final String confSenha)
    {
        try
        {
            Usuario u = UsuarioFactory.gerarUsuario(nome, email, senha, confSenha);

            RequisitionTask.enviar(new RequisitionTask.OnRequisitionEnded()
            {
                @Override
                public void onRequisitionEnded(String json, int statusCode, Exception e)
                {
                    if (e != null )
                        ShowMessage.showToast(context, "Nao foi possível registrar");
                    else
                    {
                        Response response = new Gson().fromJson(json, Response.class);

                        ShowMessage.showToast(context, response.getMessage());
                    }
                }
            }, SystemURL.URL + "Usuario/create.php", "POST", u, context);
        }
        catch(Exception e)
        {
            ShowMessage.showDialog(context, "Aten��o!!!", e.getMessage());
        }
    }

    public void login (String email, String senha)
    {
        try
        {

        }
        catch(Exception e)
        {

        }
    }


}
