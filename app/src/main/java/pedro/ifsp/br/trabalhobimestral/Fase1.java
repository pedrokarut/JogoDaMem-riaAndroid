package pedro.ifsp.br.trabalhobimestral;

import android.content.Intent;
import android.graphics.drawable.Drawable;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fase1);
        pontos = 0;

    }

    public void VerificaInvisiveis()
    {
        ImageButton ibCobreGato1 = (ImageButton) findViewById(R.id.ibCobreGato1);
        ImageButton ibCobreGato2 = (ImageButton) findViewById(R.id.ibCobreGato2);
        ImageButton ibCobrePorco1 = (ImageButton) findViewById(R.id.ibCobrePorco1);
        ImageButton ibCobrePorco2 = (ImageButton) findViewById(R.id.ibCobrePorco2);
        Button btFase2 = (Button) findViewById(R.id.btFase2);

        if(ibCobreGato1.getVisibility() == View.INVISIBLE && ibCobreGato2.getVisibility() == View.INVISIBLE)
        {
            Toast.makeText(this, "Parabéns! Você marcou 1 ponto!", Toast.LENGTH_SHORT).show();
            pontos++;
        }
        else if(ibCobrePorco1.getVisibility() == View.INVISIBLE && ibCobrePorco2.getVisibility() == View.INVISIBLE)
        {
            Toast.makeText(this, "Parabéns! Você marcou 1 ponto!", Toast.LENGTH_SHORT);
            pontos++;
        }
        else
        {
            Toast.makeText(this, "As cartas não correspondem! Tente novamente!", Toast.LENGTH_SHORT).show();
            ibCobreGato1.setVisibility(View.VISIBLE);
            ibCobreGato2.setVisibility(View.VISIBLE);
            ibCobrePorco1.setVisibility(View.VISIBLE);
            ibCobrePorco2.setVisibility(View.VISIBLE);
        }

        invisivel = 0;

        if(pontos>=2)
        {
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






}
