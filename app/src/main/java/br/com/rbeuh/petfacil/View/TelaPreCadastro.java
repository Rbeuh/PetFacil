package br.com.rbeuh.petfacil.View;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import br.com.rbeuh.petfacil.R;


public class TelaPreCadastro extends ActionBarActivity
{

    private Button buttonLogEmail;

    public void initialize()
    {
        buttonLogEmail = (Button) findViewById(R.id.buttonLogEmail);
        buttonLogEmail.setOnClickListener(buttonLogEmail_click);
    }

    View.OnClickListener buttonLogEmail_click = new View.OnClickListener()
    {
        @Override
        public void onClick(View v)
        {
            startActivity(new Intent(getBaseContext(), TelaCadastro.class));
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_pre_cadastro);

        initialize();
        getSupportActionBar().hide();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_tela_pre_cadastro, menu);
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
