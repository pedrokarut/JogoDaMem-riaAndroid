package pedro.ifsp.br.trabalhobimestral;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class CadastraEditarJogador extends AppCompatActivity {

    DBHelper dbhelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastra_editar_jogador);


        //Código para pegar o item clicado e então colocar nos editText

        Intent intent = getIntent();

        Cursor rs = dbhelper.getPlayer(intent.getIntExtra(Jogador.KEY_EXTRA_CONTACT_ID, 0));
        rs.moveToFirst();
        String personName = rs.getString(rs.getColumnIndex(dbhelper.PERSON_COLUMN_NAME));
        String personCountry = rs.getString(rs.getColumnIndex(dbhelper.PERSON_COLUMN_COUNTRY));
        int personAge = rs.getInt(rs.getColumnIndex(dbhelper.PERSON_COLUMN_AGE));

        if (!rs.isClosed())
        {
            rs.close();
        }



    }


    public void InserirJogador(View v)
    {
        dbhelper = new DBHelper(this);

        EditText nome = (EditText) findViewById(R.id.etNome);
        EditText idade = (EditText) findViewById(R.id.etIdade);
        EditText pais = (EditText) findViewById(R.id.etPais);

        dbhelper.insertPlayer(nome.getText().toString(), pais.getText().toString(), Integer.parseInt(idade.getText().toString()));

        Toast.makeText(this, "Player inserido com sucesso!", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(this, Jogador.class);
        startActivity(intent);

    }


}
