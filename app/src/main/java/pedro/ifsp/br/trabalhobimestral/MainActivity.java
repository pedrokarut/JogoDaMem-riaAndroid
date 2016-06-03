package pedro.ifsp.br.trabalhobimestral;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

       /* if(item.getItemId()==1)
        {

        }
       */

        return super.onOptionsItemSelected(item);
    }

    public void callFase1(View v)
    {
        Intent intent = new Intent(MainActivity.this, Fase1.class);
        startActivity(intent);
    }

    public void callInformacoes(View v)
    {
        Intent intent = new Intent(this, Informacoes.class);
        startActivity(intent);
    }

    public void callCadastrar(View v)
    {
        Intent intent = new Intent(this, Cadastrar.class);
        startActivity(intent);
    }
}
