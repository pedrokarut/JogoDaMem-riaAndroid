package pedro.ifsp.br.trabalhobimestral;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import static pedro.ifsp.br.trabalhobimestral.R.drawable.carta;

public class Fase1 extends AppCompatActivity {

    public static int invisivel = 0;
    public static int pontos = 0;

    SharedPreferences preferencias;

     static final String KEY_ERROS = "";
     static final String KEY_ACERTOS = "";
     public int acertos = 0;                    //variável para computar os erros
     public int erros = 0;                      //variável para compuar os acertos


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fase1);

        preferencias = getSharedPreferences("TrabalhoBimestral", Context.MODE_PRIVATE);

        pontos = 0;
    }

    public void VerificaInvisiveis()
    {
        //esse método recupera todos os imagebuttons e verifica suas visibilidades,
        //só é computado  um ponto se os mesmos imagbuttons estiverem com a visibilidade inivisivel ou invisivel,
        //ou seja, sóse formarem parem é computado. Senão, uma mensagem informa que o usuário errou e deve tentar de novo

        ImageButton ibCobreGato1 = (ImageButton) findViewById(R.id.ibCobreGato1);
        ImageButton ibCobreGato2 = (ImageButton) findViewById(R.id.ibCobreGato2);
        ImageButton ibCobrePorco1 = (ImageButton) findViewById(R.id.ibCobrePorco1);
        ImageButton ibCobrePorco2 = (ImageButton) findViewById(R.id.ibCobrePorco2);
        Button btFase2 = (Button) findViewById(R.id.btFase2);

        if(ibCobreGato1.getVisibility() == View.INVISIBLE && ibCobreGato2.getVisibility() == View.INVISIBLE)
        {
            acertos++;
            Toast.makeText(this, "Parabéns! Você marcou 1 ponto!", Toast.LENGTH_SHORT).show();
            pontos++;
        }
        else if(ibCobrePorco1.getVisibility() == View.INVISIBLE && ibCobrePorco2.getVisibility() == View.INVISIBLE)
        {
            acertos++;
            Toast.makeText(this, "Parabéns! Você marcou 1 ponto!", Toast.LENGTH_SHORT);
            pontos++;
        }
        else
        {
            erros++;
            Toast.makeText(this, "As cartas não correspondem! Tente novamente!", Toast.LENGTH_SHORT).show();
            ibCobreGato1.setVisibility(View.VISIBLE);
            ibCobreGato2.setVisibility(View.VISIBLE);
            ibCobrePorco1.setVisibility(View.VISIBLE);
            ibCobrePorco2.setVisibility(View.VISIBLE);
        }

        invisivel = 0;

        if(pontos>=2)
        {   //caso o jogador tenha acertado,  um botão para a segunda fase é disponibilizado
            //e um botão para enviar seu score por sms

            SharedPreferences.Editor editor = preferencias.edit();
            editor.putString(KEY_ERROS, String.valueOf(erros));
            editor.putString(KEY_ACERTOS, String.valueOf(acertos));
            editor.commit();


            ImageButton ibSMS = (ImageButton) findViewById(R.id.ibSMS);
            ibSMS.setVisibility(View.VISIBLE);
            btFase2.setVisibility(View.VISIBLE);
        }




    }

    public void clickGato1(View v)
    {
        ImageButton ibCobreGato1 = (ImageButton) findViewById(R.id.ibCobreGato1);
        ImageButton ibCobreGato2 = (ImageButton) findViewById(R.id.ibCobreGato2);
        ImageButton ibCobrePorco1 = (ImageButton) findViewById(R.id.ibCobrePorco1);
        ImageButton ibCobrePorco2 = (ImageButton) findViewById(R.id.ibCobrePorco2);


            if(invisivel<2)
            {
                ibCobreGato1.setVisibility(View.INVISIBLE);
                invisivel++;
            }

            if(invisivel==2)
            {
                VerificaInvisiveis();
            }

    }


    public void clickGato2(View v)
    {
        ImageButton ibCobreGato1 = (ImageButton) findViewById(R.id.ibCobreGato1);
        ImageButton ibCobreGato2 = (ImageButton) findViewById(R.id.ibCobreGato2);
        ImageButton ibCobrePorco1 = (ImageButton) findViewById(R.id.ibCobrePorco1);
        ImageButton ibCobrePorco2 = (ImageButton) findViewById(R.id.ibCobrePorco2);

        if(invisivel<2)
        {
            ibCobreGato2.setVisibility(View.INVISIBLE);
            invisivel++;
        }
        if(invisivel==2)
        {
            VerificaInvisiveis();
        }
    }

    public void clickPorco1(View v)
    {
        ImageButton ibCobreGato1 = (ImageButton) findViewById(R.id.ibCobreGato1);
        ImageButton ibCobreGato2 = (ImageButton) findViewById(R.id.ibCobreGato2);
        ImageButton ibCobrePorco1 = (ImageButton) findViewById(R.id.ibCobrePorco1);
        ImageButton ibCobrePorco2 = (ImageButton) findViewById(R.id.ibCobrePorco2);

        if(invisivel<2)
        {
            ibCobrePorco1.setVisibility(View.INVISIBLE);
            invisivel++;
        }
        if(invisivel==2)
        {
            VerificaInvisiveis();
        }
    }

    public void clickPorco2(View v)
    {
        ImageButton ibCobreGato1 = (ImageButton) findViewById(R.id.ibCobreGato1);
        ImageButton ibCobreGato2 = (ImageButton) findViewById(R.id.ibCobreGato2);
        ImageButton ibCobrePorco1 = (ImageButton) findViewById(R.id.ibCobrePorco1);
        ImageButton ibCobrePorco2 = (ImageButton) findViewById(R.id.ibCobrePorco2);


        if(invisivel<2)
        {
            ibCobrePorco2.setVisibility(View.INVISIBLE);
            invisivel++;
        }
        if(invisivel==2)
        {
            VerificaInvisiveis();
        }


    }


    public void callFase2(View v)
    {
        Intent intent = new Intent(Fase1.this, Fase2.class);
        startActivity(intent);
    }


    public void sendSMS(View v)
    {
        Intent intent = new Intent(Intent.ACTION_VIEW,
                Uri.parse("sms:" ));
        intent.putExtra("sms_body",  "Total de Acertos: " + preferencias.getString(KEY_ACERTOS, "") +
                "Total de Erros: " + preferencias.getString(KEY_ERROS, ""));
        startActivity(intent);
    }






}
