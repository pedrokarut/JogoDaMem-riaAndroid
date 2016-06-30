package pedro.ifsp.br.trabalhobimestral;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }


    public void callFase1(View v)
    {
        Intent intent = new Intent(Main2Activity.this, Fase1.class);
        startActivity(intent);

        //botão que começa o jogo
    }


    public void callCadastro(View v)
    {
        Intent intent = new Intent(Main2Activity.this, Jogador.class);
        startActivity(intent);

        //botão para cadastrar jogadores

    }

    public void callInformations(View v)
    {
        Intent intent = new Intent(Main2Activity.this, Information.class);
        startActivity(intent);

        //botão para mostrar as informações dos criadores

    }


}
