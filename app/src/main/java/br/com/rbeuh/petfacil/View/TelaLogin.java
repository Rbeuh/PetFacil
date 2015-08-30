package br.com.rbeuh.petfacil.View;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import br.com.rbeuh.petfacil.Controller.UsuarioController;
import br.com.rbeuh.petfacil.Model.Usuario;
import br.com.rbeuh.petfacil.R;


public class TelaLogin extends ActionBarActivity
{

    private EditText editTextEmailLogin;
    private EditText editTextSenhaLogin;
    private Button buttonLogin;

    public void Initialize()
    {
        editTextEmailLogin = (EditText)findViewById(R.id.editTextEmailLogin);
        editTextSenhaLogin = (EditText)findViewById(R.id.editTextSenhaLogin);
        buttonLogin = (Button)findViewById(R.id.buttonInicarSessao);
        buttonLogin.setOnClickListener(buttonLogin_Click);
    }

    View.OnClickListener buttonLogin_Click = new View.OnClickListener()
    {
        @Override
        public void onClick(View v)
        {
            UsuarioController usuarioController = new UsuarioController(getBaseContext());
            usuarioController.login
                    (
                      editTextEmailLogin.getText().toString(),
                      editTextSenhaLogin.getText().toString()
                    );
        }
    };

   @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_login);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_tela_login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings)
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
