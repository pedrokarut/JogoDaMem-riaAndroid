package pedro.ifsp.br.trabalhobimestral;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class Jogador extends AppCompatActivity {

    private ListView listView;
    DBHelper dbHelper;
    public final static String KEY_EXTRA_CONTACT_ID = "KEY_EXTRA_CONTACT_ID";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jogador);


        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);  //Código para a criação da toolbar
        setSupportActionBar(toolbar);


        dbHelper = new DBHelper(this);                          //Código para fazer a inicialização do banco


        final Cursor cursor = dbHelper.getAllPlayers();
        String [] columns = new String[]{
                DBHelper.PERSON_COLUMN_ID,
                DBHelper.PERSON_COLUMN_NAME
        };
        int [] widgets = new int[] {
                R.id.tvId,
                R.id.tvNome
        };



        SimpleCursorAdapter cursorAdapter = new SimpleCursorAdapter(this, R.layout.player_info,
                cursor, columns, widgets, 0);
        listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(cursorAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView listView, View view, int position, long id)
            {
                Cursor itemCursor = (Cursor) Jogador.this.listView.getItemAtPosition(position);
                int personID = itemCursor.getInt(itemCursor.getColumnIndex(DBHelper.PERSON_COLUMN_ID));
                Intent intent = new Intent(getApplicationContext(), CadastraEditarJogador.class);
                intent.putExtra(KEY_EXTRA_CONTACT_ID, personID);
                startActivity(intent);
            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if(id == R.id.itemAdicionar)        //caso seja adição de novo jogador
        {
            Intent intent = new Intent(this, CadastraEditarJogador.class);
            startActivity(intent);
        }

        if(id == R.id.itemEditar)           //caso seja edição
        {
            Intent intent = new Intent(this, CadastraEditarJogador.class);
            intent.putExtra("", 0);
            startActivity(intent);
        }


        if(id == R.id.itemExcluir)          //caso seja exclusão
        {
            Intent intent = new Intent(this, CadastraEditarJogador.class);
            startActivity(intent);
        }


        return super.onOptionsItemSelected(item);
    }
}
