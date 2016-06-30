package pedro.ifsp.br.trabalhobimestral;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CadastraEditarJogador extends AppCompatActivity {

    DBHelper dbhelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastra_editar_jogador);

        /*
        Essa é a classe em que o usuário pode criar, alterar e excluir um jogador. Dependendo do que vier da classe jogador,
        é tratado no oncreate e então informações para serem alteradas são disponibilizadas para o usuário. Caso o usuário
        tenha clicado no botão "Adicionar Novo" as textviews ficam vazias para que ele crie um novo.

         */


        //Código para pegar o item clicado e então colocar nos editTexts ou verifica se é para adicionar um novo player
        Intent intent = getIntent();
        dbhelper = new DBHelper(this);

        Cursor rs = dbhelper.getPlayer(intent.getIntExtra(Jogador.KEY_EXTRA_CONTACT_ID, 0));

        int teste = intent.getIntExtra(Jogador.KEY_EXTRA_CONTACT_ID, 0);

        if(teste != 0)
        {
            rs.moveToFirst();
            String personName = rs.getString(rs.getColumnIndex(dbhelper.PERSON_COLUMN_NAME));
            String personCountry = rs.getString(rs.getColumnIndex(dbhelper.PERSON_COLUMN_COUNTRY));
            int personAge = rs.getInt(rs.getColumnIndex(dbhelper.PERSON_COLUMN_AGE));

            EditText etNome = (EditText) findViewById(R.id.etNome);
            EditText etPais = (EditText) findViewById(R.id.etPais);
            EditText etIdade = (EditText) findViewById(R.id.etIdade);
            TextView tvCod = (TextView) findViewById(R.id.tvId);

            tvCod.setText(rs.getString(0));
            etPais.setText(personCountry);
            etNome.setText(personName);
            etIdade.setText(String.valueOf(personAge));

            Button btDeletar = (Button) findViewById(R.id.btDeletar);
            btDeletar.setVisibility(View.VISIBLE);



            if (!rs.isClosed())
            {
                rs.close();
            }
        }

        }


    public void deletarJogador(View v)
    {
        TextView tvId = (TextView) findViewById(R.id.tvId);
        dbhelper.deletePlayer(Integer.parseInt(tvId.getText().toString()));
        Toast.makeText(this, "Player deletado com sucesso!", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(this, Jogador.class);
        startActivity(intent);
    }



    public void InserirJogador(View v)
    {
        dbhelper = new DBHelper(this);

        TextView tvId = (TextView) findViewById(R.id.tvId);
        String id = tvId.getText().toString();
        EditText nome = (EditText) findViewById(R.id.etNome);
        EditText idade = (EditText) findViewById(R.id.etIdade);
        EditText pais = (EditText) findViewById(R.id.etPais);

        if(id != "ID")
        {
            dbhelper.insertPlayer(nome.getText().toString(), pais.getText().toString(), Integer.parseInt(idade.getText().toString()));
            Toast.makeText(this, "Player inserido com sucesso!", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(this, Jogador.class);
            startActivity(intent);                        //chama a activity que contém a listview
        }

        else
        {
            //caso esteja na activity para fazer alterações ou para deletar
            dbhelper.updatePerson(Integer.parseInt(id), nome.getText().toString(), pais.getText().toString(), Integer.parseInt(idade.getText().toString()));
            Toast.makeText(this, "Player alterado com sucesso!", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(this, Jogador.class);        //chama a activity que contém a listview
            startActivity(intent);
        }

    }


}
