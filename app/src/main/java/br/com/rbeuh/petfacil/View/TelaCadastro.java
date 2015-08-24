package br.com.rbeuh.petfacil.View;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.com.rbeuh.petfacil.Controller.UsuarioController;
import br.com.rbeuh.petfacil.R;


public class TelaCadastro extends ActionBarActivity
{
    private EditText editTextNome;
    private EditText editTextEmail;
    private EditText editTextSenha;
    private EditText editTextConfSenha;
    private Button buttonCriarConta;

    public void initialize()
    {
        editTextNome = (EditText)findViewById(R.id.editTextNome);
        editTextEmail = (EditText)findViewById(R.id.editTextEmail);
        editTextSenha = (EditText)findViewById(R.id.editTextSenha);
        editTextConfSenha = (EditText)findViewById(R.id.editTextConfSenha);
        buttonCriarConta = (Button)findViewById(R.id.buttonCriarConta);
        buttonCriarConta.setOnClickListener(buttonCriarConta_click);

    }



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastro);

        initialize();
    }

    View.OnClickListener buttonCriarConta_click = new View.OnClickListener()
    {
        @Override
        public void onClick(View v)
        {
            UsuarioController usuarioController = new UsuarioController(getApplicationContext());
            usuarioController.cadastrar
                    (
                            editTextNome.getText().toString(),
                            editTextEmail.getText().toString(),
                            editTextSenha.getText().toString(),
                            editTextConfSenha.getText().toString()
                    );
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_tela_cadastro, menu);
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
