package pedro.ifsp.br.trabalhobimestral;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import static pedro.ifsp.br.trabalhobimestral.R.drawable.carta;

public class Fase1 extends AppCompatActivity {

    public static int invisivel = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fase1);

    }

    public void VerificaInvisieis()
    {
        ImageButton ibCobreGato1 = (ImageButton) findViewById(R.id.ibCobreGato1);
        ImageButton ibCobreGato2 = (ImageButton) findViewById(R.id.ibCobreGato2);
        ImageButton ibCobrePorco1 = (ImageButton) findViewById(R.id.ibCobrePorco1);
        ImageButton ibCobrePorco2 = (ImageButton) findViewById(R.id.ibCobrePorco2);

        if(ibCobreGato1.getVisibility() == View.INVISIBLE && ibCobreGato2.getVisibility() == View.INVISIBLE)
        {
            Toast.makeText(this, "Parabéns! Você marcou 1 ponto!", Toast.LENGTH_SHORT).show();
        }
        else if(ibCobrePorco1.getVisibility() == View.INVISIBLE && ibCobrePorco2.getVisibility() == View.INVISIBLE)
        {
            Toast.makeText(this, "Parabéns! Você marcou 1 ponto!", Toast.LENGTH_SHORT);
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
                VerificaInvisieis();
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
            VerificaInvisieis();
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
            VerificaInvisieis();
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
            VerificaInvisieis();
        }


    }






}
